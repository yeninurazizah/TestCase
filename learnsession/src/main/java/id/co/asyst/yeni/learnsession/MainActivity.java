package id.co.asyst.yeni.learnsession;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import id.co.asyst.yeni.learnsession.utility.SessionUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameET, addressET;
    RadioGroup radioGender;
    RadioButton radioMale, radioFemale;
    Spinner educationSP;
    Button submitBtn;

    SessionUtils sessionUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameET = findViewById(R.id.name_et);
        addressET = findViewById(R.id.address_et);

        radioGender = findViewById(R.id.radio_gender);
        radioMale = findViewById(R.id.radio_male);
        radioFemale = findViewById(R.id.radio_female);

        educationSP = findViewById(R.id.education_sp);
        submitBtn = findViewById(R.id.submit_btn);

        sessionUtils = new SessionUtils(this);

        submitBtn.setOnClickListener(this);

//edit text
        String name = sessionUtils.loadName();
        String address = sessionUtils.loadAddress();
        nameET.setText(name);
        addressET.setText(address);

//radio group
        String gender = sessionUtils.loadGender();
        if (gender.equalsIgnoreCase("Male")) {
            radioMale.setChecked(true);
        } else {
            radioFemale.setChecked(true);
        }

//spinner
        String edu = sessionUtils.loadEdu();
        for (int i = 0; i < educationSP.getAdapter().getCount(); i++) {
            if (educationSP.getAdapter().getItem(i).toString().equalsIgnoreCase(edu)) {
                educationSP.setSelection(i);
                break;
            }
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit_btn:
                String name = nameET.getText().toString();
                String address = addressET.getText().toString();
                String gender;
                if (radioGender.isSelected()) {
                    gender = "Male";
                } else {
                    gender = "Female";
                }
                String edu = educationSP.getSelectedItem().toString();

                if (!TextUtils.isEmpty(nameET.getText().toString())) {
                    if (!TextUtils.isEmpty(addressET.getText().toString())) {


                        sessionUtils.saveName(name, address, gender, edu);


                        Toast.makeText(getApplicationContext(), "Data berhasil tersimpan", Toast.LENGTH_SHORT).show();

                    } else {
                        addressET.setError("Alamat harus diisi");
                    }

                } else {
                    nameET.setError("Nama harus diisi");
                }

                break;

        }
    }
}
