package com.day6_28_listview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.hz6_23_spinner.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wakesy on 2016/6/28.
 */
public class ListViewDemo extends Activity{
    private ListView listView;
    private List<Map<String,Object>>datalist;
    private MyBaseAdapter myBaseAdapter;
    private String path="http://218.244.149.129:9010/api/companylist.php?industryid=102";
    private int Imgs[]={R.mipmap.img_1,R.mipmap.img_2,R.mipmap.img_3,R.mipmap.img_4,R.mipmap.img_5,R.mipmap.img_6,};
    private String contents[]={"小花","小李","小亮","小白","小青","小明"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_demo);

        listView= (ListView) findViewById(R.id.listView_1);
        datalist=new ArrayList<>();
        new MyAsynctask(ListViewDemo.this,listView).execute(path);
       /* for (int i = 0; i < Imgs.length; i++) {
            Map<String ,Object>map=new HashMap<>();
            map.put("company",contents[i]);
            map.put("img",Imgs[i]);
            datalist.add(map);
        }
        myBaseAdapter=new MyBaseAdapter(this,datalist);
        listView.setAdapter(myBaseAdapter);*/
    }
}
