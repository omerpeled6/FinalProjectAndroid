package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentInfoParking#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentInfoParking extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragmentInfoParking() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentInfoParking.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentInfoParking newInstance(String param1, String param2) {
        fragmentInfoParking fragment = new fragmentInfoParking();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_parking, container, false);
    }

    public void buttonClicked(View view) {
        showPopup();
    }

    private void showPopup() {
        // Inflate the popup layout
        View popupView = getLayoutInflater().inflate(R.layout.comment_popup, null);

        // Create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // To dismiss the popup when touched outside
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // Show the popup window
        popupWindow.showAtLocation(getView(), Gravity.CENTER, 0, 0);

        // Find views in the popup layout
        TextView titlePopup = popupView.findViewById(R.id.titlePopup);
        EditText editTextText = popupView.findViewById(R.id.editTextText);
        Button buttonAddPic = popupView.findViewById(R.id.buttonAddPic);
        Button buttonAddComment = popupView.findViewById(R.id.buttonAddComment);

        // Set listeners or perform actions on popup views as needed

        // Example: Dismiss popup when 'Finish' button is clicked
        buttonAddComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                // Perform any other actions here after popup is dismissed
            }
        });
    }
}