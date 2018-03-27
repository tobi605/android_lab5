package app.polibuda.gimbus.android_lab5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements Fragment1.OnOptionPickListener {
    Fragment11 fragment11;
    Fragment12 fragment12;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment11 = new Fragment11();
        fragment12 = new Fragment12();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, fragment11);
        fragmentTransaction.detach(fragment11);
        fragmentTransaction.add(R.id.fragment_container, fragment12);
        fragmentTransaction.detach(fragment12);
        fragmentTransaction.commit();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
    }

    @Override
    public void onOptionPick(int option) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (option) {
            case 1: {
                transaction.detach(fragment12);
                transaction.attach(fragment11);
                break;
            }
            case 2: {
                transaction.detach(fragment11);
                transaction.attach(fragment12);
                break;
            }
        }
        transaction.commit();
    }
}
