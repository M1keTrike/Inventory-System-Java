import java.util.Scanner;

public class Inventory {
    private float inventoryValue;
    private ProductsList productsList = new ProductsList();
    Scanner scanner = new Scanner(System.in);

    public void InitializeInventoryMainMenu() {
        boolean stillInMenu = true;
        try {

            do {

                System.out.println("Bienvenido al inventario. Opciones:");
                System.out.println("1. Añadir producto");
                System.out.println("2. Ver todos los productos");
                System.out.println("3. Actualizar cantidad de producto por nombre");
                System.out.println("4. Eliminar producto por nombre");
                System.out.println("5. Ver valor total del inventario");
                System.out.println("Ingrese otro numero para salir");
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        addProductOption();

                        break;
                    case 2:
                        seeAllProductsOption();
                        break;
                    case 3:
                        updateProductStockByNameOption();
                        break;
                    case 4:
                        deleteProductByNameOption();
                        break;
                    case 5:
                        seeValueOfInventoryOption();
                        break;

                    default:
                        break;
                }

                stillInMenu = toContinueControl();
            } while (stillInMenu);
        } catch (Exception e) {
            System.out.println("Ingresa tu opcion en numeros enteros");
        }

    }

    public void addProductOption() {
        try {
            Product newProduct = new Product();
            System.out.println("Añadir producto");
            System.out.println("Nombre: ");
            newProduct.setName(scanner.next());
            System.out.println("Precio: ");
            newProduct.setPrice(scanner.nextFloat());
            System.out.println("Cantidad inicial: ");
            newProduct.setStock(scanner.nextInt());
            productsList.addProduct(newProduct);
        } catch (Exception e) {
            System.out.println("Error al añadir producto" + e.getMessage());
        }

    }

    public void seeAllProductsOption() {
        productsList.getAllDetailedProducts();
    }

    public void updateProductStockByNameOption() {
        try {
            System.out.println("Actualizar producto");
            System.out.println("Ingrese el nombre del producto: ");
            String productNameToUpdate = scanner.nextLine();
            System.out.println("Ingrese la cantidad nueva de stock: ");
            int productStockToUpdate = scanner.nextInt();
            productsList.updateProductStockByName(productNameToUpdate, productStockToUpdate);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al actualizar el producto");
        }
    }

    public void deleteProductByNameOption() {
        System.out.println("Ingrese el nombre del producto a eliminar: ");
        String productNameToDelete = scanner.nextLine();
        productsList.deleteProductByName(productNameToDelete);
    }

    public void seeValueOfInventoryOption() {
        this.inventoryValue = productsList.calculateValueOfInventory();
        System.out.println("Valor del inventario: " + this.inventoryValue);
    }

    public boolean toContinueControl() {
        try {
            System.out.println("Continuar: 1.Si 2.No");
            int continueOption = scanner.nextInt();
            if (continueOption == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Ingrese un numero entero");
            return true;
        }

    }

}
