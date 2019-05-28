package com.example.mymosque.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mymosque.API;
import com.example.mymosque.Adapter.AdapterDua;
import com.example.mymosque.Adapter.Dua;
import com.example.mymosque.Adapter.DuaArrayList;
import com.example.mymosque.Adapter.Links;
import com.example.mymosque.Adapter.LinksArrayList;
import com.example.mymosque.R;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentDua extends Fragment {
TextView search;
    View v;
   RecyclerView recyclerView;
   Links links;
   LinksArrayList linksArrayList=new LinksArrayList();
DuaArrayList dualist= new DuaArrayList();
LinearLayoutManager linearLayoutManager;
AdapterDua dua;
int curr_page=1;
//variables for setting recyclerview
    private int previousTotal = 0;
    private boolean loading = true;
    private int visibleThreshold = 5;
    int firstVisibleItem, visibleItemCount, totalItemCount;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    { //call fetch data funcition and pass it url and page number
        fetch_data("http://masjidi.co.uk/api/",curr_page);
        super.onCreate(savedInstanceState);


    }//end of onCreate method

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_dua, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.RV_DUAS);

linearLayoutManager=new LinearLayoutManager(getContext());
recyclerView.setLayoutManager(linearLayoutManager);
recyclerView.setHasFixedSize(true);
        //<For Toolbar>
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Duas");
        //</For Toolbar>
        search=(TextView) v.findViewById(R.id.search_text);












        return v;
    }//End onCreateView Method
    public void fetch_data(String url,int pagenumber) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        API apiInterface = retrofit.create(API.class);

        Call<DuaArrayList> call = apiInterface.getduas(pagenumber);

        call.enqueue(new Callback<DuaArrayList>() {
            @Override
            public void onResponse(Call<DuaArrayList> call, Response<DuaArrayList> response) {
//save the responce in dua list
                dualist = response.body();
                dua = new AdapterDua(getContext(), dualist.getDuaArrayList());
                recyclerView.setAdapter(dua);
                recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);
//get the current visible item on screen
                        visibleItemCount = recyclerView.getChildCount();
                        //get the total item count from adapter get item count
                        totalItemCount = linearLayoutManager.getItemCount();
                        firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();

                        if (loading) {
                            if (totalItemCount > previousTotal) {
                                loading = false;
                                previousTotal = totalItemCount;
                            }
                        }
                        if (!loading && (totalItemCount - visibleItemCount)
                                <= (firstVisibleItem + visibleThreshold)) {
                            // End has been reached



                        curr_page=curr_page+1;
                        fetch_data("http://masjidi.co.uk/api/",curr_page);

                            loading = true;
                        }
                    }
                });
search.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        filter(s.toString());
    }
});

            }
            public void filter(String Text){

                ArrayList<Dua> filteredList = new ArrayList<>();

                for (Dua item : dualist.getDuaArrayList())
                    if (item.getname().toLowerCase().contains(Text.toLowerCase())) {
                        filteredList.add(item);
                    }

                dua.filterList(filteredList);
            }



            @Override
            public void onFailure(Call<DuaArrayList> call, Throwable t) {

            }



       /* Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(String.valueOf(url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API api=retrofit.create(API.class);
       Call<String> call=api.getduas();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Responsestring", response.body().toString());
                //Toast.makeText()
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString());

                        String jsonresponse = response.body();

                        writeRecycler(jsonresponse);


                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("onEmptyResponse", "Returned empty response");
            }
        });
    }
    private void writeRecycler(String responce) {

        try {
            JSONObject jsonObject = new JSONObject(responce);//getting json object from responce

            //         Log.d("string",name);
            //  Log.d("responcetttt", String.valueOf(jsonObject));


            JSONArray jsonArray = jsonObject.getJSONArray("data");

           Dua dua;

            for (int i = 0; i < jsonArray.length(); i++) {
                dua = new Dua();

                JSONObject dataobj = jsonArray.getJSONObject(i);
                dua.setD_id(dataobj.getInt("d_id"));
                dua.setName(dataobj.getString("name"));

                dua.setFile_path(dataobj.getString("file_path"));
                dua.setFile_name(dataobj.getString("file_name"));
                dua.setDuration(dataobj.getString("duration"));
                dua.setTimestamp(dataobj.getString("timestamp"));
                dua.setDiscription(dataobj.getString("discription"));
                dua.setDiscriptionArbic(dataobj.getString("discriptionArbic"));

                Log.d("infff", String.valueOf(dataobj.getInt("farvoriate")));


                dualist.add(dua);
            }

            AdapterDua adapterDua = new AdapterDua(getContext(), dualist);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(adapterDua);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }}*/
        });
    }}