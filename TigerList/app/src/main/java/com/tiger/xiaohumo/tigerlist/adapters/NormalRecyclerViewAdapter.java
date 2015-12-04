package com.tiger.xiaohumo.tigerlist.adapters;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.rey.material.widget.CheckBox;
import com.tiger.xiaohumo.tigerlist.MainActivity;
import com.tiger.xiaohumo.tigerlist.R;
import com.tiger.xiaohumo.tigerlist.objects.DreamObject;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiaohumo on 15/7/11.
 */
public class NormalRecyclerViewAdapter extends RecyclerView.Adapter<NormalRecyclerViewAdapter.NormalTextViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private ArrayList<DreamObject> list;

    public NormalRecyclerViewAdapter(Context context, ArrayList<DreamObject> list) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.list = list;
    }

    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, final int position) {
        holder.item.setText(list.get(position).getTitle());
        holder.item.setChecked(list.get(position).isFinished());

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class NormalTextViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.check_item)
        CheckBox item;



        NormalTextViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            item.setOnCheckedChangeListener(listener);



            
        }

        private CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    list.get(getPosition()).setFinished(true);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            removeItem(getPosition(), NormalRecyclerViewAdapter.this);
                        }
                    }, 800);
                }else {
                    list.get(getPosition()).setFinished(false);
                }
            }
        };
    }

    public void removeItem(int position, RecyclerView.Adapter adapter) {
        MainActivity.list.remove(position);
        adapter.notifyItemRemoved(position);
    }
}
