package com.sg.hjs.userlist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by hjs on 17-6-6.
 */

public class UserListItem extends RecyclerView.ViewHolder {
    private TextView tvName, tvAge;

    public UserListItem(View itemView) {
        super(itemView);
        tvName = (TextView) itemView.findViewById(R.id.tvName);
        tvAge = (TextView) itemView.findViewById(R.id.tvAge);
    }

    public TextView getTvName() {
        return tvName;
    }

    public TextView getTvAge() {
        return tvAge;
    }
}
