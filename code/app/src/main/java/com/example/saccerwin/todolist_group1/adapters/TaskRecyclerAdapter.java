package com.example.saccerwin.todolist_group1.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saccerwin.todolist_group1.LoginActivity;
import com.example.saccerwin.todolist_group1.R;
import com.example.saccerwin.todolist_group1.objects.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duyle on 12/5/16.
 */

public class TaskRecyclerAdapter extends RecyclerView.Adapter<TaskRecyclerAdapter.RecyclerViewHolder> {

    private List<Task> listTask = new ArrayList<Task>();
    private Context mContext;
    private OnItemClickListener listener;

    public TaskRecyclerAdapter(Context mContext, List<Task> listTask, OnItemClickListener listener) {
        this.mContext = mContext;
        this.listTask = listTask;
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return listTask.size();
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.task_layout, parent, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.bind(listTask.get(position), listener);
    }

    /**
     * ViewHolder for item view of list
     */
    public interface OnItemClickListener {
        void onItemClick(Task item);
        boolean onItemLongClick(Task item);
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public CheckBox cbComplete;
        public TextView tvRecyclerTitle, tvRecyclerGroup, tvRecyclerTime;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            cbComplete = (CheckBox) itemView.findViewById(R.id.cbComplete);
            tvRecyclerTitle = (TextView) itemView.findViewById(R.id.tvRecyclerTitle);
            tvRecyclerGroup = (TextView) itemView.findViewById(R.id.tvRecyclerGroup);
            tvRecyclerTime = (TextView) itemView.findViewById(R.id.tvRecyclerTime);
        }

        public void bind(final Task task, final OnItemClickListener listener) {
            tvRecyclerTitle.setText(task.getTitle());
            if(task.isFinish() == true){
                tvRecyclerTitle.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
            } else {
                tvRecyclerTitle.setPaintFlags(tvRecyclerTitle.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
            }
            tvRecyclerGroup.setText(task.getGroup());
            tvRecyclerTime.setText(task.getTime());
            cbComplete.setChecked(task.isComplete());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(task);
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener(){

                @Override
                public boolean onLongClick(View view) {
                    listener.onItemLongClick(task);
                    return false;
                }
            });
        }
    }

}
