package com.ifi.kuirin.fragmentandroid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

/**
 * Created by KuiRin on 8/31/2017 AD.
 */

public class BaseFragment extends Fragment {

    protected void replaceChildFragment(Fragment fm, int viewId, boolean isAddBackstack, String tag) {
        //add child fragment
//        getChildFragmentManager()
//                .beginTransaction()
//                .replace(viewId, fm, tag)
//                .commit();
        FragmentManager fragmentManager = getChildFragmentManager();
//        fragmentManager.popBackStack();
        if (!fragmentManager.popBackStackImmediate(tag, 0) && fragmentManager.findFragmentByTag(tag) == null) {
//            Log.d("backstack: " , " "+ fragmentManager.getBackStackEntryCount());
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.add(viewId, fm, tag);
            ft.addToBackStack(tag);
            ft.commitAllowingStateLoss();
        }
        Log.d("replaceChildFragment: " , " "+ fragmentManager.getBackStackEntryCount());
    }

    public void popBackStack() {
        getChildFragmentManager().popBackStack();
    }
}
