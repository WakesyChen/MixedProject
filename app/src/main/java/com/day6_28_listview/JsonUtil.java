package com.day6_28_listview;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wakesy on 2016/6/28.
 */
public class JsonUtil {

    public static List<Bean> jsonParse(String JsonString){
        List<Bean>datalist=new ArrayList<>();
        try {
            JSONObject jsonRoot=new JSONObject(JsonString);
            JSONArray jsonArray=jsonRoot.getJSONArray("companys");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject= jsonArray.getJSONObject(i);
                String company=jsonObject.getString("company");
                String industryname=jsonObject.getString("industryname");
                String summary=jsonObject.getString("summary");
                String logo=jsonObject.getString("logo");
                Bean bean=new Bean();
                bean.setCompany(company);
                bean.setIndustryname(industryname);
                bean.setSummary(summary);
                bean.setImgUrl(logo);
                /*Map<String,Object>map=new HashMap<>();
                map.put("company",company);
                map.put("industryname",industryname);
                map.put("summary",summary);
                map.put("logo",logo);*/
                datalist.add(bean);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return  datalist;
    }
}
