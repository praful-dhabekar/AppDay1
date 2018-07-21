package com.example.praf.appday1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    public TextView textView;
    public Button button;
    public static final String TAG = SecondActivity.class.getSimpleName();
    String RandomNum_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = (TextView)findViewById(R.id.random_num_tv_2);
        button = (Button)findViewById(R.id.button_2);

        final Bundle bundle = getIntent().getExtras();
        String num1 = bundle.getString("num1");
        textView.setText(num1);
        Toast.makeText(this, "Value from MainActivity: "+num1, Toast.LENGTH_SHORT).show();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);

                /*Generating random number with Random class*/
                Random random = new Random();
                int rdm = random.nextInt(100);
                RandomNum_2 = String.valueOf(rdm);//generate random integers in 0 to 100

                Log.e(TAG, "Random Number: "+rdm);

                bundle.putString("num2",RandomNum_2);
                //Add the bundle to intent
                intent.putExtras(bundle);
                //Go to MainActivity
                startActivity(intent);
            }
        });
    }
}
