package com.studio231.android.simpletip.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.studio231.android.simpletip.R;
import com.studio231.android.simpletip.constant.C;
import com.studio231.android.simpletip.fragment.MainFragment;
import com.studio231.android.simpletip.fragment.NumpadFragment;

public class MainActivity extends Activity implements
        MainFragment.OnOptionButtonSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOptionButtonSelected(int type) {
        switch(type) {
            case C.BUTTON_TYPE_COST:
                swapFragment(new NumpadFragment());
                break;
            case C.BUTTON_TYPE_TIP:
                swapFragment(new NumpadFragment());
                break;
            case C.BUTTON_TYPE_SPLIT:
                break;
        }
    }

    private void swapFragment(Fragment f) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        //ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.setCustomAnimations(R.anim.enter_from_bottom,
                R.anim.exit_to_bottom,
                R.anim.enter_from_bottom,
                R.anim.exit_to_bottom);
        ft.addToBackStack(null);
        ft.replace(R.id.container, f);
        ft.commit();
    }
}
