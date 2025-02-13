package defaultPacket;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Product> productList; // đẻ lưu trưx nhung sản phàn mới tạo 
    private int countID = 1; 
    public ProductManager() {
        this.productList = new ArrayList<>();
    }

    // Thêm sản phẩm
    public void addProduct(Product product) {
        if (Validation.validateProduct(product)) {  // validate 
            productList.add(product);
            System.out.println("Product added successfully!");
        } else {
            System.out.println("Invalid product data.");
        }
    }

    // Tìm kiếm sản phẩm
    // Tìm kiếm sản phẩm theo tên
    public ArrayList<Product> searchProduct(String name) {
        ArrayList<Product> results = new ArrayList<>();

        if (name == null || name.trim().isEmpty()) {
            System.out.println("Search string cannot be empty.");
            return results; // Trả về danh sách rỗng nếu chuỗi tìm kiếm không hợp lệ
        }

        for (Product p : productList) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                results.add(p);
            }
        }

        return results; // Trả về danh sách sản phẩm tìm thấy
    }

    // Cập nhật sản phẩm
    public boolean updateProduct(String id, Product updatedProduct) {
        if (!Validation.validateProduct(updatedProduct)) {  // sem thông tin update có hợp lệ kh 
            System.out.println("Invalid update infomation ");
            return false;
        }
        for (Product p : productList) {
            if (p.getId().equals(id)) {
                p.setName(updatedProduct.getName());
                p.setBrandId(updatedProduct.getBrandId());
                p.setCategoryId(updatedProduct.getCategoryId());
                p.setModelYear(updatedProduct.getModelYear());
                p.setListPrice(updatedProduct.getListPrice());
                return true;
            }
        }
        return false;
    }

    // Xóa sản phẩm
    public boolean deleteProduct(String id) {

        // Tìm sản phẩm theo ID
        Product productToDelete = null;
        for (Product p : productList) {
            if (p.getId().equals(id)) {
                productToDelete = p;
                break;
            }
        }

        // Kiểm tra xem sản phẩm có tồn tại không
        if (productToDelete == null) {
            System.out.println("Product does not exist.");
            return false;
        }

        // Hiển thị thông tin sản phẩm để xác nhận xóa
        System.out.println("Are you sure you want to delete the following product?");
        System.out.println(productToDelete);
        System.out.print("Type 'yes' to confirm: ");
        String confirmation = scanner.nextLine();

        if ("yes".equalsIgnoreCase(confirmation)) {
            productList.remove(productToDelete); // Xóa sản phẩm
            
            return true;
        } else {
           
            return false;
        }
    }

    // trả về list đẻ ghi vào file 
    public ArrayList<Product> getProductList() {
        return productList;
    }
    // ở đây chỉ lấy thông tin tạo sp 
    // lúc add vào list sẽ validate 
    public Product createProduct(Scanner scanner) {
        System.out.println("Create product :");
        String id = String.format("%06d", countID++);
        String name = InputGetter.getString("Enter name :");
        String brandId = InputGetter.getString("Enter brand id :");
        String categoryId = InputGetter.getString("Enter category id:");
        int modelYear = InputGetter.getInt("Enter modelyear : :");
        double listPrice = InputGetter.getDouble("Enter listPrice ::");
        return new Product(id, name, brandId, categoryId, modelYear, listPrice);
    }

}
