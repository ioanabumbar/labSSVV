package lab2Test.controller;

import lab2Test.model.Product;
import lab2Test.repository.StoreRepository;

import java.io.IOException;
import java.util.ArrayList;

public class StoreController {
  StoreRepository repository =new StoreRepository();
  public void readProducts(String f){
     try {
        repository.readFile(f);
     } catch (NumberFormatException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     }
     catch(IOException e){
        e.printStackTrace();
     }
  }
 
  public void addProduct(Product p){
     try {

        repository.addNewProduct(p);
     } catch (NumberFormatException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     }
     catch(IOException e){
        e.printStackTrace();
     }
  }
  public ArrayList<Product> getProductsCategory(String cat){
     return repository.getProductsCategory(cat);
  }
 
  public ArrayList<Product> stockSituationProduct(String pname){
     return repository.stockSituationProduct(pname);
  }
  public ArrayList<Product> stockSituation(){
     return repository.stockSituation();
  }
}
