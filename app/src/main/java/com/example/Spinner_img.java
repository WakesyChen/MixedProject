package com.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import com.example.hz6_23_spinner.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Spinner_img extends AppCompatActivity {


    private android.widget.Spinner spinner2,spinner3;
    private List<Map<String,Object>>mList=new ArrayList<>();

    private String prince[]={"湖北","湖南","浙江","山东"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);
        spinner2 = (android.widget.Spinner) findViewById(R.id.spinner2);

        for (int i = 0; i <prince.length ; i++) {
            Map<String ,Object>map=new HashMap<>();
            map.put("prince",prince[i]);
            map.put("img",R.mipmap.ic_launcher);
            mList.add(map);

        }
        SimpleAdapter adapter1=new SimpleAdapter(getApplicationContext(),mList,R.layout.item,new String[]{"img","prince"},
                                new int[]{R.id.img_item,R.id.tv_item});
        spinner2.setAdapter(adapter1);





    }
}
