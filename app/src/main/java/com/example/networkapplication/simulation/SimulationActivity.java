package com.example.networkapplication.simulation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.networkapplication.OnItemClickListener;
import com.example.networkapplication.R;
import com.example.networkapplication.adapters.DeviceAdapter;
import com.example.networkapplication.models.Coordinate;
import com.example.networkapplication.models.Device;

import java.util.ArrayList;
import java.util.List;

public class SimulationActivity extends AppCompatActivity implements OnItemClickListener, GuiDialogListener {

    private DeviceAdapter mDeviceAdapter;
    private RecyclerView mDeviceRecycler;
    private List<Device> mDeviceList;

    private GestureDetector mGestureDetector;
    private List<Device> mSimulationDeviceList;
    private RelativeLayout mSimulationLayout;
    private int xDelta;
    private int yDelta;
    private Device mDevice;

    private Button mPingButton;
    private ImageView mPingView;

    private float mStartX;
    private float mStartY;
    private List<Coordinate> mCoordinateList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation);

        initUI();

        initDeviceList();
    }

    private void initUI() {
        mDeviceRecycler = (RecyclerView) findViewById(R.id.device_recycler);
        mDeviceRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mDeviceList = new ArrayList<>();
        mSimulationDeviceList = new ArrayList<>();
        mCoordinateList = new ArrayList<>();
        mDeviceAdapter = new DeviceAdapter(mDeviceList);
        mDeviceAdapter.setItemClickListener(this);
        mDeviceRecycler.setAdapter(mDeviceAdapter);
        mGestureDetector = new GestureDetector(this, new SingleTapConfirm());
        mSimulationLayout = (RelativeLayout) findViewById(R.id.simulation_layout);
        mPingButton = (Button) findViewById(R.id.ping);
        mPingButton.setOnClickListener(pingListener);
    }

    private void initDeviceList() {
        mDeviceList.add(new Device(1, "Laptop", R.drawable.ic_laptop, ""));
        mDeviceList.add(new Device(2, "Switch", R.drawable.ic_switch, ""));
        mDeviceList.add(new Device(3, "Router", R.drawable.ic_router, ""));
        mDeviceList.add(new Device(4, "Cable", R.drawable.ic_cable, ""));
    }

    private void addDevice(Device device) {
        int id = mSimulationDeviceList.size() + 1;
        Device simulationDevice = new Device(id, device.getName() + id, device.getImageId(), "");
        mSimulationDeviceList.add(simulationDevice);
        ImageButton newDeviceImage = new ImageButton(SimulationActivity.this);
        newDeviceImage.setTag(simulationDevice);
        newDeviceImage.setBackgroundResource(simulationDevice.getImageId());
        newDeviceImage.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT));
        newDeviceImage.setOnTouchListener(onTouchListener);
        mCoordinateList.add(new Coordinate(simulationDevice.getName(), 0f, 0f));
        mSimulationLayout.addView(newDeviceImage);
    }

    private void openGuiDialog() {
        GuiDialog guiDialog = new GuiDialog();

        Bundle bundle = new Bundle();
        bundle.putString("hostname", mDevice.getName());
        bundle.putString("ip_address", mDevice.getIpAddress());
        guiDialog.setArguments(bundle);

        guiDialog.show(getSupportFragmentManager(), "gui dialog");
    }

    private View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            final int X = (int) event.getRawX();
            final int Y = (int) event.getRawY();

            if (mGestureDetector.onTouchEvent(event)) {
                mDevice = ((Device) v.getTag());
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
                        Device device = ((Device) v.getTag());
                        for (Coordinate coordinate : mCoordinateList) {
                            if (coordinate.getHostName().equals(device.getName())) {
                                coordinate.setXLeft(X - xDelta);
                                coordinate.setYTop(Y - yDelta);
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
            mPingView = new ImageView(SimulationActivity.this);
            mPingView.setImageResource(R.drawable.ping_signal);
            mPingView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT));
            mSimulationLayout.addView(mPingView);
            startPing();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mSimulationLayout.removeView(mPingView);
                }
            }, 1200);
        }
    };

    @Override
    public void onItemClick(int position, int id) {
        Device device = mDeviceList.get(position);
        addDevice(device);
    }

    @Override
    public void applyChanges(String hostname, String ipAddress) {
        mDevice.setName(hostname);
        mDevice.setIpAddress(ipAddress);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void startPing() {
        ObjectAnimator rightAnimator = ObjectAnimator
                .ofFloat(mPingView, "x", mCoordinateList.get(0).getXLeft(), mCoordinateList.get(1).getXLeft())
                .setDuration(1000);

        ObjectAnimator downAnimator = ObjectAnimator
                .ofFloat(mPingView, "y", mCoordinateList.get(0).getYTop(), mCoordinateList.get(1).getYTop())
                .setDuration(1000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(rightAnimator, downAnimator);
        animatorSet.start();
    }
}
