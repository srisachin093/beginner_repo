package com.example.happy2style.ui.booking.Util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.happy2style.R;

import java.util.HashMap;
import java.util.List;

public class ExpandableServiceListAdapter extends BaseExpandableListAdapter {
    private static final String TAG = "ExpandableServiceListAd";
    private Context mContext;
    private List<String> mServiceListHeader;
    private HashMap<String,List<String>> mServiceListHeaderItem;


    public ExpandableServiceListAdapter(Context mContext, List<String> mServiceListHeader, HashMap<String, List<String>> mServiceListHeaderItem) {

        this.mContext = mContext;
        this.mServiceListHeader = mServiceListHeader;
        this.mServiceListHeaderItem = mServiceListHeaderItem;
    }

    @Override
    public int getGroupCount() {
        return mServiceListHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mServiceListHeaderItem.get(mServiceListHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mServiceListHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mServiceListHeaderItem.get(mServiceListHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {
        String ServiceHeader=(String)getGroup(groupPosition);
        if(view==null){
            LayoutInflater inflater=(LayoutInflater)this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.service_list_group,parent,false);
        }
        TextView mServiceHeader=view.findViewById(R.id.service_list_header);
        mServiceHeader.setTypeface(null, Typeface.BOLD);
        mServiceHeader.setText(ServiceHeader);

        return view;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View view, ViewGroup parent) {
        String ServiceItem = (String) getChild(groupPosition, childPosition);
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.service_list_item, parent, false);
        }
        final TextView mServiceItem = view.findViewById(R.id.service_list_item);
        mServiceItem.setTypeface(null, Typeface.BOLD);
        mServiceItem.setText(ServiceItem);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "clicked"+childPosition+"of"+groupPosition+mServiceItem.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
