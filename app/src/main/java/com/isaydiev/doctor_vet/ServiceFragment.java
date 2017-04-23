package com.isaydiev.doctor_vet;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isaydiev.doctor_vet.Models.Item;

import java.util.ArrayList;

public class ServiceFragment extends Fragment implements ServiceContract.View{

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycles_service);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ServicesPresenter presenter = new ServicesPresenter(getContext(), this);
        presenter.loadServiceList();
        return  view;
    }

    @Override
    public void showServicesList(ArrayList<Item> servicesList) {
        ServicesAdapter adapter = new ServicesAdapter(servicesList, getContext());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showError(String message) {
        Log.e("Error", message);
    }
}
