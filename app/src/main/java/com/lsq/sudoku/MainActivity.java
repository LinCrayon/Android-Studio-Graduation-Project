package com.lsq.sudoku;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startGame;
    private Button about;
    private Button help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        startGame = (Button) findViewById(R.id.start_game);
        about = (Button) findViewById(R.id.about);
        help = (Button)  findViewById(R.id.help);

        startGame.setOnClickListener(this);
        about.setOnClickListener(this);
        help.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_game:
                Intent intent =new Intent(MainActivity.this,GameActivity.class);
                startActivity(intent);
                break;
            case R.id.about:
                final View view1 = LayoutInflater.from(this).inflate(R.layout.main_alert,null);
                final AlertDialog dialog = new AlertDialog.Builder(this)
                        .setView(view1)
                        .show();
                Button button =view1.findViewById(R.id.alert_close);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                break;
            case R.id.help:
                final View view2 = LayoutInflater.from(this).inflate(R.layout.help,null);
                final AlertDialog dialog1 = new AlertDialog.Builder(this)
                        .setView(view2)
                        .show();
                Button button10 =view2.findViewById(R.id.alert_close);
                button10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog1.dismiss();
                    }
                });

                break;
        }
    }
}
