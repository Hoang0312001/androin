package com.example.hoaqua;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class HoaQuaAdapter extends ArrayAdapter<HoaQua> {
    private Context context;
    private int resource;
    private List<HoaQua> hoaQuaList;

    public HoaQuaAdapter(Context context, int resource, List<HoaQua> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource = resource;
        this.hoaQuaList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodel viewHodel;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_list,parent,false);
            viewHodel = new ViewHodel();
            viewHodel.tvId = (TextView)  convertView.findViewById(R.id.tvid);
            viewHodel.tvname = (TextView) convertView.findViewById(R.id.tvname);
            viewHodel.tvloai = (TextView) convertView.findViewById(R.id.tvloai);
            viewHodel.tvdvt = (TextView) convertView.findViewById(R.id.tvdvt);
            viewHodel.tvdongia = (TextView) convertView.findViewById(R.id.tvdongia);
            viewHodel.tvnoisx = (TextView) convertView.findViewById(R.id.tvsx);

            convertView.setTag(viewHodel);
        }
        else
            viewHodel = (ViewHodel) convertView.getTag();
        HoaQua hoaQua = hoaQuaList.get(position);
        viewHodel.tvId.setText(""+String.valueOf(hoaQua.getId()));
        viewHodel.tvname.setText("Tên : " + hoaQua.getTen());
        viewHodel.tvloai.setText("Loại Qủa : " + hoaQua.getLoai());
        viewHodel.tvdvt.setText("ĐVT: "+hoaQua.getDvt());
        viewHodel.tvdongia.setText("Đơn Gía: "+hoaQua.getDongia());
        viewHodel.tvnoisx.setText("Nơi sx : "+hoaQua.getNoisx());
        return convertView;
    }

    class ViewHodel{
        private TextView tvId,tvname,tvloai, tvdvt,tvdongia,tvnoisx;

    }
}
