package com.example.HabitsBuildingApp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.HabitsBuildingApp.R;
import com.example.HabitsBuildingApp.managers.HabitManager;
import com.example.HabitsBuildingApp.models.Habit;

public class CreateHabitFormActivity extends AppCompatActivity {

    private EditText edtTextHabitName;
    private EditText edtTextReason;
    private EditText edtTextStartDate;
    private Button btnCreateHabit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_habit_form);

        edtTextHabitName = (EditText) findViewById(R.id.edtTextHabitName);
        edtTextReason = (EditText) findViewById(R.id.edtTextReason);
        edtTextStartDate = (EditText) findViewById(R.id.edtTextStartDate);
        btnCreateHabit = (Button) findViewById(R.id.btnCreateHabit);

        // Title for action bar and back button
        getSupportActionBar().setTitle("Create Habit");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnCreateHabit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HabitManager habitManager = new HabitManager(CreateHabitFormActivity.this);
                Habit habit = new Habit(edtTextHabitName.getText().toString().trim(),
                        edtTextHabitName.getText().toString().trim(),
                        edtTextReason.getText().toString().trim(),
                        edtTextStartDate.getText().toString().trim());

                habitManager.addHabit(habit);
                Intent intent = new Intent(CreateHabitFormActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}