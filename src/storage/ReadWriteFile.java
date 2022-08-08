package storage;

import model.Product;

import java.io.*;
import java.util.List;

public class ReadWriteFile implements  IReadWriteFile{
private static ReadWriteFile instance = null;

private ReadWriteFile(){
}
public static ReadWriteFile getInstance(){
    if (instance == null){
        return instance = new ReadWriteFile();
    }else return instance;
}
public void writeData(List<Product> products){
    try {
        FileOutputStream fos = new FileOutputStream("data/products.csv");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(products);
        fos.close();
        oos.close();
    }catch (IOException e) {
        System.err.println(e.getMessage());
    }
}
public List<Product> readData() {
    try {
        FileInputStream fis = new FileInputStream("data/products.csv");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Product> list =  (List<Product>) ois.readObject();
        fis.close();
        ois.close();
        return list;
    }catch (IOException | ClassNotFoundException e) {
        System.err.println(e.getMessage());
    }
    return null;
}
}
