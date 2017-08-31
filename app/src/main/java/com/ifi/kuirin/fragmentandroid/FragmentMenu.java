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

public class FragmentMenu extends BaseFragment {

    public static final String KEY_POS = "KEY_POS";

    public static FragmentMenu newInstance(int pos) {

        Bundle args = new Bundle();

        FragmentMenu fragment = new FragmentMenu();
        args.putInt(KEY_POS, pos);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int pos = getArguments().getInt(KEY_POS, 0);
        ((TextView) view.findViewById(R.id.text)).setText("Item " + pos);
        switch (pos) {
            case 0:
                replaceChildFragment(FragmentMenuItem.newInstance(), R.id.frame_content,
                        true, FragmentMenuItem.TAG1);
//                replaceChildFragment(FragmentMenuItem.newInstance(), false, FragmentMenuItem.TAG1);
                break;
            case 1:
//                CustomFragmentManager.getInstance((AppCompatActivity) getActivity())
//                        .replaceFragment(R.id.frame_content, FragmentMenuItem.newInstance(),
//                                FragmentMenuItem.TAG2);
//                replaceFragment(FragmentMenuItem.newInstance(), false, FragmentMenuItem.TAG2);
                replaceChildFragment(FragmentMenuItem.newInstance(), R.id.frame_content,
                        true, FragmentMenuItem.TAG2);
                break;
            case 2:
//                CustomFragmentManager.getInstance((AppCompatActivity) getActivity())
//                        .replaceFragment(R.id.frame_content, FragmentMenuItem.newInstance(),
//                                FragmentMenuItem.TAG3);
//                replaceFragment(FragmentMenuItem.newInstance(), false, FragmentMenuItem.TAG3);
                replaceChildFragment(FragmentMenuItem.newInstance(), R.id.frame_content,
                        true, FragmentMenuItem.TAG3);
                break;
            case 3:
//                CustomFragmentManager.getInstance((AppCompatActivity) getActivity())
//                        .replaceFragment(R.id.frame_content, FragmentMenuItem.newInstance(),
//                                FragmentMenuItem.TAG4);
                replaceChildFragment(FragmentMenuItem.newInstance(), R.id.frame_content,
                        true, FragmentMenuItem.TAG4);
//                replaceFragment(FragmentMenuItem.newInstance(), false, FragmentMenuItem.TAG4);
                break;
        }
    }
}
