package com.day6_27_json2;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import com.example.hz6_23_spinner.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Wakesy on 2016/6/27.
 */
public class Weather extends Activity {

    private Spinner spinner;
    private List<Map<String,Object>>mdatalist;
    private SimpleAdapter adapter;
    private String path = "http://api.map.baidu.com/telematics/v3/weather?location=杭州&output=json&ak=mXBIDrvTOwwmYaTtN03Lo0j2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day6_27_spinner);
        spinner = (Spinner) findViewById(R.id.spinner_json);
        new Myasynctask3().execute(path);
    }

    class Myasynctask3 extends AsyncTask<String, Void, String> {
        String jsonString=null;

        @Override
        protected String doInBackground(String... params) {
            jsonString=GetJsonContent.getJsonContent(params[0]);
            Log.i("JsonString",jsonString);
            return jsonString;
        }

        @Override
        protected void onPostExecute(String jsonString) {
            super.onPostExecute(jsonString);
            mdatalist=new ArrayList<>();
            mdatalist=JsonUtils.JsonParse2(jsonString);
            Log.i("JsonString",mdatalist.toString());
            adapter=new SimpleAdapter(Weather.this,mdatalist, R.layout.weather_item,new String[]{"data","weather","wind","temperature"},
                                    new int[]{R.id.textView,R.id.textView2,R.id.textView3,R.id.textView4});
            spinner.setAdapter(adapter);
        }
    }
}
