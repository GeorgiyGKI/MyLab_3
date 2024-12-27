package com.example.lab_3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_2 extends AppCompatActivity {

    TextView textUserInfo, textRoute;
    Button btnSetPath, btnCallTaxi;
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layer_two_activity);

        initViews();
        handleIntent();
        setListeners();

        Log.d("Жизненный цикл", "onCreate вызван в Activity_2");
    }

    private void initViews() {
        textUserInfo = findViewById(R.id.textUserInfo);
        textRoute = findViewById(R.id.textRoute);
        btnSetPath = findViewById(R.id.btnSetPath);
        btnCallTaxi = findViewById(R.id.btnCallTaxi);
    }

    private void handleIntent() {
        Intent intent = getIntent();
        String phone = intent.getStringExtra("Phone");
        String firstName = intent.getStringExtra("FirstName");
        String lastName = intent.getStringExtra("LastName");

        textUserInfo.setText(firstName + " " + lastName + "\nТелефон: " + phone);
    }

    private void setListeners() {
        btnSetPath.setOnClickListener(v -> {
            Intent pathIntent = new Intent(Activity_2.this, Activity_3.class);
            startActivityForResult(pathIntent, REQUEST_CODE);
        });

        btnCallTaxi.setOnClickListener(v -> {
            Toast.makeText(Activity_2.this, "Такси успешно заказано, За вами приедет таксист Сергей", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            handleRouteResult(data);
        }
    }

    private void handleRouteResult(Intent data) {
        String route = data.getStringExtra("Route");
        String[] routeParts = route.split(", ");
        StringBuilder formattedRoute = new StringBuilder();
        for (String part : routeParts) {
            formattedRoute.append(part).append("\n");
        }
        TextView textRouteInfo = findViewById(R.id.textRoute);
        btnCallTaxi.setEnabled(true);
        textRouteInfo.setText(formattedRoute.toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Жизненный цикл", "onStart вызван в Activity_2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Жизненный цикл", "onResume вызван в Activity_2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Жизненный цикл", "onPause вызван в Activity_2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Жизненный цикл", "onStop вызван в Activity_2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Жизненный цикл", "onDestroy вызван в Activity_2");
    }
}
