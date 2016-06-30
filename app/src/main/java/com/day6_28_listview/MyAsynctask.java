package com.day6_28_listview;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Wakesy on 2016/6/28.
 */
public class MyAsynctask extends AsyncTask<String,Void,String> {

    private String JsonString;
    private ListView listView;
    private List<Bean> datalist;
    private Context context;
    private MyBaseAdapter myBaseAdapter;
    public MyAsynctask( Context context,ListView listView) {
        this.context = context;
        this.listView = listView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        datalist=new ArrayList<>();

    }

    @Override
    protected String doInBackground(String... params) {
        JsonString=HttpUtils.getJsonContent(params[0]);
        return JsonString;
    }

    @Override
    protected void onPostExecute(String JsonString) {
        super.onPostExecute(JsonString);
        datalist=JsonUtil.jsonParse(JsonString);
        myBaseAdapter=new MyBaseAdapter(context,datalist);
        listView.setAdapter(myBaseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             Bean bean =new Bean();
                //得到选择的position对应的数据源item，list<Bean>
                bean= (Bean) listView.getItemAtPosition(position);
            }
        });




    }
}
