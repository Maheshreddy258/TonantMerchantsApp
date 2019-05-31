package ecoprice.in.tonantmerchant;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

import ecoprice.in.tonantmerchant.Models.ModelProducts;
import ecoprice.in.tonantmerchant.Models.NewModelCart;
import ecoprice.in.tonantmerchant.Models.ProductsList;

import static com.android.volley.VolleyLog.TAG;

public class NewPlaceOderActivity extends AppCompatActivity {

    private static final String TAG = "NewPlaceOderActivity";
    private Button ButtonNext;
    private LinearLayout main_layout;
    TextView abcd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_place_oder);
        ButtonNext = (Button) findViewById(R.id.ButtonNext);
        abcd = (TextView) findViewById(R.id.Abcd);
        main_layout = (LinearLayout) findViewById(R.id.main_layout);



        TableLayout stk = (TableLayout) findViewById(R.id.table_main);
        stk.setVisibility(View.GONE);
        TableRow tbrow0 = new TableRow(this);
        TextView tv1 = new TextView(this);
        tv1.setText(" Product name");
        tv1.setTextSize(20);
        tv1.setTextColor(Color.BLACK);
        tv1.setBackgroundResource(R.drawable.row_border);
        tbrow0.addView(tv1);
        TextView tv2 = new TextView(this);
        tv2.setText(" Price ");
        tv2.setTextColor(Color.BLACK);
        tv2.setTextSize(20);
        tv2.setBackgroundResource(R.drawable.row_border);
        tbrow0.addView(tv2);
        TextView tv3 = new TextView(this);
        tv3.setText(" Gm/Kg ");
        tv3.setTextColor(Color.BLACK);
        tv3.setTextSize(20);
        tv3.setBackgroundResource(R.drawable.row_border);
        tbrow0.addView(tv3);
        TextView tv4 = new TextView(this);
        tv4.setText(" Qnty ");
        tv4.setTextColor(Color.BLACK);
        tv4.setTextSize(20);
        tv4.setBackgroundResource(R.drawable.row_border);
        tbrow0.addView(tv4);
        stk.addView(tbrow0);

        final String ShopUserName = getIntent().getStringExtra("ShopUserName");
        final String ShopName = getIntent().getStringExtra("ShopName");
        Log.w(TAG,"PlaceOrder ==> "+"shopuserNmae :"+ShopUserName+" ShopName :"+ShopName);
         ButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewPlaceOderActivity.this, NewCheckOutActivity.class);
                intent.putExtra("ShopUserName", ShopUserName);
                intent.putExtra("ShopName", ShopName);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                // finish();
            }
        });


        List<ModelProducts> data = NewModelCart.getData();
        System.out.println(data.size());
        for (int i = 0; i < data.size(); i++) {


            String text = data.get(i).getProductName() + " " + data.get(i).
                                      getUnitPrice() + " " + data.get(i).
                                      getQuantity()+ " " + data.get(i).
                                      getProductWait();
            Log.w(TAG, text);
            //System.out.println(data.get(i).getId());
            // removeDuplicates(data);
           // init(data,i);
            LayoutInflater li = LayoutInflater.from(getApplicationContext());
            View layout = li.inflate(R.layout.cart_item, null, false);
            TextView productname = layout.findViewById(R.id.ProductName);
            TextView Qunatity = layout.findViewById(R.id.Qunatity);
            TextView display_inc_dec2 = layout.findViewById(R.id.display_inc_dec2);
            TextView price = layout.findViewById(R.id.price);
            TextView PWeight = layout.findViewById(R.id.PWeight);
            FrameLayout RemoveFrame = layout.findViewById(R.id.RemoveFrame);
            main_layout.addView(layout);
            CartItemsUpdate(productname,Qunatity,display_inc_dec2,price,PWeight,RemoveFrame,data,i);
        }

        // Calculate total
        int total = 0;
        Log.d("TAG", "start total = " +total);
        for (int i = 0; i < data.size(); i++) {
            Log.d("TAG", "at "+i+ " quantity = " +data.get(i).getUnitPrice());
            total += data.get(i).getQuantity() * data.get(i).getUnitPrice();
            Log.d("TAG", "at "+i+ " total = " +total);
            abcd.setText("Total = " +total);
        }
    }

    private void CartItemsUpdate(TextView productname, TextView qunatity,
                                 TextView display_inc_dec2, TextView price,
                                 TextView pWeight, FrameLayout RemoveFrame, final List<ModelProducts> data123, final int i) {


        productname.setText(""+data123.get(i).getProductName());
        display_inc_dec2.setText(""+data123.get(i).getQuantity());
        qunatity.setText("Quantity: "+data123.get(i).getQuantity()+"  |  Amount: "+data123.get(i).getPrice()+"Rs");
        price.setText(""+data123.get(i).getUnitPrice());
        pWeight.setText(" | "+data123.get(i).getProductWait());





        RemoveFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            // NewModelCart.RemoveProduct(data123.get(i));

             }
        });
    }

  /*  private void init(List<ModelProducts> data123,int i) {
        TableLayout stk = (TableLayout) findViewById(R.id.table_main);
        TableRow tbrow = new TableRow(this);
        TextView t1v = new TextView(this);
        String name  = data123.get(i).getProductName();
        String s = name.substring(0,13);
        t1v.setText(s+"...");
        t1v.setTextColor(Color.GRAY);
        t1v.setGravity(Gravity.CENTER);
        t1v.setTextSize(18);
        t1v.setBackgroundResource(R.drawable.row_border);
        tbrow.addView(t1v);
        TextView t2v = new TextView(this);
        t2v.setText(""+new DecimalFormat("##.##").format(data123.get(i).getUnitPrice()));
        t2v.setTextColor(Color.GRAY);
        t2v.setGravity(Gravity.CENTER);
        t2v.setTextSize(18);
        t2v.setBackgroundResource(R.drawable.row_border);
        tbrow.addView(t2v);
        TextView t3v = new TextView(this);
        t3v.setText("" + data123.get(i).getProductWait()+" ");
        t3v.setTextColor(Color.GRAY);
        t3v.setGravity(Gravity.CENTER);
        t3v.setTextSize(18);
        t3v.setBackgroundResource(R.drawable.row_border);
        tbrow.addView(t3v);

        TextView t4v = new TextView(this);
        t4v.setText("" + data123.get(i).getQuantity()  );
        t4v.setTextColor(Color.GRAY);
        t4v.setGravity(Gravity.CENTER);
        t4v.setTextSize(18);
        t4v.setBackgroundResource(R.drawable.row_border);
        tbrow.addView(t4v);
        stk.addView(tbrow);
    }*/

}
