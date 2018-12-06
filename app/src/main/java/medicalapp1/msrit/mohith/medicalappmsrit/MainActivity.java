package medicalapp1.msrit.mohith.medicalappmsrit;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import medicalapp1.msrit.mohith.medicalappmsrit.Attitudepages.Attitude20;
import medicalapp1.msrit.mohith.medicalappmsrit.Attitudepages.Instructionsattitude;

public class MainActivity extends AppCompatActivity {
    Button pretest1,pretest2;

    SharedPreferences.Editor editor;
    SharedPreferences pref;

    private AlertDialog.Builder builder;

    TextView t;

    int show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pretest1=(Button)findViewById(R.id.button);
        pretest2=(Button)findViewById(R.id.button2);
        t=(TextView)findViewById(R.id.textView16);

        t.setVisibility(View.INVISIBLE);

        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();

        show=pref.getInt("show",-1);

        if(show==1)
        {
        pretest2.setVisibility(View.VISIBLE);
        t.setVisibility(View.VISIBLE);
        editor.putInt("show",0);
        editor.commit();

        pretest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             showalert("You are not allowed to take this for the second time!");
            }
        });
            }
            else
        {
            pretest2.setVisibility(View.INVISIBLE);
        }

        pretest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Instructionsattitude.class);
                startActivity(i);
            }
        });

        pretest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(MainActivity.this,SelectMCQ.class);
                startActivity(i1);
            }
        });
    }

    private void showalert(String s) {

        builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Invalid!").setIcon(R.mipmap.warning)
                .setMessage(s)
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),"Invalid action! \n You can't go back",Toast.LENGTH_SHORT).show();
    }
}
