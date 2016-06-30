package com.health;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hz6_23_spinner.R;

/**
 * Created by Wakesy on 2016/6/22.
 */
public class Intent2 extends Activity {
    private ImageView img_state;
    private TextView tv_bmi;
    private TextView tv_suggest;
    private static final String TAG = "Intent2";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent2);
        inint();

        Intent intent = getIntent();
        double BMI = intent.getFloatExtra("bmi", 20);
        double bmi =  (double)(Math.round(BMI * 100) / 100.0);//保留两位小数
        Log.i(TAG, "bmi :"+bmi);
        tv_bmi.setText("BMI值为：" + bmi);
        if (bmi < 18) {
            tv_suggest.setText("太瘦了，多吃肉多睡觉啊！");
            img_state.setImageResource(R.drawable.bmi_1);
        } else if (bmi >= 18 && bmi < 24) {
            tv_suggest.setText("正常，好极了！");
            img_state.setImageResource(R.drawable.bmi_2);
        } else if (bmi >= 24 && bmi < 30) {
            tv_suggest.setText("偏胖，你这样下去要变成大胖子了！");
            img_state.setImageResource(R.drawable.bmi_3);
        } else {
            tv_suggest.setText("太胖,辣么多肉，胖死你算了~");
            img_state.setImageResource(R.drawable.bmi_4);
        }

    }

    private void inint() {
        img_state = (ImageView) this.findViewById(R.id.img_state);
        tv_bmi = (TextView) findViewById(R.id.tv_bmi);
        tv_suggest = (TextView) findViewById(R.id.tv_suggest);

    }
}
