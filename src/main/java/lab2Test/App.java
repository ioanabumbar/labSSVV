package lab2Test;

import lab2Test.controller.StoreController;
import lab2Test.ui.StoreUI;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//		Product p=new Product();
        //p.read();
        StoreController c=new StoreController();
        c.readProducts("products.txt");

        StoreUI u = new StoreUI(c);
        u.run();
        //c.addProduct(p);
        //	for(Product q:c.getProductsCategory("second")){
        //	System.out.println(q.toString());
        //}
//		for(Product q:c.stockSituationProduct("Laptop"))
//			System.out.println(q.toString());
//
    }
}
