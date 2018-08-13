package id.co.asyst.yeni.learnrecycleview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import id.co.asyst.yeni.learnrecycleview.R;
import id.co.asyst.yeni.learnrecycleview.model.AlbumModel;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<AlbumModel> mListAlbum;
    onItemClickListener listener;

    public AlbumAdapter(Context context, ArrayList<AlbumModel> listAlbum) {
        this.mContext = context;
        this.mListAlbum = listAlbum;
    }

    public AlbumAdapter(Context context, ArrayList<AlbumModel> listAlbum, onItemClickListener listener) {
        this.mContext = context;
        this.mListAlbum = listAlbum;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //nampilin viewholder nya

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);

        return new AlbumAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final AlbumModel album = mListAlbum.get(position);

        holder.artisTV.setText(album.getArtis());
        holder.albumTV.setText(album.getTitle());

        RequestOptions requestOptions = new RequestOptions().placeholder(mContext.getResources().getDrawable(R.drawable.ic_error)).error(R.drawable.ic_error);
        Glide.with(mContext).load(album.getImage()).apply(requestOptions).into(holder.albumIV);

        //menfungsikan on click nya
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClickListener(album);
            }
        });
    }

    @Override
    public int getItemCount() {
        //buat nentuin jumlahnya
        return mListAlbum.size();
    }

    public interface onItemClickListener {
        void onItemClickListener(AlbumModel albumModel);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView albumIV;
        TextView albumTV, artisTV;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            albumIV = itemView.findViewById(R.id.album_imgview);
            albumTV = itemView.findViewById(R.id.album_tv);
            artisTV = itemView.findViewById(R.id.artis_tv);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }

}
