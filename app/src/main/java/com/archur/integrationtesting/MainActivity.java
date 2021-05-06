package com.archur.integrationtesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public EditText txt_first,txt_second;
    public EditText txt_result;
    public Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    void initView() {
        txt_first = (EditText) findViewById(R.id.first);
        txt_second = (EditText) findViewById(R.id.second);
        txt_result = (EditText) findViewById(R.id.result_main);

        calculate = (Button) findViewById(R.id.button);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(txt_first.getText().toString());
                int b = Integer.parseInt(txt_second.getText().toString());
                int c = a + b;
                System.out.println("a=" + a + "b=" + b + "c=" + c);
                txt_result.setText(c + "");

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("sum", c + "");
                startActivity(intent);
            }
        });
    }
}