package defaultPacket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Validation {

    public static Map<String, String[]> brandMap = new HashMap<>();
    public static Map<String, String[]> categoryMap = new HashMap<>();

    // Tải Brand ID từ file Brand.txt

    public static void loadBrandIds() {
        try (BufferedReader br = new BufferedReader(new FileReader("Brand.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // Tách các phần tử bằng dấu phẩy
                if (parts.length >= 2) {
                    // Lưu Brand ID và mảng chứa tên và nguồn gốc vào Map
                    brandMap.put(parts[0].trim(), new String[]{parts[1].trim(), parts.length > 2 ? parts[2].trim() : ""});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Tải Category ID từ file Category.txt
    public static void loadCategoryIds() {
        try (BufferedReader br = new BufferedReader(new FileReader("Category.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // Tách các phần tử bằng dấu phẩy
                if (parts.length >= 2) {
                    // Lưu Category ID và mảng chứa tên và nguồn gốc vào Map
                    categoryMap.put(parts[0].trim(), new String[]{parts[1].trim(), parts.length > 2 ? parts[2].trim() : ""});
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hàm kiểm tra tính hợp lệ của sản phẩm
    public static boolean validateProduct(Product product) {
        return isNameValid(product.getName())
                && isBrandIdValid(product.getBrandId())
                && isCategoryIdValid(product.getCategoryId())
                && isModelYearValid(product.getModelYear())
                && isListPriceValid(product.getListPrice());
    }

    // Kiểm tra tên sản phẩm không rỗng
    private static boolean isNameValid(String name) {
        return !name.isEmpty();
    }

    // Kiểm tra Brand ID có trong Map
    private static boolean isBrandIdValid(String brandId) {
        return brandMap.containsKey(brandId);
    }

    // Kiểm tra Category ID có trong Map
    private static boolean isCategoryIdValid(String categoryId) {
        return categoryMap.containsKey(categoryId);
    }

    // Kiểm tra Model Year hợp lệ
    private static boolean isModelYearValid(int modelYear) {
        return modelYear >= 2000 && modelYear <= 2024;
    }

    // Kiểm tra List Price dương
    private static boolean isListPriceValid(double listPrice) {
        return listPrice > 0;
    }
}
