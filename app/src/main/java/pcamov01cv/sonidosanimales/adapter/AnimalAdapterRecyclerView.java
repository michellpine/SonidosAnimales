package pcamov01cv.sonidosanimales.adapter;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import pcamov01cv.sonidosanimales.R;
import pcamov01cv.sonidosanimales.model.ListAnimal;
import pcamov01cv.sonidosanimales.view.ActivityBosqueSounds;
import pcamov01cv.sonidosanimales.view.ActivityCasaSounds;
import pcamov01cv.sonidosanimales.view.ActivityGranjaSounds;
import pcamov01cv.sonidosanimales.view.ActivitySelvaSounds;


public class AnimalAdapterRecyclerView extends RecyclerView.Adapter<AnimalAdapterRecyclerView.SoundsViewHolder> {

    private ArrayList<ListAnimal> animals;
    private int resource;
    private Activity activity;

    public AnimalAdapterRecyclerView(ArrayList<ListAnimal> animals, int resource, Activity activity) {
        this.animals = animals;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public SoundsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new SoundsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SoundsViewHolder holder, final int position) {
        final ListAnimal animal = animals.get(position);
        holder.tipo.setText(animal.getTipo());
        holder.descripcion.setText(animal.getDescripcion());
        Picasso.with(activity).load(animal.getImage()).into(holder.photo);
        holder.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                switch (position){
                    case 0:
                        intent =  new Intent(activity, ActivityCasaSounds.class);
                        break;
                    case 1:
                        intent =  new Intent(activity, ActivityGranjaSounds.class);
                        break;
                    case 2:
                        intent =  new Intent(activity, ActivityBosqueSounds.class);
                        break;
                    case 3:
                        intent =  new Intent(activity, ActivitySelvaSounds.class);
                        break;
                }
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class SoundsViewHolder extends RecyclerView.ViewHolder{

        private ImageView photo;
        private TextView tipo;
        private TextView descripcion;

        public SoundsViewHolder(View itemView) {
            super(itemView);
            photo  = (ImageView) itemView.findViewById(R.id.listview_fondo);
            tipo   = (TextView) itemView.findViewById(R.id.listview_tipo);
            descripcion = (TextView) itemView.findViewById(R.id.listview_descripcion);
        }
    }
}
