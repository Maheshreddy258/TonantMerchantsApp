package ecoprice.in.tonantmerchant.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelProducts {


    @SerializedName("ProductId")
    @Expose
    private int Id;

    @SerializedName("ProductName")
    @Expose
    private String ProductName;


    @SerializedName("Quantity")
    @Expose
    private int Quantity;

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @SerializedName("DeliveryDate")
    @Expose
    public String deliveryDate;

    @SerializedName("UnitPrice")
    @Expose
    private double UnitPrice;

    @SerializedName("Price")
    @Expose
    private double Price;

    @SerializedName("ProductWait")
    @Expose
    private String ProductWait;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getProductWait() {
        return ProductWait;
    }

    public void setProductWait(String productWait) {
        ProductWait = productWait;
    }
}
