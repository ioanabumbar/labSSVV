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
        repository.addNewProduct(new Product(4,"milk", "food", 12));
        assertEquals(repository.getAllProducts().size(), 4);
    }

    public void testAddNewProduct2() throws IOException {
//        assertEquals(productList.size(), 1);

        assertEquals(repository.getAllProducts().size(), 3);
        repository.addNewProduct(new Product(3,"new", "electric", 2));
        assertEquals(repository.getAllProducts().size(), 3);
    }

    public void testAddNewProduct3() throws IOException {
//        assertEquals(productList.size(), 1);

        assertEquals(repository.getAllProducts().size(), 3);
        repository.addNewProduct(new Product(19,"wire2", "electric", 2));
        assertEquals(repository.getAllProducts().size(), 4);
    }

    public void testAddNewProduct4() throws IOException {
//        assertEquals(productList.size(), 1);

        assertEquals(repository.getAllProducts().size(), 3);
        repository.addNewProduct(new Product(19,"wire2*", "electric", 2));
        assertEquals(repository.getAllProducts().size(), 3);
    }

   public void testAddNewProduct5() throws IOException {
//        assertEquals(productList.size(), 1);

        assertEquals(repository.getAllProducts().size(), 3);
        repository.addNewProduct(new Product(0,"", "electric", 2));
        assertEquals(repository.getAllProducts().size(), 3);
    }

    /*public void testGetProducts() throws IOException {
        assertEquals(repository.getAllProducts().size(), 3);
    }*/

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

    public void testGetProductsCategory3() {
        StoreRepository repository2 = new StoreRepository();
        assertEquals(repository2.getAllProducts().size(), 0);
        ArrayList<Product> filtered = repository2.getProductsCategory("aliment");
        assertEquals(filtered.size(), 0);
    }

    public void testGetProductsCategory4() throws IOException{
        StoreRepository repository2 = new StoreRepository();
        repository2.addNewProduct(new Product(1,"meat","food",12));
        ArrayList<Product> filtered = repository2.getProductsCategory("food");
        assertEquals(filtered.size(), 1);
    }

    public void testGetProductsCategory5() throws IOException{
        StoreRepository repository2 = new StoreRepository();
        repository2.addNewProduct(new Product(1,"meat","food",12));
        repository2.addNewProduct(new Product(2,"chicken","food", 5));
        ArrayList<Product> filtered = repository2.getProductsCategory("food");
        assertEquals(filtered.size(), 2);
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

    public void testIntegrationBigBang() throws IOException {
        ArrayList<Product> filtered = repository.getProductsCategory("food");
        assertEquals(filtered.size(), 2);
        assertTrue(filtered.get(0).getName().equals("meat"));

        ArrayList<Product> filtered2 = repository.stockSituationProduct("meat");
        System.out.println(filtered2.toString());
        assertTrue(filtered2.size() == 1);

        repository.addNewProduct(new Product(4,"meat", "bb", 1));
        filtered = repository.stockSituationProduct("meat");
        System.out.println(filtered.toString());
        assertTrue(filtered.size() == 2);
    }

    /*
    public void testStockSituation() {
        ArrayList<Product> filtered = repository.stockSituation();
        assertEquals(filtered.size(), 3);
    }*/
}