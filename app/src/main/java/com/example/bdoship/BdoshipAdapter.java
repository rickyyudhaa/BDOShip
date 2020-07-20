package com.example.bdoship;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class BdoshipAdapter extends RecyclerView.Adapter{

    class BdoshipHolder extends RecyclerView.ViewHolder{
        private ImageView imageViewIcon;
        private TextView textViewShiptype;
        private TextView textViewSpeed;
    }
}
