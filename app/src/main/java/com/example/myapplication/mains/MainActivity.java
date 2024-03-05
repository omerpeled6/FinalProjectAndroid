package com.example.myapplication.mains;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import com.example.myapplication.R;
import com.example.myapplication.adapters.ParkingLotAdapter;
import com.example.myapplication.models.ParkingLot;
import com.example.myapplication.services.DataService;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /*private ArrayList<ParkingLot> dataSet; //המערך רשומות
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager; //ההגדרות שלו (למעלה למטה\שמאל ימין)
    private ParkingLotAdapter adapter;
    private SearchView searchView;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* //build rv:
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
        });*/
    }

    /*private void filter(String query) {

        adapter.getFilter().filter(query);
    }*/
}