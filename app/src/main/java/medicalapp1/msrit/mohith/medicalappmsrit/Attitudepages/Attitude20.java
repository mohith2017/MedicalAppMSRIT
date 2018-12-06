package medicalapp1.msrit.mohith.medicalappmsrit.Attitudepages;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import medicalapp1.msrit.mohith.medicalappmsrit.MainActivity;
import medicalapp1.msrit.mohith.medicalappmsrit.R;

public class Attitude20 extends AppCompatActivity {
    private static final String data20 = "20";
    private Button back,next;

    private AlertDialog.Builder builder;

    private RadioGroup r;

    SharedPreferences.Editor editor;
    SharedPreferences pref;

    int id1,count,score1;
    String checked1;

    FirebaseFirestore db;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attitude20);

        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();

        back=(Button)findViewById(R.id.button3r);
        next=(Button)findViewById(R.id.button5r);
        r=(RadioGroup)findViewById(R.id.groupattituder);
        db = FirebaseFirestore.getInstance();

        back.setVisibility(View.INVISIBLE);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id1= r.getCheckedRadioButtonId();

                switch(id1)
                {
                    case R.id.radioButtonr: checked1="a";break;
                    case R.id.radioButton2r: checked1="b";break;
                    case R.id.radioButton3r: checked1="c";break;
                    case R.id.radioButton4r: checked1="d";break;
                    case R.id.radioButton5r: checked1="e";break;
                    default:checked1="nothing";break;

                }

//                Intent i=new Intent(Attitude4.this,Attitude4.class);
//                startActivity(i);
                Toast.makeText(Attitude20.this, checked1,
                        Toast.LENGTH_SHORT).show();

                UpdateData(checked1);
                score1=pref.getInt("score1",-1);

                if(checked1=="a")
                {

                    score1++;
                    editor.putInt("score1",score1);
                    editor.commit();
                }

                UpdateScore(score1);

                showalert("Are you sure you want to submit responses?","yes","no");



            }
        });
    }

    private void UpdateScore(int score1) {

        count= pref.getInt("count",-1);
        count--;
        String x=pref.getString("name","Default");
        String dbname=x;


        DocumentReference contact = db.collection("PhoneBook").document(dbname).collection("Score").document("Section-wise");
        contact.update("Attitude score", score1)

                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Attitude20.this, "Updated Successfully",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void UpdateData(String a) {

        count= pref.getInt("count",-1);
        count--;
        String x=pref.getString("name","Default");
        String dbname=x;


        DocumentReference contact = db.collection("PhoneBook").document(dbname).collection("Answers").document("Attitude");
        contact.update(data20, a)

                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Attitude20.this, "Updated Successfully",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void showalert(String s, String yes, String no) {

        builder = new AlertDialog.Builder(Attitude20.this);

        builder.setTitle("Confirm")
                .setMessage(s)
                .setPositiveButton(yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        editor.putInt("show",1);
                        editor.commit();
                        Intent i=new Intent(Attitude20.this,MainActivity.class);
                        startActivity(i);
                    }
                });
        builder.setNegativeButton(no, new DialogInterface.OnClickListener() {
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
