package controller;

import model.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductManager {
    public List<Product> productList = new ArrayList<>();
    //    private ReadWriteData readWriteData = ReadWriteData.getInstance();
    public void add(Product product) {
        productList.add(product);
    }
    public void display() {
        for (Product x : productList
        ) {
            System.out.println(x.toString());
        }
//        for (int i = 0; i < productList.size(); i++) {
//            System.out.println(this.productList.get(i));
//        }
    }
    public void editProduct(int id , Product product){
        productList.set(id,product);
    }
    public void delete(int idProduct){
        productList.remove(idProduct);
    }
    public void deleteAll(){
        productList.removeAll(productList);
    }
    public int checkId(String id) {
        int check = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (id.equals(productList.get(i).getId())){
                check = i;
            }
        }
        return check;
    }
    public void sortByPrice(){
        productList.sort(Comparator.comparingDouble(Product::getPrice));
    }
}
