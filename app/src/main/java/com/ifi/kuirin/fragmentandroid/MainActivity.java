package com.ifi.kuirin.fragmentandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//
//    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.item_1).setOnClickListener(this);
        findViewById(R.id.item_2).setOnClickListener(this);
        findViewById(R.id.item_3).setOnClickListener(this);
        findViewById(R.id.item_4).setOnClickListener(this);

//        viewPager = findViewById(R.id.pager);

        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
//        viewPager.setAdapter(adapter);
        findViewById(R.id.item_1).performClick();
    }

    @Override
    public void onClick(View view) {
        Log.d("onClick", "viewId = " + view.getId());
        switch (view.getId()) {
            case R.id.item_1:
//                viewPager.setCurrentItem(0);
                CustomFragmentManager.getInstance(this).replaceFragment(R.id.frame_content1,
                        FragmentMenu.newInstance(0), FragmentMenuItem.TAG1);
                break;
            case R.id.item_2:
//                viewPager.setCurrentItem(1);
                CustomFragmentManager.getInstance(this).replaceFragment(R.id.frame_content1,
                        FragmentMenu.newInstance(1), FragmentMenuItem.TAG2);
                break;
            case R.id.item_3:
//                viewPager.setCurrentItem(2);
                CustomFragmentManager.getInstance(this).replaceFragment(R.id.frame_content1,
                        FragmentMenu.newInstance(2), FragmentMenuItem.TAG3);
                break;
            case R.id.item_4:
//                viewPager.setCurrentItem(3);
                CustomFragmentManager.getInstance(this).replaceFragment(R.id.frame_content1,
                        FragmentMenu.newInstance(3), FragmentMenuItem.TAG4);
                break;
        }
    }

    @Override
    public void onBackPressed() {
//        if (viewPager.getCurrentItem() == 0) {
//            // If the user is currently looking at the first step, allow the system to handle the
//            // Back button. This calls finish() on this activity and pops the back stack.
//            super.onBackPressed();
//        } else {
//            // Otherwise, select the previous step.
//            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
//        }
//        if (!CustomFragmentManager.getInstance(this).popBackStack()) {
//           super.onBackPressed();
//        }

        super.onBackPressed();
        if (!CustomFragmentManager.getInstance(this).returnBackStackImmediate(getSupportFragmentManager())) {
            super.onBackPressed();
        }
    }
}
