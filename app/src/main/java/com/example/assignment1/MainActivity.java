package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtF, txtC;
    Button btnConvertF2C,btnConvertC2F;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtF = findViewById(R.id.txtF);
        txtC = findViewById(R.id.txtC);

        btnConvertF2C = findViewById(R.id.btnConvertF2C);
        btnConvertC2F = findViewById(R.id.btnConvertC2F);

        btnConvertF2C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strF = txtF.getText().toString();
                Log.i("Info", "String of txtF = " + strF);

                if (strF.length() == 0) {
                    Toast.makeText(v.getContext(),
                            "ERROR: Input value for F degree is empty!!!",
                            Toast.LENGTH_LONG).show();
                    Log.e("Error", "String of txtF is empty!");
                    return;
                }

                double valF = 32.0;
                try {
                    valF = Double.parseDouble(strF);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Log.e("Error", "String of txtF is not parsable!");
                    Toast.makeText(v.getContext(),
                            "ERROR: Input value for F degree is invalid!!!",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                double valC = (valF - 32)*5/9;

                String strC = Double.toString(valC);

                Log.i("Info", "String of txtC = " + strC);

                txtC.setText(strC);
            }
        });

        btnConvertC2F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strC = txtC.getText().toString();
                Log.i("Info", "String of txtC = " + strC);

                if (strC.length() == 0) {
                    Toast.makeText(v.getContext(),
                            "ERROR: Input value for C degree is empty!!!",
                            Toast.LENGTH_LONG).show();
                    Log.e("Error", "String of txtC is empty!");
                    return;
                }

                double valC = 32.0;
                try {
                    valC = Double.parseDouble(strC);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Log.e("Error", "String of txtC is not parsable!");
                    Toast.makeText(v.getContext(),
                            "ERROR: Input value for C degree is invalid!!!",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                double valF = (valC * 9/5 + 32);

                String strF = Double.toString(valF);

                Log.i("Info", "String of txtF = " + strF);

                txtF.setText(strF);
            }
        });

    }
}

