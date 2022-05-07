package com.example.admin;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

;
import com.example.admin.mAdapter.PhieuDangKyAdapter;
import com.example.admin.mDB.PhieuDangKy;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class QLSVFragment extends Fragment {
    ListView lvsinhvien;
    ArrayList<PhieuDangKy> arrsinhvien = new ArrayList<>();
    DatabaseReference mData;

    public QLSVFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mData = FirebaseDatabase.getInstance().getReference();
        final View v = inflater.inflate(R.layout.fragment_ql_tamtru, container, false);
        lvsinhvien = (ListView) v.findViewById(R.id.lv_Sinhvien);

        final PhieuDangKyAdapter customAdapter = new PhieuDangKyAdapter(getContext(),R.layout.lv_tam_tru,arrsinhvien);
        arrsinhvien.clear();
//        arrsinhvien.add(new PhieuDangKy("1", "jdjsđs", "dsfsd", "dsjdska","fsfdsfd","dsfdsfds",));
        mData.child("PhieuDangKy").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

//                DBTamTru SinhVien = dataSnapshot.getValue(DBTamTru.class);
                PhieuDangKy SinhVien = dataSnapshot.getValue(PhieuDangKy.class);
//                SinhVien.setKeyid(dataSnapshot.getKey());
//                keysList.add(dataSnapshot.getKey());
                arrsinhvien.add(SinhVien);
                lvsinhvien.setAdapter(customAdapter);
                customAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


lvsinhvien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), ChiTietSV.class);
        Bundle bundle = new Bundle();
        bundle.putString("ten", arrsinhvien.get(position).getHoTen());
        bundle.putString("diachi", arrsinhvien.get(position).getQueQuan());
        bundle.putString("dt", arrsinhvien.get(position).getNoiDangKyTamTru());
        bundle.putString("masv", arrsinhvien.get(position).getSoCmnd());
        intent.putExtra("chitietsinhvien", bundle);
        startActivity(intent);
    }
});
        // Inflate the layout for this fragment
        return v;
    }

}
