package com.gary.listviewexer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private String[] data={"Apple", "Banana", "Orange", "Pear","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, data);
        mListView = (ListView)findViewById(R.id.activity_main_list_view);
        mListView.setAdapter(adapter);



    }
}
