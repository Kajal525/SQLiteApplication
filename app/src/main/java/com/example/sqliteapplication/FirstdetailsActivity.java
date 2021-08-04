package com.example.sqliteapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;

public class FirstdetailsActivity extends AppCompatActivity {

    private static final String TAG = "StudentActivity";

    DBHelper mDatabase;
    List<Details> detailsList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        listView = findViewById(R.id.lvStudent);
        detailsList = new ArrayList<>();

        mDatabase = new DBHelper(this);
        loadEmployees();
    }

    private void loadEmployees() {

        Cursor cursor = mDatabase.getdata();

        if (cursor.moveToFirst()) {
            do {
                detailsList.add(new Details(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2)
                ));
            } while (cursor.moveToNext());
            cursor.close();

            DetailsAdapter detailsAdapter = new DetailsAdapter(this, R.layout.list_layout_student, detailsList, mDatabase);
            listView.setAdapter(detailsAdapter);

        }
    }

}


