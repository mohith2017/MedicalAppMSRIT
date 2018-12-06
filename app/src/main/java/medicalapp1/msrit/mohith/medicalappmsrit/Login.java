package medicalapp1.msrit.mohith.medicalappmsrit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import medicalapp1.msrit.mohith.medicalappmsrit.Knowledge1pages.Knowledgeka7;
import medicalapp1.msrit.mohith.medicalappmsrit.util.InternetConnection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import medicalapp1.msrit.mohith.medicalappmsrit.Attitudepages.Attitude1;

public class Login extends AppCompatActivity {
    Button login;

    private AlertDialog.Builder builder;

    private static final String NAME_KEY = "Name";
    private static final String EMAIL_KEY = "Email";
    private static final String PHONE_KEY = "Phone";

    String x;
    private static final String data = "1";
    private static final String data2 = "2";
    private static final String data3 = "3";
    private static final String data4 = "4";
    private static final String data5 = "5";
    private static final String data6 = "6";
    private static final String data7 = "7";
    private static final String data8 = "8";
    private static final String data9 = "9";
    private static final String data10 = "10";
    private static final String data11 = "11";
    private static final String data12 = "12";
    private static final String data13 = "13";
    private static final String data14 = "14";
    private static final String data15 = "15";
    private static final String data16 = "16";
    private static final String data17 = "17";
    private static final String data18 = "18";
    private static final String data19 = "19";
    private static final String data20 = "20";


    EditText name,email,phone;
     int x1=0;

    String name1,email1,phone1;
    private int i,count=0;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseFirestore db;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
       editor = pref.edit();



        login = (Button) findViewById(R.id.button8);
        display = (TextView) findViewById(R.id.textView6);
        name=(EditText)findViewById(R.id.editText);
        email=(EditText)findViewById(R.id.editText2);
        phone=(EditText)findViewById(R.id.editText3);
        db = FirebaseFirestore.getInstance();






        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(InternetConnection.checkConnection(getApplicationContext())) {
                    name1 = name.getText().toString();
                    email1 = email.getText().toString();
                    phone1 = phone.getText().toString();

                    editor.putString("name", email1);
                    editor.commit();


                    if (alreadyPresent(email1) == 1) {
                        Toast.makeText(Login.this, "You can take the test only once!", Toast.LENGTH_LONG);
                        x1 = 0;
                    } else {
                        addNewContact(name1, email1, phone1);
                        addNewAnswer();
                        addDetailsAttitude();
                        addDetailsKnowledge();
                        addNewAnswerKnowledge1();
                        addNewKnowledge2();
                        addScore();

                        Intent i = new Intent(Login.this, Prequestionaire.class);
                        startActivity(i);
                    }
                }

