package com.caiquan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hz6_23_spinner.R;

import java.util.Random;

/**
 * Created by Wakesy on 2016/6/22.
 */
public class Game extends Activity {

    private int Images[] = {R.mipmap.bu, R.mipmap.shitou, R.mipmap.jianzi};
    private ImageView ming_img, wang_img;
    private Button start_btn;
    private TextView result_tv;
    private int random_wang, random_ming;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_caiquan);
        initView();

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                random_ming = random.nextInt(Images.length);
                ming_img.setImageResource(Images[random_ming]);//设置图片
                random_wang = random.nextInt(Images.length);
                wang_img.setImageResource(Images[random_wang]);//设置图片
                if (random_ming == random_wang) {
                    result_tv.setText("平局！");
                } else {
//                bu 0,shitou 1,jianzi 2
                    if ((random_ming == 0 && random_wang == 1) || (random_ming == 1 && random_wang == 2) ||
                            (random_ming == 2 && random_wang == 0)) {
                        result_tv.setText("小明胜！");

                    } else result_tv.setText("老王胜！");

                }
            }
        });


    }

    private void initView() {
        ming_img = (ImageView) this.findViewById(R.id.ming_img);
        wang_img = (ImageView) this.findViewById(R.id.wang_img);
        start_btn = (Button) this.findViewById(R.id.start_btn);
        result_tv = (TextView) this.findViewById(R.id.result_tv);
    }
}
