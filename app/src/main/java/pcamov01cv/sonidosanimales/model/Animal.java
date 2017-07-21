package pcamov01cv.sonidosanimales.model;

import android.media.MediaPlayer;

/**
 * Created by usuario on 18/07/17.
 */

public class Animal {
    private int foto;
    private String animal;
    private int sonido;

    public Animal(int foto, String animal, int sonido) {
        this.foto = foto;
        this.animal = animal;
        this.sonido = sonido;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public int getSonido() {
        return sonido;
    }

    public void setSonido(int sonido) {
        this.sonido = sonido;
    }
}
