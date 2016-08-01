package com.eos.eostoy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eos.eostoy.adapter.IntentAdapter;
import com.eos.eostoy.data.Manager;

/**
 * Created by jyoung on 16. 7. 31..
 */
public class IntentFragment extends Fragment {
    private RecyclerView intentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intent, container, false);

        intentView = (RecyclerView)view.findViewById(R.id.intent_view);

        // RecyclerView 에 LinearLayoutManager를 셋팅
        intentView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // 만들어 둔 IntentAdapter를 RecyclerView에 셋팅
        intentView.setAdapter(new IntentAdapter(getActivity(), Manager.getIntentList()));

        return view;
    }
}
