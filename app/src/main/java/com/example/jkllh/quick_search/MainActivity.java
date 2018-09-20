package com.example.jkllh.quick_search;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   int inputCount=0, i=0;
    String s;
    final Button[] input=new Button[6];
    final Integer[] numInputID={R.id.Input0,R.id.Input1,R.id.Input2,R.id.Input3,
            R.id.Input4,R.id.Input5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Animation animation=new AlphaAnimation(0, 1);
        animation.setDuration(1000);
        final EditText serch=(EditText)findViewById(R.id.Search);
        Button save=(Button)findViewById(R.id.Save);
        final TextView inputted=(TextView)findViewById(R.id.Inputted);
        for(i=0;i<6;i++) {
            input[i]=(Button)findViewById(numInputID[i]);
            input[i].setTag(i);
        }
        for(i=0;i<input.length;i++) {
            final int index;
            index=i;
            input[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    serch.setText(input[index].getText());
                }
            });
        }
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=serch.getText().toString();
                inputted.append(serch.getText()+" ");
                if(inputCount==6) inputCount=0;
                input[inputCount].setText(serch.getText().toString());
                input[inputCount].setVisibility(View.VISIBLE);
                input[inputCount].setAnimation(animation);
                inputCount++;
            }
        });
        Button Google=(Button)findViewById(R.id.Google);
        Google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=serch.getText().toString();
                inputted.append(serch.getText()+" ");
                if(inputCount==6) inputCount=0;
                input[inputCount].setText(serch.getText().toString());
                input[inputCount].setVisibility(View.VISIBLE);
                input[inputCount].setAnimation(animation);
                inputCount++;
                Intent i=new Intent(Intent.ACTION_VIEW);
                Uri u=Uri.parse("https://www.google.co.kr/search?q="+s);
                i.setData(u);
                startActivity(i);
            }
        });
        Button Naver=(Button)findViewById(R.id.Naver);
        Naver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=serch.getText().toString();
                inputted.append(serch.getText()+" ");
                if(inputCount==6) inputCount=0;
                input[inputCount].setText(serch.getText().toString());
                input[inputCount].setVisibility(View.VISIBLE);
                input[inputCount].setAnimation(animation);
                inputCount++;
                Intent i=new Intent(Intent.ACTION_VIEW);
                Uri u=Uri.parse("https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query="+s);
                i.setData(u);
                startActivity(i);
            }
        });
        Button Daum=(Button)findViewById(R.id.Daum);
        Daum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=serch.getText().toString();
                inputted.append(serch.getText()+" ");
                if(inputCount==6) inputCount=0;
                input[inputCount].setText(serch.getText().toString());
                input[inputCount].setVisibility(View.VISIBLE);
                input[inputCount].setAnimation(animation);
                inputCount++;
                Intent i=new Intent(Intent.ACTION_VIEW);
                Uri u=Uri.parse("https://search.daum.net/search?nil_suggest=btn&nil_ch=&rtupcoll=&w=tot&m=&f=&lpp=&DA=SBC&sug=&sq=&o=&sugo=&q="+s);
                i.setData(u);
                startActivity(i);
            }
        });
    }
}