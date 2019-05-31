package ecoprice.in.tonantmerchant.Retrofit.network;


import com.android.volley.BuildConfig;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitBuilder {

    private static final String BASE_URL = "http://apiservices.tonantfarmers.com/api/";

    private final static OkHttpClient client = buildClient();
    private final static Retrofit retrofit = buildRetrofit(client);
   // private static TokenManager tokenManager;


    private static OkHttpClient buildClient(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Request.Builder builder = request.newBuilder()
                                .addHeader("Accept", "application/json")
                                //.addHeader("Content-Type", "application/json;charset=utf-8")
                                .addHeader("Connection", "close");

                        request = builder.build();

                        return chain.proceed(request);

                    }
                });

        if(BuildConfig.DEBUG){
            builder.addNetworkInterceptor(new StethoInterceptor());
        }

        return builder.build();

    }

    private static Retrofit buildRetrofit(OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                //.addConverterFactory(MoshiConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static <T> T createService(Class<T> service){
        return retrofit.create(service);
    }

   /* public static <T> T createServiceWithAuth(final Class<T> service, final TokenManager tokenManager,Context context){

        SharedPref dataProccessor = new SharedPref(context);
        final String username = dataProccessor.getStr("userName");
        final String password= dataProccessor.getStr("Password");
        Log.w(TAG,"Stored Username :"+username+" Password :"+password);

        OkHttpClient newClient = client.newBuilder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request request = chain.request();

                Request.Builder builder = request.newBuilder();


                try {
                    JSONObject paramObject = new JSONObject();
                    paramObject.put("UserName", username);
                    paramObject.put("Pwd", password);
                    builder.header("Authorization", String.valueOf(paramObject)).build();
                    Log.w("Auth ",String.valueOf(paramObject));
                    } catch (JSONException e) {
                    e.printStackTrace();
                }


                request = builder.build();
                return chain.proceed(request);
            }
        }).authenticator(CustomAuthenticator.getInstance(tokenManager)).build();

        Retrofit newRetrofit = retrofit.newBuilder().client(newClient).build();
        return newRetrofit.create(service);

    }
*/
    public static Retrofit getRetrofit() {
        return retrofit;
    }


}
