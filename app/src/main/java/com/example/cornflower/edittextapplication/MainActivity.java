package com.example.cornflower.edittextapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private EditText et,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.et);
        String s ;
        s = "你好呀老地方";
        et.setText(s);

        et2 = (EditText) findViewById(R.id.et2);
        et2.addTextChangedListener(new EditTextFilter(this,et2));
    }


}
