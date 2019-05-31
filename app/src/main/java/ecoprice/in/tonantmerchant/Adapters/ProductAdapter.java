package ecoprice.in.tonantmerchant.Adapters;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import ecoprice.in.tonantmerchant.Models.ModelProducts;
import ecoprice.in.tonantmerchant.Models.NewModelCart;
import ecoprice.in.tonantmerchant.Models.ProductsList;
import ecoprice.in.tonantmerchant.R;
import ecoprice.in.tonantmerchant.Retrofit.Responce.AccessToken;
import ecoprice.in.tonantmerchant.Retrofit.Responce.ProductListResponse;

import static com.android.volley.VolleyLog.TAG;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>  {
    private List<ProductsList> listitems;
    private int abcdef;
 //   private int pos;
    private Context ctx;
    private List<ProductListResponse> productListResponseList;
    String check;
    private List<ModelProducts> AddToCart = new ArrayList<ModelProducts>();
    private String productW;
    private TextView TextTotal;
   private List<AccessToken> accessTokens;

    public ProductAdapter(Context ctx, List<ProductListResponse> productListResponseList,TextView TextTotal) {
        this.ctx = ctx;
        this.productListResponseList = productListResponseList;
        this.TextTotal=TextTotal;
    }

   /* public ProductAdapter(List<ProductsList> listitems, Context ctx) {
        this.listitems = listitems;
        this.ctx = ctx;

    }*/


   /* public GralleryAdapter(List<Gallery> listitems, Context ctx) {
        this.listitems = listitems;
        this.ctx = ctx;
    }*/

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.new_product_list, parent, false);

        return new ViewHolder(v, ctx, productListResponseList);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
    /*    final ProductsList listItem = listitems.get(position);*/
        final ProductListResponse listItem = productListResponseList.get(position);
     //   pos = position;
        String URL = "http://tonantfarmers.com";
        Log.w(TAG,"Image URL :  "+URL+listItem.getBannerImage());
        //http://tonantfarmers.com/Product/kashmiri-chill-powder-500x500.jpg
      /*  Picasso.with(ctx)
                .load(URL+listItem.getBannerImage())
                .into(holder.product_image);*/

        Glide.with(ctx)
                .load(URL + listItem.getBannerImage())
                .centerCrop()
                .into(holder.product_image);

        holder.ProductName.setText(listItem.getProductName());
        /*   holder.coast.getEditText().setText(""+listItem.getSalePrice());*/
       // holder.coast.getEditText().requestFocus();
        final double count100gm = listItem.getSalePrice()/1000;

      holder.price100g.setText(""+Double.parseDouble(new DecimalFormat("##.##").format(count100gm*100)));
//      holder.price200g.setText(""+Double.parseDouble(new DecimalFormat("##.##").format(count100gm*200)));
      holder.price1kg.setText(""+Double.parseDouble(new DecimalFormat("##.##").format(count100gm*1000)));
  //    holder.price2kg.setText(""+Double.parseDouble(new DecimalFormat("##.##").format(count100gm*2000)));


//        holder.price100glay.setText(""+Double.parseDouble(new DecimalFormat("##.##").format(count100gm*100)));
        //holder.price200glay.setText(""+Double.parseDouble(new DecimalFormat("##.##").format(count100gm*200)));
