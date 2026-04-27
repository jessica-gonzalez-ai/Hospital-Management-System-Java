package Hospital;

import java.io.Serializable;

public class Doctor extends Persona implements Serializable {

    //CAMPOS
    private String especialidad;

    //CONSTRUCTOR DEFAULT
    public Doctor() {
        super();
    }

    //CONSTRUCTOR PARAMETRIZADO
    public Doctor(String nombre, int edad, String id, String especialidad) {
        super(nombre, edad, id);
        this.especialidad = especialidad;
    }

    //GETTERS Y SETTERS
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    //METODOS
    @Override
    public void mostrarDatos() {
        System.out.println("Doctor: " + getNombre() + ", Edad: " + getEdad() + ", ID: " + getId() + ", Especialidad: " + especialidad);
    }

    @Override
    public String toString() {
        return getNombre() + " (" + getId() + ")";
    }
}

