package com.example.myapplication;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
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
        View rootView = inflater.inflate(R.layout.fragment_info_parking, container, false);

        Bundle arguments = getArguments();
        if (arguments != null) {
            String name = arguments.getString("name");
            String address = arguments.getString("address");
            String number = arguments.getString("number");
            String disable = arguments.getString("disable");

            // Update UI elements
            TextView nameTextView = rootView.findViewById(R.id.textView);
            nameTextView.setText(name);

            TextView addressTextView = rootView.findViewById(R.id.parkingAddress);
            addressTextView.setText(address);

            TextView numTextView = rootView.findViewById(R.id.parkingNormal);
            numTextView.setText(number);

            TextView disableTextView = rootView.findViewById(R.id.parkingDisabled);
            disableTextView.setText(disable);

            // Find your button and set its click listener
            Button buttonShowComment = rootView.findViewById(R.id.buttonShowComment);
            buttonShowComment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showPopup(v); // Call the method to show the popup when the button is clicked
                    //rootView.setVisibility(View.INVISIBLE);
                    //rootView.setBackgroundTintMode();
                }
            });
        }
            return rootView;
        }
    public static void dimBehind(PopupWindow popupWindow) {
        View container;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            container = (View) popupWindow.getContentView().getParent();
        } else {
            container = popupWindow.getContentView();
        }
        if (popupWindow.getBackground() != null) {
            container = (View) container.getParent();
        }
        Context context = popupWindow.getContentView().getContext();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams p = (WindowManager.LayoutParams) container.getLayoutParams();
        p.flags |= WindowManager.LayoutParams.FLAG_DIM_BEHIND; // add a flag here instead of clear others
        p.dimAmount = 0.3f;
        wm.updateViewLayout(container, p);
    }

    private void showPopup(View view) {
        // Inflate the popup layout
        View popupView = LayoutInflater.from(getActivity()).inflate(R.layout.comment_popup, null);



//        // Create the popup window
//        final PopupWindow popupWindow = new PopupWindow(
//                popupView,
//                ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT
//        );
        // Create the popup window with larger width and height
        final PopupWindow popupWindow = new PopupWindow(
                popupView,
                1000, // Set the width as per your requirement, for example, 600 pixels
                1000, // Set the height as per your requirement, for example, 800 pixels
                true // Added parameter to allow the popup to dismiss when touch outside
        );

        // Set focusable true to enable touch events outside of the popup window
        popupWindow.setFocusable(true);

        // Show the popup window at the center of the screen
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // Accessing views inside the popup layout
        EditText editText = popupView.findViewById(R.id.editTextText);
        //Button buttonAddPic = popupView.findViewById(R.id.buttonAddPic);
        Button buttonAddComment = popupView.findViewById(R.id.buttonAddComment);
        dimBehind(popupWindow);
        // Example: Handling button click inside the popup
        buttonAddComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do something when the "Finish" button inside the popup is clicked
                // For example, get the text from the EditText
                String comment = editText.getText().toString();
                // Then dismiss the popup window
                popupWindow.dismiss();
            }
        });
    }


    public void buttonShowComment(View view) {
    }

}