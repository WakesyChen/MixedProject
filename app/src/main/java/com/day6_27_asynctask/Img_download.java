package com.day6_27_asynctask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.hz6_23_spinner.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Wakesy on 2016/6/27.
 */
public class Img_download extends Activity {

    private ImageView img_download;
    private Button btn_download,btn_stop;
    private MyAsyctask asynctask;
    private String url="http://img3.imgtn.bdimg.com/it/u=1879162889,1544862376&fm=11&gp=0.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.img_download);

        img_download= (ImageView) findViewById(R.id.img_download);
        btn_download= (Button) findViewById(R.id.btn_downlaod);
        btn_stop= (Button) findViewById(R.id.btn_stop);
        asynctask=new MyAsyctask();
        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asynctask.execute(url);
            }
        });
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (asynctask != null)
                    asynctask.cancel(true);
            }
        });


    }


    class MyAsyctask extends AsyncTask<String,Integer,Bitmap>{

        private ProgressDialog dialog=null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog=new ProgressDialog(Img_download.this);
            dialog.setIcon(R.mipmap.ic_launcher);
            dialog.setTitle("提示信息");
            dialog.setMessage("玩命加载中，请稍后...");
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.show();


        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            dialog.setProgress(values[0]);
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bitmap = null;
            if(!asynctask.isCancelled()) {

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                try {
                    URL url = new URL(params[0]);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    InputStream is = connection.getInputStream();
                    byte data[] = new byte[1024];
                    int len = 0;
                    int pro_len = 0;//当前读取长度
                    int progress;

                    int total_len = connection.getContentLength(); //获取输入流长度的方法
                    while ((len = is.read(data)) != -1) {
                        pro_len += len;
                        outputStream.write(data, 0, len);
                        progress = pro_len * 100 / (total_len);//设置进度,进度条总单位是100,所以要*100
                        publishProgress(progress);
                    }
                    byte[] Data = outputStream.toByteArray();
                    bitmap = BitmapFactory.decodeByteArray(Data, 0, Data.length);
                    outputStream.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            img_download.setImageBitmap(bitmap);
            dialog.dismiss();

        }
    }
}
