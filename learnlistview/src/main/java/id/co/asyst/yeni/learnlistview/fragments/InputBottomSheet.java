package id.co.asyst.yeni.learnlistview.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import id.co.asyst.yeni.learnlistview.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InputBottomSheet extends BottomSheetDialogFragment implements View.OnClickListener {


    EditText inputNameET;
    Button buttonEdit;
    int position;
    InputBottomSheet.OnSubmitButtonListener listener;

    public InputBottomSheet() {
        // Required empty public constructor
    }

    public static InputBottomSheet newInstance(String nama, int position) {
        InputBottomSheet inputBottomSheet = new InputBottomSheet();
        Bundle bundle = new Bundle();
        bundle.putString("nama", nama);
        bundle.putInt("position", position);

        inputBottomSheet.setArguments(bundle);
        return inputBottomSheet;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_input_bottom_sheet, container, false);
        inputNameET = view.findViewById(R.id.input_name_edittext);
        buttonEdit = view.findViewById(R.id.button_add);
        inputNameET.setText(getArguments().getString("nama"));
        position = getArguments().getInt("position");

        buttonEdit.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_add:

                listener.onSubmitButton(inputNameET.getText().toString(), position);
                dismiss();

                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof InputBottomSheet.OnSubmitButtonListener) {
            listener = (InputBottomSheet.OnSubmitButtonListener) context;
        } else {
            throw new RuntimeException(context.toString() + "Activity harus implement interface");
        }
    }

    public interface OnSubmitButtonListener {
        void onSubmitButton(String name, int position);
    }
}
