package com.example.laboratorinis2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        adapter.add(readTextFromFile("elements.txt", 0));
        adapter.add(readTextFromFile("elements.txt", 1));

        Button button = findViewById(R.id.button);
        button.setText(readTextFromFile("elements.txt", 2));

        final String[] selectedSpinnerItem = {""};

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                selectedSpinnerItem[0] = parentView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        button.setOnClickListener(v -> {
            TextView textView = findViewById(R.id.textView);
            EditText editText = findViewById(R.id.editTextText);
            String text = editText.getText().toString();

            Calculations calc = new Calculations();
            if (text.isEmpty()) {
                Toast.makeText(MainActivity.this, "Text is empty", Toast.LENGTH_SHORT).show();
            } else {
                int count;
                if (selectedSpinnerItem[0].equals("Tekstas")) {
                    count = calc.CountWords(text);
                } else {
                    count = calc.CountSymbols(text);
                }
                textView.setText(String.valueOf(count));
            }
        });
    }

    private String readTextFromFile(String filename, int lineNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream inputStream = getAssets().open(filename);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            int currentLine = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (currentLine == lineNumber) {
                    stringBuilder.append(line);
                    break;
                }
                currentLine++;
            }

            bufferedReader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


}