package com.fcodex.ecommerce.NavFragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.fcodex.ecommerce.Activities.AddressActivity;
import com.fcodex.ecommerce.Activities.CardPaymentActivity;
import com.fcodex.ecommerce.Activities.SelectedCartActivity;
import com.fcodex.ecommerce.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class OrdersFragment extends Fragment {

    private View view;
    private MaterialButton order_again;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_orders, container, false);

        id();
        onclick();
        return view;
    }

    private void onclick() {
        order_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialAlertDialogBuilder(getContext())
                        .setTitle("Payment Method")
                        .setMessage("Please select your payment method")
                        .setPositiveButton("Hand Cash", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getContext(), AddressActivity.class));
                                getActivity().finish();

                            }
                        })
                        .setNegativeButton("ATM Card", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                                alertDialog.setTitle("Select Method");
                                String[] items = {"Jazz Cash","EasyPaisa","Google Pay","PayPal","Payoneer", "Visa/Masterd Card"};
                                int checkedItem = 1;
                                alertDialog.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        switch (which) {
                                            case 0:
                                                startActivity(new Intent(getContext(), CardPaymentActivity.class));
                                                break;
                                            case 1:
                                                startActivity(new Intent(getContext(), CardPaymentActivity.class));
                                                break;
                                            case 2:
                                                startActivity(new Intent(getContext(), CardPaymentActivity.class));
                                                break;
                                            case 3:
                                                startActivity(new Intent(getContext(), CardPaymentActivity.class));
                                                break;
                                            case 4:
                                                startActivity(new Intent(getContext(), CardPaymentActivity.class));
                                                break;

                                            case 5:
                                                startActivity(new Intent(getContext(), CardPaymentActivity.class));
                                                break;
                                        }
                                    }
                                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                });
                                AlertDialog alert = alertDialog.create();
                                alert.setCanceledOnTouchOutside(false);
                                alert.show();

                            }
                        })
                        .show();
            }
        });
    }

    private void id() {
        order_again=view.findViewById(R.id.order_again);
    }
}