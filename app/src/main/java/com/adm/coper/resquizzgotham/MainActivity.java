package com.adm.coper.resquizzgotham;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickButton(View v){
        Intent inn = null;

        switch(v.getId()){
            case R.id.playButton:
                inn = new Intent(this, PlayActivity.class);
                break;
            case R.id.scoresButton:
                inn = new Intent(this, ScoresActivity.class);
                break;
            case R.id.settingsButton:
                inn = new Intent (this, SettingsActivity.class);
                break;
        }

        if(inn != null)
            startActivity(inn);
    }
}
