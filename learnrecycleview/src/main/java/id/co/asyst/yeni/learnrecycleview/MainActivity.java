package id.co.asyst.yeni.learnrecycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import id.co.asyst.yeni.learnrecycleview.adapter.AlbumAdapter;
import id.co.asyst.yeni.learnrecycleview.model.AlbumModel;
import id.co.asyst.yeni.learnrecycleview.retrofit.ApiClient;
import id.co.asyst.yeni.learnrecycleview.retrofit.ApiServices;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    RecyclerView recylerView;
    AlbumAdapter albumAdapter;
    ArrayList<AlbumModel> listAlbum = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recylerView = findViewById(R.id.recycler_view);

        /*for (int i=0; i<10; i++){
            AlbumModel albumModel = new AlbumModel();
            albumModel.setTitle("Title" +i);
            albumModel.setArtis("Artis" +i);
            albumModel.setImage("https://images-na.ssl-images-amazon.com/images/I/61McsadO1OL.jpg");

            listAlbum.add(albumModel);
        }*/


//        albumAdapter = new AlbumAdapter(this, listAlbum);
        albumAdapter = new AlbumAdapter(this, listAlbum, new AlbumAdapter.onItemClickListener() {
            @Override
            public void onItemClickListener(AlbumModel albumModel) {
                Toast.makeText(getApplicationContext(), albumModel.getTitle(), Toast.LENGTH_SHORT).show();

            }
        });

        RecyclerView.LayoutManager LayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recylerView.setLayoutManager(LayoutManager);
        recylerView.setItemAnimator(new DefaultItemAnimator());
        recylerView.setAdapter(albumAdapter);

//        getDataWithVolley();
        getDataWithRetrofit();

    }


//GET DATA PAKAI VOLLEY
//    public  void getDataWithVolley(){
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//
//        String url ="http://rallycoding.herokuapp.com/api/music_albums";
//
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//
//                Log.d("Response", response.toString());
//
//                try{
//                    for (int i=0; i<response.length();i++){
//
//                        AlbumModel albumModel = new Gson().fromJson(response.getString(i), AlbumModel.class);
//                        listAlbum.add(albumModel);
//                    }
//
//                    albumAdapter.notifyDataSetChanged();
//
//                }catch (JSONException e){
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        requestQueue.add(jsonArrayRequest);
//    }

    // GET DATA PAKAI RETROFIT
    public void getDataWithRetrofit() {
        ApiServices apiServices = ApiClient.newInstance(getApplicationContext()).create(ApiServices.class);

        Call<ArrayList<AlbumModel>> call = apiServices.getAlbums();

        call.enqueue(new Callback<ArrayList<AlbumModel>>() {
            @Override
            public void onResponse(Call<ArrayList<AlbumModel>> call, retrofit2.Response<ArrayList<AlbumModel>> response) {
                if (response.body() != null) {
                    if (response.body().size() > 0) {
                        listAlbum.addAll(response.body());

                        albumAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<AlbumModel>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
