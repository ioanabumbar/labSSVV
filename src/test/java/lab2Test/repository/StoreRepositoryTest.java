package lab2Test.repository;

import junit.framework.TestCase;
import lab2Test.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StoreRepositoryTest extends TestCase {

    List<Product> productList;
    StoreRepository repository = new StoreRepository();

    public void setUp() throws Exception {
        super.setUp();
//        productList = new ArrayList<Product>();
//        productList.add(new Product(1,"aa", "bb", 12));

        repository.addNewProduct(new Product(1,"meat", "food", 12));
        repository.addNewProduct(new Product(2,"chicken", "food", 5));
        repository.addNewProduct(new Product(3,"pen", "object", 15));
    }

    public void testAddNewProduct() throws IOException {
//        assertEquals(productList.size(), 1);

        assertEquals(repository.getAllProducts().size(), 3);
        repository.addNewProduct(new Product(4,"aahh", "bb", 12));
        assertEquals(repository.getAllProducts().size(), 4);
    }

    public void testGetProducts() throws IOException {
        assertEquals(repository.getAllProducts().size(), 3);
    }

    public void testGetProductsCategory() {
        ArrayList<Product> filtered = repository.getProductsCategory("object");
        assertEquals(filtered.size(), 1);
        assertTrue(filtered.get(0).getName().equals("pen"));
    }

    public void testGetProductsCategory2() {
        ArrayList<Product> filtered = repository.getProductsCategory("aliment");
        assertEquals(filtered.size(), 0);
//        assertTrue(filtered.get(0).getName().equals("pen"));
    }


    public void testStockSituationProduct() throws IOException {
        ArrayList<Product> filtered = repository.stockSituationProduct("meat");
        System.out.println(filtered.toString());
        assertTrue(filtered.size() == 1);

        repository.addNewProduct(new Product(4,"meat", "bb", 1));
        filtered = repository.stockSituationProduct("meat");
        System.out.println(filtered.toString());
        assertTrue(filtered.size() == 2);
    }

    public void testStockSituation() {
        ArrayList<Product> filtered = repository.stockSituation();
        assertEquals(filtered.size(), 3);
    }
}