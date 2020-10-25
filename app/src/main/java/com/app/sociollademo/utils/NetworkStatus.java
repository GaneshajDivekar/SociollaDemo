package com.app.sociollademo.utils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


import com.app.sociollademo.R;
import com.app.sociollademo.databinding.ActivityNetworkStatusBinding;
import com.app.sociollademo.ui.mainmodule.MainActivity;


public class NetworkStatus extends AppCompatActivity implements View.OnClickListener {
    ActivityNetworkStatusBinding networkStatusBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        }
        networkStatusBinding = DataBindingUtil.setContentView(this, R.layout.activity_network_status);
        networkStatusBinding.btnretry.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (Connectionnet.getConnectionnetInstance().isConnected(getApplicationContext())) {
            Intent l = new Intent(NetworkStatus.this, MainActivity.class);
            startActivity(l);
            finish();
        } else {
            Connectionnet.getConnectionnetInstance().showNetworkToastMessage(getApplicationContext());
        }
    }
}
