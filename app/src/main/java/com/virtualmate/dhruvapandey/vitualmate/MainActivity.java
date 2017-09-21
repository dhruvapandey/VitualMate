package com.virtualmate.dhruvapandey.vitualmate;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView replyText;
    EditText inputText;
    Button talkButton;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replyText = (TextView) findViewById(R.id.replyText);
        inputText = (EditText) findViewById(R.id.inputText);
        talkButton = (Button) findViewById(R.id.talkButton);

        talkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userInput;
                String userOutput;
                userInput = inputText.getText().toString();

                int randVal ;
                randVal = (int) ((Math.random() * 10) + 1);

                switch (randVal) {
                    case 1:  userOutput = "I am fine thankyou ..";
                        break;
                    case 2:  userOutput = "Would you Let me read your gmail ..";
                        break;
                    case 3:  userOutput = "Why do you care  ..";
                        break;
                    case 4:  userOutput = "Go fuck yourself ..";
                        break;
                    case 5:  userOutput = " now i can read your whatsapp thanks .. ";
                        break;
                    case 6:  userOutput = "I don't know what to say ..";
                        break;
                    case 7:  userOutput = "Mind your own business ..";
                        break;
                    case 8:  userOutput = " I think you are very lonely in life  ..";
                        break;
                    case 9:  userOutput = "Do you love cats ?";
                        break;
                    case 10:  userOutput = "From your facebook chat i can see you love someone ?";
                        break;
                    default: userOutput = "hmm .. God knows";
                        break;
                }
                replyText.setText(userOutput);
                inputText.setText("");

                tts=new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {

                    @Override
                    public void onInit(int status) {
                        // TODO Auto-generated method stub
                        if(status == TextToSpeech.SUCCESS){
                            int result=tts.setLanguage(Locale.US);
                            if(result==TextToSpeech.LANG_MISSING_DATA ||
                                    result==TextToSpeech.LANG_NOT_SUPPORTED){
                                Log.e("error", "This Language is not supported");
                            }
                            else{
                                ConvertTextToSpeech();
                            }
                        }
                        else
                            Log.e("error", "Initilization Failed!");
                    }
                });

            }
        });
    }

    private void ConvertTextToSpeech() {
        // TODO Auto-generated method stub
        String text = replyText.getText().toString();
        if(text==null||"".equals(text))
        {
            text = "Content not available";
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }else
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

}
