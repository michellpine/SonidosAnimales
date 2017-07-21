package pcamov01cv.sonidosanimales.model;

/**
 * Created by usuario on 17/07/17.
 */

public class ListAnimal {
    private int image;
    private int tipo;
    private String descripcion;

    public ListAnimal(int image, int tipo, String descripcion) {
        this.image = image;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
