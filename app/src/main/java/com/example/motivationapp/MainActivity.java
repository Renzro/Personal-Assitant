package com.example.motivationapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText taskEditText, scheduleEditText, reminderEditText;
    private Button addTaskButton, addScheduleButton, addReminderButton;
    private ListView toDoListView;
    private ArrayList<String> toDoList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskEditText = findViewById(R.id.taskEditText);
        scheduleEditText = findViewById(R.id.scheduleEditText);
        reminderEditText = findViewById(R.id.reminderEditText);
        addTaskButton = findViewById(R.id.addTaskButton);
        addScheduleButton = findViewById(R.id.addScheduleButton);
        addReminderButton = findViewById(R.id.addReminderButton);
        toDoListView = findViewById(R.id.toDoListView);

        // Initialize the to-do list
        toDoList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, toDoList);
        toDoListView.setAdapter(adapter);

        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = taskEditText.getText().toString().trim();
                if (!task.isEmpty()) {
                    // Add task to the to-do list
                    addTask(task);
                    // Clear the input field
                    taskEditText.getText().clear();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a task", Toast.LENGTH_SHORT).show();
                }
            }
        });

        addScheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String schedule = scheduleEditText.getText().toString().trim();
                if (!schedule.isEmpty()) {
                    // Add schedule
                    addSchedule(schedule);
                    // Clear the input field
                    scheduleEditText.getText().clear();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a schedule", Toast.LENGTH_SHORT).show();
                }
            }
        });

        addReminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reminder = reminderEditText.getText().toString().trim();
                if (!reminder.isEmpty()) {
                    // Add reminder
                    addReminder(reminder);
                    // Clear the input field
                    reminderEditText.getText().clear();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a reminder", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void addTask(String task) {
        // Add task to the ArrayList
        toDoList.add(task);
        // Notify the adapter that the dataset has changed
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Task added: " + task, Toast.LENGTH_SHORT).show();
    }

    private void addSchedule(String schedule) {
        // Add schedule logic here
        Toast.makeText(this, "Schedule added: " + schedule, Toast.LENGTH_SHORT).show();
    }

    private void addReminder(String reminder) {
        // Add reminder logic here
        Toast.makeText(this, "Reminder added: " + reminder, Toast.LENGTH_SHORT).show();
    }
}

