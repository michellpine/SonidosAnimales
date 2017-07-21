package pcamov01cv.sonidosanimales;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import java.util.ArrayList;

import pcamov01cv.sonidosanimales.adapter.AnimalAdapterRecyclerView;
import pcamov01cv.sonidosanimales.model.ListAnimal;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        showToolbar(getResources().getString(R.string.app_name), true);
        RecyclerView picturesRecycler = (RecyclerView) findViewById(R.id.animalRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        AnimalAdapterRecyclerView animalAdapterRecyclerView =
                new AnimalAdapterRecyclerView(listAnimals(), R.layout.listview_animals, this);
        picturesRecycler.setAdapter(animalAdapterRecyclerView);

    }

    private ArrayList<ListAnimal> listAnimals(){
        ArrayList<ListAnimal> animals = new ArrayList<>();
        animals.add(new ListAnimal(R.drawable.ic_casa, R.string.casa, "Animales domésticos, los cuales tenemos en nuestros hogares"));
        animals.add(new ListAnimal(R.drawable.ic_granja, R.string.granja, "Animales domésticos, los cuales producen alimentos"));
        animals.add(new ListAnimal(R.drawable.ic_bosque, R.string.bosque, "Animales salvajes"));
        animals.add(new ListAnimal(R.drawable.ic_selva, R.string.selva, "Animales salvajes"));
        return animals;
    }

    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
    }
}
