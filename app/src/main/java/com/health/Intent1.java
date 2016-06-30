package com.health;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hz6_23_spinner.R;

/**
 * Created by Wakesy on 2016/6/22.
 */
public class Intent1 extends Activity {
    private Button jump_btn;
    private EditText hight_et,weight_et;
    private float BMI;
    private float hight,weight;
    private static final String TAG = "Intent1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent1);


        jump_btn= (Button) this.findViewById(R.id.jump_btn);
        hight_et= (EditText) this.findViewById(R.id.hight_et);
        weight_et= (EditText) findViewById(R.id.weight_et);


        jump_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hight_str=hight_et.getText().toString().trim();
                String weight_str=weight_et.getText().toString().trim();
                if (!TextUtils.isEmpty(hight_str)&&!TextUtils.isEmpty(weight_str)){


                    hight=Float.parseFloat(hight_str);
                    weight=Float.parseFloat(weight_str);
                    BMI=weight/(hight*hight);

                }
                Log.i(TAG, "BMI: "+BMI);
                Log.i(TAG, "hight: "+hight);
                Log.i(TAG, "weight: "+weight);


                Intent intent=new Intent(Intent1.this,Intent2.class);
               intent.putExtra("bmi",BMI);
                startActivity(intent);
            }
        });
    }
}
