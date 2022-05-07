package com.example.admin.mAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.admin.R;
import com.example.admin.mDB.PhieuDangKy;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class PhieuDangKyAdapter extends ArrayAdapter<PhieuDangKy> {
    private Context context;
    private int resource;
    private List<PhieuDangKy> arrSinhvien;
    DatabaseReference mData;

    public PhieuDangKyAdapter(Context context, int resource, ArrayList<PhieuDangKy> arrSinhvien) {
        super(context, resource, arrSinhvien);
        this.context = context;
        this.resource = resource;
        this.arrSinhvien = arrSinhvien;
    }

    public View getView(final int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder;
        mData = FirebaseDatabase.getInstance().getReference();
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.lv_tam_tru, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvNameSV);
            viewHolder.tvCmnd = (TextView) convertView.findViewById(R.id.tvMasv);
//            viewHolder.imgavatar = (ImageView) convertView.findViewById(R.id.imgAvatarlv);
//        viewHolder.tvAvatar = (TextView) convertView.findViewById(R.id.tvAvatarCT);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        PhieuDangKy dbsinhvien = arrSinhvien.get(position);
//    viewHolder.tvAvatar.setBackgroundColor(dbChuTro.getColor());
//    viewHolder.tvAvatar.setText(String.valueOf(position+1));
        viewHolder.tvName.setText(dbsinhvien.getHoTen());
        viewHolder.tvCmnd.setText(dbsinhvien.getSoCmnd());

//        String avatar = dbsinhvien.getAvatar();

//        byte[] decodedString = Base64.decode(avatar, Base64.DEFAULT);
//        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
//        viewHolder.imgavatar.setImageBitmap(decodedByte);



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

        TextView tvName, tvCmnd;


    }
}