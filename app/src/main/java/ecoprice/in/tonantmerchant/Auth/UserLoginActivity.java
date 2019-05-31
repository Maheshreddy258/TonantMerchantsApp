package ecoprice.in.tonantmerchant.Auth;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import butterknife.ButterKnife;
import ecoprice.in.tonantmerchant.UserDashBoardActivity;
import ecoprice.in.tonantmerchant.R;
import ecoprice.in.tonantmerchant.Retrofit.Responce.AccessToken;
import ecoprice.in.tonantmerchant.Retrofit.SharedPref;
import ecoprice.in.tonantmerchant.Retrofit.network.ApiService;
import ecoprice.in.tonantmerchant.Retrofit.network.RetrofitBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserLoginActivity extends AppCompatActivity {

    private static final String TAG = "Login";
    TextInputLayout tilEmail;
    TextInputLayout tilPassword;
    LinearLayout container;
    // LinearLayout formContainer;
    ProgressBar loader;
    FrameLayout Button;
    ApiService service;
    AwesomeValidation validator;
    Call<AccessToken> call;
    TextView forgotPass,ErrorMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        ButterKnife.bind(this);
        service = RetrofitBuilder.createService(ApiService.class);
        validator = new AwesomeValidation(ValidationStyle.TEXT_INPUT_LAYOUT);

        tilEmail = (TextInputLayout) findViewById(R.id.til_email);
        tilPassword = (TextInputLayout) findViewById(R.id.til_password);
        container = (LinearLayout) findViewById(R.id.container);
        //formContainer = (LinearLayout) findViewById(R.id.form_container);
        loader = (ProgressBar) findViewById(R.id.loader);
        Button = (FrameLayout) findViewById(R.id.btn_login);
        forgotPass = (TextView) findViewById(R.id.forgotPass);
        ErrorMsg = (TextView) findViewById(R.id.ErrorMsg);



        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputManager = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(UserLoginActivity.this.getCurrentFocus().getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);

                String username =  tilEmail.getEditText().getText().toString();
                String pasword =  tilPassword.getEditText().getText().toString();

                if (!validate(tilEmail) || !validate(tilPassword)){
                    Log.w(TAG,"Response :"+ " Username Empty");
                }else {
                    login(username,pasword);
                    ErrorMsg.setVisibility(View.GONE);
                }

            }
        });


    }

    private void login(final String username, final String pasword) {
        Log.w(TAG, "Email " + username);
        Log.w(TAG, "Password " + pasword);
        tilEmail.setError(null);
        tilPassword.setError(null);
        showLoading();
        Log.w(TAG, "Login form" + "Username :" + username + "Password :" + pasword);
        call = service.SalesLogin(username, pasword);
        call.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {

                Log.w(TAG, "onResponse: " + response);
                response.body();
                boolean Loginstatus = response.body().isStatus();
                Log.w(TAG, "Loginstatus: " + Loginstatus);
                if (Loginstatus) {
                    response.raw().toString();
                    SharedPref dataProccessor = new SharedPref(getApplicationContext());
                    SharedPref.setStr("userName", username);
                    SharedPref.setStr("Password", pasword);
                    SharedPref.setBool("Loginstatus", Loginstatus);
                    boolean status = SharedPref.getBool("Loginstatus");
                    Log.w(TAG, "Loginstatus: " + status);
                    startActivity(new Intent(UserLoginActivity.this, UserDashBoardActivity.class));
                    finish();

                } else {
                    showForm();
                    tilEmail.setError("Invalid Username");
                    tilPassword.setError("Invalid Password");
                        /*ErrorMsg.setVisibility(View.VISIBLE);
                        int SPLASH_TIME_OUT = 50000;
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
                                ErrorMsg.setVisibility(View.GONE);
                            }
                        }, SPLASH_TIME_OUT);*/
                }

            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {
                Log.w(TAG, "onFailure: " + t.getMessage());
                showForm();
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
            valid = false;
        } else {
            textInputEditText.setError(null);
        }

        return valid;
    }


    @SuppressLint("NewApi")
    private void showLoading(){
        tilEmail.setError(null);
        tilPassword.setError(null);
        TransitionManager.beginDelayedTransition(Button);
        loader.setVisibility(View.VISIBLE);
        Button.setVisibility(View.GONE);
    }

    @SuppressLint("NewApi")
    private void showForm(){
        TransitionManager.beginDelayedTransition(Button);
        loader.setVisibility(View.GONE);
        Button.setVisibility(View.VISIBLE);
    }
}
