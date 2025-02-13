package defaultPacket;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Bike Stores Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. Search Product by Name");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Save Products to File");
            System.out.println("6. Print Products from File");
            System.out.println("0. Quit");
            System.out.print("Choose an option: ");
            int choice = InputGetter.getInt("Enter your choice :");
            
            // load cái brand id và catergory id vào map đẻ tý dẽ dàng validate và truy suâts 
            Validation.loadBrandIds();
            Validation.loadCategoryIds();
            switch (choice) {
                case 1:
                    // Thêm sản phẩm

                    Product product = manager.createProduct(scanner);
                    manager.addProduct(product);
                    break;
                case 2:
                    // Tìm kiếm sản phẩm

                    String name = InputGetter.getString("Enter Search Name : ");
                    manager.searchProduct(name).forEach(System.out::println);
                    break;
                case 3:
                    // Cập nhật sản phẩm

                    String id = InputGetter.getString("Enter product ID to update:");
                    Product updatedProduct = manager.createProduct(scanner);
                    if (manager.updateProduct(id, updatedProduct)) {
                        System.out.println("Product updated successfully.");
                    } else {
                        System.out.println("Product not found or Invalid ");
                    }
                    break;
                case 4:
                    // Xóa sản phẩm

                    id = InputGetter.getString("Enter product ID to delete: ");
                    if (manager.deleteProduct(id)) {
                        System.out.println("Product deleted successfully.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 5:
                    // Lưu vào file
                    FileManager.saveProductsToFile(manager.getProductList(), "Product.txt");
                    break;
                case 6:
                    // Hiển thị danh sách từ file
                    FileManager.printProductsFromFile("Product.txt");
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }

            // Yêu cầu người dùng nhấn phím để quay lại menu chính
            if (choice != 0) {
                System.out.println("\nPress Enter to return to the main menu...");
                scanner.nextLine();  // Đợi người dùng nhấn Enter
            }
        }

        scanner.close();
    }

}
