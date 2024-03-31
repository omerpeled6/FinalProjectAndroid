package com.example.myapplication.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.myapplication.NavigationListener;
import com.example.myapplication.R;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationListener {
    private FragmentContainerView fragmentContainerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentContainerView = findViewById(R.id.fragmentContainerView);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_top_navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.star){
            Toast.makeText(this,"star",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.fav){
            Toast.makeText(this,"heart",Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    /*public void navigateToInfoParking(View view) {
        NavController navController = Navigation.findNavController(view);  // Use the passed view
        navController.navigate(R.id.action_global_fragmentInfoParking);
    }
    public void navigateToInfoParking() {
        NavController navController = Navigation.findNavController(Objects.requireNonNull(this.getCurrentFocus()));
        navController.navigate(R.id.action_global_fragmentInfoParking); // Replace with your action ID
    }*/

    @Override
    public void navigateToInfoParking(View v) {
        NavController navController = Navigation.findNavController(v);
        navController.navigate(R.id.action_global_fragmentInfoParking);
    }
}
