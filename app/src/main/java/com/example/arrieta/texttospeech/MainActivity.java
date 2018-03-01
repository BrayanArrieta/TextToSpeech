package com.example.arrieta.texttospeech;

import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity{
    TextToSpeech textToSpeech;
    Button button;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.buttonSpeech);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech();
            }
        });
        editText=(EditText)findViewById(R.id.editText);
        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                textToSpeech.setLanguage(Locale.US);
            }
        });
    }

    public void textToSpeech(){
        // Get the texto to translate
        String toSpeak = editText.getText().toString();
        // Show the text to translate
        Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
        //Check if the version is higiest then Lollipop
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            //Translate text
            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null, null);
        } else {
            //Translate text
            textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
        }
    }
}
