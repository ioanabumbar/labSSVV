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
        productList = new ArrayList<Product>();
        productList.add(new Product(1,"aa", "bb", 12));
    }

    public void testAddNewProduct() throws IOException {
        assertEquals(productList.size(), 1);

        assertEquals(repository.getAllProducts().size(), 0);
        repository.addNewProduct(new Product(2,"aahh", "bb", 12));
        assertEquals(repository.getAllProducts().size(), 1);
    }
}