package com.example.datastucturescroll;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private QueueLinkedList queue;

    private EditText nameEditText;
    private EditText ageEditText;
    private EditText gpaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue = new QueueLinkedList();

        // Populating QueueLinkedList
        queue.enqueue(new Student("John", 13, 4.0));
        queue.enqueue(new Student("Alice", 16, 4.2));
        queue.enqueue(new Student("Ben", 14, 3.5));

        nameEditText = findViewById(R.id.nameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        gpaEditText = findViewById(R.id.gpaEditText);

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudent();
            }
        });

        Button removeButton = findViewById(R.id.removeButton);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeStudent();
            }
        });
    }

    private void addStudent() {
        String name = nameEditText.getText().toString();
        String ageStr = ageEditText.getText().toString();
        String gpaStr = gpaEditText.getText().toString();

        if (name.isEmpty() || ageStr.isEmpty() || gpaStr.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        int age = Integer.parseInt(ageStr);
        double gpa = Double.parseDouble(gpaStr);

        Student student = new Student(name, age, gpa);
        queue.enqueue(student);

        Toast.makeText(MainActivity.this, "Student added successfully", Toast.LENGTH_SHORT).show();

        // Clear EditText fields after adding student
        nameEditText.setText("");
        ageEditText.setText("");
        gpaEditText.setText("");
    }

    private void removeStudent() {
        if (!queue.isEmpty()) {
            Student removedStudent = queue.dequeue();
            Toast.makeText(MainActivity.this, "Removed student: " + removedStudent.getName(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "No students to remove", Toast.LENGTH_SHORT).show();
        }
    }
}
