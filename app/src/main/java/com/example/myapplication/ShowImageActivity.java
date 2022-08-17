package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.example.myapplication.ObjectDetectionActivity.AnalysisResult;

import java.nio.ByteBuffer;

public class ShowImageActivity extends AppCompatActivity {
    ImageView imageView;
    Button next;
    Button finish;
    Button retry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);
        finish = findViewById(R.id.finish);
        retry = findViewById(R.id.retry);
        next = findViewById(R.id.next);
        imageView = findViewById(R.id.imageView);
        ByteBuffer byteBuffer = MainActivity.localStorage.getImageProxies().get(MainActivity.localStorage.getNumberImage()-1).getPlanes()[0].getBuffer();
        byteBuffer.rewind();
        byte[] bytes = new byte[byteBuffer.capacity()];
        byteBuffer.get(bytes);
        byte[] clonedBytes = bytes.clone();
        imageView.setImageBitmap(BitmapFactory.decodeByteArray(clonedBytes, 0, clonedBytes.length));
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , takePictureActivity.class);
                startActivity(intent);
            }
        });
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.localStorage.setNumberImage(MainActivity.localStorage.getNumberImage()-1);
                Intent intent = new Intent(getApplicationContext() , takePictureActivity.class);
                startActivity(intent);
            }
        });
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                MainActivity.localStorage = new localStorage();
//                Intent intent = new Intent(getApplicationContext() , MainActivity.class);
//                startActivity(intent);
                ObjectDetectionActivity objectDetectionActivity = new ObjectDetectionActivity();
                AnalysisResult analysisResult =   objectDetectionActivity.analyzeImage(MainActivity.localStorage.getImageProxies().get(MainActivity.localStorage.getNumberImage()-1),0);
                Log.i("tedad", String.valueOf(analysisResult.getmResults().size()));
            }
        });
    }
}