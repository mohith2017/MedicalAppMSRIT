package medicalapp1.msrit.mohith.medicalappmsrit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import medicalapp1.msrit.mohith.medicalappmsrit.Attitudepages.Attitude2;

public class Prequestionaire2 extends AppCompatActivity {
    Button submit;
    EditText i,vno,sno;

    Switch rural,village;

    String rural1,village1,id2,vno2,sno1;
    int id1,count;

    SharedPreferences.Editor editor;
    SharedPreferences pref;

    FirebaseFirestore db;
    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prequestionaire2);

        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();

        submit=(Button)findViewById(R.id.button10);
        rural=(Switch)findViewById(R.id.switch1);
        village=(Switch)findViewById(R.id.switch2);
        i=(EditText)findViewById(R.id.editText8);
        vno=(EditText)findViewById(R.id.editText9);
        sno=(EditText)findViewById(R.id.editText10);
        db = FirebaseFirestore.getInstance();

        rural.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    rural.setText("Yes");
                    rural1 = "Yes";
                }
                else {
                    rural.setText("No");
                    rural1 = "No";
                }
            }
        });

        village.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    village.setText("Yes");
                    village1 = "Yes";
                }
                else {
                    village.setText("No");
                    village1 = "No";
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id2=i.getText().toString();
                vno2=vno.getText().toString();
                sno1=sno.getText().toString();

                UpdateData(rural1,village1);
                UpdateData1(id2,vno2,sno1);


                Intent i=new Intent(Prequestionaire2.this,MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void UpdateData1(String i, String v2, String sno1) {
        count = pref.getInt("count", -1);
        count--;
        String x=pref.getString("name","Default");
        String dbname=x;

        DocumentReference contact = db.collection("PhoneBook").document(dbname).collection("Personal").document("Knowledge");
        contact.update("id_no", i);
        contact.update("Village no",v2);
        contact.update("Serial_no",sno1)

                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Prequestionaire2.this, "Data Successfully",
                                Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void UpdateData(String rural1, String village1) {

        count = pref.getInt("count", -1);
        count--;
        String x=pref.getString("name","Default");
        String dbname=x;


        DocumentReference contact = db.collection("PhoneBook").document(dbname).collection("Personal").document("Attitude");
        contact.update("Visited rural areas", rural1);
                contact.update("Lived in village",village1)

                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Prequestionaire2.this, "Updated Successfully",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
