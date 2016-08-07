package com.ats_school.rycyclerview;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by macbookpro on 3/7/16.
 */
public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder>{


    private Cursor cursor;

    public WordAdapter() {

    }

    public void setCursor(Cursor cursor){
        this.cursor = cursor;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        private TextView wordTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            setWordTextView((TextView) itemView.findViewById(R.id.wordTextView));
        }

        public TextView getWordTextView() {
            return wordTextView;
        }

        public void setWordTextView(TextView wordTextView) {
            this.wordTextView = wordTextView;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View rowView = inflater.inflate(R.layout.itemrow, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(rowView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Log.d("Databse", "Position" + position);

        // Get the data model based on position
        cursor.moveToPosition(position);
        String word = cursor.getString(0);


        // Set item views based on your views and data model
        TextView textView = holder.getWordTextView();
        textView.setText(word);
    }

    @Override
    public int getItemCount() {
        if (cursor == null){
            return  0;
        }
        return cursor.getCount();
    }
}
