package com.example.notetaker2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Activity_OpenNote extends AppCompatActivity {
    private DatabaseHelper db;
    private NotesAdapter mAdapter;
    private List<Note> notesList = new ArrayList<>();
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__open_note);
        db = new DatabaseHelper(this);

        Intent intent = getIntent();
        message = intent.getStringExtra("noteText");
        TextView textView = findViewById(R.id.Note);
        textView.setText(message);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opennoteactivity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_encrypt:
                getPassword();
                Toast.makeText(getApplicationContext(), "Encryption Selected!", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    void getPassword() {
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getApplicationContext());
        View view = layoutInflaterAndroid.inflate(R.layout.password_dialogue, null);

        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(Activity_OpenNote.this);
        alertDialogBuilderUserInput.setView(view);

    }
}
