package com.day6_28_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hz6_23_spinner.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Wakesy on 2016/6/28.
 */
public class MyBaseAdapter extends BaseAdapter {

    private List<Bean> datalsit;

    private LayoutInflater mInflater;

    public MyBaseAdapter(Context context, List<Bean> datalsit) {
        this.mInflater = LayoutInflater.from(context);
        this.datalsit = datalsit;


    }


    @Override
    public int getCount() {
        return datalsit.size();
    }

    @Override
    public Object getItem(int position) {
        return datalsit.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.listview_item, null);
            holder.img= (ImageView) convertView.findViewById(R.id.lv_item_img);
            holder.company = (TextView) convertView.findViewById(R.id.lv_item_company);
            holder.industryname = (TextView) convertView.findViewById(R.id.lv_item_industryname);
            holder.summary = (TextView) convertView.findViewById(R.id.lv_item_summary);
            convertView.setTag(holder);
        }
        holder = (ViewHolder) convertView.getTag();
        Bean bean = new Bean();
        bean.setCompany( datalsit.get(position).getCompany());
        bean.setIndustryname(datalsit.get(position).getIndustryname());
        bean.setSummary(datalsit.get(position).getSummary());
        bean.setImgUrl( datalsit.get(position).getImgUrl());

        holder.company.setText(bean.getCompany());
        holder.industryname.setText(bean.getIndustryname());
        holder.summary.setText(bean.getSummary());
        String url=bean.getImgUrl();
        holder.img.setImageResource(R.mipmap.ic_launcher);//设置一张默认的图片
        holder.img.setTag(url);
            new LoadImgAsync(holder.img).execute(url);
        //设置图片
        return convertView;
    }

    class ViewHolder {
        ImageView img;
        TextView company;
        TextView industryname;
        TextView summary;


    }
}
