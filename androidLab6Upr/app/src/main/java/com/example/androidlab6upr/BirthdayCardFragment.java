package com.example.androidlab6upr;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BirthdayCardFragment extends Fragment {
    private static final String ARG_CARD = "arg_card";

    private BirthdayCard card;

    public static BirthdayCardFragment newInstance(BirthdayCard card) {
        BirthdayCardFragment fragment = new BirthdayCardFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_CARD, card);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            card = (BirthdayCard) getArguments().getSerializable(ARG_CARD);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_birthday_card, container, false);

        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvAge = view.findViewById(R.id.tvAge);
        TextView tvMessage = view.findViewById(R.id.tvMessage);

        tvName.setText(card.getName());
        tvAge.setText(card.getAge());
        tvMessage.setText(card.getMessage());

        return view;
    }

}