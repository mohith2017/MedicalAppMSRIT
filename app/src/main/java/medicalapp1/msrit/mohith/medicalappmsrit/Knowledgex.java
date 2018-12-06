package medicalapp1.msrit.mohith.medicalappmsrit;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Knowledgex extends AppCompatActivity {
    private static final String data = "1";
    private Button back,next;

    private RadioGroup r;

    SharedPreferences.Editor editor;
    SharedPreferences pref;

    int id1,count;
    String checked1;

    FirebaseFirestore db;
    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledgex);
    }
}
