package com.example.indexofbodymass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public void OnClick(View v) {

        EditText height = (EditText) findViewById(R.id.height);
        EditText weight = (EditText) findViewById(R.id.weight);
        TextView resText = (TextView) findViewById(R.id.textView);
        Button btn = (Button) findViewById(R.id.button2);

            //float h = 1;
            //float w = 1;

            float h = Float.parseFloat(height.getText().toString());
            float w = Float.parseFloat(weight.getText().toString());

            //if (h != 1 & w != 1){
                h = h / 100;
                final float res = w / (h * h);


            if (res > 18.5 & res < 25) {
                resText.setGravity(Gravity.CENTER_HORIZONTAL);
                resText.setText("Ваш ИМТ в норме ");
            }
            if (res < 18.6) {
                resText.setGravity(Gravity.CENTER_HORIZONTAL);
                resText.setText("Ваш ИМТ ниже нормы ");
            }
            if (res > 24.9) {
                resText.setGravity(Gravity.CENTER_HORIZONTAL);
                resText.setText("Ваш ИМТ выше нормы ");
            }

            btn.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (res > 18.5 & res < 25) {
                                Intent nLay = new Intent(".ScrollingActivity");
                                startActivity(nLay);
                            }
                            if (res < 18.6) {
                                Intent nLay = new Intent(".ScrollingActivity2");
                                startActivity(nLay);
                            }
                            if (res > 24.9) {
                                Intent nLay = new Intent(".ScrollingActivity3");
                                startActivity(nLay);
                            }
                        }
                    }
            );
        //}
        //else{
         //   resText.setText("Заполните оба поля ");
         //   resText.setGravity(Gravity.CENTER_HORIZONTAL);
        //}
    }
}

