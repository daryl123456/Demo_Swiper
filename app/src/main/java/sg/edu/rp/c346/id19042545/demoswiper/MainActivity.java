package sg.edu.rp.c346.id19042545.demoswiper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Fragment> al;
    MyFragmentPagerAdapter adapter;
    ViewPager vPager;

    Button btnBack, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //The usual UI component linking
        vPager = findViewById(R.id.viewpager1);

        btnBack = findViewById(R.id.btnBack);
        btnNext = findViewById(R.id.btnNext);



        FragmentManager fm = getSupportFragmentManager();

        //Prepare the collection of Fragments
        al = new ArrayList<Fragment>();
        al.add(new Frag1());
        al.add(new Frag2());

        //Adapter preparation
        adapter = new MyFragmentPagerAdapter(fm, al);

        //Setting adapter to the UI
        vPager.setAdapter(adapter);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vPager.getCurrentItem() > 0){
                    int previousPage = vPager.getCurrentItem() - 1;
                    vPager.setCurrentItem(previousPage, true);
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int max = vPager.getChildCount();
                if (vPager.getCurrentItem() < max-1){
                    int nextPage = vPager.getCurrentItem() + 1;
                    vPager.setCurrentItem(nextPage, true);
                }
            }
        });

    }
}