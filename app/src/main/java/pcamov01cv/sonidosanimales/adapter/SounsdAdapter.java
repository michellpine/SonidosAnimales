package pcamov01cv.sonidosanimales.adapter;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import pcamov01cv.sonidosanimales.R;
import pcamov01cv.sonidosanimales.model.Animal;
import pcamov01cv.sonidosanimales.view.ActivityShareFacebook;


public class SounsdAdapter extends RecyclerView.Adapter<SounsdAdapter.ProductViewHolder> {

    private ArrayList<Animal> animals;
    private int resource;
    private Activity activity;
    private MediaPlayer mediaPlayer;

    public SounsdAdapter(ArrayList<Animal> animals, int resource, Activity activity) {
        this.animals = animals;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, final int position) {
        final Animal animal = animals.get(position);
        holder.nombre_animal.setText(animal.getAnimal());
        holder.chkSonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(view.getContext(), animal.getSonido());
                if (holder.chkSonido.isChecked()){
                    mediaPlayer.seekTo(0);
                    mediaPlayer.start();
                }else{
                    mediaPlayer.stop();
                }
            }
        });

        Picasso.with(activity).load(animal.getFoto()).into(holder.foto);
        holder.foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ActivityShareFacebook.class);
                intent.putExtra("nombre", animal.getAnimal());
                intent.putExtra("imagen", animal.getFoto());
                intent.putExtra("sonido", animal.getSonido());
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        public ImageView foto;
        public TextView nombre_animal;
        public CheckBox chkSonido;

        public ProductViewHolder(View view) {
            super(view);
            foto          = (ImageView) itemView.findViewById(R.id.cardview_imagen);
            nombre_animal = (TextView) itemView.findViewById(R.id.cardview_animal);
            chkSonido     = (CheckBox) itemView.findViewById(R.id.cardview_sonido);

        }
    }

}

