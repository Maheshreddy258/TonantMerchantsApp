package ecoprice.in.tonantmerchant.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cart {
    /** Property name */

    private int position;

    @SerializedName("Price")
    @Expose
   private double Price;

    @SerializedName("ProductName")
    @Expose
    private String ProductName;

   @SerializedName("UnitPrice")
    @Expose
   private double salePrice;

    /** Property quantity */
    @SerializedName("Quantity")
    @Expose
    private int qnty;


    @SerializedName("ProductId")
    @Expose
    private int Id;

    public Cart(int id, String productName, int qnty, double salePrice, double price) {
        Price = price;
        ProductName = productName;
        this.salePrice = salePrice;
        this.qnty = qnty;
        Id = id;
    }



    public Cart() {
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {


        this.position = position;
    }

    /**
     * Constructor
     */


    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public int getQnty() {
        return qnty;
    }

    public void setQnty(int qnty) {
        this.qnty = qnty;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}