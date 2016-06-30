package com.day6_27_json2;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wakesy on 2016/6/27.
 */
public class JsonUtils {


    public static List<Map<String, Object>> JsonParse(String json) {

        List<Map<String, Object>> datalist = new ArrayList<>();

        try {
            JSONObject object = new JSONObject(json);
            JSONArray jsonArray = object.getJSONArray("viewpager");
            for (int i = 0; i < jsonArray.length(); i++) {
                if (i==0){
                    continue;
                }
                JSONObject object1 = jsonArray.getJSONObject(i);
                Map<String, Object> map = new HashMap<>();
                String company = object1.getString("company");
                String summary = object1.getString("summary");
                map.put("company", company);
                map.put("summary", summary);
                datalist.add(map);
                Log.i("company", company);
                Log.i("summary", summary);
            }
                return  datalist;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static List<Map<String, Object>> JsonParse2(String json) {
        List<Map<String, Object>> datalist = new ArrayList<>();
        try {
            JSONObject jsonRoot=new JSONObject(json);
            JSONArray jsonArray=jsonRoot.getJSONArray("results");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                JSONArray jsonArray1 = jsonObject1.getJSONArray("weather_data");
                for (int j = 0; j < jsonArray1.length(); j++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(j);
                    String date = jsonObject.getString("date");
                    String weather = jsonObject.getString("weather");
                    String wind = jsonObject.getString("wind");
                    String temperature = jsonObject.getString("temperature");
                    Map<String, Object> map = new HashMap<>();
                    map.put("date", date);
                    map.put("weather", weather);
                    map.put("wind", wind);
                    map.put("temperature", temperature);
                    Log.i("temperature", temperature);
                    datalist.add(map);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  datalist;
    }

}
