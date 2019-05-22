package com.example.networkapplication.simulation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.networkapplication.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GuiDialog extends AppCompatDialogFragment implements TextWatcher {

    private EditText mGuiHostName;
    private EditText mGuiIpAddress;
    private EditText mGuiSubnetMask;
    private EditText mGuiGateway;
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
                        String hostname = mGuiHostName.getText().toString();
                        String ipAddress = mGuiIpAddress.getText().toString();
                        String subnetMask = mGuiSubnetMask.getText().toString();
                        String gateway = mGuiGateway.getText().toString();
                        mListener.applyChanges(hostname, ipAddress, subnetMask, gateway);
                    }
                });

        initUI(view);

        return builder.create();
    }

    private void initUI(View view) {
        mGuiHostName = (EditText) view.findViewById(R.id.gui_hostname);
        mGuiIpAddress = (EditText) view.findViewById(R.id.gui_ip_address);
        mGuiSubnetMask = (EditText) view.findViewById(R.id.gui_subnet_mask);
        mGuiGateway = (EditText) view.findViewById(R.id.gui_gateway);

        mGuiHostName.setText(getArguments().getString("hostname"));
        mGuiIpAddress.setText(getArguments().getString("ip_address"));
        mGuiGateway.setText(getArguments().getString("gateway"));

        if (getArguments().getString("subnet_mask").equals("")) {
            mGuiSubnetMask.setText("255.255.255.0");
        } else {
            mGuiSubnetMask.setText(getArguments().getString("subnet_mask"));
        }


        mGuiHostName.setSelection(mGuiHostName.getText().length());
        mGuiIpAddress.setSelection(mGuiIpAddress.getText().length());
        mGuiSubnetMask.setSelection(mGuiSubnetMask.getText().length());
        mGuiGateway.setSelection(mGuiGateway.getText().length());

        mGuiIpAddress.addTextChangedListener(this);
        mGuiSubnetMask.addTextChangedListener(this);
        mGuiGateway.addTextChangedListener(this);
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

    private boolean isValid(String s) {
        String IP_ADDRESS_PATTERN = "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

        Pattern pattern = Pattern.compile(IP_ADDRESS_PATTERN);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    @Override
    public void afterTextChanged(Editable s) {
        String ipAddress = mGuiIpAddress.getText().toString();
        if (!isValid(ipAddress)) {
            mGuiIpAddress.setError("Invalid Ip address");
        }

        String subnetMask = mGuiSubnetMask.getText().toString();
        if(!isValid(subnetMask)) {
            mGuiSubnetMask.setError("Invalid Subnet mask");
        }

        String gateway = mGuiGateway.getText().toString();
        if (!isValid(gateway)) {
            mGuiGateway.setError("Invalid Gateway");
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }
}
