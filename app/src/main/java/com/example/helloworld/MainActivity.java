package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener{

    String[] genres = { "Action", "Adeventure",
            "Strategy", "Sports",
            "Rpg" };
    String[] desc = { "God of war \n Stray","Final fantasy\n elden ring", "Age of empires \n star craft",
            "Fifa \n cwc", "Pokeman \n chrono trigger",
             };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Take the instance of Spinner and
        // apply OnItemSelectedListener on it which
        // tells which item of spinner is clicked
        Spinner spin = findViewById(R.id.spinner);
        Button btn = findViewById(R.id.button);
        TextView txt = findViewById(R.id.textView1);

        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String selectedField = spin.getSelectedItem().toString();
                String description = getFieldDescriptionz(selectedField);
                txt.setText(description);
            }
        });

        spin.setOnItemSelectedListener(this);

        // Create the instance of ArrayAdapter
        // having the list of courses
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                genres);

        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spin.setAdapter(ad);


    }

    private String getFieldDescriptionz(String selectedField) {
        switch(selectedField){
            case "Action":
                return "A vedio game that emphasizes physical challenges";
            case "Adeventure":
                return  "A player assumes a role of protogonist";
            case "Strategy":
                return "a player uses High decision making skills";
            case "Sports":
                return " The game which includes physical activity";
            case "Rpg":
                return  "Each participant assumes the role of a character";
            default:
                return "";

        }

    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),genres[position] , Toast.LENGTH_LONG).show();
        TextView text1 = findViewById(R.id.textView);
        text1.setText(desc[position].toString());
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }



}