package com.example.jason.secondproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> listItems;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listItems = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> list, View view, int position, long id) {
                        listItems.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                }
        );
    }

    public void addWord(View view) {
        EditText wordField = (EditText) findViewById(R.id.text);
        String word = wordField.getText().toString();
        listItems.add(word);
        adapter.notifyDataSetChanged();
    }
}
