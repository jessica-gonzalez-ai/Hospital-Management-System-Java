package Hospital;

import java.io.Serializable;
import java.time.LocalDate;

public class Consulta implements Serializable {

   //CAMPOS
    private LocalDate fecha;
    private String diagnostico;
    private Paciente paciente;
    private Doctor doctor;

    //CONSTRUCTOR DEFAULT
    public Consulta() {

    }

    //CONSTRUCTOR PARAMETRIZADO
    public Consulta(Paciente paciente, Doctor doctor, LocalDate fecha, String diagnostico) {
        this.paciente = paciente;
        this.doctor = doctor;
        this.fecha = fecha;
        this.diagnostico = diagnostico;
    }

    //GETTERS Y SETTERS
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    //Mostrar datos
    public void mostrarDatos() {
        System.out.println("Consulta:");
        System.out.println("Fecha: " + fecha);
        System.out.println("Paciente: " + paciente);
        System.out.println("Doctor: " + doctor);
        System.out.println("Diagnóstico: " + diagnostico);
    }

    @Override
    public String toString() {
        return "Consulta [" + fecha + "] - " + paciente + " | " + doctor + " | Diagnóstico: " + diagnostico;
    }
}

