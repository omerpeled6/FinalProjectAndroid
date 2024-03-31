package com.example.myapplication.adapters;

import android.graphics.drawable.PictureDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.ParkingLot;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ParkingLotAdapter extends RecyclerView.Adapter<ParkingLotAdapter.MyViewHolder> {

    ArrayList<ParkingLot> dataset;
    static ArrayList<ParkingLot> datasetFull; // Backup of the original dataset for filtering


    public ParkingLotAdapter(ArrayList<ParkingLot> dataSet) {
        this.dataset = dataSet;
        this.datasetFull = new ArrayList<>(dataSet); // Copy the dataset for filtering
    }

    @NonNull
    @Override
    public ParkingLotAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //יוצר אצ הקארד

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_card_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ParkingLotAdapter.MyViewHolder holder, int position) { //עוברים על תאי המערך ומשבצים על גבי הרשומות

        holder.textname.setText(dataset.get(position).getName());
        holder.textnadress.setText(dataset.get(position).getAddress());
        holder.textparksnum.setText(dataset.get(position).getNumOfParks());
        holder.textdisablenum.setText(dataset.get(position).getNumOfDisabled());
    }

    @Override
    public int getItemCount() {

        return dataset.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textname;
        TextView textnadress;
        TextView textparksnum;
        TextView textdisablenum;

        public MyViewHolder(@NonNull View itemView) { //תוכן הקארד
            super(itemView);

            textname = itemView.findViewById(R.id.name);
            textnadress = itemView.findViewById(R.id.adress);
            textparksnum = itemView.findViewById(R.id.parksNum);
            textdisablenum = itemView.findViewById(R.id.disablesNum);
        }
    }



    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<ParkingLot> filteredList = new ArrayList<>();

                if (constraint == null || constraint.length() == 0) {
                    filteredList.addAll(datasetFull);
                } else {
                    String filterPattern = constraint.toString().toLowerCase().trim();
                    for (ParkingLot item : datasetFull) {
                        if (item.getName().toLowerCase().contains(filterPattern)) {
                            filteredList.add(item);
                        }
                    }
                }

                FilterResults results = new FilterResults();
                results.values = filteredList;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                dataset.clear();
                dataset.addAll((List<ParkingLot>) results.values);
                notifyDataSetChanged();
            }
        };
    }
}
