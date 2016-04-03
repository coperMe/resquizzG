package com.adm.coper.resquizzgotham.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TabHost;

import com.adm.coper.resquizzgotham.POJO.Score;
import com.adm.coper.resquizzgotham.POJO.ScoreAdapter;
import com.adm.coper.resquizzgotham.POJO.User;
import com.adm.coper.resquizzgotham.R;

import java.util.Comparator;
import java.util.PriorityQueue;


public class ScoresActivity extends Activity {

    private PriorityQueue<Score> scoreQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        TabHost th = (TabHost) findViewById(R.id.tabHost);

        th.setup();
        TabHost.TabSpec tsName = th.newTabSpec("Tab1");
        tsName.setContent(R.id.tLocal);
        tsName.setIndicator("Local");
        th.addTab(tsName);

        th.setup();
        TabHost.TabSpec tsFriends = th.newTabSpec("Tab2");
        tsFriends.setContent(R.id.tFriends);
        tsFriends.setIndicator("Friends");
        th.addTab(tsFriends);

        setUpQueue();

        //setUpContent();
    }

    private void setUpQueue() {

        this.scoreQueue = new PriorityQueue<Score>(1, new Comparator<Score>() {
            @Override
            public int compare(Score lhs, Score rhs) {
                if(rhs.getScore() > lhs.getScore())
                    return -1;
                else
                    return 1;
            }
        });

    }

    private void setUpContent() {

        Score []sco = new Score[]{
                new Score(new User(),9000),
                new Score(new User(2, "Jane Doe", null), 2500)
        };

        ScoreAdapter adapter = new ScoreAdapter(this,
                                                R.layout.lv_item_row,
                                                sco);

        ListView lv = (ListView) findViewById(R.id.lvLocalScores);
        ListView lv2 = (ListView) findViewById(R.id.lvFriendsScores);

        lv.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scores, menu);
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

    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        ///TODO
        return true;
    }
}
