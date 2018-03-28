package app.polibuda.gimbus.android_lab5;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class CustomBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_bar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater inflater = LayoutInflater.from(this);

        View view = inflater.inflate(R.layout.custom_bar, null);
        Spinner spinner = view.findViewById(R.id.bar_spinner);
        Button button = view.findViewById(R.id.bar_button);
        final android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        final Fragment11 fragment11 = new Fragment11();
        final Fragment12 fragment12 = new Fragment12();
        transaction.add(R.id.custom_container, fragment11);
        transaction.add(R.id.custom_container, fragment12);
        transaction.detach(fragment12);
        transaction.commit();
        String[] fragments = new String[]{fragment11.toString(), fragment12.toString()};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, fragments);
        spinner.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Custom bars rock!", Toast.LENGTH_SHORT).show();
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                android.support.v4.app.FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                switch (i) {
                    case 0: {
                        transaction1.attach(fragment11);
                        transaction1.detach(fragment12);
                        break;
                    }
                    case 1: {
                        transaction1.attach(fragment12);
                        transaction1.detach(fragment11);
                        break;
                    }
                }
                transaction1.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        actionBar.setCustomView(view);
        actionBar.setDisplayShowCustomEnabled(true);
    }
}
