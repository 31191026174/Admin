package com.example.admin.mAdapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.R;
import com.example.admin.mDB.DBChuNha;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class lvChuTroAdapter extends ArrayAdapter<DBChuNha> {
    private Context context;
    private int resource;
    private List<DBChuNha> arrChuTro;
    DatabaseReference mData;

    public lvChuTroAdapter(Context context, int resource, ArrayList<DBChuNha> arrChuTro) {
        super(context, resource, arrChuTro);
        this.context = context;
        this.resource = resource;
        this.arrChuTro = arrChuTro;
    }

public View getView(final int position, View convertView, ViewGroup parent){
    ViewHolder viewHolder;
    mData = FirebaseDatabase.getInstance().getReference();
    if (convertView == null) {
        convertView = LayoutInflater.from(context).inflate(R.layout.lv_chunha, parent, false);
        viewHolder = new ViewHolder();
        viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvNameCT);
        viewHolder.tvAddress = (TextView) convertView.findViewById(R.id.tvDiaChiCT);
        viewHolder.imgavatar = (ImageView) convertView.findViewById(R.id.imgAvatarlv);
//      viewHolder.tvAvatar = (TextView) convertView.findViewById(R.id.tvAvatarCT);

        convertView.setTag(viewHolder);
    } else {
        viewHolder = (ViewHolder) convertView.getTag();
    }
    DBChuNha dbChuTro = arrChuTro.get(position);
//    viewHolder.tvAvatar.setBackgroundColor(dbChuTro.getColor());
//    viewHolder.tvAvatar.setText(String.valueOf(position+1));
    viewHolder.tvName.setText(dbChuTro.getName());
    viewHolder.tvAddress.setText(dbChuTro.getAddess());

    String avatar = dbChuTro.getAvatar();

        byte[] decodedString = Base64.decode(avatar, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        viewHolder.imgavatar.setImageBitmap(decodedByte);



//    viewHolder.btnXoa.setOnClickListener(new View.OnClickListener() {
//
//        @Override
//        public void onClick(View arg0) {
//            // TODO Auto-generated method stub
//            // trong vi du nay de don gian minh chi log data ra logcat
//            // trong truong hop thuc te cac ban co the xu ly tuy theo yeu cau cua app
//        }
//    });


    return convertView;
}

    public class ViewHolder {
        ImageView imgavatar;
        TextView tvName, tvAddress;
        Button btnXoa;

    }
}
