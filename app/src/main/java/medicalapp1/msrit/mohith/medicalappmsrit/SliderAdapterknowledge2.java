package medicalapp1.msrit.mohith.medicalappmsrit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapterknowledge2 extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapterknowledge2(Context context)
    {
        this.context = context;
    }

    public String[] slide_question={
            "Primary Health centre in plains (not hilly areas) caters to a population of about",
            "The following speciality service is not available at Taluk Hospital  ",
            "Oral health is the responsibility of ",
            "Tooth brushing appears to be most effective in prevention of",
            "Which of the following are known risk factors in causation of oral cancer",
            "Refined carbohydrates are responsible for initiation of",
            "Community health nurse should be able to provide in the community.",
            "The process of providing nursing care to the client at their door steps.",
            "The most important role of nursing after the nursing care in the community is",
            "The back bone for the Community Health Nurse",
            "Which of the following dimensions of healthcare best describes the clinical role of a physiotherapist? ",
            "Which of the following approaches is not used by physiotherapist in treating a health condition?",
            "In planning treatment for a person with disability, the primary goal of physiotherapy is ",
            "Which one of the following health conditions does not significantly benefit from physiotherapy interventions?",
            "The main activities of a community pharmacist are:",
            "A community pharmacist decides to collaborate with the local health department to offer expanded services for geriatric patients. Which of the following is the most appropriate first step to take?",
            "'Prescription' means: I. An order given individually for the person for whom prescribed, directly from the practitioner, or the practitioner’s agent, to a pharmacist\n" +
                    " II. A chart order written for an inpatient specifying drugs which he or she is to take home upon discharge\n" +
                    "III. A chart order written for an inpatient for use while he or she is an inpatient\n",
            "A 27 year old patient presents to a community pharmacy and tells the pharmacist that he experienced an allergy to a penicillin product as a child. His symptoms included hives, wheezing and facial swelling, which resulted in hospitalized care. Which of the following is the most important reason for a community pharmacist to document this type of information in a patient’s medication profile record?"
    };

    public String[]  option1x={
      "20,000",
            "Obstetrician",
            "Patient",
            "Periodontal Disease",
            "Tobacco Consumption",
            "Dental fluorosis",
            "Primary Health Care",
            "Home visit",
            "Documentation",
            "Community Health Bag",
            "Preventive",
            "Exercise prescription",
            "To improve and maximize participation",
            "Back pain",
            "Processing of prescription with appropriate counselling",
            "Hire an additional technician to assist with the increased workload",
            "I only",
            "To provide drug allergy information to the patient’s insurance provider"
    };

    public String[] option2x= {
            "40,000",
            "Pathologist",
            "Dentist professional",
            "Malocclusion",
            "School Deprivation",
            "Periodontal disease",
            "Secondary Health Care",
            "Nursing Process",
            "Report",
            "Community Health Nursing",
            "Curative",
            "Prescription of drugs",
            "To treat the impairment",
            "Cancer",
            "Care of patients on drug related precautions",
            "Arrange for a meeting with the local public health nurses’",
            "I and II only ",
            "To encourage the patient to fill future prescriptions at this pharmacy",

    };

    public String[] option3x ={
        "50,000",
            "Pediatrician",
            "Medical professional",
            "Oral Cancer",
            "Fluoride in water",
            "Dental caries",
            "Tertiary Health Care",
            "Home Nursing Skill",
            "Planning ",
            "Home Visit",
            " Rehabilitative",
            "Use of physical modalities",
            "To correct the activity limitation",
            "Viral fever",
            "All of the above",
            "Seek financial sponsorship from pharmaceutical manufacturers’",
            "All of the above",
            "To advertise relevant pharmacy products or services to appropriate patients"
    };

    public String[] option4x ={
      "30,000",
            "Cardiologist",
            "All the above",
            "Premalignant Lesions",
            "High Levels of Stress",
            "Oral cancer",
            "All of the above ",
            "Home Health Care",
            "Evaluation of Nursing Care ",
            "b&c",
            "All the above",
            "Health education",
            "To improve strength and range of motion",
            "Arthritis",
            "None of the above",
            "Visit local physicians to inform them of upcoming plans",
            "All of the above",
            "To enhance continuity of patient care regardless of the prescriber"
    };

    public String[] option5x ={
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "None of the above",
            "Visit local physicians to inform them of upcoming plans",
            "None of the above",
            "To provide a record of cognitive services for insurance reimbursement"

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

        TextView slideQuestion=(TextView)view.findViewById(R.id.textViewy);
        RadioButton option1=(RadioButton)view.findViewById(R.id.mcq1);
        RadioButton option2=(RadioButton)view.findViewById(R.id.mcq2);
        RadioButton option3=(RadioButton)view.findViewById(R.id.mcq3);
        RadioButton option4=(RadioButton)view.findViewById(R.id.mcq4);
        RadioButton option5=(RadioButton)view.findViewById(R.id.mcq5);

        slideQuestion.setText(slide_question[position]);
        option1.setText(option1x[position]);
        option2.setText(option2x[position]);
        option3.setText(option3x[position]);
        option4.setText(option4x[position]);
        option5.setText(option5x[position]);

        container.addView(view);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
