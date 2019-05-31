package ecoprice.in.tonantmerchant;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ecoprice.in.tonantmerchant.Models.ModelProducts;

public class NewExample {
    @SerializedName("ShopUserName")
    @Expose
    private String ShopUserName;
    @SerializedName("ShopName")
    @Expose
    private String ShopName;
    @SerializedName("SalesLogin")
    @Expose
    private String SalesLogin;
    @SerializedName("NetAmount")
    @Expose
    private double NetAmount;
    @SerializedName("paidthrough")
    @Expose
    private String paidthrough;


    @SerializedName("paidAmount")
    @Expose
    private double paidAmount;
    @SerializedName("Quantity")
    @Expose
    private int Quantity;
    @SerializedName("DeliveryDate")
    @Expose
    public String deliveryDate;

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @SerializedName("PaymentStatus")
    @Expose
    private boolean PaymentStatus;

    @SerializedName("Deliverydate")
    @Expose
    private String deliverydate;

    @SerializedName("CreatedDate")
    @Expose
    private String CreatedDate;

   /* @SerializedName("CartItems")
    @Expose
    private List<Cart> CartItems = null;
*/

    public String getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(String deliverydate) {
        this.deliverydate = deliverydate;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    public NewExample() {

    }

    @SerializedName("CartItems")
    @Expose
    private List<ModelProducts> agendaWeekDays = null;

    public String getShopUserName() {
        return ShopUserName;
    }

    public void setShopUserName(String shopUserName) {
        ShopUserName = shopUserName;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String shopName) {
        ShopName = shopName;
    }

    public String getSalesLogin() {
        return SalesLogin;
    }

    public void setSalesLogin(String salesLogin) {
        SalesLogin = salesLogin;
    }

    public double getNetAmount() {
        return NetAmount;
    }

    public void setNetAmount(double netAmount) {
        NetAmount = netAmount;
    }

    public String getPaidthrough() {
        return paidthrough;
    }

    public void setPaidthrough(String paidthrough) {
        this.paidthrough = paidthrough;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public boolean isPaymentStatus() {
        return PaymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        PaymentStatus = paymentStatus;
    }

    public List<ModelProducts> getAgendaWeekDays() {
        return agendaWeekDays;
    }

    public void setAgendaWeekDays(List<ModelProducts> agendaWeekDays) {
        this.agendaWeekDays = agendaWeekDays;
    }
}

