package medicalapp1.msrit.mohith.medicalappmsrit.Attitudepages;

import android.content.Intent;
import android.content.SharedPreferences;
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

import medicalapp1.msrit.mohith.medicalappmsrit.R;

public class Attitude13 extends AppCompatActivity {
    private static final String data13 = "13";
    private Button back,next;

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
        setContentView(R.layout.activity_attitude13);

        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();

        back=(Button)findViewById(R.id.button3k);
        next=(Button)findViewById(R.id.button5k);
        r=(RadioGroup)findViewById(R.id.groupattitudek);
        db = FirebaseFirestore.getInstance();

        back.setVisibility(View.INVISIBLE);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id1= r.getCheckedRadioButtonId();

                switch(id1)
                {
                    case R.id.radioButtonk: checked1="a";break;
                    case R.id.radioButton2k: checked1="b";break;
                    case R.id.radioButton3k: checked1="c";break;
                    case R.id.radioButton4k: checked1="d";break;
                    case R.id.radioButton5k: checked1="e";break;
                    default:checked1="nothing";break;

                }

//                Intent i=new Intent(Attitude4.this,Attitude4.class);
//                startActivity(i);
                Toast.makeText(Attitude13.this, checked1,
                        Toast.LENGTH_SHORT).show();

                UpdateData(checked1);

                if(checked1=="a")
                {
                    score1=pref.getInt("score1",-1);
                    score1++;
                    editor.putInt("score1",score1);
                    editor.commit();
                }

                Intent i=new Intent(Attitude13.this,Attitude14.class);
                startActivity(i);

            }
        });
    }
    private void UpdateData(String a) {

        count= pref.getInt("count",-1);
        count--;
        String x=pref.getString("name","Default");
        String dbname=x;


        DocumentReference contact = db.collection("PhoneBook").document(dbname).collection("Answers").document("Attitude");
        contact.update(data13, a)

                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Attitude13.this, "Updated Successfully",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),"Invalid action! \n You can't go back",Toast.LENGTH_SHORT).show();
    }
}
