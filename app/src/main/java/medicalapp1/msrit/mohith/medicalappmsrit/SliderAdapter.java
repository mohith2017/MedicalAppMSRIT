package medicalapp1.msrit.mohith.medicalappmsrit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context)
    {
      this.context = context;
    }

    //Arrays of slides for the form
    public String[] slide_question= {
            "Villagers are generally rigid in their beliefs and practices, hence is impossible to change them (3)",
            "Villagers as a whole are unclean and have little inclination towards personal and community hygiene (5)",
            "Practitioners of traditional and indigenous medicine are detrimental to health care of the community (3)",
            "Villagers can do very little to improve their health due to challenges of rural life and need outside help (2)",
            "Most nutritional problems would not exist if villagers had enough money to buy food (2)",
            "The doctor’s responsibility is only towards those who come to him seeking help. (2)",
            "Educating the whole community about health is an additional job for the doctor other than treating patients. (11)",
            "Unimmunized child in the community is mainly their parents’ fault. (3)(1)",
            "What a patient believes about his/her illness is not essential for proper treatment and standard treatment protocols. (3)",
            "There are not many opportunities for scientific medical research in rural areas. (8)",
            "Placing a doctor in a remote village is a waste of his expertise and scientific training. (9)",
            "If you practice in rural areas, you cannot expect the kind of job satisfaction which results from an intellectual approach to medicine. (6)(9)",
            "I would work in a rural hospital if it were the only way to obtain admission to a post-graduate degree seat. (1)(3)",
            "Working in a village should entitle me to monetary and other incentives. (1)",
            "Working in a rural health centre is not an option for me in my career (1)",
            "A villager who died due to cancer is not of much concern as he/she wouldn’t be economically beneficial to the society when compared a city-dweller who died due to cancer. (3)",
            "A villager cannot complain about lack of basic amenities as it is his ill-luck and misfortune that he is born in a rural area and not in a city. (3)",
            "It is unfair to expect the Government to provide free healthcare and education in rural areas as villages don’t bring them revenue. (6)",
            "People will not inculcate healthy habits after health education by professionals unless it is reinforced periodically. (11)",
            "People would accept health messages better from their own people (local health workers, Anganwadi teachers) than outsiders (social workers, health educators, medical students) (11)",
            "If the intention of your health interventions is beneficial to the people, building rapport with the community is not of much importance. (1)",
            "It is always imperative to know the community’s health problems and needs before educating them of general healthy lifestyle habits. (11)",
            "Providing equal healthcare to all is better than special health care for needs of vulnerable groups. (4)",
            "Providing training for jobs (vocations) and self-sustenance to differently abled people is their families’ responsibility and not that of the health team. (2)",
            "Even for minor ailments, home based treatment is always detrimental to health. (11)"


    };



    @Override
    public int getCount() {
        return slide_question.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_attitude1, container, false);

        TextView slideQuestion=(TextView)view.findViewById(R.id.textView4);



        slideQuestion.setText(slide_question[position]);

        container.addView(view);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

     container.removeView((RelativeLayout)object);

    }
}
