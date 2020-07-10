package com.home.currency3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.home.currency3.R;

public class MainActivity extends AppCompatActivity {

    private EditText etNtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNtd = findViewById(R.id.et_ntd);
    }

    public void exchangeUSD(View v){
        if(etNtd.length()==0){
            new AlertDialog.Builder(this)
                    .setTitle(R.string.problem)
                    .setMessage(R.string.ProblemDescription)
                    .setPositiveButton(R.string.ok,null)
                    .show();
        }
        else{
            float ntd=Float.parseFloat(etNtd.getText().toString());
            float usd= (float) (ntd/30.9);
            float jpd= (float) (ntd*3.6254);
            new AlertDialog.Builder(this)
                    .setTitle(R.string.result)
                    .setMessage(getString(R.string.usd_is)+usd+". "+"\n"+getString(R.string.jpd_is)+jpd+". ")
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            etNtd.setText("");
                        }
                    })
                    .show();
        }
    }
}
