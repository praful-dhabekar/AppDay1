package com.example.praf.appday1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public TextView textView;
    public Button button;
    public static final String TAG = MainActivity.class.getSimpleName();
    String RandomNum_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.random_num_tv_1);
        button = (Button)findViewById(R.id.button_1);

        /*Generating random number using Random class*/
        Random random = new Random();
        int rdm = random.nextInt(100);//generate random integers in 0 to 100
        RandomNum_1 = String.valueOf(rdm);

        final Bundle bundle = getIntent().getExtras();

        textView.setText(RandomNum_1);
        Log.e(TAG, "Error: "+RandomNum_1);
        if (bundle != null) {
            String num2 = bundle.getString("num2");
            textView.setText(num2);
            Toast.makeText(this, "Value from: "+num2, Toast.LENGTH_SHORT).show();
        }



        Log.e(TAG, "Random Number: "+rdm);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                //Creating the bundle
                Bundle bundle = new Bundle();
                bundle.putString("num1", RandomNum_1);
                //Add the bundle to intent
                intent.putExtras(bundle);
                //Goto SecondActivity
                startActivity(intent);
            }
        });
    }
}
