package com.example.calcularpeso;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class LibrasFragment extends Fragment {

    private TextView resultadoTextView;
    private ArrayList<TextInputEditText> cantidadesTextInputEditText;
    private ArrayList<AutoCompleteTextView> unidadesAutoCompleteTextView;

    private void calcularResultado() {
        float resultado = 0.00f;
        for(int i = 0; i < cantidadesTextInputEditText.size(); i++) {
            if (!cantidadesTextInputEditText.get(i).getText().toString().equals("") && !unidadesAutoCompleteTextView.get(i).getText().toString().equals("")) {
                if (unidadesAutoCompleteTextView.get(i).getText().toString().equals("Lb")) {
                    resultado = resultado + Float.parseFloat(cantidadesTextInputEditText.get(i).getText().toString());
                } else {
                    resultado = resultado + Float.parseFloat(cantidadesTextInputEditText.get(i).getText().toString()) * 2.20462f;
                }
            }
        }
        resultadoTextView.setText(String.valueOf(resultado) + " lb");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_libras, container, false);

        resultadoTextView = view.findViewById(R.id.resultadoTextView);

        ArrayList<TextInputLayout> unidadesTextInputLayout = new ArrayList<TextInputLayout>();

        unidadesTextInputLayout.add(view.findViewById(R.id.unidad1TextInputLayout));
        unidadesTextInputLayout.add(view.findViewById(R.id.unidad2TextInputLayout));
        unidadesTextInputLayout.add(view.findViewById(R.id.unidad3TextInputLayout));
        unidadesTextInputLayout.add(view.findViewById(R.id.unidad4TextInputLayout));
        unidadesTextInputLayout.add(view.findViewById(R.id.unidad5TextInputLayout));
        unidadesTextInputLayout.add(view.findViewById(R.id.unidad6TextInputLayout));
        unidadesTextInputLayout.add(view.findViewById(R.id.unidad7TextInputLayout));
        unidadesTextInputLayout.add(view.findViewById(R.id.unidad8TextInputLayout));
        unidadesTextInputLayout.add(view.findViewById(R.id.unidad9TextInputLayout));
        unidadesTextInputLayout.add(view.findViewById(R.id.unidad10TextInputLayout));

        String[] unidadesString = {"Lb", "Kg"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), R.layout.list_item, unidadesString);

        for(TextInputLayout unidadTextInputLayout : unidadesTextInputLayout) {
            ((AutoCompleteTextView) unidadTextInputLayout.getEditText()).setAdapter(arrayAdapter);
        }

        cantidadesTextInputEditText = new ArrayList<TextInputEditText>();

        cantidadesTextInputEditText.add(view.findViewById(R.id.cantidad1TextInputEditText));
        cantidadesTextInputEditText.add(view.findViewById(R.id.cantidad2TextInputEditText));
        cantidadesTextInputEditText.add(view.findViewById(R.id.cantidad3TextInputEditText));
        cantidadesTextInputEditText.add(view.findViewById(R.id.cantidad4TextInputEditText));
        cantidadesTextInputEditText.add(view.findViewById(R.id.cantidad5TextInputEditText));
        cantidadesTextInputEditText.add(view.findViewById(R.id.cantidad6TextInputEditText));
        cantidadesTextInputEditText.add(view.findViewById(R.id.cantidad7TextInputEditText));
        cantidadesTextInputEditText.add(view.findViewById(R.id.cantidad8TextInputEditText));
        cantidadesTextInputEditText.add(view.findViewById(R.id.cantidad9TextInputEditText));
        cantidadesTextInputEditText.add(view.findViewById(R.id.cantidad10TextInputEditText));

        for(TextInputEditText cantidadTextInputEditText : cantidadesTextInputEditText) {
            cantidadTextInputEditText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    calcularResultado();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        unidadesAutoCompleteTextView = new ArrayList<AutoCompleteTextView>();

        unidadesAutoCompleteTextView.add(view.findViewById(R.id.unidad1AutoCompleteTextView));
        unidadesAutoCompleteTextView.add(view.findViewById(R.id.unidad2AutoCompleteTextView));
        unidadesAutoCompleteTextView.add(view.findViewById(R.id.unidad3AutoCompleteTextView));
        unidadesAutoCompleteTextView.add(view.findViewById(R.id.unidad4AutoCompleteTextView));
        unidadesAutoCompleteTextView.add(view.findViewById(R.id.unidad5AutoCompleteTextView));
        unidadesAutoCompleteTextView.add(view.findViewById(R.id.unidad6AutoCompleteTextView));
        unidadesAutoCompleteTextView.add(view.findViewById(R.id.unidad7AutoCompleteTextView));
        unidadesAutoCompleteTextView.add(view.findViewById(R.id.unidad8AutoCompleteTextView));
        unidadesAutoCompleteTextView.add(view.findViewById(R.id.unidad9AutoCompleteTextView));
        unidadesAutoCompleteTextView.add(view.findViewById(R.id.unidad10AutoCompleteTextView));

        for(AutoCompleteTextView unidadAutoCompleteTextView : unidadesAutoCompleteTextView) {
            unidadAutoCompleteTextView.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    calcularResultado();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        Button limpiarButton = view.findViewById(R.id.limpiarButton);

        limpiarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0; i < cantidadesTextInputEditText.size(); i++) {
                    cantidadesTextInputEditText.get(i).setText("");
                    unidadesAutoCompleteTextView.get(i).setText("");
                }
            }
        });


        return view;
    }
}