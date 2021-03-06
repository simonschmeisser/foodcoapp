package org.baobab.foodcoapp.fragments;


import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.baobab.foodcoapp.R;

public abstract class TextDialogFragment extends DialogFragment {

    private final String value;
    private final String msg;
    private EditText text;

    public TextDialogFragment(String msg, String value) {
        this.value = value;
        this.msg = msg;
    }

    @Override
    public View onCreateView(LayoutInflater flate, ViewGroup container, Bundle savedInstanceState) {
        return flate.inflate(R.layout.fragment_dialog_text, null, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((TextView) view.findViewById(R.id.message)).setText(msg);
        text = (EditText) view.findViewById(R.id.text);
        text.setText(value);
        text.requestFocus();
        text.selectAll();
        text.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                finish();
                return true;
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ((InputMethodManager) getActivity()
                .getSystemService(Context.INPUT_METHOD_SERVICE))
                .showSoftInput(text, InputMethodManager.SHOW_FORCED);
    }

    @Override
    public void onResume() {
        super.onResume();
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (getResources().getConfiguration().hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO) {
            Toast.makeText(getActivity(), "Switch hardware keyboard OFF", Toast.LENGTH_LONG).show();
            imm.showInputMethodPicker();
        } else {
            imm.showSoftInput(text, InputMethodManager.SHOW_FORCED);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        ((InputMethodManager) getActivity()
                .getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(text.getWindowToken(), 0);
    }

    private void finish() {
        onText(text.getText().toString());
        getFragmentManager().popBackStack();
        ((InputMethodManager) getActivity()
                .getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(text.getWindowToken(), 0);
    }

    public abstract void onText(String text);
}
