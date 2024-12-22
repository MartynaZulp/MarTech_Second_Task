package com.example.martechsecondtask;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.martechsecondtask.added.TextCounter;

public class MainActivity extends AppCompatActivity {

    private EditText edUserInput;
    private TextView tvResult;
    private Spinner spCountingOpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        spCountingOpt = findViewById(R.id.spCountingOpt);
        edUserInput = findViewById(R.id.edUserInput);
        tvResult = findViewById(R.id.tvResult);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.Options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCountingOpt.setAdapter(adapter);
    }

    public void btnCalculate(View view) {
        String notImplemented = getResources().getString(R.string.message_not_implemented);
        if(spCountingOpt.getSelectedItem().toString().equals("Chars")) {
                String userInputPhrase = edUserInput.getText().toString();
                int result = TextCounter.getCharsCount(userInputPhrase);
                tvResult.setText(String.valueOf(result));
        }
        else{
            tvResult.setText(R.string. message_not_implemented);
        }
    }
}