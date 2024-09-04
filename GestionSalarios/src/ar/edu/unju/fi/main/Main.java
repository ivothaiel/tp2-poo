package ar.edu.unju.fi.main;

import ar.edu.unju.fi.manager.manager;
import ar.edu.unju.fi.model.Administrativo;
import ar.edu.unju.fi.model.Empleado;
import ar.edu.unju.fi.model.Profesional;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Instanciar el manager
        manager servicio = new manager();

        // Leer los archivos de adicionales y categorías
        servicio.leerAdicionalTitulo("adicionalTitulo.txt"); // Leer adicional para Profesional
        servicio.leerCategorias("categorias.txt"); // Leer categorías para Administrativo

        // Agregar empleados con información leída
        servicio.agregarProfesional(new Profesional(1, "P001", "Juan Pérez", 2, LocalDate.of(1980, 5, 15), 10));
        servicio.agregarAdministrativo(new Administrativo(2, "A001", "Ana Gómez", 1, LocalDate.of(1985, 8, 20), 5, 0), 1); // Usar categoría 1 como ejemplo
        servicio.agregarProfesional(new Profesional(3, "POO2", "Marcos Lopez", 4, LocalDate.of(1990, 3, 23), 7));

        // Interacción con el usuario a través del Scanner
        Scanner scanner = new Scanner(System.in);

        // Mostrar empleados por antigüedad
        System.out.print("Ingrese la antigüedad en años para filtrar empleados: ");
        int antiguedad = scanner.nextInt();
        servicio.mostrarEmpleadosPorAntiguedad(antiguedad);

        // Calcular y mostrar totales
        double totalRemunerativosBonificables = servicio.obtenerEmpleados().stream().mapToDouble(e -> 
            e.calcularRemunerativosBonificables(
                e instanceof Profesional ? ((Profesional) e).getAdicionalTitulo() : 
                e instanceof Administrativo ? ((Administrativo) e).getCategoria() : 0)
            ).sum();
        double totalSalarioFamiliar = servicio.obtenerEmpleados().stream().mapToDouble(Empleado::calcularSalarioFamiliar).sum();
        double totalDescuentos = servicio.obtenerEmpleados().stream().mapToDouble(e -> 
            e.calcularDescuentos(
                e.calcularRemunerativosBonificables(
                    e instanceof Profesional ? ((Profesional) e).getAdicionalTitulo() : 
                    e instanceof Administrativo ? ((Administrativo) e).getCategoria() : 0)
                )
            ).sum();
        double totalImporteNeto = servicio.obtenerEmpleados().stream().mapToDouble(Empleado::calcularSueldoNeto).sum();

        // Imprimir resultados
        System.out.println("Total Acumulado:");
        System.out.println("Remunerativos Bonificables: " + totalRemunerativosBonificables);
        System.out.println("Salario Familiar: " + totalSalarioFamiliar);
        System.out.println("Descuentos: " + totalDescuentos);
        System.out.println("Importe Neto: " + totalImporteNeto);

        // Mostrar empleados por edad
        System.out.print("Ingrese la edad mínima para filtrar empleados: ");
        int edadMinima = scanner.nextInt();
        servicio.mostrarEmpleadosPorEdad(edadMinima);

        // Calcular importe neto acumulado
        double importeNetoAcumulado = servicio.calcularImporteNetoAcumulado(edadMinima);
        System.out.println("Importe Neto Acumulado de empleados con edad mayor o igual a " + edadMinima + ": " + importeNetoAcumulado);

        // Incrementar salario básico para empleados con antigüedad menor o igual a 2 años
        servicio.incrementarSalarioBasico(2);
        System.out.println("Salario básico incrementado en un 10% para empleados con antigüedad menor o igual a 2 años.");

        scanner.close();
    }
}

