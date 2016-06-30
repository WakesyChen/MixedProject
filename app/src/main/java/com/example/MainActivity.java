package com.example;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.day6_27_asynctask.Img_download;
import com.caiquan.Game;
import com.day6_27_json2.JsonSpinner2;
import com.day6_27_json2.Weather;
import com.day6_28_listview.ListViewDemo;
import com.health.Intent1;
import com.imagegame.ImageGame;
import com.servey.ServeyActivity;

/**
 * Created by Wakesy on 2016/6/24.
 */
public class MainActivity extends LauncherActivity {
//, "猜拳游戏", "健康测试","问卷调查","下拉列表"
    String []activityNames={"下拉列表", "图文下拉列表","拼图游戏","猜拳游戏", "健康测试","问卷调查","下载图片",
                "Json下拉列表","天气","图片listview"};
    Class<?>[] classes={Spinner.class, Spinner_img.class,ImageGame.class, Game.class, Intent1.class, ServeyActivity.class,
            Img_download.class, JsonSpinner2.class, Weather.class, ListViewDemo.class};
    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        ArrayAdapter<String>adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,activityNames);
        setListAdapter(adapter);

    }

    @Override
    protected Intent intentForPosition(int position) {
        return new Intent(MainActivity.this,classes[position]);

    }
}
