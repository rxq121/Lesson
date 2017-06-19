package com.sg.hjs.userlist;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by hjs on 17-6-6.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListItem> {
    private final Context context;
    private Cursor cursur;

    public UserListAdapter(Cursor cursur, Context context) {
        setCursur(cursur);
        this.context = context;
    }

    public void setCursur(Cursor cursur) {
        this.cursur = cursur;

        notifyDataSetChanged();
    }

    public Context getContext() {
        return context;
    }

    @Override
    public UserListItem onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserListItem(LayoutInflater.from(getContext()).inflate(R.layout.list_item, null));
    }

    @Override
    public void onBindViewHolder(UserListItem holder, int position) {
        if (cursur != null) {
            cursur.moveToPosition(position);

            String name = cursur.getString(cursur.getColumnIndex("name"));
            String age = cursur.getString(cursur.getColumnIndex("age"));

            holder.getTvName().setText(name);
            holder.getTvAge().setText(age);
        }
    }

    @Override
    public int getItemCount() {
        return cursur != null ? cursur.getCount() : 0;
    }
}
