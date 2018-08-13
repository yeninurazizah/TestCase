package id.co.asyst.yeni.learnrecycleview.retrofit;

import java.util.ArrayList;

import id.co.asyst.yeni.learnrecycleview.model.AlbumModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {
    @GET("music_albums")
    Call<ArrayList<AlbumModel>> getAlbums();
//    Call<ArrayList<AlbumModel>> getAlbums(@Query("id") String id);
}
