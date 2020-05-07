package com.example.task73;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    Context context = null;
    EditText FN,text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        System.out.println("File we are  in "+context.getFilesDir());
    }

    public void readFile(View v){
        String fileName="";
        FN = findViewById(R.id.editText2);
        fileName = FN.getText().toString();
        String input = "";
        System.out.println(fileName);
        try {
            InputStream ins = context.openFileInput(fileName); // tälle arvo

            BufferedReader br = new BufferedReader(new InputStreamReader(ins));
            String s = "";

            while((s=br.readLine())!= null){
                System.out.println(s);
                input = input.concat(s);
            }
            ins.close();

        }catch (IOException e) {
            Log.e("IOException","Wrong input");
        } finally {
            System.out.println("Read successful");
        }

        text =findViewById(R.id.textEditor);
        text.setText(input);
    }

    public void writeFile(View v){
        String fileName = "";
        FN = findViewById(R.id.editText2); // Assign filename
        fileName = FN.getText().toString();
        System.out.println(fileName);

        text = findViewById(R.id.textEditor);
        try {
            OutputStreamWriter ows = new OutputStreamWriter(context.openFileOutput(fileName,Context.MODE_PRIVATE)); //tähän nimi

            String s = "";
            s = text.getText().toString();
            ows.write(s);
            ows.close();
            System.out.println(s);
        }
        catch (IOException e) {
            Log.e("IOException","Wrong input");
        } finally {
            System.out.println("Write successful");
        }

    }
}
