package pcamov01cv.sonidosanimales.view;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;

import pcamov01cv.sonidosanimales.R;
import pcamov01cv.sonidosanimales.adapter.SounsdAdapter;
import pcamov01cv.sonidosanimales.model.Animal;

public class ActivitySelvaSounds extends AppCompatActivity {
    private CheckBox chkSonido;

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

        SounsdAdapter sounsdAdapter = new SounsdAdapter(sonidos_selva(), R.layout.cardview_animals, this);
            productoRecycler.setAdapter(sounsdAdapter);

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.tigre);

    }


    public ArrayList<Animal> sonidos_selva() {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal(R.drawable.leon, "Leon", R.raw.leon));
        animals.add(new Animal(R.drawable.tigre, "Tigre", R.raw.tigre));
        animals.add(new Animal(R.drawable.elefante, "Elefante", R.raw.elefante));
        animals.add(new Animal(R.drawable.lobo, "Lobo", R.raw.lobo));
        animals.add(new Animal(R.drawable.gorilla, "Gorila", R.raw.gorilla));
        animals.add(new Animal(R.drawable.serpiente, "Serpiente", R.raw.serpiente));
        return animals;
    }

    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
