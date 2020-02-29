package com.lingamworks.recyclerviewMultiselectcheckboxes;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {
    private List<String> mlists;
    public List<String>selectedValues;
    private Context mContext1;
    private RecyclerView mRecyclerV1;
    public class ViewHolder extends RecyclerView.ViewHolder {
        public View layout;
        TextView cbactivitieslistreg;
        public ViewHolder(View v) {
            super(v);
            layout = v;
            cbactivitieslistreg=v.findViewById(R.id.textView);
            selectedValues=new ArrayList<>();
        }

    }
    public adapter(List<String> myDataset, Context context, RecyclerView recyclerView) {
        mlists = myDataset;
        mContext1 = context;
        mRecyclerV1 = recyclerView;
    }
    public adapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                 int viewType){
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =inflater.inflate(R.layout.row_values, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    public void onBindViewHolder(final adapter.ViewHolder holder, final int position){
        final String al=mlists.get(position);
        holder.cbactivitieslistreg.setText(al);
        holder.cbactivitieslistreg.setBackgroundResource(R.drawable.boxes1);
        holder.cbactivitieslistreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.cbactivitieslistreg.getBackground().getConstantState()!=v.getResources().getDrawable(R.drawable.boxes1).getConstantState()){
                selectedValues.remove(al);
                holder.cbactivitieslistreg.setBackgroundResource(R.drawable.boxes1);
            }
            else{
              selectedValues.add(al);
              holder.cbactivitieslistreg.setBackgroundResource(R.drawable.boxes);
            }
        }});
    }
    public int getItemCount(){
        return  mlists.size();}
    public List<String> listofselectedactivites(){
        return selectedValues;
    }
}