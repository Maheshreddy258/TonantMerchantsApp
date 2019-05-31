package ecoprice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.widget.Toast;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class InternetChecker {

    private Activity mActivity;


    public boolean isEveryThingEnabled() {
       if (!isConnected()) {
            showWifiSettingsDialog(mActivity);
            return false;
        }

        return true;
    }


    public InternetChecker(Activity activity){
        mActivity=activity;
        isEveryThingEnabled();
    }


    public boolean isConnected() {
        try {
            ConnectivityManager cm = (ConnectivityManager) mActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();

            return netInfo != null && netInfo.isConnected();
        } catch (Exception e) {
            return false;
        }
    }

    public   void showWifiSettingsDialog(final Context context) {
        SweetAlertDialog builder = new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE);
        builder.setTitleText("Need Internet");
        builder.setContentText("Please enable your internet connection");

        builder.setConfirmText("Enable");
        builder.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog dialog) {
                dialog.cancel();
                startWifiSettings(context);
            }
        });
        builder.setCancelText("Cancel");
        builder.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog dialog) {
                dialog.cancel();

            }
        });

        builder.show();

    }
    private   void startWifiSettings(Context context) {
        try {
            context.startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
        } catch (Exception e) {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
