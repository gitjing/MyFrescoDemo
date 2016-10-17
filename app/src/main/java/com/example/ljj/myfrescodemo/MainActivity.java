package com.example.ljj.myfrescodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ljj.myfrescodemo.basicusage.AbnormalActivity;
import com.example.ljj.myfrescodemo.basicusage.CircleActivity;
import com.example.ljj.myfrescodemo.basicusage.FadeDurationActivity;
import com.example.ljj.myfrescodemo.basicusage.GifImageActivity;
import com.example.ljj.myfrescodemo.basicusage.LowResolutionActivity;
import com.example.ljj.myfrescodemo.basicusage.OverlayShowActivity;
import com.example.ljj.myfrescodemo.basicusage.ProgressBarActivity;
import com.example.ljj.myfrescodemo.basicusage.SimpleShowActivity;
import com.example.ljj.myfrescodemo.demolist.ActivityHolder;
import com.example.ljj.myfrescodemo.postprocessor.PostprocessorActivity;


import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private ActivityHolder activityHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        activityHolder = new ActivityHolder();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager linearlayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearlayoutManager);
        recyclerView.setAdapter(new MainAdapter());


        initActivityHolder();
    }

    private void initActivityHolder() {
        activityHolder.addActivity("SimpleShow",SimpleShowActivity.class);
        activityHolder.addActivity("fadeDuration",FadeDurationActivity.class);
        activityHolder.addActivity("cornerShow",CircleActivity.class);
        activityHolder.addActivity("abnormalShow",AbnormalActivity.class);
        activityHolder.addActivity("progressbarShow",ProgressBarActivity.class);
        activityHolder.addActivity("overlayShow",OverlayShowActivity.class);
        activityHolder.addActivity("gifImage  Show",GifImageActivity.class);
        activityHolder.addActivity(" low resolution", LowResolutionActivity.class);
        activityHolder.addActivity(" grid PrstProcessor", PostprocessorActivity.class);


    }




    private class MainAdapter extends RecyclerView.Adapter<ViewHolder>{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_recyclerview,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.textView.setText(activityHolder.getActivityName(position));
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activityHolder.startActivity(v.getContext(),position);
                }
            });

        }

        @Override
        public int getItemCount() {
            return activityHolder.getNameList().size();
        }

    }

    private class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.activity_tv);
        }
    }
}
