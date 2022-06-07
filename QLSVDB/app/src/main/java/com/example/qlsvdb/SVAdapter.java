package com.example.qlsvdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;

public class SVAdapter extends ArrayAdapter<sinhvien> {
    private Context context;
    private int resource;
    private List<sinhvien> listSV;

    public SVAdapter(Context context, int resource, List<sinhvien> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listSV = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodel viewHodel;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_listsv,parent,false);
            viewHodel = new ViewHodel();
            viewHodel.tv_id = (TextView) convertView.findViewById(R.id.tvId);
            viewHodel.tv_hoten = (TextView) convertView.findViewById(R.id.tvFullName);
            viewHodel.tv_lop = (TextView) convertView.findViewById(R.id.tvClass);
            viewHodel.tv_sdt= (TextView) convertView.findViewById(R.id.tvPhone);
            viewHodel.tv_diachi= (TextView) convertView.findViewById(R.id.tvAddress);
            convertView.setTag(viewHodel);
        }else{
            viewHodel = (ViewHodel) convertView.getTag();
        }
        sinhvien sv = listSV.get(position);
        viewHodel.tv_id.setText(String.valueOf(sv.getId()));
        viewHodel.tv_hoten.setText(sv.getHoten());
        viewHodel.tv_lop.setText(sv.getLop());
        viewHodel.tv_sdt.setText(sv.getSdt());
        viewHodel.tv_diachi.setText(sv.getDiachi());

        return convertView;
    }

    class ViewHodel {
        private TextView tv_id, tv_hoten, tv_lop, tv_diachi, tv_sdt;

    }
}
