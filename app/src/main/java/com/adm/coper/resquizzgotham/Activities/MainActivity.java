package com.adm.coper.resquizzgotham.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.adm.coper.resquizzgotham.POJO.User;
import com.adm.coper.resquizzgotham.R;
import com.facebook.FacebookSdk;


public class MainActivity extends Activity {
    private User player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init facebook sdk -> dependences added ar build.grande/app
        FacebookSdk.sdkInitialize(getApplicationContext());

        TextView tv = (TextView) findViewById(R.id.tvPlayersName);
        TextView tv2 = (TextView) findViewById(R.id.tvNumCalls);
        this.player = new User();
        this.player.getFriends().add("Jane Doe");
        tv.setText(player.getName());
        tv2.setText(String.valueOf(player.getNumCalls()));

        getActionBar().show();
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
            Intent inn = new Intent(this,CreditsActivity.class);
            startActivity(inn);
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
                //Bundle bun = new Bundle();
                inn = new Intent (this, SettingsActivity.class);
                //bun.putSerializable("dataUser", this.player);
                inn.putExtra("player",this.player);
                //inn.putExtra("dataUser", this.player);
                break;
        }

        if(inn != null)
            startActivity(inn);
    }
}
