package com.example.myapplication.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.myapplication.NavigationListener;
import com.example.myapplication.R;
import com.example.myapplication.activitys.MainActivity;
import com.example.myapplication.adapters.ParkingLotAdapter;
import com.example.myapplication.models.ParkingLot;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentCardLayout#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentCardLayout extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<ParkingLot> dataSet;
    private RecyclerView recyclerView;
    private ParkingLotAdapter adapter;
    private SearchView searchView;
    private NavigationListener listener;  // Define a listener variable



    public fragmentCardLayout() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentCardLayout.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentCardLayout newInstance(String param1, String param2) {
        fragmentCardLayout fragment = new fragmentCardLayout();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            listener = (NavigationListener) context;
            Log.d("Navigation", "Listener attached");
        } else {
            throw new RuntimeException("Must implement NavigationListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_layout, container, false);

        Button button = view.findViewById(R.id.tocardcomment);//שולפת על הכפתור1
        button.setOnClickListener(new View.OnClickListener() { //מה אני רוצה שיקרה כשלוחצת על הכפתור1
            @Override
            public void onClick(View v) {
                //Navigation.findNavController(view).navigate(R.id.action_global_fragmentInfoParking);
                if (listener != null) {
                    Log.d("Navigation", "Calling listener navigateToInfoParking");
                    listener.navigateToInfoParking(view);
                    }
                };
        });

        return view;
    }
}
