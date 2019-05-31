package ecoprice.in.tonantmerchant.Retrofit.Responce;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProductListResponse implements Serializable
{

    @SerializedName("Id")
    @Expose
    public Integer id;
    @SerializedName("ProductName")
    @Expose
    public String productName;
    @SerializedName("Description")
    @Expose
    public String description;
    @SerializedName("MRP")
    @Expose
    public Double mRP;
    @SerializedName("SalePrice")
    @Expose
    public Double salePrice;
    @SerializedName("StockUnit")
    @Expose
    public String stockUnit;
    @SerializedName("StockQuantity")
    @Expose
    public Integer stockQuantity;
    @SerializedName("Cancelation")
    @Expose
    public String cancelation;
    @SerializedName("StockStatus")
    @Expose
    public String stockStatus;
    @SerializedName("ProductWeight")
    @Expose
    public Double productWeight;
    @SerializedName("Lenght")
    @Expose
    public Double lenght;
    @SerializedName("Width")
    @Expose
    public Double width;
    @SerializedName("Height")
    @Expose
    public Double height;
    @SerializedName("ShippingClass")
    @Expose
    public String shippingClass;
    @SerializedName("LinkedProductsofme")
    @Expose
    public String linkedProductsofme;
    @SerializedName("Otherinfo")
    @Expose
    public String otherinfo;
    @SerializedName("TermsandCondition")
    @Expose
    public String termsandCondition;
    @SerializedName("CODStatus")
    @Expose
    public Boolean cODStatus;
    @SerializedName("BannerImage")
    @Expose
    public String bannerImage;
    @SerializedName("OtherImages")
    @Expose
    public String otherImages;
    @SerializedName("DiscountPercentage")
    @Expose
    public Double discountPercentage;
    @SerializedName("DeliveryContent")
    @Expose
    public String deliveryContent;
    @SerializedName("ProductCode")
    @Expose
    public String productCode;
    @SerializedName("CreatedBy")
    @Expose
    public String createdBy;
    @SerializedName("Createdate")
    @Expose
    public String createdate;
    @SerializedName("SortDesc")
    @Expose
    public String sortDesc;
    @SerializedName("MenuCateogory")
    @Expose
    public String menuCateogory;
    @SerializedName("Category")
    @Expose
    public String category;
    @SerializedName("SubCategory")
    @Expose
    public String subCategory;
    @SerializedName("Status")
    @Expose
    public Boolean status;
    @SerializedName("ProductStatus")
    @Expose
    public Integer productStatus;
    @SerializedName("BrandName")
    @Expose
    public String brandName;
    @SerializedName("ISISStsua")
    @Expose
    public Boolean iSISStsua;
    @SerializedName("ISISStsua_")
    @Expose
    public Boolean iSISStsua_;
    @SerializedName("IsFutureProduct")
    @Expose
    public Boolean isFutureProduct;
    @SerializedName("IsFutureProduct_")
    @Expose
    public Boolean isFutureProduct_;
    @SerializedName("OnSaleFrom")
    @Expose
    public String onSaleFrom;
    @SerializedName("Rating")
    @Expose
    public Double rating;
    @SerializedName("Color")
    @Expose
    public String color;
    @SerializedName("Highlights")
    @Expose
    public String highlights;
    @SerializedName("DeliveryCharges")
    @Expose
    public Double deliveryCharges;
    @SerializedName("VendorName")
    @Expose
    public String vendorName;
    @SerializedName("AvailableSizes")
    @Expose
    public String availableSizes;
    @SerializedName("AvailableColors")
    @Expose
    public Integer availableColors;
    @SerializedName("sibilingProducts")
    @Expose
    public String sibilingProducts;
    @SerializedName("marginPercentage")
    @Expose
    public Integer marginPercentage;
    @SerializedName("CashopyPrice")
    @Expose
    public Double cashopyPrice;
    @SerializedName("specification")
    @Expose
    public String specification;
    @SerializedName("ProductType")
    @Expose
    public String productType;
    @SerializedName("SKU")
    @Expose
    public String sKU;
    @SerializedName("TaxRate_Percentage")
    @Expose
    public Double taxRatePercentage;
    @SerializedName("Tax_Type")
    @Expose
    public String taxType;
    @SerializedName("Tax_Amount")
    @Expose
    public Double taxAmount;
    @SerializedName("Shipping_TaxRate_Percentage")
    @Expose
    public Double shippingTaxRatePercentage;
    @SerializedName("Shipping_Tax_Type")
    @Expose
    public String shippingTaxType;
    @SerializedName("Shipping_Tax_Amount")
    @Expose
    public Double shippingTaxAmount;
    @SerializedName("keywords")
    @Expose
    public String keywords;
    @SerializedName("Productsfabtype")
    @Expose
    public String productsfabtype;
    @SerializedName("ShortName")
    @Expose
    public String shortName;
    @SerializedName("InHouseProd_Status")
    @Expose
    public Boolean inHouseProdStatus;
    @SerializedName("PartOfoffer")
    @Expose
    public Boolean partOfoffer;
    @SerializedName("Comments")
    @Expose
    public String comments;
    @SerializedName("Is_Trendy")
    @Expose
    public Boolean isTrendy;
    @SerializedName("Is_Trendy_")
    @Expose
    public Boolean isTrendy_;
    @SerializedName("Is_HotDeal")
    @Expose
    public Boolean isHotDeal;
    @SerializedName("Is_HotDeal_")
    @Expose
    public Boolean isHotDeal_;
    @SerializedName("gm100")
    @Expose
    public Integer gm100;
    @SerializedName("gm200")
    @Expose
    public Integer gm200;
    @SerializedName("gm500")
    @Expose
    public Integer gm500;
    @SerializedName("kg1")
    @Expose
    public Integer kg1;
    @SerializedName("kg2")
    @Expose
    public Integer kg2;
    @SerializedName("kg5")
    @Expose
    public Integer kg5;
    @SerializedName("gm100price")
    @Expose
    public Double gm100price;
    @SerializedName("gm200price")
    @Expose
    public Double gm200price;
    @SerializedName("gm500price")
    @Expose
    public Double gm500price;
    @SerializedName("kg1price")
    @Expose
    public Double kg1price;
    @SerializedName("kg2price")
    @Expose
    public Double kg2price;
    @SerializedName("kg5price")
    @Expose
    public Double kg5price;
    @SerializedName("gm100mrp")
    @Expose
    public Double gm100mrp;
    @SerializedName("gm200mrp")
    @Expose
    public Double gm200mrp;
    @SerializedName("gm500mrp")
    @Expose
    public Double gm500mrp;
    @SerializedName("kg1mrp")
    @Expose
    public Double kg1mrp;
    @SerializedName("kg2mrp")
    @Expose
    public Double kg2mrp;
    @SerializedName("kg5mrp")
    @Expose
    public Double kg5mrp;
    @SerializedName("ReceivedBy_product")
    @Expose
    public String receivedByProduct;
    @SerializedName("DeliveredBy_product")
    @Expose
    public String deliveredByProduct;
    @SerializedName("minPrice")
    @Expose
    public Double minPrice;
    @SerializedName("backgroundColor")
    @Expose
    public String backgroundColor;
    private final static long serialVersionUID = 4495954418488028950L;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMRP() {
        return mRP;
    }

    public void setMRP(Double mRP) {
        this.mRP = mRP;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getStockUnit() {
        return stockUnit;
    }

    public void setStockUnit(String stockUnit) {
        this.stockUnit = stockUnit;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getCancelation() {
        return cancelation;
    }

    public void setCancelation(String cancelation) {
        this.cancelation = cancelation;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }

    public Double getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(Double productWeight) {
        this.productWeight = productWeight;
    }

    public Double getLenght() {
        return lenght;
    }

    public void setLenght(Double lenght) {
        this.lenght = lenght;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getShippingClass() {
        return shippingClass;
    }

    public void setShippingClass(String shippingClass) {
        this.shippingClass = shippingClass;
    }

    public String getLinkedProductsofme() {
        return linkedProductsofme;
    }

    public void setLinkedProductsofme(String linkedProductsofme) {
        this.linkedProductsofme = linkedProductsofme;
    }

    public String getOtherinfo() {
        return otherinfo;
    }

    public void setOtherinfo(String otherinfo) {
        this.otherinfo = otherinfo;
    }

    public String getTermsandCondition() {
        return termsandCondition;
    }

    public void setTermsandCondition(String termsandCondition) {
        this.termsandCondition = termsandCondition;
    }

    public Boolean getCODStatus() {
        return cODStatus;
    }

    public void setCODStatus(Boolean cODStatus) {
        this.cODStatus = cODStatus;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getOtherImages() {
        return otherImages;
    }

    public void setOtherImages(String otherImages) {
        this.otherImages = otherImages;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getDeliveryContent() {
        return deliveryContent;
    }

    public void setDeliveryContent(String deliveryContent) {
        this.deliveryContent = deliveryContent;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getSortDesc() {
        return sortDesc;
    }

    public void setSortDesc(String sortDesc) {
        this.sortDesc = sortDesc;
    }

    public String getMenuCateogory() {
        return menuCateogory;
    }

    public void setMenuCateogory(String menuCateogory) {
        this.menuCateogory = menuCateogory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Boolean getISISStsua() {
        return iSISStsua;
    }

    public void setISISStsua(Boolean iSISStsua) {
        this.iSISStsua = iSISStsua;
    }

    public Boolean getIsFutureProduct() {
        return isFutureProduct;
    }

    public void setIsFutureProduct(Boolean isFutureProduct) {
        this.isFutureProduct = isFutureProduct;
    }

    public String getOnSaleFrom() {
        return onSaleFrom;
    }

    public void setOnSaleFrom(String onSaleFrom) {
        this.onSaleFrom = onSaleFrom;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHighlights() {
        return highlights;
    }

    public void setHighlights(String highlights) {
        this.highlights = highlights;
    }

    public Double getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(Double deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getAvailableSizes() {
        return availableSizes;
    }

    public void setAvailableSizes(String availableSizes) {
        this.availableSizes = availableSizes;
    }

    public Integer getAvailableColors() {
        return availableColors;
    }

    public void setAvailableColors(Integer availableColors) {
        this.availableColors = availableColors;
    }

    public String getSibilingProducts() {
        return sibilingProducts;
    }

    public void setSibilingProducts(String sibilingProducts) {
        this.sibilingProducts = sibilingProducts;
    }

    public Integer getMarginPercentage() {
        return marginPercentage;
    }

    public void setMarginPercentage(Integer marginPercentage) {
        this.marginPercentage = marginPercentage;
    }

    public Double getCashopyPrice() {
        return cashopyPrice;
    }

    public void setCashopyPrice(Double cashopyPrice) {
        this.cashopyPrice = cashopyPrice;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getSKU() {
        return sKU;
    }

    public void setSKU(String sKU) {
        this.sKU = sKU;
    }

    public Double getTaxRatePercentage() {
        return taxRatePercentage;
    }

    public void setTaxRatePercentage(Double taxRatePercentage) {
        this.taxRatePercentage = taxRatePercentage;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Double getShippingTaxRatePercentage() {
        return shippingTaxRatePercentage;
    }

    public void setShippingTaxRatePercentage(Double shippingTaxRatePercentage) {
        this.shippingTaxRatePercentage = shippingTaxRatePercentage;
    }

    public String getShippingTaxType() {
        return shippingTaxType;
    }

    public void setShippingTaxType(String shippingTaxType) {
        this.shippingTaxType = shippingTaxType;
    }

    public Double getShippingTaxAmount() {
        return shippingTaxAmount;
    }

    public void setShippingTaxAmount(Double shippingTaxAmount) {
        this.shippingTaxAmount = shippingTaxAmount;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getProductsfabtype() {
        return productsfabtype;
    }

    public void setProductsfabtype(String productsfabtype) {
        this.productsfabtype = productsfabtype;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Boolean getInHouseProdStatus() {
        return inHouseProdStatus;
    }

    public void setInHouseProdStatus(Boolean inHouseProdStatus) {
        this.inHouseProdStatus = inHouseProdStatus;
    }

    public Boolean getPartOfoffer() {
        return partOfoffer;
    }

    public void setPartOfoffer(Boolean partOfoffer) {
        this.partOfoffer = partOfoffer;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Boolean getIsTrendy() {
        return isTrendy;
    }

    public void setIsTrendy(Boolean isTrendy) {
        this.isTrendy = isTrendy;
    }

    public Boolean getIsHotDeal() {
        return isHotDeal;
    }

    public void setIsHotDeal(Boolean isHotDeal) {
        this.isHotDeal = isHotDeal;
    }

    public Integer getGm100() {
        return gm100;
    }

    public void setGm100(Integer gm100) {
        this.gm100 = gm100;
    }

    public Integer getGm200() {
        return gm200;
    }

    public void setGm200(Integer gm200) {
        this.gm200 = gm200;
    }

    public Integer getGm500() {
        return gm500;
    }

    public void setGm500(Integer gm500) {
        this.gm500 = gm500;
    }

    public Integer getKg1() {
        return kg1;
    }

    public void setKg1(Integer kg1) {
        this.kg1 = kg1;
    }

    public Integer getKg2() {
        return kg2;
    }

    public void setKg2(Integer kg2) {
        this.kg2 = kg2;
    }

    public Integer getKg5() {
        return kg5;
    }

    public void setKg5(Integer kg5) {
        this.kg5 = kg5;
    }

    public Double getGm100price() {
        return gm100price;
    }

    public void setGm100price(Double gm100price) {
        this.gm100price = gm100price;
    }

    public Double getGm200price() {
        return gm200price;
    }

    public void setGm200price(Double gm200price) {
        this.gm200price = gm200price;
    }

    public Double getGm500price() {
        return gm500price;
    }

    public void setGm500price(Double gm500price) {
        this.gm500price = gm500price;
    }

    public Double getKg1price() {
        return kg1price;
    }

    public void setKg1price(Double kg1price) {
        this.kg1price = kg1price;
    }

    public Double getKg2price() {
        return kg2price;
    }

    public void setKg2price(Double kg2price) {
        this.kg2price = kg2price;
    }

    public Double getKg5price() {
        return kg5price;
    }

    public void setKg5price(Double kg5price) {
        this.kg5price = kg5price;
    }

    public Double getGm100mrp() {
        return gm100mrp;
    }

    public void setGm100mrp(Double gm100mrp) {
        this.gm100mrp = gm100mrp;
    }

    public Double getGm200mrp() {
        return gm200mrp;
    }

    public void setGm200mrp(Double gm200mrp) {
        this.gm200mrp = gm200mrp;
    }

    public Double getGm500mrp() {
        return gm500mrp;
    }

    public void setGm500mrp(Double gm500mrp) {
        this.gm500mrp = gm500mrp;
    }

    public Double getKg1mrp() {
        return kg1mrp;
    }

    public void setKg1mrp(Double kg1mrp) {
        this.kg1mrp = kg1mrp;
    }

    public Double getKg2mrp() {
        return kg2mrp;
    }

    public void setKg2mrp(Double kg2mrp) {
        this.kg2mrp = kg2mrp;
    }

    public Double getKg5mrp() {
        return kg5mrp;
    }

    public void setKg5mrp(Double kg5mrp) {
        this.kg5mrp = kg5mrp;
    }

    public String getReceivedByProduct() {
        return receivedByProduct;
    }

    public void setReceivedByProduct(String receivedByProduct) {
        this.receivedByProduct = receivedByProduct;
    }

    public String getDeliveredByProduct() {
        return deliveredByProduct;
    }

    public void setDeliveredByProduct(String deliveredByProduct) {
        this.deliveredByProduct = deliveredByProduct;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

}