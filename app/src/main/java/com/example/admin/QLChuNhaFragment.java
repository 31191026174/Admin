package com.example.admin;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.admin.mAdapter.lvChuTroAdapter;
import com.example.admin.mDB.DBChuNha;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class QLChuNhaFragment extends Fragment {

    Button btnThem;
    ListView lvChuTro;
    ArrayList<DBChuNha> arrChuTro = new ArrayList<>();
    DatabaseReference mData;
    private ProgressDialog myProgress;


    public QLChuNhaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        Tạo Progress Bar
        myProgress = new ProgressDialog(getContext());
        myProgress.setTitle("Đang tải dữ liệu ...");
        myProgress.setMessage("Xin vui lòng chờ...");
        myProgress.setCancelable(true);

        // Hiển thị Progress Bar
        myProgress.show();
        mData = FirebaseDatabase.getInstance().getReference();
        final View v = inflater.inflate(R.layout.fragment_qlchu_nha, container, false);
        btnThem = (Button) v.findViewById(R.id.btnThemChu);
        lvChuTro = (ListView) v.findViewById(R.id.lv_ChuTro);

        final lvChuTroAdapter customAdapter = new lvChuTroAdapter(getContext(),R.layout.lv_chunha,arrChuTro);
arrChuTro.clear();
        mData.child("ChuTro").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                DBChuNha ChuTro = dataSnapshot.getValue(DBChuNha.class);
                ChuTro.setKeyid(dataSnapshot.getKey());
//                keysList.add(dataSnapshot.getKey());
                arrChuTro.add(ChuTro);
                lvChuTro.setAdapter(customAdapter);
                myProgress.dismiss();
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

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentThemChuTro = new Intent(getActivity(), ThemChuNhaActivity.class);
                startActivity(intentThemChuTro);
            }
        });


        // Inflate the layout for this fragment
        return v;
    }

}
