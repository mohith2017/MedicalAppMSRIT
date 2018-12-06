package medicalapp1.msrit.mohith.medicalappmsrit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import medicalapp1.msrit.mohith.medicalappmsrit.Knowledge1pages.Instructionsknowledge;
import medicalapp1.msrit.mohith.medicalappmsrit.Knowledge2pages.Instuctionsknowledge1;

public class SelectMCQ extends AppCompatActivity {

    Button mcq1,mcq2;

    int show1;

    SharedPreferences.Editor editor;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mcq);

        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();

        mcq1=(Button)findViewById(R.id.button6);
        mcq2=(Button)findViewById(R.id.button7);

        show1=pref.getInt("show1",-1);

        if(show1==1)
        {
           mcq2.setVisibility(View.VISIBLE);
            mcq1.setVisibility(View.INVISIBLE);
            editor.putInt("show1",0);
            editor.commit();
        }
        else
        {
            mcq2.setVisibility(View.INVISIBLE);
        }

        mcq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SelectMCQ.this,Instructionsknowledge.class);
                startActivity(i);
            }
        });

        mcq2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(SelectMCQ.this,Instuctionsknowledge1.class);
                startActivity(i1);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),"Invalid action! \n You can't go back",Toast.LENGTH_SHORT).show();
    }
}
