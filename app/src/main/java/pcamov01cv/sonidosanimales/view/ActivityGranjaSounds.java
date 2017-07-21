package pcamov01cv.sonidosanimales.view;

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

public class ActivityGranjaSounds extends AppCompatActivity {

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

        SounsdAdapter sounsdAdapter = new SounsdAdapter(sonidos_granja(), R.layout.cardview_animals, this);
            productoRecycler.setAdapter(sounsdAdapter);
    }


    public ArrayList<Animal> sonidos_granja() {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal(R.drawable.caballo, "Caballo", R.raw.caballo));
        animals.add(new Animal(R.drawable.asno, "Asno", R.raw.asno));
        animals.add(new Animal(R.drawable.gallina, "Gallina", R.raw.gallina));
        animals.add(new Animal(R.drawable.gallo, "Gallo", R.raw.gallo));
        animals.add(new Animal(R.drawable.vaca, "Vaca", R.raw.vaca));
        animals.add(new Animal(R.drawable.cerdo, "Cerdo", R.raw.cerdo));
        return animals;
    }


    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
