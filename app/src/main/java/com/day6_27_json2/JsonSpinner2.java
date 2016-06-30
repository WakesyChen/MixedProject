package com.day6_27_json2;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import android.widget.SimpleAdapter;
import android.widget.Spinner;


import com.example.hz6_23_spinner.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Wakesy on 2016/6/27.
 */
public class JsonSpinner2 extends Activity{

    private Spinner spinner;
    private List<Map<String,Object>> mlist;
    private SimpleAdapter adapter;
    String path="http://218.244.149.129:9010/api/bannerlist.php?imei=xxxxxx";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day6_27_spinner);
        spinner= (Spinner) findViewById(R.id.spinner_json);
        new MyAsynctask2().execute(path);
    }

    class MyAsynctask2 extends AsyncTask<String,Void,String>{
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        String jsonString=null;

        @Override
        protected String doInBackground(String... params) {
           jsonString= GetJsonContent.getJsonContent(params[0]);
            /*try {
                URL url=new URL(params[0]);
                HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                InputStream is=connection.getInputStream();
                byte[] data=new byte[1024];
                int len=0;
                while((len= is.read(data))!=-1){

                    baos.write(data,0,len);
                }
                jsonString=baos.toByteArray().toString();
                Log.i("jsonString",jsonString);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
*/
            Log.i("jsonString",jsonString);
            return jsonString;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mlist=new ArrayList<>();
            mlist=JsonUtils.JsonParse(s);
            adapter = new SimpleAdapter(JsonSpinner2.this, mlist, R.layout.day6_27_item, new String[]{"company", "summary"}, new int[]{R.id.tv_title,R.id.tv_content});
            spinner.setAdapter(adapter);

        }
    }

}
