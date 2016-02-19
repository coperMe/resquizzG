package com.adm.coper.resquizzgotham.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.adm.coper.resquizzgotham.POJO.User;
import com.adm.coper.resquizzgotham.R;

import java.util.ArrayList;


public class SettingsActivity extends Activity {

    private User data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        this.data = (User) getIntent().getExtras().get("dataUser");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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

    public void onClickSaveButton(View view){

        EditText et = (EditText) findViewById(R.id.etSettingsName);
        Spinner sp = (Spinner) findViewById(R.id.spinner);

        data.setName(et.getText().toString());
        data.setNumCalls(sp.getSelectedItemPosition());
        data.setFriends(new User().getFriends());

    }
}
