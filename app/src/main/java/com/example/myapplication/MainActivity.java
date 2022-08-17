package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    public static localStorage localStorage = new localStorage();
    Button newSlide;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_slide);
        newSlide = findViewById(R.id.newSlide);
        newSlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequest();
                Intent intent = new Intent(getApplicationContext() , takePictureActivity.class);
                startActivity(intent);
            }
        });
    }
    public void sendRequest(){
        Call<ResponseNewSlide> responseCall = ApiClient.myApi().sendRequest(new body());
        responseCall.enqueue(new Callback<ResponseNewSlide>() {
            @Override
            public void onResponse(Call<ResponseNewSlide> call, Response<ResponseNewSlide> response) {
                Log.i("lasjfd","kals;dfj");
                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
                Log.i("yes",response.toString());
            }


            @Override
            public void onFailure(Call<ResponseNewSlide> call, Throwable t) {
                Log.d("no","nooooooooooooooooooo");
                Log.d("no",t.toString());
            }
        });
    }
    public static String assetFilePath(Context context, String assetName) throws IOException {
        File file = new File(context.getFilesDir(), assetName);
        if (file.exists() && file.length() > 0) {
            return file.getAbsolutePath();
        }

        try (InputStream is = context.getAssets().open(assetName)) {
            try (OutputStream os = new FileOutputStream(file)) {
                byte[] buffer = new byte[4 * 1024];
                int read;
                while ((read = is.read(buffer)) != -1) {
                    os.write(buffer, 0, read);
                }
                os.flush();
            }
            return file.getAbsolutePath();
        }
    }
}