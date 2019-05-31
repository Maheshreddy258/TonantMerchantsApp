package ecoprice.in.tonantmerchant;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
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
import ecoprice.in.tonantmerchant.Models.Cart;
import ecoprice.in.tonantmerchant.Models.ProductsList;
import ecoprice.in.tonantmerchant.Retrofit.Responce.ProductListResponse;
import ecoprice.in.tonantmerchant.Retrofit.network.ApiClient;
import ecoprice.in.tonantmerchant.Retrofit.network.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductListActivity extends AppCompatActivity {


    private static final String TAG = "Product";
    private RecyclerView Gal_Rec;
    private TextView TextTotal;
    private ProductAdapter adapter;
    private List<ProductsList> listItems;
    List<ProductListResponse> productListResponses;
    private List<Cart> list;
    String URL_DATA = "http://apiservices.tonantfarmers.com/api/AllProducts";
    private AppCompatButton ButtonBtn;
    private String[] strings;
    private List<Cart> productsList = new ArrayList();
    private ProgressBar progressBar;
       int clickon;
    InternetChecker internetChecker;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Products List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        internetChecker = new InternetChecker(this);

        //ButtonBtn = (AppCompatButton) findViewById(R.id.ButtonBtn);
        progressBar = (ProgressBar)  findViewById(R.id.Prog_Assigned);
        Gal_Rec = (RecyclerView) findViewById(R.id.Rec_Gallery);
        Gal_Rec.setHasFixedSize(true);
        Gal_Rec.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        Gal_Rec.setLayoutManager(mLayoutManager);
        listItems = new ArrayList<>();
        list = new ArrayList<>();
        TextTotal = (TextView) findViewById(R.id.TextTotal);


      /*  OldProductsAdapter selectItemAdapter =  new OldProductsAdapter();
        int quantities [] = selectItemAdapter.getQuantities();
        Log.w(TAG,quantities.toString());*/
        /*LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter("custom-message"));*/



     /*   SharedDelete.setVisibility(View.GONE);
        SharedDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartPref cartPref = new CartPref(ProductListActivity.this);
                cartPref.deleteShared();
            }
        });*/
        listItems.clear();
        loadRecyclerViewData();
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter("custom-message"));
    /*    Gal_Rec.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(),
                                       new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, final int position) {


                *//*if (data.isEmpty()){
                    TextTotal.setText(" 0 "+" Rs");
                }
                int total = 0;
                for (int i = 0; i < data.size(); i++) {
                    total += data.get(i).getQuantity() * data.get(i).getUnitPrice();
                }
                TextTotal.setText(total+" Rs");*//*

                *//*List<ModelProducts> data = NewModelCart.getData();
                int total = 0;
                Log.d("TAG", "start total = " +total);
                for (int i = 0; i < data.size(); i++) {
                    Log.d("TAG", "at "+i+ " quantity = " +data.get(i).getUnitPrice());
                    total += data.get(i).getQuantity() * data.get(i).getUnitPrice();
                    Log.d("TAG", "at "+i+ " total = " +total);
                    TextTotal.setText(total+" Rs");
                }*//*




                }
        }));*/

        final String ShopUserName = getIntent().getStringExtra("ShopUserName");
        final String ShopName = getIntent().getStringExtra("ShopName");
        //ModelCart.setData(productsList);
        ButtonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ModelCart.setData(productsList);
                Intent intent = new Intent(ProductListActivity.this, NewPlaceOderActivity.class);
                intent.putExtra("strings", String.valueOf(productsList));
                intent.putExtra("ShopUserName", ShopUserName);
                intent.putExtra("ShopName", ShopName);
                //intent.putExtra("pos", position);
                startActivity(intent);
            }
        });
            }

    /*private void upDateData() {
       // adapter.notifyDataSetChanged();
        CartPref cartPref = new CartPref(ProductListActivity.this);
        String position=  cartPref.getStr("position");
        String itemName=  cartPref.getStr("ItemName");
        String itemCoast = cartPref.getStr("ItemCoast");
        String itemImage =  cartPref.getStr("ItemImage");
        int qunty = cartPref.getInt("qnty");
        Log.w(TAG," position: "+position+" itemName: "+itemName+" itemCoast: "+itemCoast+" qunty: "+qunty);
        adapter.notifyDataSetChanged();
        TextTotal.setText(itemCoast);

        }*/


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
                                /*  adapter = new MyReportAdapter(getActivity(), myReportResponseList);
                                  mMyreportrecycle.setAdapter(myReportAdapter);*/


                                adapter = new ProductAdapter(getApplicationContext(), productList,TextTotal);
                                Log.e("productlist", "sucesss....");
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
          /*      JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL_DATA, new Response.Listener<JSONArray>() {
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
                                Log.e("listItems",""+listItems.size());
                             *//*   adapter = new ProductAdapter(listItems, getApplicationContext());
                                Gal_Rec.setAdapter(adapter);*//*
                            }
                        } catch (JSONException e){
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
                RequestQueue requestQueue = Volley.newRequestQueue(ProductListActivity.this);
                jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                        2000*5,
                        *//*DefaultRetryPolicy.DEFAULT_MAX_RETRIES*//* 3,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                requestQueue.add(jsonArrayRequest);*/


            }

            private void TringAgain() {
                Toast.makeText(ProductListActivity.this, "Try Again :(", Toast.LENGTH_SHORT).show();

            }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String total = intent.getStringExtra("total");
            TextTotal.setText(total+"");
            //  Toast.makeText(ProductListActivity.this,total+"" ,Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onResume() {
        internetChecker.isEveryThingEnabled();
        super.onResume();
    }

    @Override
    protected void onPause() {
        internetChecker.isEveryThingEnabled();
        super.onPause();
    }

    @Override
    protected void onRestart() {
        internetChecker.isEveryThingEnabled();
        super.onRestart();
    }
    /*public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String ItemName = intent.getStringExtra("item");
            String qty = intent.getStringExtra("quantity");
            String total = intent.getStringExtra("total");
          //  Log.w(TAG,"ItemName :"+ItemName +"qty :"+qty+"total :"+total);
            //Toast.makeText(ProductListActivity.this,ItemName +" "+qty ,Toast.LENGTH_SHORT).show();
        }
    };*/


    /*public void onClick(DialogInterface dialogInterface, int i) {
        String getSubjectInput = input.getText().toString();
        storedList.add(getSubjectInput);
        tinyDB.putListString("storedList1stYr2", storedList);

        generalList.add(getSubjectInput);
        arrayAdapter.notifyDataSetChanged();
    }*/
    /*private void removeDuplicates(List<ModelProducts> list) {
        int count = list.size();

        for (int i = 0; i < count; i++)
        {
            for (int j = i + 1; j < count; j++)
            {
                Log.w(TAG,"Product name I :"+ list.get(i).getProductName());
                Log.w(TAG,"Product Wait I :"+ list.get(i).getProductWait());


                Log.w(TAG,"Product name J :"+ list.get(j).getProductName());
                Log.w(TAG,"Product Wait J :"+ list.get(j).getProductWait());
           *//*     if (list.get(i).getQuantity() < list.get(j).getQuantity())
            {
                list.get(i).setQuantity(list.get(j).getQuantity());
                Log.w(TAG,"Product HIght NUmber :"+ list.get(j).getQuantity());
            }*//*
                *//*list.get(i).setQuantity(list.get(j).getQuantity());
                list.get(i).setProductWait(list.get(j).getProductWait());*//*

                if (list.get(i).getProductWait().equals(list.get(j).getProductWait())) {
                    list.remove(j--);
                    count--;

                }
            }
        }
    }*/

}
