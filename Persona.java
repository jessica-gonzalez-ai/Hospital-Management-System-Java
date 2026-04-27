package Hospital;

import java.io.Serializable;

public abstract class Persona implements Serializable {

    //CAMPOS
    private String nombre;
    private int edad;
    private String id;

    //CONSTRUCTOR DEFAULT
    public Persona (){}

    //CONSTRUCTOR PARAMETRIZADO
    public Persona(String nombre, int edad, String id) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
    }

    //GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //METODOS
    public abstract void mostrarDatos();
}
