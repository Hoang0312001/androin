package com.example.nguyensyhoang_08d4800079;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class VTAdapter extends ArrayAdapter<cvantai> {
    private Context context;
    private int resource;
    private List<cvantai> listVanTai;

    public VTAdapter(Context context, int resource, List<cvantai> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listVanTai = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodel viewHodel;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activitylistvt,parent,false);
            viewHodel = new ViewHodel();

            viewHodel.tv_bienks = (TextView) convertView.findViewById(R.id.tvbks);
            viewHodel.tv_tenchuxe = (TextView) convertView.findViewById(R.id.tvtenchuxe);
            viewHodel.tv_hangxe= (TextView) convertView.findViewById(R.id.tvhangxe);
            viewHodel.tv_trongtai= (TextView) convertView.findViewById(R.id.tvtrongtai);
            viewHodel.tv_hdkd= (TextView) convertView.findViewById(R.id.tvhinhthuckd);

            convertView.setTag(viewHodel);
        }else{
            viewHodel = (ViewHodel) convertView.getTag();
        }
        cvantai vt = listVanTai.get(position);

        viewHodel.tv_bienks.setText(vt.getBienks());
        viewHodel.tv_tenchuxe.setText(vt.getTenchuxe());
        viewHodel.tv_hangxe.setText(String.valueOf(vt.getHangxe()));
        viewHodel.tv_trongtai.setText(String.valueOf(vt.getTrongtai()));
        viewHodel.tv_hdkd.setText(vt.getHdkd());
        return convertView;
    }

    class ViewHodel {
        private TextView tv_id, tv_bienks, tv_tenchuxe, tv_hangxe, tv_trongtai,tv_hdkd;

    }
}
