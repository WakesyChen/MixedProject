package com.day6_28_listview;

import java.io.Serializable;

/**
 * Created by Wakesy on 2016/6/28.
 */
public class Bean implements Serializable{

    private String imgUrl;
    private String company;
    private String industryname;
    private String summary;

    public Bean(String imgUrl, String company, String industryname, String summary) {
        this.imgUrl = imgUrl;
        this.company = company;
        this.industryname = industryname;
        this.summary = summary;
    }

    public Bean() {
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getIndustryname() {
        return industryname;
    }

    public void setIndustryname(String industryname) {
        this.industryname = industryname;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
