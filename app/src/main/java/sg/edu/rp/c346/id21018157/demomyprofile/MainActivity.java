package sg.edu.rp.c346.id21018157.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);

    }

    @Override
    protected void onPause() {
        super.onPause();

        //a. get user input from EditText and store into a variable
        String strName = etName.getText().toString();
        float gpa = Float.parseFloat(etGPA.getText().toString());
        //b. obtain instance of SharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        //c. obtain instance of SharedPreference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();
        //d. add key-value pair
        prefEdit.putString("name", strName);
        //GPA
        prefEdit.putFloat("GPA", gpa);
        //e. call commit() to save changes into SharedPreferences
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //a. obtain instance of SharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        //b. retrieve saved data from SharedPreferences obj
        String strName = prefs.getString("name","Default name");
        float gpa = prefs.getFloat("GPA",0.0f);
        //c. update UI element with the value
        etName.setText(strName);
        etGPA.setText(gpa + "");
    }
    
}