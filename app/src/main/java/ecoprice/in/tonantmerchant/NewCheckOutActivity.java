package ecoprice.in.tonantmerchant;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ecoprice.in.tonantmerchant.Models.AddtoCartRes;
import ecoprice.in.tonantmerchant.Models.ModelProducts;
import ecoprice.in.tonantmerchant.Models.NewModelCart;
import ecoprice.in.tonantmerchant.Retrofit.SharedPref;
import ecoprice.in.tonantmerchant.Retrofit.network.ApiClient;
import ecoprice.in.tonantmerchant.Retrofit.network.ApiService;
import ecoprice.in.tonantmerchant.dummy.ModelCart;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewCheckOutActivity extends AppCompatActivity {


    private static final String TAG = "Checkout";
    ApiService service;
    Call call;
    Button send;
    TextView mNetAmount,mQnty,Shopname;
    TextInputLayout mPIN_Code,paid_amount,SelectDateTime;
    private LinearLayout SendDetails,RemarksLayout;
    TextInputEditText SelectShop,DateofVisitTobe,VisiteType;
    AppCompatEditText Remarks;
    Button button;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_check_out);
        SelectShop = (TextInputEditText) findViewById(R.id.SelectShop);
        DateofVisitTobe = (TextInputEditText) findViewById(R.id.DateofVisitTobe);
        VisiteType = (TextInputEditText) findViewById(R.id.VisiteType);
        Remarks = (AppCompatEditText) findViewById(R.id.Remarks);
        button = (Button) findViewById(R.id.BtnTarget);
        SendDetails = (LinearLayout) findViewById(R.id.SendDetails);
        RemarksLayout = (LinearLayout) findViewById(R.id.RemarksLayout);
        SendDetails.setVisibility(View.VISIBLE);

        SelectShop.setEnabled(false);
        VisiteType.setEnabled(false);
        //Remarks.setEnabled(false);

        send = (Button) findViewById(R.id.send);
        mNetAmount = (TextView) findViewById(R.id.NetAmount);
        mQnty = (TextView) findViewById(R.id.mQnty);
        Shopname = (TextView) findViewById(R.id.Shopname);
        mPIN_Code = (TextInputLayout) findViewById(R.id.PIN_Code);
        SelectDateTime = (TextInputLayout) findViewById(R.id.SelectDateTime);
        paid_amount = (TextInputLayout) findViewById(R.id.paid_amount);
        //SelectDateTime.setVisibility(View.GONE);

        final List<ModelProducts> data = NewModelCart.getData();
        final String ShopName = getIntent().getStringExtra("ShopName");
        Shopname.setText("Shop Name :" + ShopName);


        int total = 0;
        Log.d("TAG", "start total = " + total);
        for (int i = 0; i < data.size(); i++) {
            Log.d("TAG", "at " + i + " quantity = " + data.get(i).getUnitPrice());
            total += data.get(i).getQuantity() * data.get(i).getUnitPrice();
            Log.d("TAG", "at " + i + " total = " + total);
            mNetAmount.setText("Total = " + total);
            paid_amount.getEditText().setText(""+total);
        }


        int total12 = 0;
        Log.d("TAG", "start total = " + total12);
        for (int i = 0; i < data.size(); i++) {
            Log.d("TAG", "at " + i + " quantity = " + data.get(i).getQuantity());
            total12 += data.get(i).getQuantity();
            Log.d("TAG", "at " + i + " total = " + total12);
            mQnty.setText("Qnty = " + total12);
        }
        mPIN_Code.getEditText().setText("Cash");
        mPIN_Code.getEditText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] text = {"Cash", "Account Transfer", "Paytm"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
                builder.setItems(text, new DialogInterface.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ListView lw = ((AlertDialog) dialog).getListView();
                        Object checkedItem = lw.getAdapter().getItem(which);
                        mPIN_Code.getEditText().setText(checkedItem.toString());

                    }
                });
                builder.show();
            }
        });


        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        SelectDateTime.getEditText().setText(strDate);
        Log.w(TAG,"Today Date :" +SelectDateTime.getEditText().getText().toString());
        SelectDateTime.getEditText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dpd = new DatePickerDialog(NewCheckOutActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                                String dateString = format.format(c.getTime());
                                SelectDateTime.getEditText().setText(dateString);

                            }
                        }, mYear, mMonth, mDay);
                dpd.show();
            }
        });



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validate(paid_amount)) {
                    Log.w(TAG, "Response :" + " Username Empty");

                } else {
                    int total = 0;
                    Log.d("TAG", "start total = " + total);
                    for (int i = 0; i < data.size(); i++) {
                        Log.d("TAG", "at " + i + " quantity = " + data.get(i).getQuantity());
                        total += data.get(i).getQuantity() * data.get(i).getUnitPrice();
                        Log.d("TAG", "at " + i + " total = " + total);
                        mNetAmount.setText("Total = " + total);

                    }

                    int total12 = 0;
                    Log.d("TAG", "start total = " + total12);
                    for (int i = 0; i < data.size(); i++) {
                        Log.d("TAG", "at " + i + " quantity = " + data.get(i).getQuantity());
                        total12 += data.get(i).getQuantity();
                        Log.d("TAG", "at " + i + " total = " + total12);
                        mQnty.setText("Qnty = " + total12);
                    }

                    SharedPref sharedPref = new SharedPref(getApplicationContext());

                    final String NetAmount = String.valueOf(total);
                    final String paidAmount = paid_amount.getEditText().getText().toString();
                    final String Quantity = String.valueOf(total12);
                    final String paidthrough = mPIN_Code.getEditText().getText().toString();


                    final String PaymentStatus = "true";
                    final String shopuserNmae = getIntent().getStringExtra("ShopUserName");
                    final String ShopName = getIntent().getStringExtra("ShopName");
                    final String username = sharedPref.getStr("userName");
                    final String datetime = SelectDateTime.getEditText().getText().toString();
                    Log.w(TAG, String.valueOf(ModelCart.getData()));
                    InputMethodManager inputManager = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(NewCheckOutActivity.this.getCurrentFocus().getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
                    Log.w(TAG, shopuserNmae + " " + ShopName + " " + username + " " + NetAmount + " " + paidthrough + " " + paidAmount + " " + Quantity + " " + PaymentStatus);
                    SendAddToCart(shopuserNmae, ShopName, username, NetAmount, paidthrough, paidAmount, Quantity, PaymentStatus,datetime);

                }


            }

            ;
        });


        DateofVisitTobe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dpd = new DatePickerDialog(NewCheckOutActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                                                   /*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                                                                   String dateString = format.format(c.getTime());
                                                                   ;*/

                                @SuppressLint("SimpleDateFormat")
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                                c.set(year, monthOfYear , dayOfMonth);
                                String dateString = sdf.format(c.getTime());
                                DateofVisitTobe.setText(dateString);
                            }
                        }, mYear, mMonth, mDay);
                dpd.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                dpd.show();
            }
        });

        //Log.w(TAG, data.toArray().toString());
        System.out.println(data.size());
        for(int i = 0; i<data.size();i++) {
            String text = data.get(i).getId() + "       " + data.get(i).getProductName() + "       " + data.get(i).getUnitPrice() + "       " + data.get(i).getQuantity();
            Log.w(TAG, text);
        }




    }

    private void SendAddToCart(String shopuserNmae, String shopName, String username, String netAmount,
                               String paidthrough, String paidAmount, String quantity, String paymentStatus, String datetime) {


        List<ModelProducts> orderList =  NewModelCart.getData();
        final NewExample example = new NewExample();

        example.setShopUserName(username);
        example.setShopName(shopName);
       // example.setSalesLogin(username);
        example.setNetAmount(Double.parseDouble(netAmount));
        example.setPaidthrough(paidthrough);
        example.setPaidAmount(0);
        example.setQuantity(Integer.parseInt(quantity));
        example.setPaymentStatus(Boolean.parseBoolean(paymentStatus));
        example.setAgendaWeekDays(orderList);
        example.setDeliverydate(datetime);
        Log.w("printed gson => ",new GsonBuilder().setPrettyPrinting().create().toJson(example));

        final ProgressDialog progressDialog= new ProgressDialog(NewCheckOutActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);

        ApiService apiInterface = ApiClient.getClient().create(ApiService.class);
        Call<AddtoCartRes> call=apiInterface.NewAddtoCart(example);
        call.enqueue(new Callback<AddtoCartRes>() {
            @Override
            public void onResponse(@NonNull Call<AddtoCartRes> call, @NonNull Response<AddtoCartRes> response) {
                Log.w(TAG, "onResponse: " + response);
                response.body().toString();
                Log.d("Status :=>", String.valueOf(response.body().isStatus()));
                Log.d("Error MSG :=>", String.valueOf(response.body().getErrorMessage()));

                if (response.isSuccessful()) {

                    if (response.body().isStatus()) {

                        final List<ModelProducts> data = NewModelCart.getData();

                        data.clear();
                        Toast.makeText(NewCheckOutActivity.this, response.body().getErrorMessage(), Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                        Intent intent = new Intent(NewCheckOutActivity.this, UserDashBoardActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                                Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(NewCheckOutActivity.this, "Try Again", Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                        Log.d("error message", response.body().getErrorMessage());
                    }



                }else {
                    Toast.makeText(NewCheckOutActivity.this, "Error BODY :" + response.errorBody().toString(), Toast.LENGTH_LONG).show();
                    Log.w(TAG, "Error BODY :" + response.errorBody().toString());
                }




            }

            @Override
            public void onFailure(Call<AddtoCartRes> call, Throwable t) {

                Log.w(TAG, "onFailure: " + t.getMessage());
                progressDialog.dismiss();

            }
        });





    }


    public boolean validate(TextInputLayout textInputEditText) {
        boolean valid = true;
        textInputEditText.setEnabled(true);
        textInputEditText.setError(null);
        String  textInputEditText123 = textInputEditText.getEditText().getText().toString();
        if (textInputEditText123.length() == 0) {
            textInputEditText.setError("Required");
            textInputEditText.getEditText().requestFocus();
            valid = false;
        } else {
            textInputEditText.setError(null);
        }

        return valid;
    }

    @Override
    public void onBackPressed() {
        List<ModelProducts> data = NewModelCart.getData();
        data.clear();
        //  onBackPressed();
        super.onBackPressed();
    }

}
