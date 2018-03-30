package lab2Test.controller;

import junit.framework.TestCase;
import lab2Test.model.Product;

public class StoreControllerTest extends TestCase {

    StoreController controller = new StoreController();

    public void setUp() throws Exception {
        super.setUp();

        controller.addProduct(new Product(1,"meat", "food", 12));
        controller.addProduct(new Product(1,"chicken", "food", 5));
        controller.addProduct(new Product(1,"pen", "object", 15));
    }

    public void testAddProduct() {
       /* assertEquals(controller.getAllProducts().size(), 3);
        controller.addProduct(new Product(2,"aahh", "bb", 12));
        assertEquals(controller.getAllProducts().size(), 4);*/
    }

    public void testGetProductsCategory() {

    }

    public void testStockSituationProduct() {
    }

    public void testStockSituation() {
    }
}