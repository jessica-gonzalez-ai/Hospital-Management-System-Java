import Hospital.Consulta;
import Hospital.Doctor;
import Hospital.GestorDatos;
import Hospital.Paciente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //CARGAR DATOS
        ArrayList<Paciente> pacientes = GestorDatos.cargarPacientes();
        ArrayList<Doctor> doctores = GestorDatos.cargarDoctores();
        ArrayList<Consulta> consultas = GestorDatos.cargarConsultas();

        int opcion = 0;

        do {
            limpiarPantalla();
            System.out.println("\n--------- Sistema de Consultas ---------");
            System.out.println("1. Agregar paciente. ");
            System.out.println("2. Agregar doctor. ");
            System.out.println("3. Registrar consulta. ");
            System.out.println("4. Mostrar pacientes. ");
            System.out.println("5. Mostrar doctores. ");
            System.out.println("6. Mostrar consultas. ");
            System.out.println("7. Buscar paciente por ID.");
            System.out.println("8. Buscar doctor por ID. ");
            System.out.println("9. Buscar consultas por ID de paciente.");
            System.out.println("10. Buscar consultas por fecha. ");
            System.out.println("11. Guardar y salir. ");
            System.out.println("---------------------------------------");


            opcion = leerOpcion(sc, 1, 11);

            switch (opcion) {
                case 1:
                    agregarPaciente(pacientes, sc);
                    break;
                case 2:
                    agregarDoctor(doctores, sc);
                    break;
                case 3:
                    registrarConsulta(pacientes, doctores, consultas, sc);
                    break;
                case 4:
                    mostrarPacientes(pacientes);
                    break;
                case 5:
                    mostrarDoctores(doctores);
                    break;
                case 6:
                    mostrarConsultas(consultas);
                    break;
                case 7:
                    buscarPacientePorId(pacientes, sc);
                    break;
                case 8:
                    buscarDoctorPorId(doctores, sc);
                    break;
                case 9:
                    buscarConsulasPorIdPaciente(consultas, sc);
                    break;
                case 10:
                    buscarConsultasPorFecha(consultas, sc);
                    break;
                case 11:
                    GestorDatos.guardarPacientes(pacientes);
                    GestorDatos.guardarDoctores(doctores);
                    GestorDatos.guardarConsultas(consultas);
                    System.out.println("Datos guardados exitosamente. ¡Gracias por usar el sistema!");
                    break;
                default:

                    break;
            }
        } while (opcion != 11);

        sc.close();
    }

    //METODOSSS
    public static int leerOpcion(Scanner sc, int min, int max) {
        int opcion = -1;
        while (true) {
            System.out.print("Seleccione una opción (" + min + " - " + max + "): ");
            String entrada = sc.nextLine().trim();
            try {
                opcion = Integer.parseInt(entrada);
                if (opcion < min || opcion > max) {
                    System.out.println("Opción fuera de rango. Intenta de nuevo.");
                } else {
                    return opcion;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ser un número.");
            }
        }
    }

    public static void agregarPaciente(ArrayList<Paciente> pacientes, Scanner sc) {
        String id;
        boolean idRepetido;

        //ID
        do {
            System.out.print("Ingrese el ID del paciente (solo números): \n"); // Salto de línea
            id = sc.nextLine().trim();
            idRepetido = false;

            //Validar que el ID solo contenga números
            if (!id.matches("\\d+")) {
                System.out.println("El ID debe contener solo números. Intente de nuevo.");
                idRepetido = true;
                continue;
            }

            for (Paciente p : pacientes) {
                if (p.getId().equalsIgnoreCase(id)) {
                    idRepetido = true;
                    System.out.println("El ID ya existe. Ingrese uno diferente.");
                    break;
                }
            }
        } while (idRepetido || id.isEmpty());

        System.out.print("Ingrese el nombre completo del paciente: \n"); // Salto de línea
        String nombre = sc.nextLine().trim();

        int edad = 0;
        while (true) {
            System.out.print("Ingrese la edad del paciente: \n");
            String inputEdad = sc.nextLine();
            try {
                edad = Integer.parseInt(inputEdad);
                if (edad < 0) {
                    System.out.println("La edad no puede ser negativa.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Edad inválida. Ingrese un número.");
            }
        }

        System.out.print("Ingrese el género del paciente: \n");
        String genero = sc.nextLine().trim();

        Paciente nuevoPaciente = new Paciente(nombre, edad, id, genero);
        pacientes.add(nuevoPaciente);
        System.out.println("Paciente agregado exitosamente.");
    }

    public static void agregarDoctor(ArrayList<Doctor> doctores, Scanner sc) {
        String id;
        boolean idRepetido;

        //ID
        do {
            System.out.print("Ingrese el ID del doctor (solo números): \n");
            id = sc.nextLine().trim();
            idRepetido = false;

            //Validar que el ID solo contenga números
            if (!id.matches("\\d+")) {
                System.out.println("El ID debe contener solo números. Intente de nuevo.");
                idRepetido = true;
                continue;
            }

            for (Doctor d : doctores) {
                if (d.getId().equalsIgnoreCase(id)) {
                    idRepetido = true;
                    System.out.println("El ID ya existe. Ingrese uno diferente.");
                    break;
                }
            }
        } while (idRepetido || id.isEmpty());

        System.out.print("Ingrese el nombre del doctor: \n");
        String nombre = sc.nextLine().trim();

        int edad = 0;
        while (true) {
            System.out.print("Ingrese la edad del doctor: \n");
            String inputEdad = sc.nextLine();
            try {
                edad = Integer.parseInt(inputEdad);
                if (edad < 0) {
                    System.out.println("La edad no puede ser negativa.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Edad inválida. Ingrese un número.");
            }
        }

        System.out.print("Ingrese la especialidad del doctor: \n");
        String especialidad = sc.nextLine().trim();

        Doctor nuevoDoctor = new Doctor(nombre, edad, id, especialidad);
        doctores.add(nuevoDoctor);
        System.out.println("Doctor agregado exitosamente.");
    }


    public static void registrarConsulta(ArrayList<Paciente> pacientes, ArrayList<Doctor> doctores, ArrayList<Consulta> consultas, Scanner sc) {
        if (pacientes.isEmpty() || doctores.isEmpty()) {
            System.out.println("Debe haber al menos un paciente y un doctor para registrar una consulta.");
            return;
        }
        System.out.println("Seleccione un paciente: ");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println(i + ". " + pacientes.get(i));
        }
        int indicePaciente = sc.nextInt();
        sc.nextLine();
        if (indicePaciente < 0 || indicePaciente >= pacientes.size()) {
            System.out.println("Índice de paciente inválido.");
            return;
        }

        System.out.println("Seleccione un doctor: ");
        for (int i = 0; i < doctores.size(); i++) {
            System.out.println(i + ". " + doctores.get(i));
        }
        int indiceDoctor = sc.nextInt();
        sc.nextLine();
        if (indiceDoctor < 0 || indiceDoctor >= doctores.size()) {
            System.out.println("Índice de doctor inválido.");
            return;
        }

        LocalDate fecha;
        while (true) {
            System.out.print("Fecha (AAAA-MM-DD): \n");
            String fechaTexto = sc.nextLine();
            try {
                fecha = LocalDate.parse(fechaTexto);
                break;
            } catch (Exception e) {
                System.out.println("Formato de fecha inválido. Usa AAAA-MM-DD.");
            }
        }

        System.out.println("Diagnóstico del paciente: ");
        String diagnostico = sc.nextLine();

        Consulta consulta = new Consulta(pacientes.get(indicePaciente), doctores.get(indiceDoctor), fecha, diagnostico);
        consultas.add(consulta);
        System.out.println("Consulta registrada correctamente.");
    }

    public static void mostrarPacientes(ArrayList<Paciente> pacientes) {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
        } else {
            pacientes.sort(Comparator.comparing(Paciente::getNombre));
            System.out.println("Lista de pacientes: ");
            for (Paciente p : pacientes) {
                System.out.println("-------------------");
                p.mostrarDatos();
            }
            System.out.println("-------------------");
            System.out.println("Hay " + pacientes.size() + " pacientes registrados.");
        }
    }
    public static void mostrarDoctores(ArrayList<Doctor> doctores) {
        if (doctores.isEmpty()) {
            System.out.println("No hay doctores registrados.");
        } else {
            System.out.println("Lista de doctores: ");
            for (Doctor d : doctores) {
                System.out.println("-------------------");
                d.mostrarDatos();
            }
            System.out.println("-------------------");
            System.out.println("Hay " + doctores.size() + " doctores registrados.");
        }
    }

    public static void mostrarConsultas(ArrayList<Consulta> consultas) {
        if (consultas.isEmpty()) {
            System.out.println("No hay consultas registradas.");
        } else {
            System.out.println("Lista de consultas: ");
            for (Consulta c : consultas) {
                System.out.println("-------------------");
                c.mostrarDatos();
            }
            System.out.println("-------------------");
            System.out.println("Hay " + consultas.size() + " consultas registradas.");
        }
    }

    public static void buscarPacientePorId(ArrayList<Paciente> pacientes, Scanner sc) {
        System.out.println("Ingrese el ID del paciente a buscar: ");
        String id = sc.nextLine().trim();

        boolean encontrar = false;
        for (Paciente p : pacientes) {
            if (p.getId().equalsIgnoreCase(id)) {
                System.out.println("Paciente encontrado: ");
                p.mostrarDatos();
                encontrar = true;
                break;
            }
        }

        if (!encontrar) {
            System.out.println("No se encontró un paciente con ese ID.");
        }
    }

    private static void buscarDoctorPorId(ArrayList<Doctor> doctores, Scanner sc) {
        System.out.println("Ingrese el ID del doctor a buscar: ");
        String id = sc.nextLine().trim();

        boolean encontrar = false;
        for (Doctor d : doctores) {
            if (d.getId().equalsIgnoreCase(id)) {
                System.out.println("Doctor encontrado: ");
                d.mostrarDatos();
                encontrar = true;
                break;
            }
        }
        if (!encontrar) {
            System.out.println("No se encontró un doctor con ese ID.");
        }
    }

    public static void buscarConsulasPorIdPaciente(ArrayList<Consulta> consultas, Scanner sc) {
        System.out.println("Ingrese el ID del paciente: ");
        String idBuscar = sc.nextLine();

        boolean encontrado = false;

        for (Consulta c : consultas) {
            if (c.getPaciente().getId().equalsIgnoreCase(idBuscar)) {
                System.out.println(c);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron consultas para el paciente con ID: " + idBuscar);
        }
    }


    public static void buscarConsultasPorFecha(ArrayList<Consulta> consultas, Scanner sc) {
        System.out.print("Ingrese la fecha a buscar (AAAA-MM-DD): ");
        String fechaTexto = sc.nextLine();

        try {
            LocalDate fecha = LocalDate.parse(fechaTexto);
            boolean encontrado = false;
            for (Consulta c : consultas) {
                if (c.getFecha().equals(fecha)) {
                    System.out.println(c);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("No hay consultas para esa fecha.");
            }
        } catch (Exception e) {
            System.out.println("Formato de fecha inválido.");
        }
    }

    public static void limpiarPantalla() {
        //Windows
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                System.out.println("No se pudo limpiar la pantalla.");
            }
        } else { //Para sistemas Unix/Linux/Mac
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

}
