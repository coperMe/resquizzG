package com.adm.coper.resquizzgotham.POJO;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.adm.coper.resquizzgotham.R;

/**
 * Created by coper on 24/03/16.
 */
public class ScoreAdapter extends ArrayAdapter<Score> {

    Context context;
    int layoutResourceId;
    Score data[] = null;

    public ScoreAdapter(Context context, int layoutResourceId, Score[] objects) {

        super(context, layoutResourceId, objects);

        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = objects;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ScoreHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ScoreHolder();
            holder.tvIRName = (TextView) row.findViewById(R.id.tvIR_name);
            holder.tvIRScore = (TextView) row.findViewById(R.id.tvIR_score);

            row.setTag(holder);
        }
        else
        {
            holder = (ScoreHolder) row.getTag();
        }

        Score sc = getItem(position);
        holder.tvIRName.setText( sc.getPlayer().getName() );
        holder.tvIRScore.setText( String.valueOf(sc.getScore()) );

        return row;
    }

    static class ScoreHolder
    {
        TextView tvIRName;
        TextView tvIRScore;
    }

}