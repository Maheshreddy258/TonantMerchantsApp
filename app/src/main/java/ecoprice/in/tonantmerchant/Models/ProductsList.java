package ecoprice.in.tonantmerchant.Models;

public class ProductsList {
    private int Id,MRP,StockQuantity,ProductStatus;
    private double SalePrice,DiscountPercentage,minPrice;
    private String ProductName,Description,StockUnit,BannerImage,SortDesc,BrandName;
    private String DeliveryCharges,ShortName;
    private int qnty = 0;

    public ProductsList(int id, int MRP, int stockQuantity, int productStatus, double salePrice, double discountPercentage, double minPrice, String productName, String description, String stockUnit, String bannerImage, String sortDesc, String brandName, String deliveryCharges, String shortName) {
        Id = id;
        this.MRP = MRP;
        StockQuantity = stockQuantity;
        ProductStatus = productStatus;
        SalePrice = salePrice;
        DiscountPercentage = discountPercentage;
        this.minPrice = minPrice;
        ProductName = productName;
        Description = description;
        StockUnit = stockUnit;
        BannerImage = bannerImage;
        SortDesc = sortDesc;
        BrandName = brandName;
        DeliveryCharges = deliveryCharges;
        ShortName = shortName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getMRP() {
        return MRP;
    }

    public void setMRP(int MRP) {
        this.MRP = MRP;
    }

    public int getStockQuantity() {
        return StockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        StockQuantity = stockQuantity;
    }

    public int getProductStatus() {
        return ProductStatus;
    }

    public void setProductStatus(int productStatus) {
        ProductStatus = productStatus;
    }

    public double getSalePrice() {
        return SalePrice;
    }

    public void setSalePrice(double salePrice) {
        SalePrice = salePrice;
    }

    public double getDiscountPercentage() {
        return DiscountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        DiscountPercentage = discountPercentage;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getStockUnit() {
        return StockUnit;
    }

    public void setStockUnit(String stockUnit) {
        StockUnit = stockUnit;
    }

    public String getBannerImage() {
        return BannerImage;
    }

    public void setBannerImage(String bannerImage) {
        BannerImage = bannerImage;
    }

    public String getSortDesc() {
        return SortDesc;
    }

    public void setSortDesc(String sortDesc) {
        SortDesc = sortDesc;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    public String getDeliveryCharges() {
        return DeliveryCharges;
    }

    public void setDeliveryCharges(String deliveryCharges) {
        DeliveryCharges = deliveryCharges;
    }

    public String getShortName() {
        return ShortName;
    }

    public void setShortName(String shortName) {
        ShortName = shortName;
    }

    public int getQnty() {
        return qnty;
    }

    public void setQnty(int qnty) {
        this.qnty = qnty;
    }
}
