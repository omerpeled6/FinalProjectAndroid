package com.example.myapplication;

import android.graphics.PorterDuff;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.models.Comment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class fragmentInfoParking extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public fragmentInfoParking() {
        // Required empty public constructor
    }

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
        View rootView = inflater.inflate(R.layout.fragment_info_parking, container, false);

        Bundle arguments = getArguments();
        if (arguments != null) {
            String name = arguments.getString("name");
            String address = arguments.getString("address");
            String number = arguments.getString("number");
            String disable = arguments.getString("disable");

            TextView nameTextView = rootView.findViewById(R.id.textView);
            nameTextView.setText(name);

            TextView addressTextView = rootView.findViewById(R.id.parkingAddress);
            addressTextView.setText(address);

            TextView numTextView = rootView.findViewById(R.id.parkingNormal);
            numTextView.setText(number);

            TextView disableTextView = rootView.findViewById(R.id.parkingDisabled);
            disableTextView.setText(disable);

            Button buttonShowComment = rootView.findViewById(R.id.buttonShowComment);
            buttonShowComment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showPopup(v);
                }
            });
        }
        return rootView;
    }

    private void showPopup(View view) {
        View popupView = LayoutInflater.from(getActivity()).inflate(R.layout.comment_popup, null);
        final PopupWindow popupWindow = new PopupWindow(
                popupView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                true
        );
        popupWindow.setFocusable(true);

        EditText editText = popupView.findViewById(R.id.editTextText);
        Button buttonAddComment = popupView.findViewById(R.id.buttonAddComment);

        buttonAddComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commentText = editText.getText().toString();
                String currentDate = getCurrentDate();
                String userId = null;

                // Check if the user is authenticated
                FirebaseAuth auth = FirebaseAuth.getInstance();
                if (auth.getCurrentUser() != null) {
                    // Get the user ID
                    userId = auth.getCurrentUser().getUid();
                } else {
                    // Handle the case when the user is not authenticated
                    // You can show a message or prompt the user to log in
                    // For now, just log an error message
                    Log.e("FragmentInfoParking", "User is not authenticated");
                    return; // Exit the onClick method
                }

                Comment comment = new Comment(commentText, currentDate, "", "", userId);

                DatabaseReference commentsRef = FirebaseDatabase.getInstance().getReference()
                        .child("comments").child("parkingLotId");

                commentsRef.push().setValue(comment);

                popupWindow.dismiss();

                // Show a toast message
                Toast.makeText(getContext(), "Comment added successfully", Toast.LENGTH_SHORT).show();
            }
        });


        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
    }

    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}
