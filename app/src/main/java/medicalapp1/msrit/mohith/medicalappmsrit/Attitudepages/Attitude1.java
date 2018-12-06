package medicalapp1.msrit.mohith.medicalappmsrit.Attitudepages;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import medicalapp1.msrit.mohith.medicalappmsrit.MainActivity;
import medicalapp1.msrit.mohith.medicalappmsrit.R;
import medicalapp1.msrit.mohith.medicalappmsrit.SliderAdapter;

public class Attitude1 extends AppCompatActivity {

//    private ViewPager slideview;
//    private LinearLayout dotslayout;
//
//    private SliderAdapter s;

//    private TextView[] dots;
private static final String data = "1";


    private RadioGroup r;

    SharedPreferences.Editor editor;
    SharedPreferences pref;



    int id1, count,score1;
    String checked1;

    FirebaseFirestore db;
    FirebaseAuth auth = FirebaseAuth.getInstance();

    private Button back, next;
    private int Currentpage;

    //private AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_attitude1);

        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();

//        slideview=(ViewPager)findViewById(R.id.slideview);
//        dotslayout=(LinearLayout)findViewById(R.id.dotslayout);

        back = (Button) findViewById(R.id.button3);
        next = (Button) findViewById(R.id.button5);
        r = (RadioGroup) findViewById(R.id.groupattitude);
        db = FirebaseFirestore.getInstance();

        back.setVisibility(View.INVISIBLE);

//        s =new SliderAdapter(this);
//
//        slideview.setAdapter(s);
//
//       // addDotsIndicator();
//
//        slideview.addOnPageChangeListener(viewListener);
        editor.putInt("score1",1);
        editor.commit();


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(Currentpage==24)
//                {
//                    showalert("Are you sure you want to submit responses?","Yes","No");
//                }
//                else {
                id1 = r.getCheckedRadioButtonId();

                switch (id1) {
                    case R.id.radioButton:
                        checked1 = "a";
                        break;
                    case R.id.radioButton2:
                        checked1 = "b";
                        break;
                    case R.id.radioButton3:
                        checked1 = "c";
                        break;
                    case R.id.radioButton4:
                        checked1 = "d";
                        break;
                    case R.id.radioButton5:
                        checked1 = "e";
                        break;
                    default:
                        checked1 = "nothing";
                        break;

                }

//                Intent i=new Intent(Attitude4.this,Attitude4.class);
//                startActivity(i);
                Toast.makeText(Attitude1.this, checked1,
                        Toast.LENGTH_SHORT).show();

                UpdateData(checked1);

                if(checked1=="a")
                {
                    score1=pref.getInt("score1",-1);
                    score1++;
                    editor.putInt("score1",score1);
                    editor.commit();
                }

                Intent i = new Intent(Attitude1.this, Attitude2.class);
                startActivity(i);
                //}


            }
        });

//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//            }
//        });

    }

    private void UpdateData(String a) {

        count = pref.getInt("count", -1);
        count--;
        String x=pref.getString("name","Default");
        String dbname=x;


        DocumentReference contact = db.collection("PhoneBook").document(dbname).collection("Answers").document("Attitude");
        contact.update(data, a)

                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Attitude1.this, "Updated Successfully",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

//    private void showalert(String s, String yes, String no) {
//
//        builder = new AlertDialog.Builder(Attitude1.this);
//
//        builder.setTitle("Confirm")
//                .setMessage(s)
//                .setPositiveButton(yes, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        Intent i = new Intent(Attitude1.this, MainActivity.class);
//                        startActivity(i);
//                    }
//                });
//        builder.setNegativeButton(no, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//        builder.show();
//    }

//    public void addDotsIndicator(){
//        dots =new TextView[3];
////        dotslayout.removeAllViews();
//
//        for(int i=0;i<dots.length;i++)
//        {
//          dots[i]=new TextView(this);
//          dots[i].setText(Html.fromHtml("&#8226;"));
//          dots[i].setTextSize(35);
//          dots[i].setTextColor(getResources().getColor(R.color.colorPrimary));
//
//          dotslayout.addView(dots[i]);
//        }

//        if(dots.length > 0){
//            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
//        }

//    }

//    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
//        @Override
//        public void onPageScrolled(int i, float v, int i1) {
//
//        }
//
//        @Override
//        public void onPageSelected(int i) {
////          addDotsIndicator(i);
//            Currentpage=i;
//
//
//
//            if(i==0)
//            {
//                back.setEnabled(false);
//                next.setEnabled(true);
//                back.setVisibility(View.INVISIBLE);
//
//                back.setText("");
//                next.setText("Next");
//
//
//            }
//
//            else if(i==24)
//            {
//                back.setEnabled(true);
//                next.setEnabled(true);
//                back.setVisibility(View.VISIBLE);
//
//                back.setText("Back");
//                next.setText("Finish");
//
//
//            }
//            else
//            {
//                back.setEnabled(true);
//                next.setEnabled(true);
//                back.setVisibility(View.VISIBLE);
//
//                back.setText("Back");
//                next.setText("Next");
//
//
//            }
//
//
//        }
//
//        @Override
//        public void onPageScrollStateChanged(int i) {
//
//        }
//    };
@Override
public void onBackPressed() {
    Toast.makeText(getApplicationContext(),"Invalid action! \n You can't go back",Toast.LENGTH_SHORT).show();
}

}
