package com.example.shan.androiddialogs;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showAlertDialog(View view){
        AlertDialog.Builder builder =
                new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Button Clicked")
                .setTitle("Button Event")
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Toast.makeText(MainActivity.this,
                                        "Tang na ker",
                                        Toast.LENGTH_LONG).show();
                            }
                        });

        builder.create().show();
    }

    public void showListDialog(View view) {

        final ArrayList selectedItems = new ArrayList();

        AlertDialog.Builder builder
                = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Choose Color")
                .setMultiChoiceItems(R.array.colors,
                        null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if (isChecked == true){
                                    selectedItems.add(which);
                                } else if
                                        (selectedItems.contains(which)) {
                                    selectedItems.remove(Integer.valueOf(which));
                                }

                            }
                        })
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.create().show();
    }

    public void showNewTaskDialog(View view) {

        LayoutInflater inflater = getLayoutInflater();

        AlertDialog.Builder builder =
                new AlertDialog.Builder(MainActivity.this);

        builder.setView(inflater.inflate(R.layout.new_task,null));
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.create().show();
    }
}
