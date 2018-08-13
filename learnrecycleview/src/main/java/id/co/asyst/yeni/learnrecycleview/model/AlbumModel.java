package id.co.asyst.yeni.learnrecycleview.model;

import com.google.gson.annotations.SerializedName;

public class AlbumModel {

    @SerializedName("artist")
    String artis;
    String title;
    String image;

    public String getArtis() {
        return artis;
    }

    public void setArtis(String artis) {
        this.artis = artis;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
