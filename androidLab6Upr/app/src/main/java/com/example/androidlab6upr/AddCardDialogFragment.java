package com.example.androidlab6upr;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class AddCardDialogFragment extends DialogFragment {
    private DialogListener listener;

    public interface DialogListener {
        void onCardAdded(BirthdayCard card);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (DialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement DialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_card, null);

        final EditText etName = dialogView.findViewById(R.id.etName);
        final EditText etAge = dialogView.findViewById(R.id.etAge);
        final EditText etMessage = dialogView.findViewById(R.id.etMessage);
        Button btnAdd = dialogView.findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String age = etAge.getText().toString();
                String message = etMessage.getText().toString();

                BirthdayCard card = new BirthdayCard(name, age, message);

                listener.onCardAdded(card);

                dismiss();
            }
        });

        builder.setView(dialogView);
        return builder.create();
    }

}