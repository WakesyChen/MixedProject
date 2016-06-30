package com.servey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hz6_23_spinner.R;


/**
 * Created by Wakesy on 2016/6/23.
 */
public class ServeySecond extends Activity {
    private TextView tv_infor;
    String infor;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servey_second);

tv_infor= (TextView) findViewById(R.id.tv_infor);
        Intent intent=getIntent();
      infor=intent.getStringExtra("infor");
        tv_infor.setText(infor);
    }


}
