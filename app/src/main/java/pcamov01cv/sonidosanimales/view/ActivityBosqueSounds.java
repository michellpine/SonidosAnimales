package pcamov01cv.sonidosanimales.view;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import pcamov01cv.sonidosanimales.R;
import pcamov01cv.sonidosanimales.adapter.SounsdAdapter;
import pcamov01cv.sonidosanimales.model.Animal;

public class ActivityBosqueSounds extends AppCompatActivity {
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_sounds);
        showToolbar(getResources().getString(R.string.app_name), true);

        RecyclerView productoRecycler = (RecyclerView) findViewById(R.id.soundsRecycler);
        productoRecycler.setHasFixedSize(true);

        GridLayoutManager recycleLayoutManager;
        recycleLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        productoRecycler.setLayoutManager(recycleLayoutManager);
        productoRecycler.setItemAnimator(new DefaultItemAnimator());

        SounsdAdapter sounsdAdapter = new SounsdAdapter(sonidos_bosque(), R.layout.cardview_animals, this);
            productoRecycler.setAdapter(sounsdAdapter);

    }


    public ArrayList<Animal> sonidos_bosque() {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal(R.drawable.buho, "Búho", R.raw.buho));
        animals.add(new Animal(R.drawable.ardilla, "Ardilla", R.raw.ardilla));
        animals.add(new Animal(R.drawable.oso, "Oso", R.raw.oso));
        animals.add(new Animal(R.drawable.rana, "Rana", R.raw.rana));
        animals.add(new Animal(R.drawable.aguila, "Aguila", R.raw.aguila));
        animals.add(new Animal(R.drawable.mono, "Mono", R.raw.mono));
        return animals;
    }


    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
