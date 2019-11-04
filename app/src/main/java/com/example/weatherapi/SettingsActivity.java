package com.example.weatherapi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class SettingsActivity extends AppCompatActivity {

    TextInputLayout tv_zip;
    RadioGroup tv_unit;
    RadioButton tv_button;
    Button btn_apply;
    String zip = "";
    String unit = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        final SharedPreferences sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE);

        String api_key = "448d3758fc3d980204a08f0d2a5b6e7e";
        String current_api_weather = "api.openweathermap.org/data/2.5/weather?zip={60506},{us}?appid={448d3758fc3d980204a08f0d2a5b6e7e}";

        String current_api_weather1 = "http://api.openweathermap.org/data/2.5/weather?zip=60506,us&appid=448d3758fc3d980204a08f0d2a5b6e7e";
        String three_hour_api = "api.openweathermap.org/data/2.5/forecast?zip=60506,us&appid=448d3758fc3d980204a08f0d2a5b6e7e";

        tv_zip = findViewById(R.id.til_zip);
        tv_unit = findViewById(R.id.radio_group);
        btn_apply = findViewById(R.id.btn_set);


        btn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                int checkedID = tv_unit.getCheckedRadioButtonId();
                tv_button = findViewById(checkedID);
                zip = tv_zip.getEditText().getText().toString();

                if (zip.isEmpty() || tv_unit.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(SettingsActivity.this, "Cannot leave empty!", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    unit = tv_button.getText().toString();

                    editor.putString("zip", zip);
                    editor.putString("unit", unit);
                    editor.commit();

                    startActivity(new Intent(SettingsActivity.this, MainActivity.class));
                }
            }
        });
    }


}
