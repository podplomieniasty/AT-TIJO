import java.util.ArrayList;
import java.util.List;

public class CartUnitTests {

    public static void main(String[] args) {

        // addProduct
        ShoppingCartTests.testAddProductWithNullName();
        ShoppingCartTests.testAddProductWithEmptyName();
        ShoppingCartTests.testAddProductWithNegativePrice();
        ShoppingCartTests.testAddProductWithPriceAsZero();
        ShoppingCartTests.testAddProductWithNegativeQuantity();
        ShoppingCartTests.testAddProductWithQuantityAsZero();
        ShoppingCartTests.testAddProductWithProperValues();

        // removeProduct
        ShoppingCartTests.testRemoveProductWithNullName();
        ShoppingCartTests.testRemoveProductWithEmptyName();
        ShoppingCartTests.testRemoveProductWithMissingItem();
        ShoppingCartTests.testRemoveProductWithExistingItem();


    }
}

class ShoppingCart {

    List<String> products = new ArrayList<>();

    public boolean addProduct(String productName, double price, int quantity) {
        if(productName == null || productName.isEmpty()) return false;
        if(price <= 0 || quantity <= 0) return false;
        products.add(productName);
        return true;
    }

    public boolean removeProduct(String productName) {
        if(productName == null || productName.isEmpty()) return false;
        if(products.contains(productName)) {
            products.remove(productName);
            return true;
        }
        return false;
    }
}

class ShoppingCartTests {

    // addProduct
    static void testAddProductWithNullName() {
        ShoppingCart cart = new ShoppingCart();
        String product = null;
        double price = 10.0;
        int quantity = 1;

        boolean result = cart.addProduct(product, price, quantity);

        assert !result : "addProduct(null, 10.0, 1) should return false";
    }
    static void testAddProductWithEmptyName() {
        ShoppingCart cart = new ShoppingCart();
        String product = "";
        double price = 10.0;
        int quantity = 1;

        boolean result = cart.addProduct(product, price, quantity);

        assert !result : "addProduct(\"\", 10.0, 1) should return false";
    }
    static void testAddProductWithNegativePrice() {
        ShoppingCart cart = new ShoppingCart();
        String product = "Foo";
        double price = -10.0;
        int quantity = 1;

        boolean result = cart.addProduct(product, price, quantity);

        assert !result : "addProduct(\"Foo\", -10.0, 1) should return false";
    }
    static void testAddProductWithPriceAsZero() {
        ShoppingCart cart = new ShoppingCart();
        String product = "Foo";
        double price = 0;
        int quantity = 1;

        boolean result = cart.addProduct(product, price, quantity);

        assert !result : "addProduct(\"Foo\", 0, 1) should return false";
    }
    static void testAddProductWithNegativeQuantity() {
        ShoppingCart cart = new ShoppingCart();
        String product = "Foo";
        double price = 10.0;
        int quantity = -1;

        boolean result = cart.addProduct(product, price, quantity);

        assert !result : "addProduct(\"Foo\", 10.0, -1) should return false";
    }
    static void testAddProductWithQuantityAsZero() {
        ShoppingCart cart = new ShoppingCart();
        String product = "Foo";
        double price = 10.0;
        int quantity = 0;

        boolean result = cart.addProduct(product, price, quantity);

        assert !result : "addProduct(\"Foo\", -10.0, 0) should return false";
    }
    static void testAddProductWithProperValues() {
        ShoppingCart cart = new ShoppingCart();
        String product = "Foo";
        double price = 10.0;
        int quantity = 1;

        boolean result = cart.addProduct(product, price, quantity);

        assert result : "addProduct(\"Foo\". 10.0, 1) should return true";
    }


    // removeProduct
    static void testRemoveProductWithNullName() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Foo", 10.0, 1);
        String product = null;
        boolean result = cart.removeProduct(product);
        assert !result : "removeProduct(null) should return false";
    }

    static void testRemoveProductWithEmptyName() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Foo", 10.0, 1);
        String product = "";
        boolean result = cart.removeProduct(product);
        assert !result : "removeProduct(\"\") should return false";
    }

    static void testRemoveProductWithMissingItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Foo", 10.0, 1);
        String product = "Bar";
        boolean result = cart.removeProduct(product);
        assert !result : "removeProduct(\"Bar\") should return false";
    }

    static void testRemoveProductWithExistingItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Foo", 10.0, 1);
        String product = "Foo";
        boolean result = cart.removeProduct(product);
        assert result : "removeProduct(\"Foo\") should return true";
    }
}