package com.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.hz6_23_spinner.R;

public class Spinner extends AppCompatActivity {


    private android.widget.Spinner spinner2,spinner3;
    private ArrayAdapter<String> adapter;
    ArrayAdapter<CharSequence>adapter2;
    private String hobby[]={"钓鱼","打LOL","下棋","跑步","听歌"};
    private String hubei[]={"咸宁","襄阳","黄冈","十堰","神农架"};
    private String hunan[]={"岳阳","长沙","益阳","娄底","凤凰"};
    private String zhejiang[]={"杭州","宁波","温州","萧山","玉泉"};
    private String shandong[]={"济南","日照","甲地","乙地","随便啦"};
    private String prince[]={"湖北","湖南","浙江","山东"};
    private String prince2[][]={hubei,hunan,zhejiang,shandong};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);
        spinner2 = (android.widget.Spinner) findViewById(R.id.spinner2);
        spinner3 = (android.widget.Spinner) findViewById(R.id.spinner3);
        adapter = new ArrayAdapter<String>(Spinner.this, android.R.layout.simple_spinner_item, prince);
        spinner2.setAdapter(adapter);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                adapter2 = new ArrayAdapter<CharSequence>(Spinner.this,android.R.layout.simple_spinner_dropdown_item,prince2[position]);
                spinner3.setAdapter(adapter2);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
}
