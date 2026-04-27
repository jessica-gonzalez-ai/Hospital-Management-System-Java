package Hospital;

import java.io.*;
import java.util.ArrayList;

public class GestorDatos {

    private static final String ARCHIVO_PACIENTES = "pacientes.dat";
    private static final String ARCHIVO_DOCTORES = "doctores.dat";
    private static final String ARCHIVO_CONSULTAS = "consultas.dat";

    //PACIENTES

    public static ArrayList<Paciente> cargarPacientes() {
        return cargarDatos(ARCHIVO_PACIENTES);
    }

    public static void guardarPacientes(ArrayList<Paciente> pacientes) {
        guardarDatos(pacientes, ARCHIVO_PACIENTES);
    }

    //DOCTORES

    public static ArrayList<Doctor> cargarDoctores() {
        return cargarDatos(ARCHIVO_DOCTORES);
    }

    public static void guardarDoctores(ArrayList<Doctor> doctores) {
        guardarDatos(doctores, ARCHIVO_DOCTORES);
    }

    //CONSULTAS

    public static ArrayList<Consulta> cargarConsultas() {
        return cargarDatos(ARCHIVO_CONSULTAS);
    }

    public static void guardarConsultas(ArrayList<Consulta> consultas) {
        guardarDatos(consultas, ARCHIVO_CONSULTAS);
    }

    //METODOS


    private static <T> ArrayList<T> cargarDatos(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (!archivo.exists() || archivo.length() == 0) {
            return new ArrayList<>();
        }
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo))) {
            return (ArrayList<T>) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar datos desde " + nombreArchivo + ": " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private static <T> void guardarDatos(ArrayList<T> datos, String nombreArchivo) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            salida.writeObject(datos);
        } catch (IOException e) {
            System.out.println("Error al guardar datos en " + nombreArchivo + ": " + e.getMessage());
        }
    }
}
