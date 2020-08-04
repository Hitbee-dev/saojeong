package com.example.saojeong.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saojeong.R;
import com.example.saojeong.adapter.VegetableCloseAdapter;
import com.example.saojeong.adapter.VegetableOpenAdapter;
import com.example.saojeong.model.ContactVegetableClose;
import com.example.saojeong.model.ContactVegetableOpen;
import com.example.saojeong.model.RecyclerDecoration;

import java.util.ArrayList;

public class VegetableFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private RecyclerView recyclerVegetableopen;
    private RecyclerView recyclerVegetableclose;
    private VegetableOpenAdapter vegetableOpenAdapter;
    private VegetableCloseAdapter vegetableCloseAdapter;
    ArrayList<ContactVegetableOpen> contactVegetableOpens;
    ArrayList<ContactVegetableClose> contactVegetableCloses;

    TextView selectedText;
    Spinner spinner_vegetable;
    String[] item_vegetable;

    RecyclerDecoration.BottomDecoration bottomDecoration = new RecyclerDecoration.BottomDecoration(50);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentManager = getChildFragmentManager();
        transaction = fragmentManager.beginTransaction();

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_vegetable, container, false);

        //순서 나열 Spinner
        selectedText = (TextView) rootView.findViewById(R.id.selected_vegetable);
        spinner_vegetable = (Spinner) rootView.findViewById(R.id.spinner_vegetable);

        item_vegetable = new String[]{"평점 높은 순", "평점 많은 순", "이름 순"};
        ArrayAdapter<String> adapter_vegetableopen = new ArrayAdapter<String >(getContext(), android.R.layout.simple_spinner_item, item_vegetable);
        adapter_vegetableopen.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_vegetable.setAdapter(adapter_vegetableopen);

        //과일동 오픈가게 Recycler View
        recyclerVegetableopen = (RecyclerView) rootView.findViewById(R.id.recyclervegetableopen_fragment);
        contactVegetableOpens = ContactVegetableOpen.createContactsList(5);
        vegetableOpenAdapter = new VegetableOpenAdapter(contactVegetableOpens);
        recyclerVegetableopen.addItemDecoration(bottomDecoration);
        recyclerVegetableopen.setLayoutManager((new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false)));
        recyclerVegetableopen.setAdapter(vegetableOpenAdapter);

        //과일동 닫은가게 Recycler View
        recyclerVegetableclose = (RecyclerView) rootView.findViewById(R.id.recyclervegetableclose_fragment);
        contactVegetableCloses = ContactVegetableClose.createContactsList(3);
        vegetableCloseAdapter = new VegetableCloseAdapter(contactVegetableCloses);
        recyclerVegetableclose.addItemDecoration(bottomDecoration);
        recyclerVegetableclose.setLayoutManager((new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false)));
        recyclerVegetableclose.setAdapter(vegetableCloseAdapter);



        return rootView;

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        selectedText.setText(item_vegetable[i]);
        if(selectedText.getText().toString().equals("선택하세요")) {
            selectedText.setText("");

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        selectedText.setText("");

    }
}