package id.co.asyst.yeni.learnlistview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import id.co.asyst.yeni.learnlistview.R;
import id.co.asyst.yeni.learnlistview.model.Person;

public class PersonAdapter extends ArrayAdapter<Person> {

    ArrayList<Person> listPerson;

    public PersonAdapter(Context context, ArrayList<Person> listPerson) {
        super(context, R.layout.item_person, listPerson);

        this.listPerson = listPerson;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, null);

        TextView nameTV = rootView.findViewById(R.id.name_tv);
        TextView addressTV = rootView.findViewById(R.id.address_tv);

        nameTV.setText(listPerson.get(position).getName());
        addressTV.setText(listPerson.get(position).getAddress());

        return rootView;
    }
}
