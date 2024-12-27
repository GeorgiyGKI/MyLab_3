package com.example.lab_3;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_3 extends AppCompatActivity {

    EditText editStartPoint, editEndPoint, editDepartureTime, editArriveTime, editPrice, editDistanse;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layer_three_activity);

        initViews();
        setListeners();

        Log.d("Жизненный цикл", "onCreate вызван в Activity_3");
    }

    private void initViews() {
        editStartPoint = findViewById(R.id.editStartPoint);
        editEndPoint = findViewById(R.id.editEndPoint);
        editDepartureTime = findViewById(R.id.editDepartureTime);
        editArriveTime = findViewById(R.id.editArriveTime);
        editPrice = findViewById(R.id.editPrice);
        editDistanse = findViewById(R.id.editDistanse);
        btnOk = findViewById(R.id.btnOk);
        btnOk.setEnabled(false);

        setInputTypes();
    }

    private void setInputTypes() {
        editStartPoint.setInputType(InputType.TYPE_CLASS_TEXT);
        editEndPoint.setInputType(InputType.TYPE_CLASS_TEXT);
        editDepartureTime.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        editArriveTime.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        editPrice.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        editDistanse.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
    }

    private void setListeners() {
        TextWatcher textWatcher = createTextWatcher();
        addTextWatchers(textWatcher);

        btnOk.setOnClickListener(v -> {
            String route = buildRouteString();
            Intent resultIntent = new Intent();
            resultIntent.putExtra("Route", route);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }

    private TextWatcher createTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkFieldsForEmptyValues();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };
    }

    private void addTextWatchers(TextWatcher textWatcher) {
        editStartPoint.addTextChangedListener(textWatcher);
        editEndPoint.addTextChangedListener(textWatcher);
        editDepartureTime.addTextChangedListener(textWatcher);
        editArriveTime.addTextChangedListener(textWatcher);
        editPrice.addTextChangedListener(textWatcher);
        editDistanse.addTextChangedListener(textWatcher);
    }

    private String buildRouteString() {
        return ", Откуда: " + editStartPoint.getText().toString() +
                ", Куда: " + editEndPoint.getText().toString() +
                ", Время отправления: " + editDepartureTime.getText().toString() +
                ", Время прибытия: " + editArriveTime.getText().toString() +
                ", Цена: " + editPrice.getText().toString() + " BYN" +
                ", Расстояние: " + editDistanse.getText().toString() + " km";
    }

    private void checkFieldsForEmptyValues() {
        String startPoint = editStartPoint.getText().toString();
        String endPoint = editEndPoint.getText().toString();
        String departureTime = editDepartureTime.getText().toString();
        String arriveTime = editArriveTime.getText().toString();
        String price = editPrice.getText().toString();
        String distance = editDistanse.getText().toString();

        btnOk.setEnabled(!startPoint.isEmpty() && !endPoint.isEmpty() &&
                !departureTime.isEmpty() && !arriveTime.isEmpty() &&
                !price.isEmpty() && !distance.isEmpty());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Жизненный цикл", "onStart вызван в Activity_3");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Жизненный цикл", "onResume вызван в Activity_3");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Жизненный цикл", "onPause вызван в Activity_3");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Жизненный цикл", "onStop вызван в Activity_3");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Жизненный цикл", "onDestroy вызван в Activity_3");
    }
}
