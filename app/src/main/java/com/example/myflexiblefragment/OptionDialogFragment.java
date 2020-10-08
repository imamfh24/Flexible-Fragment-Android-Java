package com.example.myflexiblefragment;


import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class OptionDialogFragment extends DialogFragment implements View.OnClickListener{

    private Button btnChoose, btnClose;
    private RadioGroup rgOptions;
    private RadioButton rbA,rbB,rbC,rbD;
    private OnOptionDialogListener onOptionDialogListener;

    public OnOptionDialogListener getOnOptionDialogListener() {
        return onOptionDialogListener;
    }

    public void setOnOptionDialogListener(OnOptionDialogListener onOptionDialogListener) {
        this.onOptionDialogListener = onOptionDialogListener;
    }

    public OptionDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_option_dialog, container, false);
        btnChoose = view.findViewById(R.id.btn_choose);
        btnChoose.setOnClickListener(this);
        btnClose = view.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(this);
        rgOptions = view.findViewById(R.id.rg_option);
        rbA = view.findViewById(R.id.rb_a);
        rbB = view.findViewById(R.id.rb_b);
        rbC = view.findViewById(R.id.rb_c);
        rbD = view.findViewById(R.id.rb_d);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_close:
                break;
            case R.id.btn_choose:
                int checkedRadioButtonId = rgOptions.getCheckedRadioButtonId();
                if (checkedRadioButtonId != -1) {
                    String coach = null;
                    switch (checkedRadioButtonId) {
                        case R.id.rb_a:
                            coach = rbA.getText().toString().trim();
                            break;
                        case R.id.rb_b:
                            coach = rbB.getText().toString().trim();
                            break;
                        case R.id.rb_c:
                            coach = rbC.getText().toString().trim();
                            break;
                        case R.id.rb_d:
                            coach = rbD.getText().toString().trim();
                            break;
                    }
                    getOnOptionDialogListener().onOptionChoosen(coach);
                    getDialog().cancel();
                }
                break;
        }
    }

    public interface OnOptionDialogListener{

        void onOptionChoosen(String coach);
    }

}