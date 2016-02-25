package com.adm.coper.resquizzgotham.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import com.adm.coper.resquizzgotham.POJO.User;
import com.adm.coper.resquizzgotham.R;


public class SettingsActivity extends Activity {

    private User data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView lv = (ListView) findViewById(R.id.lvFriendsList);
        Spinner sp = (Spinner) findViewById(R.id.spinner);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        this.data = (User) getIntent().getExtras().get("dataUser");

        /*
        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                data.getFriends());

        lv.setAdapter(arrayAdapter);*/
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

    public void onClickAddButton(View v){


        AlertDialog.Builder alertDialog = new AlertDialog.Builder(SettingsActivity.this);
        alertDialog.setTitle("FRIEND");
        alertDialog.setMessage("Enter your friend's name");

        final EditText input = new EditText(SettingsActivity.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                                                     LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        alertDialog.setView(input);
        alertDialog.setIcon(R.drawable.addfriendicon);

        alertDialog.setPositiveButton("ADD",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        data.getFriends().add(input.getText().toString());
                    }
                });

        alertDialog.setNegativeButton("CANCEL",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        alertDialog.show();


    }
}
