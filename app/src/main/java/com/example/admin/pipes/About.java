package com.example.admin.pipes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                Toast.makeText(About.this, getString(R.string.action_settings), Toast.LENGTH_LONG).show();
                Intent intent_setting = new Intent(this, Setting.class);
                startActivity(intent_setting);
                break;
            case R.id.action_calk:
                Toast.makeText(About.this, getString(R.string.action_item1), Toast.LENGTH_LONG).show();
                Intent intent_calk = new Intent(this, Calc.class);
                startActivity(intent_calk);
                break;
            case R.id.action_about:
                Toast.makeText(About.this, getString(R.string.action_item2), Toast.LENGTH_LONG).show();
                Intent intent_about = new Intent(this, About.class);
                startActivity(intent_about);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