                else{
                    showalert("Do you want to switch on Wifi?");
                }

            }
        });


    }

    private void addDetailsKnowledge() {

        Map<String, Object> newDetails = new HashMap<>();

        count=pref.getInt("count",-1);
        count--;
        x=pref.getString("name","Default");
        String dbname=x;

        newDetails.put("id_no", "id");
        newDetails.put("Village no", "no");
        newDetails.put("Serial_no", "1");

        db.collection("PhoneBook").document(dbname).collection("Personal").document("Knowledge").set(newDetails)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Login.this, "Details1 added",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this, "ERROR" + e.toString(),
                                Toast.LENGTH_SHORT).show();
                        Log.d("TAG", e.toString());
                    }
                });

    }


    private void addDetailsAttitude() {
        Map<String, Object> newDetails = new HashMap<>();

        count=pref.getInt("count",-1);
        count--;
        x=pref.getString("name","Default");
        String dbname=x;

        newDetails.put("Date", "Date");
        newDetails.put("Gender", "Male");
        newDetails.put("Age","20");
        newDetails.put("Reg number","1MS16IS145");
        newDetails.put("Discipline","Medical");
        newDetails.put("Address","MSR Nagar");
        newDetails.put("Visited rural areas","Yes");
        newDetails.put("Lived in village","20");

        db.collection("PhoneBook").document(dbname).collection("Personal").document("Attitude").set(newDetails)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Login.this, "Details added",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this, "ERROR" + e.toString(),
                                Toast.LENGTH_SHORT).show();
                        Log.d("TAG", e.toString());
                    }
                });

    }

    private int alreadyPresent(String e) {

        CollectionReference emailref = db.collection("PhoneBook");
        Query query = emailref.whereEqualTo(EMAIL_KEY, e);


        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
              if(task.isSuccessful())
                  x1=1;
              else
                  x1=0;
            }
        });
        return x1;

    }

    private void addNewAnswerKnowledge1() {
        Map<String, Object> newKnowledge = new HashMap<>();

        count= pref.getInt("count",-1);
        count--;
        x=pref.getString("name","Default");
        String dbname=x;

        Map<String, Object> newOptions = new HashMap<>();
        newOptions.put("a","true");
        newOptions.put("b","true");
        newOptions.put("c","true");
        newOptions.put("d","true");

        newKnowledge.put(data, newOptions);
        newKnowledge.put(data2,newOptions);
        newKnowledge.put(data3, newOptions);
        newKnowledge.put(data4, newOptions);
        newKnowledge.put(data5, newOptions);
        newKnowledge.put(data6, newOptions);
        newKnowledge.put(data7, newOptions);




        db.collection("PhoneBook").document(dbname).collection("Answers").document("Knowledge").set(newKnowledge)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Login.this, "Knowledge1 added",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this, "ERROR" + e.toString(),
                                Toast.LENGTH_SHORT).show();
                        Log.d("TAG", e.toString());
                    }
                });
    }


    private void addNewKnowledge2() {
        Map<String, Object> newAttitude = new HashMap<>();

//        count=pref.getInt("count",-1);
//
//        String dbname="Contact"+count;
//        count++;
//        editor.putInt("count",count);
//        editor.commit();

        count= pref.getInt("count",-1);
        count--;
        x=pref.getString("name","Default");
        String dbname=x;

        newAttitude.put(data, "c");
        newAttitude.put(data2, "c");
        newAttitude.put(data3, "c");
        newAttitude.put(data4, "c");
        newAttitude.put(data5, "c");
        newAttitude.put(data6, "c");
        newAttitude.put(data7, "c");
        newAttitude.put(data8, "c");
        newAttitude.put(data9, "c");
        newAttitude.put(data10, "c");
        newAttitude.put(data11, "c");
        newAttitude.put(data12, "c");
        newAttitude.put(data13, "c");
        newAttitude.put(data14, "c");
        newAttitude.put(data15, "c");
        newAttitude.put(data16, "c");
        newAttitude.put(data17, "c");
        newAttitude.put(data18, "c");






        db.collection("PhoneBook").document(dbname).collection("Answers").document("Knowledge2").set(newAttitude)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Login.this, "Knowledge2 added",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this, "ERROR" + e.toString(),
                                Toast.LENGTH_SHORT).show();
                        Log.d("TAG", e.toString());
                    }
                });
    }

    private void addScore() {
        Map<String, Object> newScore = new HashMap<>();

        count=pref.getInt("count",-1);

        x=pref.getString("name","Default");
        String dbname=x;

        newScore.put("Attitude score", "20");
        newScore.put("Knowledge1 score", "7");
        newScore.put("Knowledge2 score", "18");

        db.collection("PhoneBook").document(dbname).collection("Score").document("Section-wise").set(newScore)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Login.this, "Score tallied",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this, "ERROR" + e.toString(),
                                Toast.LENGTH_SHORT).show();
                        Log.d("TAG", e.toString());
                    }
                });
    }

    private void addNewContact(String n,String e, String p) {
        Map<String, Object> newContact = new HashMap<>();

        count=pref.getInt("count",-1);
        Toast.makeText(getApplicationContext(),count,Toast.LENGTH_SHORT);

        x=pref.getString("name","Default");
        String dbname=x;


        count++;
        editor.putInt("count",count);
        editor.commit();

        newContact.put(NAME_KEY, n);
        newContact.put(EMAIL_KEY, e);
        newContact.put(PHONE_KEY, p);

        db.collection("PhoneBook").document(dbname).set(newContact)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Login.this, "User Registered",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this, "ERROR" + e.toString(),
                                Toast.LENGTH_SHORT).show();
                        Log.d("TAG", e.toString());
                    }
                });
    }

    private void ReadSingleContact() {
        x=pref.getString("name","Default");
        String dbname=x;
        DocumentReference user = db.collection("PhoneBook").document(dbname);

        user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){
                    DocumentSnapshot doc = task.getResult();

                    StringBuilder fields = new StringBuilder("");
                    fields.append("Name: ").append(doc.get("Name"));
                    fields.append("\nEmail: ").append(doc.get("Email"));
                    fields.append("\nPhone: ").append(doc.get("Phone"));
                    display.setText(fields.toString());
                }
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Failed to fetch details! \nCheck internet connection",Toast.LENGTH_LONG);
                    }
                });
    }

    private void addNewAnswer() {
        Map<String, Object> newAttitude = new HashMap<>();

//        count=pref.getInt("count",-1);
//
//        String dbname="Contact"+count;
//        count++;
//        editor.putInt("count",count);
//        editor.commit();

        count= pref.getInt("count",-1);
        count--;
        x=pref.getString("name","Default");
        String dbname=x;

        newAttitude.put(data, "c");
        newAttitude.put(data2, "c");
        newAttitude.put(data3, "c");
        newAttitude.put(data4, "c");
        newAttitude.put(data5, "c");
        newAttitude.put(data6, "c");
        newAttitude.put(data7, "c");
        newAttitude.put(data8, "c");
        newAttitude.put(data9, "c");
        newAttitude.put(data10, "c");
        newAttitude.put(data11, "c");
        newAttitude.put(data12, "c");
        newAttitude.put(data13, "c");
        newAttitude.put(data14, "c");
        newAttitude.put(data15, "c");
        newAttitude.put(data16, "c");
        newAttitude.put(data17, "c");
        newAttitude.put(data18, "c");
        newAttitude.put(data19, "c");
        newAttitude.put(data20, "c");





        db.collection("PhoneBook").document(dbname).collection("Answers").document("Attitude").set(newAttitude)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Login.this, "Data added",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this, "ERROR" + e.toString(),
                                Toast.LENGTH_SHORT).show();
                        Log.d("TAG", e.toString());
                    }
                });
    }
    private void showalert(String s) {

        builder = new AlertDialog.Builder(Login.this);

        builder.setTitle("Oops, no data!")
                .setMessage(s)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                        wifi.setWifiEnabled(true);
                    }
                });
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

}

