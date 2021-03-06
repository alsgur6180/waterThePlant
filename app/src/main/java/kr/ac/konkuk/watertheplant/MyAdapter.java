package kr.ac.konkuk.watertheplanttest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<kr.ac.konkuk.watertheplanttest.SampleData> sample;

    public MyAdapter(Context context, ArrayList<kr.ac.konkuk.watertheplanttest.SampleData> data) {
        mContext = context;
        sample = data;

        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return sample.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public kr.ac.konkuk.watertheplanttest.SampleData getItem(int position) {
        return sample.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.listview_custom, null);

        ImageView imageView = (ImageView)view.findViewById(R.id.picture);
        TextView plantName = (TextView)view.findViewById(R.id.plantName);
        TextView wateringCycleSummer = (TextView)view.findViewById(R.id.wateringCycleSummer);
        TextView wateringCycleWinter = (TextView)view.findViewById(R.id.wateringCycleWinter);


        imageView.setImageResource(sample.get(position).getPoster());
        plantName.setText(sample.get(position).getPlantName());
        wateringCycleSummer.setText(sample.get(position).getWateringCycleSummer());
        wateringCycleWinter.setText(sample.get(position).getWateringCycleWinter());

        return view;
    }
}