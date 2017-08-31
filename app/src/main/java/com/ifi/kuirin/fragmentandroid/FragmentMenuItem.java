package com.ifi.kuirin.fragmentandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by KuiRin on 8/31/2017 AD.
 */

public class FragmentMenuItem extends BaseFragment {
    public static final String TAG1 = "TAG_1";
    public static final String TAG2 = "TAG_2";
    public static final String TAG3 = "TAG_3";
    public static final String TAG4 = "TAG_4";
    public static final String TAG1_child1 = "TAG1_child1";
    public static final String TAG1_child2 = "TAG1_child2";
    public static final String TAG2_child1 = "TAG2_child1";
    public static final String TAG2_child2 = "TAG2_child2";
    public static final String TAG3_child1 = "TAG3_child1";
    public static final String TAG3_child2 = "TAG3_child2";
    public static final String TAG4_child1 = "TAG4_child1";
    public static final String TAG4_child2 = "TAG4_child2";

    public static FragmentMenuItem newInstance() {

        Bundle args = new Bundle();

        FragmentMenuItem fragment = new FragmentMenuItem();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        Log.d("getTag", "Tag: " + getTag());
        ((TextView) view.findViewById(R.id.text)).setText(getTag());
        switch (getTag()) {
            case TAG1:
//                replaceChildFragment(FragmentMenuItem.newInstance(), R.id.frame_child,
//                        false, FragmentMenuItem.TAG1_child1);
                break;
            case TAG2:
//                replaceChildFragment(FragmentMenuItem.newInstance(), R.id.frame_child,
//                        false, FragmentMenuItem.TAG2_child1);
                break;
            case TAG3:
//                replaceChildFragment(FragmentMenuItem.newInstance(), R.id.frame_child,
//                        false, FragmentMenuItem.TAG3_child1);
                break;
            case TAG4:
//                replaceChildFragment(FragmentMenuItem.newInstance(), R.id.frame_child,
//                        false, FragmentMenuItem.TAG4_child1);
                break;
        }
    }
}
