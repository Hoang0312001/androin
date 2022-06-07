package com.example.qlsvp3;

import static com.example.qlsvp2.R.drawable.businessman;
import static com.example.qlsvp2.R.drawable.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
            viewHodel.tv_id = (TextView) convertView.findViewById(R.id.tvmnv);
            viewHodel.tv_hoten = (TextView) convertView.findViewById(R.id.tvFullName);
            viewHodel.tv_img = (ImageView) convertView.findViewById(R.id.imgGender);
            viewHodel.tv_email= (TextView) convertView.findViewById(R.id.tvemail);
            viewHodel.tv_phone= (TextView) convertView.findViewById(R.id.tvphone);
            convertView.setTag(viewHodel);
        }else{
            viewHodel = (ViewHodel) convertView.getTag();
        }
        sinhvien sv = listSV.get(position);
        viewHodel.tv_id.setText(String.valueOf(sv.getId()));
        viewHodel.tv_hoten.setText(sv.getHoten());
        viewHodel.tv_email.setText(sv.getEmail());
        viewHodel.tv_phone.setText(sv.getPhone());
        if(sv.getImg().equals("Nam"))
            viewHodel.tv_img.setImageResource(businessman);
        else
            viewHodel.tv_img.setImageResource(manager);
        return convertView;
    }

    class ViewHodel {
        private TextView tv_id;
        private TextView tv_hoten;
        private ImageView tv_img;
        private TextView tv_phone;
        private TextView tv_email;

    }
}
