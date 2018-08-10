package id.co.asyst.yeni.covertersuhu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText nilaiET;
    Spinner spinnerA, spinnerB;
    String suhuAStr, suhuBStr;
    TextView hasilTS;
    float nilai;
    double hitung;

    ArrayList<String> listSuhuA = new ArrayList<String>();
    ArrayList<String> listSuhuB = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nilaiET = findViewById(R.id.nilai_et);
        spinnerA = findViewById(R.id.spinner_a);
        spinnerB = findViewById(R.id.spinner_b);
        hasilTS = findViewById(R.id.hasil_ts);

        listSuhuA.add("celcius");
        listSuhuA.add("fahrenheit");
        listSuhuA.add("reamur");
        listSuhuA.add("kelvin");

        listSuhuB.add("celcius");
        listSuhuB.add("fahrenheit");
        listSuhuB.add("reamur");
        listSuhuB.add("kelvin");


        ArrayAdapter<String> suhuAAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listSuhuA);
        spinnerA.setAdapter(suhuAAdapter);
        ArrayAdapter<String> suhuBAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listSuhuB);
        spinnerB.setAdapter(suhuBAdapter);

        spinnerA.setOnItemSelectedListener(this);
        spinnerB.setOnItemSelectedListener(this);


        nilaiET.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() != 0) {
                    if (!TextUtils.isEmpty(nilaiET.getText().toString())) {
                        nilai = Float.valueOf(nilaiET.getText().toString());
                    }
                    if (suhuAStr.equalsIgnoreCase(suhuBStr)) {
                        hasilTS.setText(nilai + " ");
                    } else if (suhuAStr.equalsIgnoreCase("celcius") && suhuBStr.equalsIgnoreCase("fahrenheit")) {
                        hitung = (nilai * 1.8) + 32;
                        hasilTS.setText(String.valueOf(hitung));
                    } else if (suhuAStr.equalsIgnoreCase("celcius") && suhuBStr.equalsIgnoreCase("reamur")) {
                        hasilTS.setText(nilai * 0.8 + "");
                    } else if (suhuAStr.equalsIgnoreCase("celcius") && suhuBStr.equalsIgnoreCase("kelvin")) {
                        hasilTS.setText(nilai + 273.15 + "");

                    } else if (suhuAStr.equalsIgnoreCase("fahrenheit") && suhuBStr.equalsIgnoreCase("celcius")) {
                        hasilTS.setText((nilai - 32) / 1.8 + "");
                    } else if (suhuAStr.equalsIgnoreCase("fahrenheit") && suhuBStr.equalsIgnoreCase("reamur")) {
                        hasilTS.setText((nilai - 32) / 0.44 + "");
                    } else if (suhuAStr.equalsIgnoreCase("fahrenheit") && suhuBStr.equalsIgnoreCase("kelvin")) {
                        hasilTS.setText((nilai + 459.67) / 1.8 + "");

                    } else if (suhuAStr.equalsIgnoreCase("reamur") && suhuBStr.equalsIgnoreCase("celcius")) {
                        hasilTS.setText(nilai / 0.8 + "");
                    } else if (suhuAStr.equalsIgnoreCase("reamur") && suhuBStr.equalsIgnoreCase("fahreinheit")) {
                        hasilTS.setText((nilai * 2.25) + 32 + "");
                    } else if (suhuAStr.equalsIgnoreCase("reamur") && suhuBStr.equalsIgnoreCase("kelvin")) {
                        hasilTS.setText((nilai / 0.89) + 273.15 + "");

                    } else if (suhuAStr.equalsIgnoreCase("kelvin") && suhuBStr.equalsIgnoreCase("celcius")) {
                        hasilTS.setText((nilai * 9) + 32 + "");
                    } else if (suhuAStr.equalsIgnoreCase("kelvin") && suhuBStr.equalsIgnoreCase("fahreinheit")) {
                        hasilTS.setText(nilai - 273.15 + "");
                    } else {
                        hasilTS.setText((nilai - 273.15) / 0.8 + "");
                    }

                } else {
                    hasilTS.setError("Errrroooor");
                }

            }
        });


    }

    public void hitung() {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        suhuAStr = spinnerA.getSelectedItem().toString();
        suhuBStr = spinnerB.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


/*    private final TextWatcher hasil = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            hasilTS.setVisibility(View.VISIBLE);
        }

        public void afterTextChanged(Editable s) {
            if (s.length() == 0) {
                hasilTS.setVisibility(View.GONE);
            } else{
                hasilTS.setText("You have entered : " + nilaiET.getText());
            }
        }
    };*/
}
