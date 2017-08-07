package com.shmj.buttonnavigationactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    static ArrayList<String> cityNames = new ArrayList<String>();
    static ArrayList<String> hosts = new ArrayList<String>();

    static ArrayAdapter arrayAdapter_annunciations;
    static ArrayAdapter arrayAdapter_hosts;
    Intent annunciations;
    Intent intent_hosts;
    ListView listView, listView_hosts;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.navigation_hostage:
                    mTextMessage.setText(R.string.title_hostage);
                    listView.setEnabled(false);
                    listView.setVisibility(View.GONE);
                    listView_hosts.setEnabled(true);
                    listView_hosts.setVisibility(View.VISIBLE);

                    listView_hosts.setAdapter(arrayAdapter_hosts);
                    listView_hosts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            intent_hosts = new Intent(getApplicationContext(), ScrollingActivity_hosts.class);
                            startActivity(intent_hosts);
                        }
                    });



                    return true;

                case R.id.navigation_guest:
                    mTextMessage.setText(R.string.text_guest);
                    listView.setEnabled(true);
                    listView.setVisibility(View.VISIBLE);
                    listView_hosts.setEnabled(false);
                    listView_hosts.setVisibility(View.GONE);


                    listView.setAdapter(arrayAdapter_annunciations);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            annunciations = new Intent(getApplicationContext(), ScrollingActivity.class);
                            //annunciations.putExtra("noteId", position);
                            startActivity(annunciations);

                        }
                    });
                    return true;

            }
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        mTextMessage.setText("");
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

         listView = (ListView) findViewById(R.id.listView);
        arrayAdapter_annunciations = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, cityNames );

        listView_hosts = (ListView) findViewById(R.id.listView_Host_properties);
        arrayAdapter_hosts = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, hosts);

        cityNames.add("hamedan");
        hosts.add("khaneman");


    }

}
