package controller;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    List<Product> productList = new ArrayList<Product>();

    public ProductManager() {
    }

    public ProductManager(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void add(Product product) {
        this.productList.add(product);
    }
    public void display() {
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(this.productList.get(i));
        }
    }

}
