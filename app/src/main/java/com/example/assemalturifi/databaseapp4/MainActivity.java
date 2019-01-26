package com.example.assemalturifi.databaseapp4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText age;
    private EditText gender;
    private ListView lvPerson;

    //step16
    private PersonDataBase personDatabase;

    private ArrayAdapter<String> personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //step3
        bindViews();

        //step17
//create person database
        personDatabase = new PersonDataBase(getApplicationContext());

        //step18
        //to view the saved list
        personAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,new ArrayList<String>());
        lvPerson.setAdapter(personAdapter);


    }
    //step2
    public void bindViews(){
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);
        lvPerson = findViewById(R.id.lvPerson);



    }

    //step19
    public void onSQLiteDatabase(View view) {
        String personName=name.getText().toString();
        String personAge=age.getText().toString();
        String personGender=gender.getText().toString();

        Person person=new Person(personName,personAge,personGender);


        switch (view.getId()){
            case R.id.saveData:
                long rowId=personDatabase.savePerson(person);
                Toast.makeText(this,String.valueOf(rowId),Toast.LENGTH_SHORT).show();
                name.setText("");
                age.setText("");
                gender.setText("");
                break;

            case R.id.getdata:
                for (Person person1 : personDatabase.getPeople()) {
                    personAdapter.add(person1.toString());
                }

                break;
        }
    }
}
