package com.ifi.kuirin.fragmentandroid;

import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

/**
 * Created by KuiRin on 8/31/2017 AD.
 */

public class CustomFragmentManager {

    public static CustomFragmentManager getInstance(AppCompatActivity context) {
        CustomFragmentManager ourInstance = new CustomFragmentManager(context);
        return ourInstance;
    }

    private AppCompatActivity mContext;

    public CustomFragmentManager(AppCompatActivity context) {
        this.mContext = context;
    }

    public FragmentManager getFragmentManager() {
        return mContext.getSupportFragmentManager();
    }

    public static CustomFragmentManager build(AppCompatActivity context) {
        return new CustomFragmentManager(context);
    }

    public void addFragment(int layoutId, @NonNull Fragment fragment, @NonNull String tag) {
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragmentCheck = fragmentManager.findFragmentByTag(tag);
        if (fragmentCheck != null) {
            return;
        }
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.add(layoutId, fragment, tag);
//        fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commitAllowingStateLoss();
    }

    public void replaceFragment(int layoutId, @NonNull Fragment fragment, @NonNull String tag) {
        FragmentManager fragmentManager = getFragmentManager();
        if (!fragmentManager.popBackStackImmediate(tag, 0) && fragmentManager.findFragmentByTag(tag) == null) {
//            Log.d("replaceChildFragment: " , " "+ fragmentManager.getBackStackEntryCount());
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(layoutId, fragment, tag);
            ft.addToBackStack(tag);
            ft.commit();
        }
        Log.d("replaceFragment: " , " "+ fragmentManager.getBackStackEntryCount());
    }

    public void replaceFragmentNonAddStack(int layoutId, @NonNull Fragment fragment, @NonNull String tag) {
        FragmentManager fragmentManager = getFragmentManager();
//        fragmentManager.popBackStack();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.replace(layoutId, fragment, tag);
        fragmentTransaction.commitAllowingStateLoss();
    }

    public boolean popBackStack() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 1) {
            Fragment fragment = getCurrentFragment();
            FragmentManager fragmentChildManager = fragment.getChildFragmentManager();
            Log.d("backstack: " , " "+ fragmentManager.getBackStackEntryCount());
            Log.d("child backstack: " , " "+ fragmentChildManager.getBackStackEntryCount());
            if (fragmentChildManager.getBackStackEntryCount() > 1) {
                fragmentChildManager.popBackStack();
            } else {
                fragmentManager.popBackStack();
            }
            return true;
        }
        return false;
    }

    /**
     * Propagates a back button press down to our nested fragment manager
     * and its fragments.
     * @param fm the Fragment Manager
     * @return true if the back stack was returned from successfully,
     * false if not
     */
    public boolean returnBackStackImmediate(FragmentManager fm) {
        // HACK: propagate back button press to child fragments.
        // This might not work properly when you have multiple fragments adding
        // multiple children to the back stack.
        // (in our case, only one child fragments adds fragments to the back stack,
        // so we're fine with this)
        //
        // This code was taken from the web site:
        // http://android.joao.jp/2013/09/back-stack-with-nested-fragments-back.html
        // Accessed on March 21, 2014
        List<Fragment> fragments = fm.getFragments();
        if (fragments != null && fragments.size() > 0) {
            for (Fragment fragment : fragments) {
                if (fragment != null && fragment.getChildFragmentManager() != null) {
                    if (fragment.getChildFragmentManager().getBackStackEntryCount() > 1) {
                        if (fragment.getChildFragmentManager().popBackStackImmediate()) {
                            return true;
                        } else {
                            return returnBackStackImmediate(fragment.getChildFragmentManager());
                        }
                    }
                }
            }
        }
        return false;
    }

    private Fragment getCurrentFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        String fragmentTag = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
        Fragment currentFragment = fragmentManager.findFragmentByTag(fragmentTag);
        return currentFragment;
    }


    public void clearBackStack() {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }


    public void addDialogFragment(DialogFragment dialogFragment, String tag) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        FragmentManager fm = getFragmentManager();
        Fragment prev = getFragmentManager().findFragmentByTag(tag);
        if (prev != null) {
            ft.remove(prev);
        }
//        dialogFragment.show(fm, AlertDialogFragment.TAG);
    }
}