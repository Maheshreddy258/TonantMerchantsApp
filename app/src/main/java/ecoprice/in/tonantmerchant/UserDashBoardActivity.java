package ecoprice.in.tonantmerchant;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import ecoprice.InternetChecker;
import ecoprice.in.tonantmerchant.Adapters.ProductAdapter;
import ecoprice.in.tonantmerchant.Auth.UserLoginActivity;
import ecoprice.in.tonantmerchant.Models.Cart;
import ecoprice.in.tonantmerchant.Models.ModelProducts;
import ecoprice.in.tonantmerchant.Models.NewModelCart;
import ecoprice.in.tonantmerchant.Models.ProductsList;
import ecoprice.in.tonantmerchant.Retrofit.Responce.AccessToken;
import ecoprice.in.tonantmerchant.Retrofit.Responce.ProductListResponse;
import ecoprice.in.tonantmerchant.Retrofit.SharedPref;
import ecoprice.in.tonantmerchant.Retrofit.network.ApiClient;
import ecoprice.in.tonantmerchant.Retrofit.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDashBoardActivity extends AppCompatActivity {

    private static final String TAG = "UserDashBoardActivity";
    private RecyclerView Gal_Rec;
    private TextView TextTotal;
    private ProductAdapter adapter;
    private List<ProductsList> listItems;
    private List<Cart> list;
    private List<AccessToken> accessTokens;
    String URL_DATA = "http://apiservices.tonantfarmers.com/api/AllProducts";
  //  private AppCompatButton ButtonBtn;
    private String[] strings;
    private List<Cart> productsList = new ArrayList();
    private ProgressBar progressBar;
    private LinearLayout coordinatorLayout;
    int clickon;
   // InternetChecker internetChecker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //internetChecker = new InternetChecker(this);
        ///ButtonBtn = (AppCompatButton) findViewById(R.id.ButtonBtn);
        progressBar = (ProgressBar)  findViewById(R.id.Prog_Assigned);
        Gal_Rec = (RecyclerView) findViewById(R.id.Rec_Gallery);
        Gal_Rec.setHasFixedSize(true);
        Gal_Rec.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        Gal_Rec.setLayoutManager(mLayoutManager);
        listItems = new ArrayList<>();
        list = new ArrayList<>();
        TextTotal = (TextView) findViewById(R.id.TextTotal);
        coordinatorLayout = (LinearLayout) findViewById(R.id.coordinatorLayout);

        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter("custom-message"));

        loadRecyclerViewData();
        final String ShopUserName = getIntent().getStringExtra("ShopUserName");
        final String ShopName = getIntent().getStringExtra("ShopName");
        //ModelCart.setData(productsList);
        coordinatorLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<ModelProducts> data = NewModelCart.getData();
                if (data.size() > 0){
                    Intent intent = new Intent(UserDashBoardActivity.this, NewPlaceOderActivity.class);
                    intent.putExtra("strings", String.valueOf(productsList));
                    intent.putExtra("ShopUserName", ShopUserName);
                    intent.putExtra("ShopName", ShopName);
                    //intent.putExtra("pos", position);
                    startActivity(intent);
                }else {
                    Toast.makeText(UserDashBoardActivity.this,"Select Any Product to CART",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loadRecyclerViewData() {
        progressBar.setVisibility(View.VISIBLE);
        Gal_Rec.setVisibility(View.GONE);
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<List<ProductListResponse>> productListResponseCall = apiService.getProductList();
        productListResponseCall.enqueue(new Callback<List<ProductListResponse>>() {
            @Override
            public void onResponse(Call<List<ProductListResponse>> call, Response<List<ProductListResponse>> response) {
                progressBar.setVisibility(View.GONE);
                Gal_Rec.setVisibility(View.VISIBLE);

                if (response.isSuccessful() && response != null) {

                    List<ProductListResponse> productList = new ArrayList<>();
                    productList = response.body();

                    if (productList != null && productList.size() > 0) {

                        adapter = new ProductAdapter(getApplicationContext(), productList,TextTotal);
                        Log.e("product list", "sucesss....maggg");
                        Gal_Rec.setAdapter(adapter);

                    } else {
                        Toast.makeText(getApplicationContext(), "No Products found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Failed To get the Products List", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ProductListResponse>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
        /*JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL_DATA, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                progressBar.setVisibility(View.GONE);
                Gal_Rec.setVisibility(View.VISIBLE);
                try {
                    if (response.length() > 0) {
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject obj = response.getJSONObject(i);
                            ProductsList item = new ProductsList(
                                    obj.getInt("Id"),
                                    obj.getInt("MRP"),
                                    obj.getInt("StockQuantity"),
                                    obj.getInt("ProductStatus"),
                                    obj.getDouble("SalePrice"),
                                    obj.getDouble("DiscountPercentage"),
                                    obj.getDouble("minPrice"),
                                    obj.getString("ProductName"),
                                    obj.getString("Description"),
                                    obj.getString("StockUnit"),
                                    obj.getString("BannerImage"),
                                    obj.getString("SortDesc"),
                                    obj.getString("BrandName"),
                                    obj.getString("DeliveryCharges"),
                                    obj.getString("ShortName")
                            );
                            listItems.add(item);
                            Log.e("listItems",""+listItems.size());
                            adapter = new ProductAdapter(listItems, getApplicationContext());
                            Gal_Rec.setAdapter(adapter);
                        }
                        adapter = new ProductAdapter(listItems, getApplicationContext());
                        Gal_Rec.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Gal_Rec.setVisibility(View.GONE);
                TringAgain();


            }
        }){

            @Override
            protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
                try {
                    Cache.Entry cacheEntry = HttpHeaderParser.parseCacheHeaders(response);
                    if (cacheEntry == null) {
                        cacheEntry = new Cache.Entry();
                    }
                    final long cacheHitButRefreshed = 3 * 60 * 1000; // in 3 minutes cache will be hit, but also refreshed on background
                    final long cacheExpired = 24 * 60 * 60 * 1000; // in 24 hours this cache entry expires completely
                    long now = System.currentTimeMillis();
                    final long softExpire = now + cacheHitButRefreshed;
                    final long ttl = now + cacheExpired;
                    cacheEntry.data = response.data;
                    cacheEntry.softTtl = softExpire;
                    cacheEntry.ttl = ttl;
                    String headerValue;
                    headerValue = response.headers.get("Date");
                    if (headerValue != null) {
                        cacheEntry.serverDate = HttpHeaderParser.parseDateAsEpoch(headerValue);
                    }
                    headerValue = response.headers.get("Last-Modified");
                    if (headerValue != null) {
                        cacheEntry.lastModified = HttpHeaderParser.parseDateAsEpoch(headerValue);
                    }
                    cacheEntry.responseHeaders = response.headers;
                    final String jsonString = new String(response.data,
                            HttpHeaderParser.parseCharset(response.headers));
                    return Response.success(new JSONArray(jsonString), cacheEntry);
                } catch (UnsupportedEncodingException e) {
                    return Response.error(new ParseError(e));
                } catch (JSONException e) {
                    return Response.error(new ParseError(e));
                }
            }

            @Override
            protected void deliverResponse(JSONArray response) {
                super.deliverResponse(response);
            }

            @Override
            public void deliverError(VolleyError error) {
                super.deliverError(error);
            }

            @Override
            protected VolleyError parseNetworkError(VolleyError volleyError) {
                return super.parseNetworkError(volleyError);
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(UserDashBoardActivity.this);
        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                2000*5,
                *//*DefaultRetryPolicy.DEFAULT_MAX_RETRIES*//* 3,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(jsonArrayRequest);*/


    }
       /* RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(jsonArrayRequest);


    }
*/
    private void TringAgain() {
       // Toast.makeText(UserDashBoardActivity.this, "Try Again :(", Toast.LENGTH_SHORT).show();
        loadRecyclerViewData();

    }
    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String total = intent.getStringExtra("total");
            String quantity = intent.getStringExtra("quantity");
            Log.e("quantity",""+quantity);
            //int a = Integer.parseInt(quntity);
            //TextTotal.setText(quantity+" items | "+total+"Rs");
            TextTotal.setText("₹"+total);



                }
    };

/*    @Override
    protected void onStart() {
        SharedPref sharedPref = new SharedPref(this);
        boolean status = sharedPref.getBool("Cus_Loginstatus");
        if (!status){
            startActivity(new Intent(UserDashBoardActivity.this, UserDashBoardActivity.class));
            finish();
        }else {
            Log.w(TAG, "Loginstatus: " + status);
        }

        super.onStart();
    }*/
}
