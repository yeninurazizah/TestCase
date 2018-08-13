package id.co.asyst.yeni.learnlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import id.co.asyst.yeni.learnlistview.model.Person;

public class SecondActivity extends AppCompatActivity {

    TextView nameTV, addressTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nameTV = findViewById(R.id.name_tv);
        addressTV = findViewById(R.id.address_tv);

        if (getIntent().getExtras() != null) {
            Person person = getIntent().getExtras().getParcelable("person");
            nameTV.setText(person.getName());
            addressTV.setText(person.getAddress());
        }
    }
}
