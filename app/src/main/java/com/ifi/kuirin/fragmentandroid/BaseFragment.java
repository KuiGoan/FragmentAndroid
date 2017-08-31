package com.ifi.kuirin.fragmentandroid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

/**
 * Created by KuiRin on 8/31/2017 AD.
 */

public class BaseFragment extends Fragment {

    protected void replaceFragment(Fragment fm, boolean isAddBackstack, String tag) {
//        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.frame_content, fm, tag);
//        transaction.commit();
        FragmentManager manager = getActivity().getSupportFragmentManager();
//        boolean fragmentPopped = manager.popBackStackImmediate (tag, 0);
        Fragment fragment = manager.findFragmentByTag(tag);
        if (fragment == null){ //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.frame_content, fm, tag);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            if (isAddBackstack) {
                ft.addToBackStack(tag);
            }
            ft.commit();
        }
    }

    protected void replaceChildFragment(Fragment fm, int viewId, boolean isAddBackstack, String tag) {
        //add child fragment
//        getChildFragmentManager()
//                .beginTransaction()
//                .replace(viewId, fm, tag)
//                .commit();
        FragmentManager fragmentManager = getChildFragmentManager();
//        fragmentManager.popBackStack();
        if (!fragmentManager.popBackStackImmediate(tag, 0)) {
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