//        holder.price1kglay.setText(""+Double.parseDouble(new DecimalFormat("##.##").format(count100gm*1000)));
        //holder.price2kglay.setText(""+Double.parseDouble(new DecimalFormat("##.##").format(count100gm*2000)));


        //first list
        holder.increment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // holder.rs_linear1.setVisibility(View.GONE);
                //holder.down_view_linear1.setVisibility(View.VISIBLE);



            }
        });

        holder.increment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count=0;
                count= Integer.parseInt(String.valueOf(holder.display_inc_dec1.getText().toString()));
                Log.e("count...",""+count);
                count++;
                holder.display_inc_dec1.setText(String.valueOf(count));

                final ModelProducts modelProducts = new ModelProducts();
                modelProducts.setProductName(listItem.getProductName());
                modelProducts.setQuantity(count);
                modelProducts.setProductWait("100gm");
                modelProducts.setUnitPrice(Double.parseDouble(new DecimalFormat("##.##").format(count100gm*100)));
                modelProducts.setId(listItem.getId());
                modelProducts.setPrice(Double.parseDouble(new DecimalFormat("##.##").format(count100gm*100))*count);
                //check if the same product Id is existed or not
                boolean existed=false;
                int count1=0;

                if(AddToCart!=null && AddToCart.size()>0){
                    for(ModelProducts modelProducts1:AddToCart){
                        count1++;
                        if(modelProducts1.getId()==modelProducts.getId()&& modelProducts1.getProductWait().equals(modelProducts.getProductWait())){
                            existed=true;
                            break;
                        }
                    }
                }
                if(existed){
                    AddToCart.remove(count1-1);
                    AddToCart.add(modelProducts);
                }else{
                    AddToCart.add(modelProducts);
                }

                NewModelCart.setData(AddToCart);
                List<ModelProducts> data = NewModelCart.getData();
                int total = 0;
                for (int i = 0; i < data.size(); i++) {
                    total += data.get(i).getQuantity() * data.get(i).getUnitPrice();
                   /* Intent intent = new Intent("custom-message");
                    intent.putExtra("total",total);
                    LocalBroadcastManager.getInstance(ctx).sendBroadcast(intent);*/

                }
                TextTotal.setText("₹"+total);
            }

        });

        holder.decrement1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count= Integer.parseInt(String.valueOf(holder.display_inc_dec1.getText()));
                if (count > 0){
                    count--;
                    holder.display_inc_dec1.setText(String.valueOf(count));
                    final ProductListResponse listItem = productListResponseList.get(position);
                    Iterator<ModelProducts> iter = AddToCart.iterator();
                    while (iter.hasNext()) {
                        ModelProducts user = iter.next();
                        if (user.getId()==listItem.getId() && user.getProductWait().equals("100gm"))  {
                            iter.remove();
                            Log.w(TAG,"Removed :"+user.getProductName());

                        }
                    }

                    final ModelProducts modelProducts = new ModelProducts();
                    modelProducts.setProductName(listItem.getProductName());
                    modelProducts.setQuantity(count);
                    modelProducts.setProductWait("100gm");
                    modelProducts.setUnitPrice(Double.parseDouble(new DecimalFormat("##.##").format(count100gm*100)));
                    modelProducts.setId(listItem.getId());
                    modelProducts.setPrice(Double.parseDouble(new DecimalFormat("##.##").format(count100gm*100))*count);
                    AddToCart.add(modelProducts);
                    NewModelCart.setData(AddToCart);
                    List<ModelProducts> data = NewModelCart.getData();


                    int total = 0;
                    for (int i = 0; i < data.size(); i++) {
                        total += data.get(i).getQuantity() * data.get(i).getUnitPrice();
                       /* Intent intent = new Intent("custom-message");
                        intent.putExtra("total",total);
                        String size = String.valueOf(data.size());
                        intent.putExtra("quantity",size);
                        LocalBroadcastManager.getInstance(ctx).sendBroadcast(intent);*/

                    }
                    TextTotal.setText("₹"+total);
                }else {
                    //holder.linear_green1.setVisibility(View.VISIBLE);
                    //holder.down_view_linear1.setVisibility(View.GONE);
                    //holder.rs_linear1.setVisibility(View.VISIBLE);
                }

            }
        });




