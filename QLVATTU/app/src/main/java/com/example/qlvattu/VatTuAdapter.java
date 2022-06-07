package com.example.qlvattu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class VatTuAdapter extends ArrayAdapter<VatTu> {
    private Context context;
    private int resource;
    private List<VatTu> listSV;

    public VatTuAdapter(Context context, int resource, List<VatTu> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listSV = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodel viewHodel;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activitylistvattu,parent,false);
            viewHodel = new ViewHodel();
            viewHodel.tv_id = (TextView) convertView.findViewById(R.id.tvId);
            viewHodel.tv_tenvt = (TextView) convertView.findViewById(R.id.tvtenvattu);
            viewHodel.tv_dongia = (TextView) convertView.findViewById(R.id.tvdongia);
            viewHodel.tv_donvi= (TextView) convertView.findViewById(R.id.tvdonvi);
            viewHodel.tv_hangvt= (TextView) convertView.findViewById(R.id.tvhangsx);
            convertView.setTag(viewHodel);
        }else{
            viewHodel = (ViewHodel) convertView.getTag();
        }
        VatTu vt = listSV.get(position);
        viewHodel.tv_id.setText(String.valueOf(vt.getId()));
        viewHodel.tv_tenvt.setText(vt.getTenvt());
        viewHodel.tv_hangvt.setText(vt.getHangvt());
        viewHodel.tv_dongia.setText(String.valueOf(vt.getDongia()));
        viewHodel.tv_donvi.setText(vt.getDonvi());

        return convertView;
    }

    class ViewHodel {
        private TextView tv_id, tv_tenvt, tv_hangvt, tv_donvi, tv_dongia;

    }
}
