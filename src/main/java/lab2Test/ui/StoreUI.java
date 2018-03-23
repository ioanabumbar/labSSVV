package lab2Test.ui;

import lab2Test.controller.StoreController;
import lab2Test.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by Vlad on 17-Mar-16.
 */
public class StoreUI {
    public StoreController ctrl;
    Scanner in;
    public StoreUI(StoreController ctrl){
        this.ctrl=ctrl;
        this.in=new Scanner(System.in);
    }
    public void printMenu() {
        String menu;
        menu = "These are the available commands:\n";
        menu += "\t 1 - Add a new Product \n";
        menu += "\t 2 - Displays all products from category\n";
        menu += "\t 3 - Stock situation for all productst \n";
        menu += "\t 4 - Stock situation for a certain product \n";
        menu += "\t 0 - to exit; \n";
        System.out.println(menu);
    }

    public void AddNewProduct()
    {

    	/*    	Calendar now = Calendar.getInstance();
    	    	System.out.println(now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE));*/
    	
    	Calendar rightNow = Calendar.getInstance();
    	int hour = rightNow.get(Calendar.HOUR_OF_DAY);
    	System.out.println("hour: " + hour);
    	/*if(hour != 11) {
    		System.out.println("You cand add only at the end of the day!");
    	}else {*/
	    	    	
	       /* System.out.println("Give the Product code:");
	        int pCode = Integer.parseInt(in.nextLine());
	
	        System.out.println("Give the product name:");
	        String pName = in.nextLine();
	
	        System.out.println("Give the product category:");
	        String pCategory = in.nextLine();
	
	        System.out.println("Give the quantity:");
	        int pQunatity = Integer.parseInt(in.nextLine());
	
	        Product p = new Product(pCode,pName,pCategory,pQunatity);
	        ctrl.addProduct(p);
	        System.out.println("Product Added");*/
//    	}
    	
    	Product product = new Product();
    	try {
    		Product p = product.read();
    		ctrl.addProduct(p);
    		System.out.println("Product Added");
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }

    public void DisplayCategory()
    {
        System.out.println("Give category");
        String cat=in.nextLine();
        ArrayList<Product> temp = ctrl.getProductsCategory(cat);

        if(temp.isEmpty())
        	System.out.println("Don't exist products of this category");
        for (Product p : temp) {
            System.out.println(p.toString());
        }
    }

    public void DisplayStock()
    {

        ArrayList<Product> temp = ctrl.stockSituation();
        
        if(temp.isEmpty())
        	System.out.println("Don't exist products in stock");
        for (Product p : temp) {
            System.out.println(p.toString());
        }
    }

    public void DisplayStockFor()
    {
        System.out.println("Give product name");
        String cat=in.nextLine();
        ArrayList<Product> temp = ctrl.stockSituationProduct(cat);

        if(temp.isEmpty())
        	System.out.println("Doesn't exist product with this name in stock");
        for (Product p : temp) {
            System.out.println(p.toString());
        }
    }

    public int readCommand() {
        System.out.println("Give a command: ");
        int c = 0;
//        c = Integer.parseInt(in.nextLine());
        try{
			c = Integer.parseInt(in.nextLine());
		}
		catch(IllegalStateException ex){
			System.out.println("The number cannot be read!!!");
		}
		catch(Exception e) {
			System.out.println("Unknown exeption!");
			System.out.println("Enter it again: ");
		}

        
        return c;
    }

    public void executeCommand(int c) {
        switch(c) {
            case 1:
                AddNewProduct();
                break;
            case 2:
                DisplayCategory();
                break;
            case 3:
                DisplayStock();
                break;
            case 4:
                DisplayStockFor();
                break;
            default:
                System.out.println("B'bye now!...\n");
                break;
        }
    }

    public void run() {
        int c;
        do {
            printMenu();
            c = readCommand();
            executeCommand(c);
        } while(c != 0);

    }



}
