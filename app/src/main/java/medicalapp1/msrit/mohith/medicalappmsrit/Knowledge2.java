package medicalapp1.msrit.mohith.medicalappmsrit;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import medicalapp1.msrit.mohith.medicalappmsrit.Attitudepages.Attitude2;

public class Knowledge2 extends AppCompatActivity {

    private ViewPager slideknowledge2;
    private LinearLayout dotslayout2;

    private SliderAdapterknowledge2 s;

    String checked1;
    int id1;
    private RadioGroup r;

//    private TextView[] dots;

    private Button back,next;
    private int Currentpage;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge2);

        slideknowledge2=(ViewPager)findViewById(R.id.slideknowledge2);
        dotslayout2=(LinearLayout)findViewById(R.id.dotslayout2);
        back=(Button)findViewById(R.id.buttonback1);
        next=(Button)findViewById(R.id.buttonnext1);
        r=(RadioGroup)findViewById(R.id.groupknowledge2);

        s =new SliderAdapterknowledge2(this);

        slideknowledge2.setAdapter(s);

        slideknowledge2.addOnPageChangeListener(viewListener);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Currentpage==16)
                {
                    showalert("Are you sure you want to submit responses?","Yes","No");
                }
                else {


                    slideknowledge2.setCurrentItem(Currentpage + 1);
                }


            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideknowledge2.setCurrentItem(Currentpage-1);


            }
        });
    }

    private void showalert(String s, String yes, String no) {

        builder = new AlertDialog.Builder(Knowledge2.this);

        builder.setTitle("Confirm")
                .setMessage(s)
                .setPositiveButton(yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i=new Intent(Knowledge2.this,MainActivity.class);
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

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
//          addDotsIndicator(i);


            if(i==0)
            {


                back.setEnabled(false);
                next.setEnabled(true);
                back.setVisibility(View.INVISIBLE);

                back.setText("");
                next.setText("Next");
            }

            else if(i==16)
            {
                back.setEnabled(true);
                next.setEnabled(true);
                back.setVisibility(View.VISIBLE);

                back.setText("Back");
                next.setText("Finish");
            }
            else
            {
                back.setEnabled(true);
                next.setEnabled(true);
                back.setVisibility(View.VISIBLE);

                back.setText("Back");
                next.setText("Next");
            }


        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

}
