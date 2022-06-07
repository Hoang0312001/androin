package com.example.nguyensyhoang_08dcntt1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class MayTinhAdapter extends ArrayAdapter<MayTinh> {

    private Context context;
    private int resource;
    private List<MayTinh> mayTinhList;

    public MayTinhAdapter(Context context, int resource, List<MayTinh> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource = resource;
        this.mayTinhList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodel viewHodel;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_listmaytinh,parent,false);
            viewHodel = new ViewHodel();
            viewHodel.tvId = (TextView)  convertView.findViewById(R.id.tvid);
            viewHodel.tvname = (TextView) convertView.findViewById(R.id.tvname);
            viewHodel.tvloaimt = (TextView) convertView.findViewById(R.id.tvloaimt);
            viewHodel.tvnamsx = (TextView) convertView.findViewById(R.id.tvnamsx);
            viewHodel.tvhangsx = (TextView) convertView.findViewById(R.id.tvhangsx);
            viewHodel.tvdongia = (TextView) convertView.findViewById(R.id.tvdongia);
            viewHodel.tvsl = (TextView) convertView.findViewById(R.id.tvsoluong);
            convertView.setTag(viewHodel);
        }
        else
            viewHodel = (ViewHodel) convertView.getTag();
        MayTinh mayTinh = mayTinhList.get(position);
        viewHodel.tvId.setText("Mã MT: "+ mayTinh.getMamt());
        viewHodel.tvname.setText("Tên : " + mayTinh.getTenmt());
        viewHodel.tvloaimt.setText("Họ tên: "+mayTinh.getLoaimt());
        viewHodel.tvnamsx.setText("Namsx: "+mayTinh.getNamsx());
        viewHodel.tvhangsx.setText("Hangsx: "+mayTinh.getHangsx());
        viewHodel.tvdongia.setText("Đơn Gia: "+mayTinh.getDongia());
        viewHodel.tvsl.setText("So Luong: "+ mayTinh.getSoluong());
        return convertView;
    }
    class ViewHodel{
        private TextView tvId,tvname,tvloaimt,tvnamsx,tvhangsx,tvdongia,tvsl;

    }
}
