package medicalapp1.msrit.mohith.medicalappmsrit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import medicalapp1.msrit.mohith.medicalappmsrit.Attitudepages.Attitude2;

public class Prequestionaire extends AppCompatActivity {

    EditText date,age,reg,address;
    Button proceed;

    RadioGroup r;

    int id1,count;
    String date1,age1, reg1,address1,gender,discipline1;

    SharedPreferences.Editor editor;
    SharedPreferences pref;

    Spinner discipline;
    ArrayAdapter<CharSequence> adapter;

    FirebaseFirestore db;
    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prequestionaire);

        proceed=(Button)findViewById(R.id.button9);
        r=(RadioGroup)findViewById(R.id.grouppre);
        date=(EditText)findViewById(R.id.editText4);
        age=(EditText)findViewById(R.id.editText5);
        reg=(EditText)findViewById(R.id.editText11);
        address=(EditText)findViewById(R.id.editText7);
        discipline=(Spinner)findViewById(R.id.spinner);

        adapter= ArrayAdapter.createFromResource(Prequestionaire.this,R.array.discipline,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        discipline.setAdapter(adapter);

        discipline.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                  discipline1=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();

        db = FirebaseFirestore.getInstance();



        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date1=date.getText().toString();
                age1=age.getText().toString();
                reg1=reg.getText().toString();
                address1=address.getText().toString();

                int id1=r.getCheckedRadioButtonId();

                switch (id1)
                {
                    case R.id.radioButton6:gender="Male";break;
                    case R.id.radioButton7:gender="Female";break;
                }

                UpdateData(date1,age1,reg1,address1,gender,discipline1);

                Intent i=new Intent(Prequestionaire.this,Prequestionaire2.class);
                startActivity(i);
            }
        });




    }
    private void UpdateData(String date1, String age1, String reg1, String address1, String a, String discipline1) {

        count= pref.getInt("count",-1);
        count--;
        String x=pref.getString("name","Default");
        String dbname=x;


        DocumentReference contact = db.collection("PhoneBook").document(dbname).collection("Personal").document("Attitude");
        contact.update("Date",date1);
        contact.update("Gender",a);
                contact.update("Age",age1);
                contact.update ("Reg number",reg1);
                contact.update    ("Address",address1);
        contact.update ("Discipline",discipline1)

                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Prequestionaire.this, "Updated Successfully",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
