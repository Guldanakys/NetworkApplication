package com.example.networkapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.networkapplication.OnItemClickListener;
import com.example.networkapplication.R;
import com.example.networkapplication.models.MenuItem;

import java.util.List;

public class MenuItemAdapter extends RecyclerView.Adapter<MenuItemAdapter.MenuItemViewHolder> {

    private List<MenuItem> mMenuItemList;

    private Context mContext;

    private OnItemClickListener mItemClickListener;

    public MenuItemAdapter(Context context, List<MenuItem> menuItems) {
        mContext = context;
        mMenuItemList = menuItems;
    }

    @NonNull
    @Override
    public MenuItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.menu_list_item, viewGroup, false);
        return new MenuItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuItemViewHolder menuItemViewHolder, int i) {
        MenuItem menuItem = mMenuItemList.get(i);
        menuItemViewHolder.bind(menuItem);
    }

    @Override
    public int getItemCount() {
        return mMenuItemList.size();
    }

    public void setClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public class MenuItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mMenuItemTextName;
        private ImageView mMenuItemImage;
        private MenuItem mMenuItem;

        public MenuItemViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            mMenuItemTextName = itemView.findViewById(R.id.menu_item_name);
            mMenuItemImage = itemView.findViewById(R.id.menu_item_image);
        }

        public void bind(MenuItem menuItem) {
            mMenuItem = menuItem;
            mMenuItemTextName.setText(mMenuItem.getName());
            mMenuItemImage.setImageResource(mContext.getResources().getIdentifier(
                    mMenuItem.getImage(), "drawable", mContext.getPackageName()
            ));
        }

        @Override
        public void onClick(View v) {
            mItemClickListener.onItemClick(getAdapterPosition(), mMenuItem.getId());
        }
    }
}
