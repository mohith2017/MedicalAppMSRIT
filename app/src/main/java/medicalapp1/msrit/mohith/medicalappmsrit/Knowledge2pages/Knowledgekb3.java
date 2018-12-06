package medicalapp1.msrit.mohith.medicalappmsrit.Knowledge2pages;

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

public class Knowledgekb3 extends AppCompatActivity {
    private static final String data3 = "3";
    private Button back,next;

    private RadioGroup r;

    SharedPreferences.Editor editor;
    SharedPreferences pref;

    int id1,count,score3;
    String checked1;

    FirebaseFirestore db;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledgekb3);

        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();

        back=(Button)findViewById(R.id.button3kb3);
        next=(Button)findViewById(R.id.button5kb3);
        r=(RadioGroup)findViewById(R.id.groupattitudekb3);
        db = FirebaseFirestore.getInstance();

        back.setVisibility(View.INVISIBLE);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id1= r.getCheckedRadioButtonId();

                switch(id1)
                {
                    case R.id.radioButtonkb3: checked1="a";break;
                    case R.id.radioButton2kb3: checked1="b";break;
                    case R.id.radioButton3kb3: checked1="c";break;
                    case R.id.radioButton4kb3: checked1="d";break;
                    case R.id.radioButton5kb3: checked1="e";break;
                    default:checked1="nothing";break;

                }

//                Intent i=new Intent(Attitude4.this,Attitude4.class);
//                startActivity(i);
                Toast.makeText(Knowledgekb3.this, checked1,
                        Toast.LENGTH_SHORT).show();

                UpdateData(checked1);

                if(checked1=="a")
                {
                    score3=pref.getInt("score3",-1);
                    score3++;
                    editor.putInt("score3",score3);
                    editor.commit();
                }

                Intent i=new Intent(Knowledgekb3.this,Knowledgekb4.class);
                startActivity(i);

            }
        });
    }

    private void UpdateData(String a) {

        count= pref.getInt("count",-1);
        count--;
        String x=pref.getString("name","Default");
        String dbname=x;


        DocumentReference contact = db.collection("PhoneBook").document(dbname).collection("Answers").document("Knowledge2");
        contact.update(data3, a)

                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Knowledgekb3.this, "Updated Successfully",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),"Invalid action! \n You can't go back",Toast.LENGTH_SHORT).show();
    }
}
