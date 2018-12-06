package medicalapp1.msrit.mohith.medicalappmsrit.Knowledge1pages;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import medicalapp1.msrit.mohith.medicalappmsrit.R;

public class Knowledgeka4 extends AppCompatActivity {
    Button next;
    CheckBox a,b,c,d;

    String a1,b1,c1,d1;

    SharedPreferences.Editor editor;
    SharedPreferences pref;


    int id1, count,score2;
    String checked1;

    FirebaseFirestore db;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledgeka4);


        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();


        a=(CheckBox)findViewById(R.id.checkBoxka4);
        b=(CheckBox)findViewById(R.id.checkBox1ka4);
        c=(CheckBox)findViewById(R.id.checkBox2ka4);
        d=(CheckBox)findViewById(R.id.checkBox3ka4);
        next=(Button)findViewById(R.id.buttonka4);
        db = FirebaseFirestore.getInstance();

        a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    a1="true";
                else
                    a1="false";
            }
        });

        b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    b1="true";
                else
                    b1="false";
            }
        });

        c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    c1="true";
                else
                    c1="false";
            }
        });

        d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    d1="true";
                else
                    d1="false";
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateData(a1,b1,c1,d1);

                if(a1=="true")
                {
                    score2=pref.getInt("score2",-1);
                    score2++;
                    editor.putInt("score2",score2);
                    editor.commit();
                }

                Intent i = new Intent(Knowledgeka4.this, Knowledgeka5.class);
                startActivity(i);
            }
        });
    }
    private void UpdateData(String a1, String b1, String c1, String d1) {

        count = pref.getInt("count", -1);
        count--;
        String x=pref.getString("name","Default");
        String dbname=x;

        Map<String, Object> newOptions = new HashMap<>();
        newOptions.put("a",a1);
        newOptions.put("b",b1);
        newOptions.put("c",c1);
        newOptions.put("d",d1);

        DocumentReference contact = db.collection("PhoneBook").document(dbname).collection("Answers").document("Knowledge");
        contact.update("4",newOptions)

                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Knowledgeka4.this, "Updated Successfully",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),"Invalid action! \n You can't go back",Toast.LENGTH_SHORT).show();
    }
}
