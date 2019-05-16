package com.example.networkapplication.simulation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.networkapplication.R;

public class GuiDialog extends AppCompatDialogFragment {

    private EditText mGuiHostname;
    private EditText mGuiIpAddress;
    private GuiDialogListener mListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_gui, null);

        builder.setView(view)
                .setTitle("Gui")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String hostname = mGuiHostname.getText().toString();
                        String ipAddress = mGuiIpAddress.getText().toString();
                        mListener.applyChanges(hostname, ipAddress);
                    }
                });

        initUI(view);

        return builder.create();
    }

    private void initUI(View view) {
        mGuiHostname = (EditText) view.findViewById(R.id.gui_hostname);
        mGuiIpAddress = (EditText) view.findViewById(R.id.gui_ip_address);
        mGuiHostname.setText(getArguments().getString("hostname"));
        mGuiIpAddress.setText(getArguments().getString("ip_address"));
        mGuiHostname.setSelection(mGuiHostname.getText().length());
        mGuiIpAddress.setSelection(mGuiIpAddress.getText().length());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (GuiDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement GuiDialogListener");
        }
    }
}
