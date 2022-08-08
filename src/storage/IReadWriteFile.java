package storage;

import model.Product;

import java.util.List;

public interface IReadWriteFile {
    public void writeData(List<Product> products);
    public List<Product> readData();
}
