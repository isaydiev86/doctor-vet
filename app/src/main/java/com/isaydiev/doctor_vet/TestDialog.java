package com.isaydiev.doctor_vet;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by USER on 19.04.2017.
 */

public class TestDialog extends android.support.v4.app.DialogFragment{

    public static void showDialog(Activity activity){
        TestDialog dialog = new TestDialog();

        FragmentTransaction transaction = ((FragmentActivity)activity)
                .getSupportFragmentManager()
                .beginTransaction();
        dialog.show(transaction, "dialog");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_test, container, false);
        return view;
    }
}