//second list
  /*      holder.rs_linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.rs_linear2.setVisibility(View.GONE);
                holder.down_view_linear2.setVisibility(View.VISIBLE);

               *//* Snackbar snackbar = Snackbar.make(view,"Cart 1 Item | 40 Rs",Snackbar.LENGTH_LONG);
                View snckbar_view = snackbar.getView();

                TextView snackbar_text = snckbar_view.findViewById(android.support.design.R.id.snackbar_text);
                snackbar_text.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_back_arrow,0);
                snackbar_text.setGravity(Gravity.CENTER);
                snackbar.show();*//*

            }
        });

        holder.increment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count= Integer.parseInt(String.valueOf(holder.display_inc_dec2.getText()));
                count++;
                holder.display_inc_dec2.setText(String.valueOf(count));
                final ModelProducts modelProducts = new ModelProducts();
                modelProducts.setProductName(listItem.getProductName());
                modelProducts.setQuantity(count);
                modelProducts.setProductWait("200gm");
                modelProducts.setUnitPrice(Double.parseDouble(new DecimalFormat("##.##").format(count100gm*1000)));
                modelProducts.setId(listItem.getId());
                modelProducts.setPrice(Double.parseDouble(new DecimalFormat("##.##").format(count100gm*1000))*count);
                AddToCart.add(modelProducts);
                NewModelCart.setData(AddToCart);
                List<ModelProducts> data = NewModelCart.getData();
                int total = 0;
                for (int i = 0; i < data.size(); i++) {
                    total += data.get(i).getQuantity() * data.get(i).getUnitPrice();
                    Intent intent = new Intent("custom-message");
                    intent.putExtra("total",total+" Rs");
                    LocalBroadcastManager.getInstance(ctx).sendBroadcast(intent);

                }
            }

        });

        holder.decrement2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count= Integer.parseInt(String.valueOf(holder.display_inc_dec2.getText()));
                if (count > 1){
                    count--;
                    holder.display_inc_dec2.setText(String.valueOf(count));
                    final ProductListResponse listItem = productListResponseList.get(position);
                    Iterator<ModelProducts> iter = AddToCart.iterator();
                    while (iter.hasNext()) {
                        ModelProducts user = iter.next();
                        if (user.getProductName().equals(listItem.getProductName())) {
                            iter.remove();
                            Log.w(TAG,"Removed :"+user.getProductName());

                        }
                    }
                    final ModelProducts modelProducts = new ModelProducts();
                    modelProducts.setProductName(listItem.getProductName());
                    modelProducts.setQuantity(count);
                    modelProducts.setProductWait("200gm");
                    modelProducts.setUnitPrice(Double.parseDouble(new DecimalFormat("##.##").format(count100gm*1000)));
                    modelProducts.setId(listItem.getId());
                    modelProducts.setPrice(Double.parseDouble(new DecimalFormat("##.##").format(count100gm*1000))*count);
                    AddToCart.add(modelProducts);
                    NewModelCart.setData(AddToCart);
                    List<ModelProducts> data = NewModelCart.getData();
                    int total = 0;
                    for (int i = 0; i < data.size(); i++) {
                        total += data.get(i).getQuantity() * data.get(i).getUnitPrice();
                        Intent intent = new Intent("custom-message");
                        intent.putExtra("total",total+" Rs");
                        LocalBroadcastManager.getInstance(ctx).sendBroadcast(intent);

                    }
                }else {
                    holder.linear_green2.setVisibility(View.VISIBLE);
                    holder.down_view_linear2.setVisibility(View.GONE);
                    holder.rs_linear2.setVisibility(View.VISIBLE);
                }

            }
        });
*/




        //third list
        holder.increment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //holder.rs_linear3.setVisibility(View.GONE);
                //holder.down_view_linear3.setVisibility(View.VISIBLE);

               /* Snackbar snackbar = Snackbar.make(view,"Cart                                               1 Item | 40 Rs",Snackbar.LENGTH_LONG);
                View snckbar_view = snackbar.getView();
                TextView snackbar_text = snckbar_view.findViewById(android.support.design.R.id.snackbar_text);
                snackbar_text.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_back_arrow,0);
                snackbar_text.setGravity(Gravity.CENTER);
                snackbar.show();*/

            }
        });

        holder.increment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count= Integer.parseInt(String.valueOf(holder.display_inc_dec3.getText()));
                count++;
                holder.display_inc_dec3.setText(String.valueOf(count));
                final ModelProducts modelProducts = new ModelProducts();
                modelProducts.setProductName(listItem.getProductName());
                modelProducts.setQuantity(count);
                modelProducts.setProductWait("1kg");
                modelProducts.setUnitPrice(Double.parseDouble(new DecimalFormat("##.##").format(count100gm*1000)));
                modelProducts.setId(listItem.getId());
                modelProducts.setPrice(Double.parseDouble(new DecimalFormat("##.##").format(count100gm*1000))*count);
                boolean existed=false;
                int count1=0;
                if(AddToCart!=null && AddToCart.size()>0){
                    for(ModelProducts modelProducts1:AddToCart){
                        count1++;
                        if(modelProducts1.getId()==modelProducts.getId() && modelProducts1.getProductWait().equals(modelProducts.getProductWait())){
                            existed=true;
                            break;
                        }
                    }
                }
                if(existed){
                    AddToCart.remove(count1-1);
                    AddToCart.add(modelProducts);
                }else{
                    AddToCart.add(modelProducts);
                }
                NewModelCart.setData(AddToCart);
                List<ModelProducts> data = NewModelCart.getData();
                int total = 0;
                for (int i = 0; i < data.size(); i++) {
                    total += data.get(i).getQuantity() * data.get(i).getUnitPrice();
                   /* Intent intent = new Intent("custom-message");
                    intent.putExtra("total",total);
                    LocalBroadcastManager.getInstance(ctx).sendBroadcast(intent);*/

                }
                TextTotal.setText("₹"+total);
            }

        });

        holder.decrement3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count= Integer.parseInt(String.valueOf(holder.display_inc_dec3.getText()));
                if (count > 0){
                    count--;
                    holder.display_inc_dec3.setText(String.valueOf(count));
                    final ProductListResponse listItem = productListResponseList.get(position);
                    Iterator<ModelProducts> iter = AddToCart.iterator();
                    while (iter.hasNext()) {
                        ModelProducts user = iter.next();
                        if (user.getId()==listItem.getId() && user.getProductWait().equals("1kg"))  {
                            iter.remove();
                            Log.w(TAG,"Removed :"+user.getProductName());

                        }
                    }
                    final ModelProducts modelProducts = new ModelProducts();
                    modelProducts.setProductName(listItem.getProductName());
                    modelProducts.setQuantity(count);
                    modelProducts.setProductWait("1kg");
                    modelProducts.setUnitPrice(Double.parseDouble(new DecimalFormat("##.##").format(count100gm*1000)));
                    modelProducts.setId(listItem.getId());
                    modelProducts.setPrice(Double.parseDouble(new DecimalFormat("##.##").format(count100gm*1000))*count);
                    AddToCart.add(modelProducts);
                    NewModelCart.setData(AddToCart);
                    List<ModelProducts> data = NewModelCart.getData();
                    int total = 0;
                    for (int i = 0; i < data.size(); i++) {
                        total += data.get(i).getQuantity() * data.get(i).getUnitPrice();
                       /* Intent intent = new Intent("custom-message");
                        intent.putExtra("total",total);
                        LocalBroadcastManager.getInstance(ctx).sendBroadcast(intent);*/

                    }
                    TextTotal.setText("₹"+total);
                }else {
                    //holder.linear_green3.setVisibility(View.VISIBLE);
                    //holder.down_view_linear3.setVisibility(View.GONE);
                    //holder.rs_linear3.setVisibility(View.VISIBLE);
                }

            }
        });


        //forth list
       /* holder.rs_linear4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.rs_linear4.setVisibility(View.GONE);
                holder.down_view_linear4.setVisibility(View.VISIBLE);

               *//* Snackbar snackbar = Snackbar.make(view,"Cart 1 Item | 40 Rs",Snackbar.LENGTH_LONG);
                View snckbar_view = snackbar.getView();
                TextView snackbar_text = snckbar_view.findViewById(android.support.design.R.id.snackbar_text);
                snackbar_text.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_back_arrow,0);
                snackbar_text.setGravity(Gravity.CENTER);
                snackbar.show();*//*

            }
        });

        holder.increment4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count= Integer.parseInt(String.valueOf(holder.display_inc_dec4.getText()));
                count++;
                holder.display_inc_dec4.setText(String.valueOf(count));
                final ModelProducts modelProducts = new ModelProducts();
                modelProducts.setProductName(listItem.getProductName());
                modelProducts.setQuantity(count);
                modelProducts.setProductWait("2kg");
                modelProducts.setUnitPrice(Double.parseDouble(new DecimalFormat("##.##").format(count100gm*2000)));
                modelProducts.setId(listItem.getId());
                modelProducts.setPrice(Double.parseDouble(new DecimalFormat("##.##").format(count100gm*2000))*count);
                AddToCart.add(modelProducts);
                NewModelCart.setData(AddToCart);
                List<ModelProducts> data = NewModelCart.getData();
                int total = 0;
                for (int i = 0; i < data.size(); i++) {
                    total += data.get(i).getQuantity() * data.get(i).getUnitPrice();
                    Intent intent = new Intent("custom-message");
                    intent.putExtra("total",total+" Rs");
                    LocalBroadcastManager.getInstance(ctx).sendBroadcast(intent);

                }
            }

        });

        holder.decrement4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count= Integer.parseInt(String.valueOf(holder.display_inc_dec4.getText()));
                if (count > 1){
                    count--;
                    holder.display_inc_dec4.setText(String.valueOf(count));
                    final ProductListResponse listItem = productListResponseList.get(position);
                    Iterator<ModelProducts> iter = AddToCart.iterator();
                    while (iter.hasNext()) {
                        ModelProducts user = iter.next();
                        if (user.getProductName().equals(listItem.getProductName())) {
                            iter.remove();
                            Log.w(TAG,"Removed :"+user.getProductName());

                        }
                    }
                    final ModelProducts modelProducts = new ModelProducts();
                    modelProducts.setProductName(listItem.getProductName());
                    modelProducts.setQuantity(count);
                    modelProducts.setProductWait("2kg");
                    modelProducts.setUnitPrice(Double.parseDouble(new DecimalFormat("##.##").format(count100gm*2000)));
                    modelProducts.setId(listItem.getId());
                    modelProducts.setPrice(Double.parseDouble(new DecimalFormat("##.##").format(count100gm*2000))*count);
                    AddToCart.add(modelProducts);
                    NewModelCart.setData(AddToCart);
                    List<ModelProducts> data = NewModelCart.getData();
                    int total = 0;
                    for (int i = 0; i < data.size(); i++) {
                        total += data.get(i).getQuantity() * data.get(i).getUnitPrice();
                        Intent intent = new Intent("custom-message");
                        intent.putExtra("total",total+" Rs");
                        LocalBroadcastManager.getInstance(ctx).sendBroadcast(intent);

                    }

                }else {
                    holder.linear_green4.setVisibility(View.VISIBLE);
                    holder.down_view_linear4.setVisibility(View.GONE);
                    holder.rs_linear4.setVisibility(View.VISIBLE);
                }

            }
        });*/

        }



    @Override
    public int getItemCount() {
        return productListResponseList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder /*implements View.OnClickListener*/ {

        ImageView product_image;
        LinearLayout rs_linear1,linear_green1,down_view_linear1;
        TextView increment1,display_inc_dec1,decrement1,ProductName;

        LinearLayout rs_linear2,linear_green2,down_view_linear2;
        TextView increment2,display_inc_dec2,decrement2;

        LinearLayout rs_linear3,linear_green3,down_view_linear3;
        TextView increment3,display_inc_dec3,decrement3;

        LinearLayout rs_linear4,linear_green4,down_view_linear4;
        TextView increment4,display_inc_dec4,decrement4;
        TextView price100g,price200g,price1kg,price2kg;
        TextView price100glay,price200glay,price1kglay,price2kglay;

        private LinearLayout snckbar;
        Context ctx;
        ArrayList<ProductsList> completeds = new ArrayList<ProductsList>();
        ArrayList<ProductListResponse> completeds2 = new ArrayList<ProductListResponse>();

        @SuppressLint("CutPasteId")
        public ViewHolder(final View View, final Context ctx, final List<ProductListResponse> completeds2) {
            super(View);

            /* View.setOnClickListener(this);*/
            this.completeds2 = (ArrayList<ProductListResponse>) completeds2;
            this.ctx = ctx;
            product_image = itemView.findViewById(R.id.product_image);


            rs_linear1 = itemView.findViewById(R.id.rs_linear1);
            linear_green1 = itemView.findViewById(R.id.linear_green);
            //down_view_linear1 = itemView.findViewById(R.id.down_view_linear);
            ProductName = itemView.findViewById(R.id.ProductName);
            increment1 = itemView.findViewById(R.id.increment);
            display_inc_dec1 = itemView.findViewById(R.id.display_inc_dec);
            decrement1 = itemView.findViewById(R.id.decrement);


            //rs_linear2 = itemView.findViewById(R.id.rs_linear2);
            linear_green2 = itemView.findViewById(R.id.linear_green2);
            down_view_linear2 = itemView.findViewById(R.id.down_view_linear2);
            increment2 = itemView.findViewById(R.id.increment2);
            display_inc_dec2 = itemView.findViewById(R.id.display_inc_dec2);
            decrement2 = itemView.findViewById(R.id.decrement2);

            rs_linear3 = itemView.findViewById(R.id.rs_linear3);
            linear_green3 = itemView.findViewById(R.id.linear_green3);
           // down_view_linear3 = itemView.findViewById(R.id.down_view_linear3);
            increment3 = itemView.findViewById(R.id.increment3);
            display_inc_dec3 = itemView.findViewById(R.id.display_inc_dec3);
            decrement3 = itemView.findViewById(R.id.decrement3);


            //rs_linear4 = itemView.findViewById(R.id.rs_linear4);
            //linear_green4 = itemView.findViewById(R.id.linear_green4);
            //down_view_linear4 = itemView.findViewById(R.id.down_view_linear4);
            //increment4 = itemView.findViewById(R.id.increment4);
            //display_inc_dec4 = itemView.findViewById(R.id.display_inc_dec4);
            //decrement4 = itemView.findViewById(R.id.decrement4);


            snckbar = itemView.findViewById(R.id.coordinatorLayout);

            price100g = itemView.findViewById(R.id.price100g);
           // price200g = itemView.findViewById(R.id.price200g);
            price1kg = itemView.findViewById(R.id.price1kg);
            //price2kg = itemView.findViewById(R.id.price2kg);

            //price100glay = itemView.findViewById(R.id.price100glay);
            //price200glay = itemView.findViewById(R.id.price200glay);
          //  price1kglay = itemView.findViewById(R.id.price1kglay);
            //price2kglay = itemView.findViewById(R.id.price2kglay);

        }

    }




    }



