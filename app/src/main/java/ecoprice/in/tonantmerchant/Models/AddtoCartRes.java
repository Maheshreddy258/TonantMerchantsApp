package ecoprice.in.tonantmerchant.Models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddtoCartRes {

    // Designation
    @SerializedName("RecardStatus")
    @Expose
   private boolean Status;

    @SerializedName("ErrorMessage")
    @Expose
    private  String ErrorMessage;

    @SerializedName("paidAmount")
   private int paidAmount;

    @SerializedName("NetAmount")
    private int NetAmount;

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public int getNetAmount() {
        return NetAmount;
    }

    public void setNetAmount(int netAmount) {
        NetAmount = netAmount;
    }
}

