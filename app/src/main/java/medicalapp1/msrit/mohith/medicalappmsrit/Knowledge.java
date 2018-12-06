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

public class Knowledge extends AppCompatActivity {

    private ViewPager slideknowledge;
    private LinearLayout dotslayout;

    private SlideAdapterKnowledge1 s;

//    private TextView[] dots;

    private Button back,next;
    private int Currentpage;
    private AlertDialog.Builder builder;

    private RadioGroup r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_knowledge2);

        slideknowledge=(ViewPager)findViewById(R.id.slideknowledge);
        dotslayout=(LinearLayout)findViewById(R.id.dotslayout1);
        back=(Button)findViewById(R.id.buttonback);
        next=(Button)findViewById(R.id.buttonnext);

        s =new SlideAdapterKnowledge1(this);

        slideknowledge.setAdapter(s);

        slideknowledge.addOnPageChangeListener(viewListener);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Currentpage==6)
                {
                    showalert("Are you sure you want to submit responses?","Yes","No");
                }
                else {

                    slideknowledge.setCurrentItem(Currentpage + 1);
                }


            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideknowledge.setCurrentItem(Currentpage-1);


            }
        });
    }

    private void showalert(String s, String yes, String no) {

        builder = new AlertDialog.Builder(Knowledge.this);

        builder.setTitle("Confirm")
                .setMessage(s)
                .setPositiveButton(yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i=new Intent(Knowledge.this,MainActivity.class);
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
            Currentpage=i;

            if(i==0)
            {
                back.setEnabled(false);
                next.setEnabled(true);
                back.setVisibility(View.INVISIBLE);

                back.setText("");
                next.setText("Next");
            }

            else if(i==6)
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
