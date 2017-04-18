package com.example.mylibrary;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {


    private ImageView bingPicImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bingPicImg = (ImageView) findViewById(R.id.bing_pic_img);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String bingPic = prefs.getString("bing_pic", null);
        if(bingPic != null){
            Glide.with(this).load(bingPic).into(bingPicImg);
            Toast.makeText(MainActivity.this,"sharedpreferences已经有图片",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(MainActivity.this,"mei有图片",Toast.LENGTH_LONG).show();
            loadBingPic();
        }

    }

    private void loadBingPic(){
        String requestBingPic = "http://guolin.tech/api/bing_pic";

        HttpUtil.sendOkHttpRequest(requestBingPic, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String bingPic = response.body().toString();
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit();
                editor.putString("bing_pic",bingPic);
                editor.apply();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(bingPic != null){
                            Glide.with(MainActivity.this).load(bingPic).into(bingPicImg);
                            Toast.makeText(MainActivity.this,"已经显示图片",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }

}
