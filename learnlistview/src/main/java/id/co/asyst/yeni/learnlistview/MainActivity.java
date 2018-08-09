package id.co.asyst.yeni.learnlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import id.co.asyst.yeni.learnlistview.fragments.InputBottomSheet;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener, AdapterView.OnItemLongClickListener, InputBottomSheet.OnSubmitButtonListener {

    ListView listView;
    ArrayList<String> listNama = new ArrayList<String>();
    ArrayAdapter arrayAdapter;

    EditText inputNameET;
    Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        inputNameET = findViewById(R.id.input_name_edittext);
        buttonAdd = findViewById(R.id.button_add);

        listNama.add("Yeni");
        listNama.add("Adelia");
        listNama.add("Mifta");
        listNama.add("Anisa");
        listNama.add("Evi");
        listNama.add("Feby");


        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listNama);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemLongClickListener(this);
        buttonAdd.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (!inputNameET.getText().toString().equalsIgnoreCase("")) {
            listNama.add(inputNameET.getText().toString());
            inputNameET.setText("");
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, listNama.get(position), Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        InputBottomSheet inputBottomSheet = InputBottomSheet.newInstance(listNama.get(position), position);
        inputBottomSheet.show(getSupportFragmentManager(), "");
        return false;
    }


    @Override
    public void onSubmitButton(String name, int position) {
        listNama.set(position, name);
        arrayAdapter.notifyDataSetChanged();
    }
}
