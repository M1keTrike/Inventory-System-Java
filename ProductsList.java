import java.util.ArrayList;

public class ProductsList {
    private ArrayList<Product> list = new ArrayList<Product>();

    public void addProduct(Product product) {
        this.list.add(product);
    }

    public void deleteProductByName(String name) {
        Product toDeleteProduct = searchProduct(name);
        if (toDeleteProduct != null) {
            if (this.list.remove(toDeleteProduct)) {
                System.out.println("Producto eliminado");
            } else {
                System.out.println("Ocurrio un error al eliminar el producto");
            }
        } else {
            System.out.println("Producto no encontrado");
        }
    }

    public void updateProductStockByName(String name, int amount) {
        try {
            Product currentProduct = searchProduct(name);
            if (currentProduct != null) {
                Product updatedProduct = currentProduct;
                updatedProduct.setStock(amount);
                int indexOfProduct = this.list.indexOf(currentProduct);

                System.out.println("Producto actualizado: " + this.list.set(indexOfProduct, updatedProduct).toString()
                        + " Nuevo: " + updatedProduct.toString());
            } else {
                System.out.println("Producto no encontrado");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar producto" + e.getMessage());
        }

    }

    private Product searchProduct(String name) {
        for (Product product : list) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public void getAllDetailedProducts() {
        System.out.println("Productos en inventario");
        for (Product product : list) {
            System.out.println(list.indexOf(product) + ":");
            System.out.println("Nombre: " + product.getName());
            System.out.println("Precio: " + product.getPrice());
            System.out.println("Cantidad: " + product.getStock());
            System.out.println("---------------------------");
        }

    }

    public float calculateValueOfInventory() {
        float inventoryValue = 0;
        for (Product product : list) {
            float productStockPrice = product.getPrice() * product.getStock();
            inventoryValue += productStockPrice;
        }
        return inventoryValue;
    }

}
