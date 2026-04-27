package Hospital;

import java.io.Serializable;

public class Paciente extends Persona implements Serializable {

    //CAMPOS
    private String genero;

    //CONSTRUCTOR DEFAULT
    public Paciente() {
        super();
    }

    //CONSTRUCTOR PARAMETRIZADO
    public Paciente(String nombre, int edad, String id, String genero) {
        super(nombre, edad, id);
        this.genero = genero;
    }

    //GETTERS Y SETTERS
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    //METODOS
    @Override
    public void mostrarDatos() {
        System.out.println("Paciente: " + getNombre() + ", Edad: " + getEdad() + ", ID: " + getId() + ", Género: " + genero);
    }

    @Override
    public String toString() {
        return getNombre() + " (" + getId() + ")";
    }
}

