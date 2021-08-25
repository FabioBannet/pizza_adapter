package com.pizzaitemslist.customAdapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.pizzaitemslist.Entity.Pizza;
import com.pizzaitemslist.R;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

// використовував таку документацію:
// https://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView

public class PizzaItemAdapter extends ArrayAdapter<Pizza> {

    public static final String DIAMETER_MEASURE = "cm";
    public static final String WEIGHT_MEASURE = "g";
    public static final String CURRENCY_MEASURE = "UAH";

    private Context context;

    private static class ViewHolder{
        private ImageView imageViewItem;
        private TextView tvName;
        private TextView tvDiameter;
        private TextView tvDescription;
        private TextView tvWeight;
        private TextView tvPrice;
    }


    public PizzaItemAdapter(@NonNull Context context, int resource, @NonNull List<Pizza> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Pizza pizza = getItem(position);

        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.pizza_item, parent, false);

            initViews(viewHolder,convertView);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        fillTheViewItem(convertView,viewHolder,pizza);

        return convertView;
    }

    private void fillTheViewItem(View convertView, ViewHolder viewHolder, Pizza pizza) {
        //fill in img view from URL through third party lib https://github.com/bumptech/glide
        Glide.with(context).load(pizza.getImgURL()).into(viewHolder.imageViewItem);

        viewHolder.tvName.setText(pizza.getName());
        viewHolder.tvDiameter.setText(String.valueOf(pizza.getDiameter()) +" "+ DIAMETER_MEASURE);
        viewHolder.tvDescription.setText(pizza.getDescription());
        viewHolder.tvWeight.setText(String.valueOf(pizza.getWight())  +" "+ WEIGHT_MEASURE);
        viewHolder.tvPrice.setText(String.valueOf(pizza.getPrice())  +" "+ CURRENCY_MEASURE);
    }


    private void initViews(ViewHolder viewHolder, View convertView) {
        viewHolder.imageViewItem = (ImageView) convertView.findViewById(R.id.imageViewItem);
        viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
        viewHolder.tvDiameter = (TextView) convertView.findViewById(R.id.tvDiameter);
        viewHolder.tvDescription = (TextView) convertView.findViewById(R.id.tvDescription);
        viewHolder.tvWeight = convertView.findViewById(R.id.tvWeight);
        viewHolder.tvPrice = convertView.findViewById(R.id.tvPrice);
    }

}
