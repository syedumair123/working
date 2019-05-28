package com.example.mymosque.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.mymosque.DuaDetailScreen;
import com.example.mymosque.R;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class AdapterDua extends RecyclerView.Adapter<AdapterDua.ReyclerViewHolder> {
    String Filepath,Filename;
    String audio_url;
    SharedPreferences.Editor editor;
    Context context;
    ArrayList<Dua> duaList;

public AdapterDua(Context context,ArrayList<Dua> duaList){
    this.context=context;
    this.duaList=duaList;

}
    @NonNull
    @Override
    public AdapterDua.ReyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_item_dua, viewGroup, false);
        return new ReyclerViewHolder(v);

    }



    @Override
    public void onBindViewHolder(@NonNull AdapterDua.ReyclerViewHolder reyclerViewHolder, int i) {
Dua dua=duaList.get(i);
reyclerViewHolder.Title_.setText(dua.getname());
reyclerViewHolder.DuaNumber.setText(String.valueOf(dua.getD_id()));
Filepath=dua.getFile_path();
Filename=dua.getFile_name();
audio_url="http://masjidi.co.uk/"+ Filepath + Filename;
//setting on click listener in layout to show detail screen layout
reyclerViewHolder.Layout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //put dua detail screen content into shared preference and call intent
editor=editor = context.getSharedPreferences("DuaDataPass", MODE_PRIVATE).edit();
        editor.putString("Title",dua.getname());
        editor.putString("DuaNumber", String.valueOf(dua.getD_id()));
        editor.putString("TextDua", dua.getDiscription());
        editor.putString("TextDuaTranslation", dua.getDiscriptionArbic());
        editor.putString("AudioUrl","http://masjidi.co.uk/"+dua.getFile_path()+ dua.getFile_name());
        editor.apply();
        Intent intent = new Intent(context, DuaDetailScreen.class);
        context.startActivity(intent);
    }
});


    }

    @Override
    public int getItemCount() {
        return duaList.size();
    }


    public class ReyclerViewHolder extends RecyclerView.ViewHolder {

        TextView DuaNumber,Title_,Text_Dua_,Text_Translate_;

        RelativeLayout Layout;



        public ReyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            DuaNumber=(TextView) itemView.findViewById(R.id.Txt_Number_);
            Title_=(TextView) itemView.findViewById(R.id.Txt_Title);
            Layout=itemView.findViewById(R.id.dua_layout_);

        }





        }
//making filtered list for searching duas
    public void filterList(ArrayList<Dua> filteredList) {
        duaList = filteredList;
        notifyDataSetChanged();
    }


    }
