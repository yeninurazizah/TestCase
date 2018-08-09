package id.co.asyst.yeni.testcase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.co.asyst.yeni.testcase.utility.Constant;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText timAET, timBET;
    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timAET = findViewById(R.id.tim_a_edittext);
        timBET = findViewById(R.id.tim_b_edittext);
        startButton = findViewById(R.id.start_button);

        startButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_button:
                if (validate()) {
                    Intent intent = new Intent(this, MatchActivity.class);

                    intent.putExtra(Constant.KEY_TEAM_A_NAME, timAET.getText().toString());
                    intent.putExtra(Constant.KEY_TEAM_B_NAME, timBET.getText().toString());

                    startActivity(intent);
                }
                break;
        }
    }

    public boolean validate() {
        if (TextUtils.isEmpty(timAET.getText().toString()) || TextUtils.isEmpty(timBET.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Nama tim harus diisi", Toast.LENGTH_SHORT).show();
            return false;

        }
        if (timAET.getText().toString().equalsIgnoreCase(timBET.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Nama tim tidak boleh sama", Toast.LENGTH_SHORT).show();
            return false;

        }

        return true;
    }
}
