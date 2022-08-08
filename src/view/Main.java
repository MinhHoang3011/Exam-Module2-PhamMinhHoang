package view;

import controller.ProductManager;
import model.Product;
import storage.IReadWriteFile;
import storage.ReadWriteFile;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ProductManager productManager = new ProductManager();
    static IReadWriteFile readWriteFile = ReadWriteFile.getInstance();

    public static void main(String[] args) {
        menuOfProduct();
    }

    public static void menuOfProduct() {
        try {
            do {
                System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ----");
                System.out.println("Chọn chức năng theo số (để tiếp tục)");
                System.out.println("1. Xem danh sách");
                System.out.println("2. Thêm mới");
                System.out.println("3. Cập nhật");
                System.out.println("4. Xóa");
                System.out.println("5. Sắp xếp");
                System.out.println("6. Tìm sản phẩm có giá đắt nhất");
                System.out.println("7. Ghi file");
                System.out.println("8. Đọc file");
                System.out.println("9. Thoát");
                System.out.println("____________________________________________________");
                System.out.println("Xin mời nhập lựa chọn !!! ");

                Scanner scanner = new Scanner(System.in);
                Scanner scanner1 = new Scanner(System.in);
                int checknum = scanner1.nextInt();
                switch (checknum) {
                    case 1:
                        productManager.display();
                        break;
                    case 2:
                        try {
                            System.out.println("Mời bạn nhập id");
                            String id = scanner.nextLine();
                            System.out.println("Mời bạn nhập tên");
                            String name = scanner.nextLine();
                            System.out.println("Mời bạn nhập giá");
                            double price = scanner1.nextDouble();
                            System.out.println("Mời bạn nhập số lượng");
                            int amount = scanner1.nextInt();
                            System.out.println("Mời bạn nhập mô tả");
                            String describe = scanner.nextLine();
                            Product product = new Product(id, name, price, amount, describe);
                            productManager.add(product);
                        } catch (InputMismatchException e) {
                            System.out.println("Không thể thêm sản phẩm.Vui lòng nhập lại!!!");
                            System.out.println("____________________________________________________");
                        }
                        break;
                    case 3:
                        try {
                            System.out.println("Mời bạn nhập id (Mã) sản phẩm!!!");
                            String id = scanner.nextLine();
                            int check = productManager.checkId(id);
                            if (check == -1) {
                                System.out.println("Không tìm được sản phẩm với mã sản phẩm trên.");
                            } else {
                                System.out.println("Mời bạn nhập id ");
                                String newId = scanner.nextLine();
                                System.out.println("Mời bạn nhập tên ");
                                String newName = scanner.nextLine();
                                System.out.println("Mời bạn nhập giá ");
                                double newPrice = scanner1.nextDouble();
                                System.out.println("Mời bạn nhập số lượng ");
                                int newAmount = scanner1.nextInt();
                                System.out.println("Mời bạn nhập mô tả ");
                                String newDescribe = scanner.nextLine();
                                Product product = new Product(newId, newName, newPrice, newAmount, newDescribe);
                                productManager.editProduct(check, product);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Không tìm được sản phẩm với mã sản phẩm trên.");
                            System.out.println("______________________________________________________");
                        }
                        break;
                    case 4:
                        try {
                            System.out.println("Mời bạn nhập Id sản phẩm !!!");
                            String id = scanner.nextLine();
                            int check = productManager.checkId(id);
                            if (check == -1) {
                                System.out.println("Không tìm được sản phẩm với mã sản phẩm trên.");
                                System.out.println("____________________________________________________");
                            } else {
                                productManager.delete(check);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Không tìm được sản phẩm với mã sản phẩm trên.");
                            System.out.println("__________________________________________________________");
                        }
                        break;
                    case 5:
                        try {
                            System.out.println("1. Sắp sếp sản phẩm ");
                            System.out.println("2. Hiển thị danh sách sản phẩm đã sắp xếp");
                            System.out.println("3. Trở lại");
                            int check1 = scanner.nextInt();
                            switch (check1) {
                                case 1:
                                    productManager.sortByPrice();
                                    break;
                                case 2:
                                    productManager.display();
                                    break;
                                case 3:
                                    menuOfProduct();
                                    break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Không tìm được sản phẩm với mã sản phẩm trên.");
                            System.out.println("___________________________________________________");
                        }
                        break;
                    case 6:
                        productManager.sortByPrice();
                        List<Product> product1 = productManager.productList;
                        System.out.println(product1.get(product1.size()-1));
                        break;
                    case 7:
                        System.out.println("Bạn có chắc cập nhật File ( Y/N ) ");
                        String option = scanner1.nextLine();
                        if (option.equalsIgnoreCase("Y")) {
                            readWriteFile.writeData(productManager.productList);
                        }else {
                            System.out.println("Bạn lựa chọn không !!!");
                            menuOfProduct();
                        }
                    case 8:
                        productManager.productList = readWriteFile.readData();
                        break;
                    case 9:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Lựa chọn không tồn tại, mời bạn nhập lại !!!");
                        break;
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Nhập sai dữ liệu !!!");
            System.out.println("___________________________________________________");
            menuOfProduct();
        }
    }
}