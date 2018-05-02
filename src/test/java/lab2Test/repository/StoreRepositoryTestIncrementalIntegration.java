package lab2Test.repository;

import junit.framework.TestCase;
import lab2Test.model.Product;

import java.io.IOException;
import java.util.ArrayList;

public class StoreRepositoryTestIncrementalIntegration extends TestCase {

    StoreRepository repository = new StoreRepository();

    public void setUp() throws Exception {
        super.setUp();

        repository.addNewProduct(new Product(1,"meat", "food", 12));
        repository.addNewProduct(new Product(2,"chicken", "food", 5));
        repository.addNewProduct(new Product(3,"pen", "object", 15));
    }

    public void testAddNewProductIntegrationA() throws IOException {
        assertEquals(repository.getAllProducts().size(), 3);
        repository.addNewProduct(new Product(4,"milk", "food", 12));
        assertEquals(repository.getAllProducts().size(), 4);
    }

    public void testIntegrationB() throws IOException {
        ArrayList<Product> filtered = repository.getProductsCategory("food");
        assertEquals(filtered.size(), 2);
        assertTrue(filtered.get(0).getName().equals("meat"));

        repository.addNewProduct(new Product(4,"meat", "food", 1));
        filtered = repository.getProductsCategory("food");
        assertTrue(filtered.size() == 3);
    }

    public void testIntegrationC() throws IOException {
        ArrayList<Product> filtered = repository.getProductsCategory("food");
        assertEquals(filtered.size(), 2);
        assertTrue(filtered.get(0).getName().equals("meat"));

        ArrayList<Product> filtered2 = repository.stockSituationProduct("meat");
        System.out.println(filtered2.toString());
        assertTrue(filtered2.size() == 1);

        repository.addNewProduct(new Product(4,"meat", "food", 1));
        filtered = repository.getProductsCategory("food");
        assertTrue(filtered.size() == 3);
    }
}