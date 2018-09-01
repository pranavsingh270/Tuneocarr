package com.example.pranav.tuneocarr;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class BottomNavigationActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                 //   mTextMessage.setText(R.string.title_home);
                  //  Toast.makeText(BottomNavigationActivity.this,"Home selected",Toast.LENGTH_SHORT).show();
                    switchToHomeFragment();
                    return true;
          /*      case R.id.navigation_services:
                 //   mTextMessage.setText(R.string.title_dashboard);
                    Toast.makeText(BottomNavigationActivity.this,"Services selected",Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_testimonials:
                 //   mTextMessage.setText(R.string.title_notifications);
                    return true;*/
                case R.id.navigation_contact:
                //    mTextMessage.setText("Contact");
                    switchToContactFragment();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        switchToHomeFragment();
    }

    public void switchToHomeFragment() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.content_main, new HomeFragment()).commit();
    }
    public void switchToContactFragment() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.content_main, new ContactFragment()).commit();
    }
}
