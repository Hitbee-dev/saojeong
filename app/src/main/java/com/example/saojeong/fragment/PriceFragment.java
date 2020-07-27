package com.example.saojeong.fragment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saojeong.MainActivity;
import com.example.saojeong.R;
import com.example.saojeong.adapter.ChartAdapter;
import com.example.saojeong.model.ChartContact;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;

public class PriceFragment extends Fragment {

    private List<ChartContact> mChartContact;
    ChartAdapter mAdapter;


    ImageView mFrult;
    ImageView mVegetable;
    ImageView mFish;
    EditText mShopSearch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_price, container, false);

        mFrult=view.findViewById(R.id.iv_price_btn_fruit_price);
        mVegetable=view.findViewById(R.id.iv_price_btn_vegetable_price);
        mFish=view.findViewById(R.id.iv_price_btn_fish_price);
        mShopSearch=view.findViewById(R.id.et_price_shopsearch);


        mFrult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(int i=0; i<4; ++i)
                {
                    ArrayList<Entry> list_ChartValue1= new ArrayList<>();
                    Entry entry1 = new Entry(i, 1000+i*20);
                    list_ChartValue1.add(entry1);
                }
            }
        });

        mVegetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mFish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mShopSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //Enter key Action
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    //Enter키눌렀을떄 처리
                    return true;
                }
                return false;
            }
        });



        RecyclerView mRecyclerView = view.findViewById(R.id.chartview);
        //Line_Chartmini =new ArrayList<>();
        mChartContact=new ArrayList<>();
        ArrayList<Entry> list_ChartValue= new ArrayList<>();
        //그래프에 들어갈 좌표값 입력
        for(int i=0; i<4; ++i)
        {
            Entry entry1 = new Entry(i, 1000+i*20);
            list_ChartValue.add(entry1);
        }

        for(int i=0; i<4; ++i)
        {
            mChartContact.add(new ChartContact(i+"100", list_ChartValue));
        }

        mAdapter = new ChartAdapter(this.getContext(), mChartContact);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        return view;
    }


}


