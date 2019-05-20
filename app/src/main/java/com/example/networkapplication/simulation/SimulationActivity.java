package com.example.networkapplication.simulation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.networkapplication.DataLab;
import com.example.networkapplication.OnItemClickListener;
import com.example.networkapplication.R;
import com.example.networkapplication.adapters.StandardDeviceAdapter;
import com.example.networkapplication.models.SimulationDevice;
import com.example.networkapplication.models.StandardDevice;

import java.util.ArrayList;
import java.util.List;

public class SimulationActivity extends AppCompatActivity implements OnItemClickListener, GuiDialogListener {

    private StandardDeviceAdapter mStandardDeviceAdapter;
    private RecyclerView mStandardDeviceRecycler;
    private List<StandardDevice> mStandardDeviceList;

    private GestureDetector mGestureDetector;

    private SimulationDevice mCurrentDevice;
    private List<SimulationDevice> mSimulationDeviceList;
    private RelativeLayout mSimulationLayout;

    private int xDelta;
    private int yDelta;
    private EditText mCommand;
    private Button mPingButton;
    private ImageView mPacketView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation);

        initUI();
    }

    private void initUI() {
        mStandardDeviceList = new ArrayList<>();
        mStandardDeviceList = DataLab.get().getStandardDeviceList();
        mStandardDeviceRecycler = (RecyclerView) findViewById(R.id.standard_device_recycler);
        mStandardDeviceRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mStandardDeviceAdapter = new StandardDeviceAdapter(mStandardDeviceList);
        mStandardDeviceAdapter.setItemClickListener(this);
        mStandardDeviceRecycler.setAdapter(mStandardDeviceAdapter);

        mSimulationDeviceList = new ArrayList<>();
        mGestureDetector = new GestureDetector(this, new SingleTapConfirm());
        mSimulationLayout = (RelativeLayout) findViewById(R.id.simulation_layout);
        mCommand = (EditText) findViewById(R.id.command);
        mPingButton = (Button) findViewById(R.id.ping);
        mPingButton.setOnClickListener(pingListener);
    }

    private void addDevice(StandardDevice standardDevice) {
        int id = mSimulationDeviceList.size() + 1;
        SimulationDevice simulationDevice = new SimulationDevice(id,
                standardDevice.getName() + id,
                standardDevice.getImageId(),
                "", "", "", 0, 0);
        mSimulationDeviceList.add(simulationDevice);

        ImageButton newSimulationDevice = new ImageButton(SimulationActivity.this);
        newSimulationDevice.setTag(simulationDevice);
        newSimulationDevice.setBackgroundResource(simulationDevice.getImageId());
        newSimulationDevice.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT));
        newSimulationDevice.setOnTouchListener(onTouchListener);
        mSimulationLayout.addView(newSimulationDevice);
    }

    private void addPacket() {
        mPacketView = new ImageView(SimulationActivity.this);
        mPacketView.setImageResource(R.drawable.ic_envelope);
        mPacketView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT));
        mSimulationLayout.addView(mPacketView);
    }

    private void openGuiDialog() {
        GuiDialog guiDialog = new GuiDialog();
        Bundle bundle = new Bundle();
        bundle.putString("hostname", mCurrentDevice.getName());
        bundle.putString("ip_address", mCurrentDevice.getIpAddress());
        bundle.putString("subnet_mask", mCurrentDevice.getSubnetMask());
        bundle.putString("gateway", mCurrentDevice.getGateway());
        guiDialog.setArguments(bundle);
        guiDialog.show(getSupportFragmentManager(), "gui dialog");
    }

    private View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            final int X = (int) event.getRawX();
            final int Y = (int) event.getRawY();
            mCurrentDevice = ((SimulationDevice) v.getTag());

            if (mGestureDetector.onTouchEvent(event)) {
                openGuiDialog();
                return true;
            } else {
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
                        xDelta = X - lParams.leftMargin;
                        yDelta = Y - lParams.topMargin;
                        break;
                    case MotionEvent.ACTION_UP:
                        for (SimulationDevice simulationDevice : mSimulationDeviceList) {
                            if (simulationDevice.getName().equals(mCurrentDevice.getName())) {
                                simulationDevice.setXLeft(X - xDelta);
                                simulationDevice.setYTop(Y - yDelta);
                            }
                        }
                        break;
                    case MotionEvent.ACTION_POINTER_DOWN:
                        break;
                    case MotionEvent.ACTION_POINTER_UP:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
                        layoutParams.leftMargin = X - xDelta;
                        layoutParams.topMargin = Y - yDelta;
                        layoutParams.rightMargin = -250;
                        layoutParams.bottomMargin = -250;
                        v.setLayoutParams(layoutParams);
                        break;
                }
                mSimulationLayout.invalidate();
            }
            return false;
        }
    };

    private View.OnClickListener pingListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String command = mCommand.getText().toString();
            String[] commands = command.split("\\s+");

            SimulationDevice simulationDeviceStart = new SimulationDevice(1, "", 1, "", "", "", 0f, 0f);
            SimulationDevice simulationDeviceEnd = new SimulationDevice(2, "", 2, "", "", "", 0f, 0f);

            for (SimulationDevice simulationDevice : mSimulationDeviceList) {
                if (commands[0].equals(simulationDevice.getName())) {
                    simulationDeviceStart = simulationDevice;
                }
                if (commands[1].equals(simulationDevice.getIpAddress())) {
                    simulationDeviceEnd = simulationDevice;
                }
            }
            addPacket();
            startPing(simulationDeviceStart, simulationDeviceEnd);


            /*Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mSimulationLayout.removeView(mPacketView);
                }
            }, 1200);*/
        }
    };

    @Override
    public void onItemClick(int position, int id) {
        StandardDevice standardDevice = mStandardDeviceList.get(position);
        addDevice(standardDevice);
    }

    @Override
    public void applyChanges(String hostname, String ipAddress, String subnetMask, String gateway) {
        mCurrentDevice.setName(hostname);
        mCurrentDevice.setIpAddress(ipAddress);
        mCurrentDevice.setSubnetMask(subnetMask);
        mCurrentDevice.setGateway(gateway);
        for (SimulationDevice simulationDevice : mSimulationDeviceList) {
            if (mCurrentDevice.getId() == simulationDevice.getId()) {
                simulationDevice.setName(hostname);
                simulationDevice.setIpAddress(ipAddress);
                simulationDevice.setSubnetMask(subnetMask);
                simulationDevice.setGateway(gateway);
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void startPing(SimulationDevice deviceStart, SimulationDevice deviceEnd) {

        ObjectAnimator rightAnimator = ObjectAnimator
                .ofFloat(mPacketView, "x", deviceStart.getXLeft(), deviceEnd.getXLeft())
                .setDuration(1000);
        rightAnimator.setInterpolator(new AccelerateInterpolator());
        rightAnimator.setRepeatCount(2);

        ObjectAnimator downAnimator = ObjectAnimator
                .ofFloat(mPacketView, "y", deviceStart.getYTop(), deviceEnd.getYTop())
                .setDuration(1000);
        downAnimator.setInterpolator(new AccelerateInterpolator());
        downAnimator.setRepeatCount(2);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(rightAnimator, downAnimator);
        animatorSet.start();
    }
}
