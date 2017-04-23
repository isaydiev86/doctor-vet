package com.isaydiev.doctor_vet;

import com.isaydiev.doctor_vet.Models.Item;

import java.util.ArrayList;

/**
 * Created by USER on 11.04.2017.
 */

public interface ServiceContract {
    interface View{
        void showServicesList(ArrayList<Item> servicesList);
        void showError(String message);
    }
    interface Presenter{
        void loadServiceList();
    }
}
