package com.archur.integrationtesting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView re;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        re = (TextView)findViewById(R.id.second_res);

        Bundle data = getIntent().getExtras();
        String sum = data.getString("sum");
        re.setText("结果是："+sum);
    }
}