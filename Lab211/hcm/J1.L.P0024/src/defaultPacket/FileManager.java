
package defaultPacket;

import static defaultPacket.Validation.brandMap;
import static defaultPacket.Validation.categoryMap;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileManager {

    // Ghi thông tin các sản pham đã tạo vào file 
    public static void saveProductsToFile(ArrayList<Product> productList,String fileName) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
        for (Product product : productList) {
            String line = String.join(",",
                    product.getId(),
                    product.getName(),
                    product.getBrandId(),
                    product.getCategoryId(),
                    String.valueOf(product.getModelYear()),
                    String.valueOf(product.getListPrice())
            );
            writer.write(line);
            writer.newLine(); // Thêm dòng mới sau mỗi sản phẩm
        }
        System.out.println("Products saved to file successfully!");
    } catch (IOException e) {
        System.out.println("Error saving products to file: " + e.getMessage());
    }
}


 
    // đọc từ file các sản phẩm đã lưu và hiển thị ra màn hình 
    
  public static void printProductsFromFile(String fileName) {
    List<Product> products = new ArrayList<>();

    // Đọc thông tin sản phẩm từ file
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(","); // Tách thông tin sản phẩm
            if (parts.length == 6) {
                // Tạo sản phẩm từ các phần tử trong mảng
                Product product = new Product(
                        parts[0].trim(),
                        parts[1].trim(),
                        parts[2].trim(),
                        parts[3].trim(),
                        Integer.parseInt(parts[4].trim()), // ép kiểu cho đúng format 
                        Double.parseDouble(parts[5].trim())
                );
                products.add(product); // Thêm vào danh sách
            }
        }
        // sử lý ngoại lệ nếu có lỗi khi đọc file 
    } catch (IOException e) {
        System.out.println("Error reading products from file: " + e.getMessage());
        return;
    }

    // Sắp xếp sản phẩm theo giá giảm, nếu giá giống nhau thì theo tên tăng dần
    products.sort(Comparator.comparingDouble(Product::getListPrice).reversed()
            .thenComparing(Product::getName));

    // Hiển thị thông tin sản phẩm
    System.out.printf("%-10s %-20s %-20s %-20s %-10s %-10s%n", "ID", "Name", "Brand Name", "Category Name", "Model Year", "List Price");
    for (Product product : products) {
        // đề bài yều cầu hiển thị tên không phải ID nền phải đổi 
        String brandName = Validation.brandMap.containsKey(product.getBrandId()) ? brandMap.get(product.getBrandId())[0] : "Unknown";
        String categoryName = Validation.categoryMap.containsKey(product.getCategoryId()) ? categoryMap.get(product.getCategoryId())[0] : "Unknown";

        System.out.printf("%-10s %-20s %-20s %-20s %-10d %-10.2f%n",
                product.getId(),
                product.getName(),
                brandName,
                categoryName,
                product.getModelYear(),
                product.getListPrice());
    }
}
}

   

