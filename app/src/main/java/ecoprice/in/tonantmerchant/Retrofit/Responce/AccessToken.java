package ecoprice.in.tonantmerchant.Retrofit.Responce;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccessToken {

    // Designation

    @SerializedName("UserName")
    @Expose
   public String Username;

    @SerializedName("Loginstatus")
    @Expose
   private boolean Status;

    @SerializedName("Role")
    @Expose
    public String role;

    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("ErrorMessage")
    @Expose
    public String errorMessage;



    public void setUsername(String username) {
        Username = username;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }
}

