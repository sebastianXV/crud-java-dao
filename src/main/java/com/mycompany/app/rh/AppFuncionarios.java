package com.mycompany.app.rh;

import controller.FuncionarioController;
import domain.Funcionario;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AppFuncionarios {

    public static void crear(FuncionarioController funcionarioController) {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite la identificación");
            int identificacion = sc.nextInt();
            sc.nextLine();
            System.out.println("La identificación es = " + identificacion);
            System.out.println("_________________________________ ");

            System.out.println("Digite los nombres");
            String nombres = sc.nextLine();
            System.out.println("Los nombres son = " + nombres);
            System.out.println("_________________________________ ");

            System.out.println("Digite los apellidos");
            String apellidos = sc.nextLine();
            System.out.println("Los apellidos son = " + apellidos);
            System.out.println("_________________________________ ");

            System.out.println("Digite el estado civil");
            String estadoCivil = sc.nextLine();
            System.out.println("El estado civil es = " + estadoCivil);
            System.out.println("_________________________________ ");

            System.out.println("Digite el sexo  M/F");
            String sexo = sc.nextLine();
            System.out.println("El sexo es = " + sexo);
            System.out.println("_________________________________ ");

            System.out.println("Digite la dirección");
            String direccion = sc.nextLine();
            System.out.println("La dirección es = " + direccion);
            System.out.println("_________________________________ ");

            System.out.println("Digite el teléfono");
            String telefono = sc.nextLine();
            System.out.println("El teléfono es = " + telefono);
            System.out.println("_________________________________ ");

            System.out.println("Digite la fecha de nacimiento (en formato yyyy-MM-dd)");
            String fechaNacimientoStr = sc.nextLine();
            java.sql.Date fechaNacimiento = java.sql.Date.valueOf(fechaNacimientoStr);
            System.out.println("La fecha de nacimiento es = " + fechaNacimiento);
            System.out.println("_________________________________ ");

            System.out.println("Digite el rol");
            String rol = sc.nextLine();
            System.out.println("El teléfono es = " + rol);
            System.out.println("_________________________________ ");

            Funcionario funcionario = new Funcionario();
            funcionario.setIdentificacion(identificacion);
            funcionario.setNombres(nombres);
            funcionario.setApellidos(apellidos);
            funcionario.setEstadoCivil(estadoCivil);
            funcionario.setSexo(sexo);
            funcionario.setDireccion(direccion);
            funcionario.setTelefono(telefono);
            funcionario.setFechaNacimiento(fechaNacimiento);
            funcionario.setRol(rol);

            funcionarioController.crearFuncionario(funcionario);
            System.out.println("Funcionario creado con éxito");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void obtener(FuncionarioController funcionarioController) {
        try {
            List<Funcionario> funcionarios = funcionarioController.obtenerFuncionarios();
            if (funcionarios.isEmpty()) {
                System.out.println("No hay funcionarios ");
            } else {
                funcionarios.forEach(funcionario -> {
                    System.out.println("id: " + funcionario.getId());
                    System.out.println("Identificación: " + funcionario.getIdentificacion());
                    System.out.println("Nombres: " + funcionario.getNombres());
                    System.out.println("Apellidos: " + funcionario.getApellidos());
                    System.out.println("Estado Civil: " + funcionario.getEstadoCivil());
                    System.out.println("Sexo: " + funcionario.getSexo());
                    System.out.println("Dirección: " + funcionario.getDireccion());
                    System.out.println("Teléfono: " + funcionario.getTelefono());
                    System.out.println("Fecha de Nacimiento: " + funcionario.getFechaNacimiento());
                    System.out.println("Rol: " + funcionario.getRol());
                    System.out.println("___________________________________________ ");
                    System.out.println("___________________________________________ ");
                    System.out.println("___________________________________________ ");
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void actualizar(FuncionarioController funcionarioController) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingrese el ID del funcionario que desea actualizar: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Funcionario funcionarioExistente = funcionarioController.obtenerFuncionario(id);

            if (funcionarioExistente != null) {
                System.out.println("Funcionario actual:");
                System.out.println(funcionarioExistente);

                System.out.println("Ingrese los nuevos datos del funcionario:");

                System.out.print("Numero de identificacion: ");
                int nuevaIdentificacion = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Nombres: ");
                String nuevosNombres = scanner.nextLine();
                System.out.print("Apellidos: ");
                String nuevosApellidos = scanner.nextLine();
                System.out.print("Estado Civil: ");
                String nuevoEstadoCivil = scanner.nextLine();
                System.out.print("Sexo  M/F : ");
                String nuevoSexo = scanner.nextLine();
                System.out.print("Dirección: ");
                String nuevaDireccion = scanner.nextLine();
                System.out.print("Teléfono: ");
                String nuevoTelefono = scanner.nextLine();
                System.out.println("Fecha de nacimiento (en formato yyyy-MM-dd): ");
                String fechaNacimientoStr = scanner.nextLine();
                java.sql.Date fechaNacimiento = java.sql.Date.valueOf(fechaNacimientoStr);
                System.out.print("Rol: ");
                String rol = scanner.nextLine();

                Funcionario funcionarioActualizado = new Funcionario();
                funcionarioActualizado.setNumeroIdentificacion(nuevaIdentificacion);
                funcionarioActualizado.setNombres(nuevosNombres);
                funcionarioActualizado.setApellidos(nuevosApellidos);
                funcionarioActualizado.setEstadoCivil(nuevoEstadoCivil);
                funcionarioActualizado.setSexo(nuevoSexo);
                funcionarioActualizado.setDireccion(nuevaDireccion);
                funcionarioActualizado.setTelefono(nuevoTelefono);
                funcionarioActualizado.setFechaNacimiento(fechaNacimiento);
                funcionarioActualizado.setRol(rol);

                funcionarioController.actualizarFuncionario(id, funcionarioActualizado);
                System.out.println("Funcionario actualizado con éxito.");
            } else {
                System.out.println("Funcionario no encontrado. Verifique el ID.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void eliminar(FuncionarioController funcionarioController) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingrese el ID del funcionario que desea eliminar: ");
            int id = scanner.nextInt();

            Funcionario funcionarioExistente = funcionarioController.obtenerFuncionario(id);

            if (funcionarioExistente != null) {
                funcionarioController.eliminarFuncionario(id);
                System.out.println("Funcionario eliminado con éxito.");
            } else {
                System.out.println("Funcionario no encontrado. Verifique el ID.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        FuncionarioController funcionarioController = new FuncionarioController();

        while (true) {
            System.out.println("\nMenú de Funcionarios:");
            System.out.println("1. Crear Funcionario");
            System.out.println("2. Obtener Funcionarios");
            System.out.println("3. Actualizar Funcionario");
            System.out.println("4. Eliminar Funcionario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crear(funcionarioController);
                    break;
                case 2:
                    obtener(funcionarioController);
                    break;
                case 3:
                    actualizar(funcionarioController);
                    break;
                case 4:
                     eliminar(funcionarioController);              
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

}
