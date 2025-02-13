
package defaultPacket;

public class Product {
    private String id;
    private String name;
    private String brandId;
    private String categoryId;
    private int modelYear;
    private double listPrice;

    // Constructor
    public Product(String id, String name, String brandId, String categoryId, int modelYear, double listPrice) {
        this.id = id;
        this.name = name;
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.modelYear = modelYear;
        this.listPrice = listPrice;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBrandId() { return brandId; }
    public void setBrandId(String brandId) { this.brandId = brandId; }

    public String getCategoryId() { return categoryId; }
    public void setCategoryId(String categoryId) { this.categoryId = categoryId; }

    public int getModelYear() { return modelYear; }
    public void setModelYear(int modelYear) { this.modelYear = modelYear; }

    public double getListPrice() { return listPrice; }
    public void setListPrice(double listPrice) { this.listPrice = listPrice; }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Brand: %s | Category: %s | Year: %d | Price: %.2f", 
            id, name, brandId, categoryId, modelYear, listPrice);
    }
}
