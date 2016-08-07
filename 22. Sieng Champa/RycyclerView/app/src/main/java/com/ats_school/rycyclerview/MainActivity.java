package com.ats_school.rycyclerview;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.EventLog;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WordAdapter wordAdapter;
    private MyDatabase myDatabase;

    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        List<DictionaryItem> dictionaryItemList = new ArrayList<>();
      //  dictionaryItemList.add(new DictionaryItem("Apple", "A Fruit"));
       // dictionaryItemList.add(new DictionaryItem("Banana", "Another Fruit"));

        myDatabase = new MyDatabase(getApplicationContext());
        wordAdapter = new WordAdapter();
        assert recyclerView != null;
        recyclerView.setAdapter(wordAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        EditText editText = (EditText) findViewById(R.id.searchText);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("Search", "onTextChange" + s.toString());
                Search(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Search("");



//        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout );
//        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
////        drawerLayout.addDrawerListener(toggle);
//        drawerLayout.setDrawerListener(toggle);
//        toggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navView );
//        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    private void Search (String word){
        String [] selectionArgs = {word + "%"};
        Cursor cursor = myDatabase.getReadableDatabase().rawQuery("SELECT * FROM dictionary WHERE word LIKE ?", selectionArgs);
        wordAdapter.setCursor(cursor);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
