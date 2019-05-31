package ecoprice.in.tonantmerchant.Retrofit.network;

import java.util.List;

import ecoprice.in.tonantmerchant.Models.AddtoCartRes;
import ecoprice.in.tonantmerchant.NewExample;
import ecoprice.in.tonantmerchant.Retrofit.Responce.AccessToken;
import ecoprice.in.tonantmerchant.Retrofit.Responce.ProductListResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface ApiService {

   /* @POST("SalesLogin")
    @FormUrlEncoded
    Call<AccessToken> getSalesLogin(@Body AccessToken request);*/



    @POST("SalesLogin")
    @FormUrlEncoded
    Call<AccessToken> SalesLogin(@Field("username") String username, @Field("pwd") String password);


    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @GET("AllProducts")
    Call<List<ProductListResponse>> getProductList();




    @POST("VendorAddcart")
    Call<AddtoCartRes> NewAddtoCart(@Body NewExample example);

    /*@POST("Login")
    @FormUrlEncoded
    Call<UserRegRes> Login(@Field("username") String username, @Field("pwd") String password);

    @POST("UserRegistration")
    @FormUrlEncoded
    Call<UserRegRes> UserRegistration(@Field("Name") String username, @Field("Phone") String Phone, @Field("Email") String Email, @Field("Password") String Password);
*/

   /* @POST("CreateShopKeepar")
    @FormUrlEncoded
    Call<AddShopResp> AddShop(
            @Field("First_Name") String firstname,
            @Field("CROEMailID") String emailid,
            @Field("MobileNumber") String mobilenumber,
            @Field("ShopName") String shopname,
            @Field("ShopAddress") String shopAddress,
            @Field("LeadType") String leadby,
            @Field("PIN_Code") String pincode,
            @Field("Latitude") String lat,
            @Field("Longitude") String longi,
            @Field("CreateBy") String createdby,
            @Field("LoginUserName") String loginUsername,
            @Field("UserName") String username
    );



    @POST("CreateShopKeepar")
    @FormUrlEncoded
    Call<AddShopResp> Update(
            @Field("Id") String id,
            @Field("First_Name") String firstname,
            @Field("CROEMailID") String emailid,
            @Field("MobileNumber") String mobilenumber,
            @Field("ShopName") String shopname,
            @Field("ShopAddress") String shopAddress,
            @Field("LeadType") String leadby,
            @Field("PIN_Code") String pincode,
            @Field("CreateBy") String createdby,
            @Field("LoginUserName") String loginUsername,
            @Field("UserName") String username
    );
    @POST("Settings")
    @FormUrlEncoded
    Call<Result> ChangePassword(@Field("OldPassword") String oldpass,
                                @Field("SPassword") String newpass,
                                @Field("Cpassword") String repass,
                                @Field("UserName") String username);

    @POST("CreateRemarks")
    @FormUrlEncoded
    Call<CreateRemarksRes> CreateRemarks(@Field("SalesName") String SalesName,
                                         @Field("ShopName") String ShopName,
                                         @Field("ShopUserName") String ShopUserName,
                                         @Field("Date") String Date,
                                         @Field("Remark") String Remark,
                                         @Field("RevisitDate") String RevisitDate);


    @POST("CreateTarget")
    @FormUrlEncoded
    Call<Targets> CreateTarget(@Field("OutletType") String TargetType,
                               @Field("TargetTitle") String TargetTitle,
                               @Field("OutletCount") String Retailers,
                               @Field("TargetDays") String TargetDays,
                               @Field("SaleKgs") String SaleKgs,
                               @Field("AddedBy") String userName,
                               @Field("Applicablefrom") String Applicablefrom,
                               @Field("Applicaleto") String Applicaleto,
                               @Field("TargetType") String type,
                               @Field("UserRole") String UserRole,
                               @Field("Month") String Month,
                               @Field("BusinessAmountlimit") String BusinessAmountlimit,
                               @Field("LoginUserName") String LoginUserName


    );

    @POST("Addreminder")
    @FormUrlEncoded
    Call<RemainderResp> Addreminder(@Field("ShopKeeperName") String ShopKeeperName,
                                    @Field("dateofvisittobe") String dateofvisittobe,
                                    @Field("VisiteType") String VisiteType,
                                    @Field("reason") String reason,
                                    @Field("SalesPerson") String SalesPerson);

    @POST("UpdateReminder")
    @FormUrlEncoded
    Call<RemainderResp> UpdateReminder(
            @Field("Id") String Id,
            @Field("ShopKeeperName") String ShopKeeperName,
            @Field("dateofvisittobe") String dateofvisittobe,
            @Field("VisiteType") String VisiteType,
            @Field("reason") String reason,
            @Field("SalesPerson") String SalesPerson);


    @POST("PendingAmount")
    @FormUrlEncoded
    Call<PendingRes> PendingAmount(@Field("ShopID") double ShopID,
                                   @Field("ShopName") String ShopName,
                                   @Field("ShopUsername") String ShopUsername,
                                   @Field("PendingAmount") String PendingAmount,
                                   @Field("PaidAmount") String PaidAmount,
                                   @Field("LoginUsername") String LoginUsername
    );

    //@FormUrlEncoded
    @POST("Addtocart")
    Call<AddtoCartRes> AddtoCart(@Body Example example);

    @POST("Addtocart")
    Call<AddtoCartRes> NewAddtoCart(@Body NewExample example);

    @GET("Addtocart")
    Call<AddtoCartRes> GetData(@Body NewExample example);*/

    /*@GET("MyOrdersbysales?Sales="+Ayup)
    Call<AddtoCartRes> GetOders(@Body NewExample example);*/

}


