package com.imagegame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hz6_23_spinner.R;

/**
 * Created by Wakesy on 2016/6/24.
 */
public class ImageGame extends Activity {


    private ImageView img_00, img_01, img_02, img_10, img_11, img_12, img_20, img_21, img_22;
    private Button btn_restart;

    private int imgs[] = {R.mipmap.img_xiaoxiong_00x00, R.mipmap.img_xiaoxiong_00x01, R.mipmap.img_xiaoxiong_00x02,
            R.mipmap.img_xiaoxiong_01x00, R.mipmap.img_xiaoxiong_01x01, R.mipmap.img_xiaoxiong_01x02,
            R.mipmap.img_xiaoxiong_02x00, R.mipmap.img_xiaoxiong_02x01, R.mipmap.img_xiaoxiong_02x02,};

    int length = imgs.length;
    int imgIndex[] = new int[length];//存放图片下标顺序的数组

    private int Imgx = 3;
    private int Imgy = 3;
    private int blankNum = length - 1;
    private int blankId = R.id.img_22;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_game);
        initView();//初始化控件


        for (int i = 0; i < length; i++) {
            imgIndex[i] = i;
            //默认先顺序赋值
        }

        setRandom();//打乱顺序的方法
        setImage();
        btn_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restore();
                img_00.setClickable(true);
                img_01.setClickable(true);
                img_02.setClickable(true);
                img_10.setClickable(true);
                img_11.setClickable(true);
                img_12.setClickable(true);
                img_20.setClickable(true);
                img_21.setClickable(true);
                img_22.setClickable(true);


                setRandom();
                setImage();
            }

            //恢复原来的右下角图片空白
            private void restore() {
                ImageView imgBlank= (ImageView) findViewById(blankId);
                imgBlank.setVisibility(View.VISIBLE);
                blankId=R.id.img_22;
                blankNum=length-1;
                ImageView imgDef= (ImageView) findViewById(blankId);
                imgDef.setVisibility(View.INVISIBLE);



            }


        });

    }

    private void setImage() {
        img_00.setImageDrawable(getResources().getDrawable(imgs[imgIndex[0]]));
        img_01.setImageDrawable(getResources().getDrawable(imgs[imgIndex[1]]));
        img_02.setImageDrawable(getResources().getDrawable(imgs[imgIndex[2]]));
        img_10.setImageDrawable(getResources().getDrawable(imgs[imgIndex[3]]));
        img_11.setImageDrawable(getResources().getDrawable(imgs[imgIndex[4]]));
        img_12.setImageDrawable(getResources().getDrawable(imgs[imgIndex[5]]));
        img_20.setImageDrawable(getResources().getDrawable(imgs[imgIndex[6]]));
        img_21.setImageDrawable(getResources().getDrawable(imgs[imgIndex[7]]));
        img_22.setImageDrawable(getResources().getDrawable(imgs[imgIndex[8]]));

    }

    private void setRandom() {
        int random1, random2;
        for (int i = 0; i < 20; i++) {

            do {
                random1 = (int) (Math.random() * (length - 1));
                random2 = (int) (Math.random() * (length - 1));
                if (random1 != random2) {//交换下标顺序
                    int temp = imgIndex[random1];
                    imgIndex[random1] = imgIndex[random2];
                    imgIndex[random2] = temp;
                    break;
                }

            } while (true);
        }


    }

    private void initView() {
        img_00 = (ImageView) findViewById(R.id.img_00);
        img_01 = (ImageView) findViewById(R.id.img_01);
        img_02 = (ImageView) findViewById(R.id.img_02);
        img_10 = (ImageView) findViewById(R.id.img_10);
        img_11 = (ImageView) findViewById(R.id.img_11);
        img_12 = (ImageView) findViewById(R.id.img_12);
        img_20 = (ImageView) findViewById(R.id.img_20);
        img_21 = (ImageView) findViewById(R.id.img_21);
        img_22 = (ImageView) findViewById(R.id.img_22);
        btn_restart = (Button) findViewById(R.id.btn_restart);

    }

    public void click(View view) {

        switch (view.getId()) {

            case R.id.img_00:
                move(R.id.img_00, 0);

                break;
            case R.id.img_01:
                move(R.id.img_01, 1);

                break;
            case R.id.img_02:
                move(R.id.img_02, 2);

                break;
            case R.id.img_10:
                move(R.id.img_10, 3);

                break;
            case R.id.img_11:
                move(R.id.img_11, 4);

                break;
            case R.id.img_12:
                move(R.id.img_12, 5);

                break;
            case R.id.img_20:

                move(R.id.img_20, 6);
                break;
            case R.id.img_21:
                move(R.id.img_21, 7);

                break;
            case R.id.img_22:
                move(R.id.img_22, 8);

                break;


        }
    }

    private void move(int id, int site) {
        //被点击的图片坐标
        int imgx = site % Imgx;
        int imgy = site / Imgy;
        //空白处的图片坐标
        int blankx = blankNum % Imgx;
        int blanky = blankNum / Imgy;
        //判断是否相邻
        int x = Math.abs(blankx - imgx);
        int y = Math.abs(blanky - imgy);
        //相邻，可以交换位置
        if ((x == 0 && y == 1) || (x == 1 && y == 0)) {

            ImageView imgClick = (ImageView) findViewById(id);
            imgClick.setVisibility(View.INVISIBLE);//点击的图片设置不可见
            ImageView imgBlank = (ImageView) findViewById(blankId);
            imgBlank.setVisibility(View.VISIBLE);
            imgBlank.setImageDrawable(getResources().getDrawable(imgs[imgIndex[site]]));//设置图片
            //交换两个图片的位置
            int temp = imgIndex[site];
            imgIndex[site] = imgIndex[blankNum];
            imgIndex[blankNum] = temp;
            //重置空白位置的信息
            blankId = id;
            blankNum = site;

        }
        GameOver();


    }

    private void GameOver() {
        boolean flag = true;

        for (int i = 0; i < imgs.length; i++) {
            if (imgIndex[i] != i) {
                flag = false;
            }


        }
            if(flag){//拼图成功
                ImageView imageBlank= (ImageView) findViewById(blankId);
                imageBlank.setVisibility(View.VISIBLE);
                imageBlank.setImageDrawable(getResources().getDrawable(imgs[imgIndex[blankNum]]));
                Toast.makeText(ImageGame.this, "我擦，猴赛雷啊!", Toast.LENGTH_SHORT).show();
                img_00.setClickable(false);
                img_01.setClickable(false);
                img_02.setClickable(false);
                img_10.setClickable(false);
                img_11.setClickable(false);
                img_12.setClickable(false);
                img_20.setClickable(false);
                img_21.setClickable(false);
                img_22.setClickable(false);

            }

    }
}
