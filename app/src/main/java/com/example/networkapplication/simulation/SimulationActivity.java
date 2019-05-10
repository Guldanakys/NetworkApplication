package com.example.networkapplication.simulation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.networkapplication.OnItemClickListener;
import com.example.networkapplication.R;
import com.example.networkapplication.adapters.DeviceAdapter;
import com.example.networkapplication.models.Device;

import java.util.ArrayList;
import java.util.List;

public class SimulationActivity extends AppCompatActivity implements OnItemClickListener {

    private DeviceAdapter mDeviceAdapter;
    private RecyclerView mDeviceRecycler;
    private List<Device> mDeviceList;

    private GestureDetector mGestureDetector;
    private List<Device> mSimulationDeviceList;
    private RelativeLayout mSimulationLayout;
    private int xDelta;
    private int yDelta;
    private Device mDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation);

        mGestureDetector = new GestureDetector(this, new SingleTapConfirm());
        mSimulationLayout = (RelativeLayout) findViewById(R.id.simulation_layout);

        initUI();
        initDeviceList();
    }

    private void initUI() {
        mDeviceRecycler = (RecyclerView) findViewById(R.id.device_recycler);
        mDeviceRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mDeviceList = new ArrayList<>();
        mSimulationDeviceList = new ArrayList<>();
        mDeviceAdapter = new DeviceAdapter(mDeviceList);
        mDeviceAdapter.setItemClickListener(this);
        mDeviceRecycler.setAdapter(mDeviceAdapter);
    }

    private void initDeviceList() {
        mDeviceList.add(new Device(1, "Laptop", R.drawable.ic_laptop));
        mDeviceList.add(new Device(2, "Switch", R.drawable.ic_switch));
        mDeviceList.add(new Device(3, "Router", R.drawable.ic_router));
        mDeviceList.add(new Device(4, "Cable", R.drawable.ic_cable));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            final int X = (int) event.getRawX();
            final int Y = (int) event.getRawY();

            if (mGestureDetector.onTouchEvent(event)) {
                mDevice = ((Device) v.getTag());
                Toast.makeText(SimulationActivity.this, mDevice.getName(), Toast.LENGTH_SHORT).show();
                return true;
            } else {
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
                        xDelta = X - lParams.leftMargin;
                        yDelta = Y - lParams.topMargin;
                        break;
                    case MotionEvent.ACTION_UP:
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

    @Override
    public void onItemClick(int position, int id) {
        final Device device = mDeviceList.get(position);
        addDevice(device);
    }

    private void addDevice(Device device) {
        int id = mSimulationDeviceList.size() + 1;
        Device simDev = new Device(id, device.getName() + id, device.getImageId());
        mSimulationDeviceList.add(simDev);
        ImageButton newDeviceImage = new ImageButton(SimulationActivity.this);
        newDeviceImage.setTag(simDev);
        newDeviceImage.setBackgroundResource(device.getImageId());
        newDeviceImage.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT));
        newDeviceImage.setOnTouchListener(onTouchListener);
        mSimulationLayout.addView(newDeviceImage);
    }

    private class SingleTapConfirm extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onSingleTapUp(MotionEvent event) {
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            return true;
        }
    }
}
