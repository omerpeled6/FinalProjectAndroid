package com.example.myapplication.mains;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.adapters.ParkingLotAdapter;
import com.example.myapplication.models.ParkingLot;
import com.example.myapplication.services.DataService;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Dialog commentPopup;  // add to popup
    private ArrayList<ParkingLot> dataSet; //המערך רשומות
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager; //ההגדרות שלו (למעלה למטה\שמאל ימין)
    private ParkingLotAdapter adapter;
    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add to popup
        commentPopup = new Dialog(this);

        //build rv:
        dataSet = new ArrayList<>();
        recyclerView = findViewById(R.id.resview);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator()); // add data to your array


        dataSet= DataService.getArrParkingLots(); //Add data to your array using DataService
        adapter=new ParkingLotAdapter(dataSet);
        recyclerView.setAdapter(adapter);


        searchView = findViewById(R.id.search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String query) {
                // Handle search submission (if needed)
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Handle text changes in the search view
                filter(newText); // Implement your filtering logic
                return true;
            }
        });
    }

    private void filter(String query) {
        adapter.getFilter().filter(query);
    }


    public void ShowPopup(View v) {
        TextView txtclose;
        Button btnAddComment;
        commentPopup.setContentView(R.layout.custopopup);
        txtclose = (TextView) commentPopup.findViewById(R.id.txtclose);

    }
}