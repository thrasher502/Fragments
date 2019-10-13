package com.example.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


interface NumbersMultiplier {
    void multiply (String x, String y);
}

public class BotFragment extends Fragment {
    private Button button;
    private EditText firstEditText,lastEditText;
    private NumbersMultiplier numbersMultiplierObject;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bot_frag,container,false);
        firstEditText = (EditText) view.findViewById(R.id.firstEditText);
        lastEditText = (EditText) view.findViewById(R.id.lastEditText);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstEditText.getText().toString() != "" && lastEditText.getText().toString() !="" )
                numbersMultiplierObject.multiply(firstEditText.getText().toString(), lastEditText.getText().toString());
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            numbersMultiplierObject = (NumbersMultiplier) context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }
}
