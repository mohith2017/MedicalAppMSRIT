package medicalapp1.msrit.mohith.medicalappmsrit.Knowledge1pages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import medicalapp1.msrit.mohith.medicalappmsrit.R;

public class Instructionsknowledge extends AppCompatActivity {

    Button proceed;
    CheckBox gonethrough;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructionsknowledge);

        proceed=(Button)findViewById(R.id.buttonx);
        gonethrough=(CheckBox)findViewById(R.id.checkBoxx);

        proceed.setVisibility(View.INVISIBLE);

        gonethrough.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true)
                {
                    proceed.setVisibility(View.VISIBLE);

                    proceed.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i=new Intent(Instructionsknowledge.this,Knowledgeka1.class);
                            startActivity(i);
                        }
                    });
                }

                else{
                    proceed.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
