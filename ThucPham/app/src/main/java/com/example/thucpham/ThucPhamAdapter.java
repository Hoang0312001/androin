package com.example.thucpham;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class ThucPhamAdapter extends ArrayAdapter<ThucPham> {

    private Context context;
    private int resource;
    private List<ThucPham> thucPhamList;

    public ThucPhamAdapter(Context context, int resource, List<ThucPham> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource = resource;
        this.thucPhamList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodel viewHodel;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_listthucpham,parent,false);
            viewHodel = new ViewHodel();
            viewHodel.tvId = (TextView)  convertView.findViewById(R.id.tvid);
            viewHodel.tvname = (TextView) convertView.findViewById(R.id.tvname);
            viewHodel.tvdvt = (TextView) convertView.findViewById(R.id.tvdvt);
            viewHodel.tvdongia = (TextView) convertView.findViewById(R.id.tvdongia);
            convertView.setTag(viewHodel);
        }
        else
            viewHodel = (ViewHodel) convertView.getTag();
        ThucPham thucPham = thucPhamList.get(position);
        viewHodel.tvId.setText("Mã TP: "+String.valueOf(thucPham.getId()));
        viewHodel.tvname.setText("Tên : " + thucPham.getName());
        viewHodel.tvdvt.setText("Họ tên: "+thucPham.getDvt());
        viewHodel.tvdongia.setText("Đơn Gía: "+thucPham.getDongia());
        return convertView;
    }

    class ViewHodel{
        private TextView tvId,tvname, tvdvt,tvdongia;
        private ImageView imgGender;

    }
}
