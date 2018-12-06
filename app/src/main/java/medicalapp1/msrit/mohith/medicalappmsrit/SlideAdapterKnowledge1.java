package medicalapp1.msrit.mohith.medicalappmsrit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SlideAdapterKnowledge1 extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapterKnowledge1(Context context)
    {
        this.context = context;
    }

    public String[] slide_question= {
      "The following statement about social mapping are true ",
      "The common health problems of school children are",
            "Composition of the family would reveal the following information",
            " Services rendered under ICDS in Anganwadi center include ",
            "Principles of health care waste management include",
            "Nutritional assessment at field level includes ",
            "Functions of Primary Health centre include"
    };

    public String[] slide_option1={
      "Community spirit could be generated ",
            "Malnutrition",
            "Family size",
            "Supplementary nutrition",
            "Refuse",
            "Biochemical evaluation ",
            "Medical care, MCH and family planning"
    };

    public String[] slide_option2={
     "Quick understanding of the village infrastructure is possible",
            "Hypertension",
            "Child rearing practices",
            "Non formal education of children",
            "Recluse",
            "Anthropometry ",
            "Safe Water supply and Sanitation"
    };

    public String[] slide_option3={
            "It helps us in identifying various issues in village that needs more reflection",
            "Dental caries",
            "Type of family",
            "Immunization",
            "Reject",
            "Serological evaluation ",
            "Prevention and control of endemic diseases",

    };

    public String[] slide_option4={
      "Gives complete information about village infrastructure and need not be complemented with other tools",
            "Intestinal parasites",
            "Attitude of the family",
            "Basic lab services",
            "Reduce",
            "Clinical examination",
            "Caesarean section and blood bank"
    };


    @Override
    public int getCount() {
        return slide_question.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==(RelativeLayout)o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_knowledge2, container, false);

        TextView slideQuestion=(TextView)view.findViewById(R.id.textView9);
        CheckBox option1=(CheckBox)view.findViewById(R.id.checkBox2);
        CheckBox option2=(CheckBox)view.findViewById(R.id.checkBox3);
        CheckBox option3=(CheckBox)view.findViewById(R.id.checkBox4);
        CheckBox option4=(CheckBox)view.findViewById(R.id.checkBox5);

        slideQuestion.setText(slide_question[position]);
        option1.setText(slide_option1[position]);
        option2.setText(slide_option2[position]);
        option3.setText(slide_option3[position]);
        option4.setText(slide_option4[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
