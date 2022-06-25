package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
     TextView text;
    Button btnstart;
    ProgressBar progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.txt);
        btnstart = (Button) findViewById(R.id.btn_start);
        progress = (ProgressBar) findViewById(R.id.progressbar);
    }


    public void onClick(View view) {

        OurTask ourTask = new OurTask();
        ourTask.execute();
    }
    class OurTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            text.setText("Даша и Алина пошли в магазин");
            progress.setVisibility(View.VISIBLE);
            btnstart.setVisibility(View.INVISIBLE);
        }
        @Override
        protected Void doInBackground(Void... voids) {
            try{
                TimeUnit.SECONDS.sleep(5);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            text.setText("Даша и Алина дошли до магазина");
            progress.setVisibility(View.INVISIBLE);
            btnstart.setVisibility(View.VISIBLE);
        }
    }
}