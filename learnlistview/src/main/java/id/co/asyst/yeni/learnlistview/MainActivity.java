package id.co.asyst.yeni.learnlistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import id.co.asyst.yeni.learnlistview.adapter.PersonAdapter;
import id.co.asyst.yeni.learnlistview.model.Person;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {

    ListView listView;
    ArrayList<String> listNama = new ArrayList<String>();
    ArrayAdapter arrayAdapter;

    ArrayList<Person> listPerson = new ArrayList<>();

    EditText inputNameET;
    Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        inputNameET = findViewById(R.id.input_name_edittext);
        buttonAdd = findViewById(R.id.button_add);

/*        listNama.add("Yeni");
        listNama.add("Adelia");
        listNama.add("Mifta");
        listNama.add("Anisa");
        listNama.add("Evi");
        listNama.add("Feby");*/

        //ngambil listperson
        for (int i = 0; i < 10; i++) {
            Person person = new Person("Nama ke " + i, "Alamat ke " + i);
            listPerson.add(person);
        }

        //nampilin listperson
        PersonAdapter personAdapter = new PersonAdapter(this, listPerson);
        listView.setAdapter(personAdapter);

/*        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listNama);
        listView.setAdapter(arrayAdapter);*/

        listView.setOnItemLongClickListener(this);
        listView.setOnItemClickListener(this);
//        buttonAdd.setOnClickListener(this);
    }

//JIKA LONG PRESS MUNCUL BOTTOMSHEET EDIT
@Override
public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
    return false;
}

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("person", listPerson.get(position));
        startActivity(intent);
    }


   /* @Override
    public void onClick(View v) {
        if (!inputNameET.getText().toString().equalsIgnoreCase("")) {
            listNama.add(inputNameET.getText().toString());
            inputNameET.setText("");
            arrayAdapter.notifyDataSetChanged();
        }
    }*/

   /* @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, listNama.get(position), Toast.LENGTH_SHORT).show();
    }
*/

   /* @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        InputBottomSheet inputBottomSheet = InputBottomSheet.newInstance(listNama.get(position), position);
        inputBottomSheet.show(getSupportFragmentManager(), "");
        return false;
    }*/




    /*@Override
    public void onSubmitButton(String name, int position) {
        listNama.set(position, name);
        arrayAdapter.notifyDataSetChanged();
    }*/
}
