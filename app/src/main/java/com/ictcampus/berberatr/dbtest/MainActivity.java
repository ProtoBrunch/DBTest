package com.ictcampus.berberatr.dbtest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    Button btn1, btn2;
    TextView txtView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        txtView1 = (TextView)findViewById(R.id.txtView1);
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nwi = cm.getActiveNetworkInfo();
        if(nwi != null && nwi.isConnected()){
            txtView1.setVisibility(View.INVISIBLE);
        }
        else{
            btn1.setEnabled(false);
            btn2.setEnabled(false);
        }
    }

    public void addData(View view) {
        startActivity(new Intent(this, AddData.class));
    }

    public void viewData(View view){
        startActivity(new Intent(this, GetData.class));
    }
}
