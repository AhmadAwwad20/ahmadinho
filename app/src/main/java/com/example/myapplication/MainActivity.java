package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ImageView img;
    private float x,y;
    private Thread thread;
    private int score=0,level=2500;
    private Button btn,btn1;
    private boolean flag=false;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.imageView2);
        btn=findViewById(R.id.button);
        btn1=findViewById(R.id.button2);
        txt=findViewById(R.id.textView);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = false;
                score = 0;

            }

        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=true;
                thread=new Thread(()->{
                    try{
                        while(flag){
                            if(score>14){
                                level-=500;
                            }
                            if(level<600){
                                flag=false;

                            }
                            starMovingImage();
                            Thread.sleep(level);
                        }
                    }
                    catch(Exception e){
                    }
                });
                    thread.start();;

            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                String str=Integer.toString(score);
                txt.setText(str);
            }
        });

        }

        public void starMovingImage() {
            x = (float) (Math.random() * 800);
            y = (float) (Math.random() * 1600);
            img.setX(x);
            img.setY(y);
        }

}
