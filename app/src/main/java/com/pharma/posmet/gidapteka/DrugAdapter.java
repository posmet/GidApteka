package com.pharma.posmet.gidapteka;

/**
 * Created by posmet on 15.12.2017.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DrugAdapter extends ArrayAdapter<Drug>{
    private LayoutInflater inflater;
    private int layout;
    private List<Drug> drugs;

    public DrugAdapter(Context context,int resource, List<Drug> drugs){
        super(context, resource, drugs);
        this.drugs = drugs;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=inflater.inflate(this.layout,parent,false);

        ImageView photoView = (ImageView) view.findViewById(R.id.pic);
        TextView nameView = (TextView) view.findViewById(R.id.name);
        TextView artView = (TextView) view.findViewById(R.id.art);
        TextView makerView = (TextView) view.findViewById(R.id.maker);
        TextView priceView = (TextView) view.findViewById(R.id.price);

        Drug drug = drugs.get(position);

        photoView.setImageResource(drug.getPic());
        nameView.setText(drug.getName());
        makerView.setText(drug.getMaker());
        artView.setText(drug.getArt());
        priceView.setText(drug.getPrice());
        return view;
    }

}
