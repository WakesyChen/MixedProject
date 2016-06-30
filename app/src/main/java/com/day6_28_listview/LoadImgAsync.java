package com.day6_28_listview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Wakesy on 2016/6/28.
 */
public class LoadImgAsync  extends AsyncTask<String,Void,Bitmap>{

    private ImageView img;
    private String ImgUrl;
    public LoadImgAsync(ImageView img) {
        this.img=img;
    }


    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap bitmap=null;
        ImgUrl=params[0];
        URL url= null;
        try {

            url = new URL(ImgUrl);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            InputStream is=connection.getInputStream();
            bitmap= BitmapFactory.decodeStream(is);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        String url= (String) img.getTag();
        if (ImgUrl.equals(url)){
            img.setImageBitmap(bitmap);
        }

    }
}
