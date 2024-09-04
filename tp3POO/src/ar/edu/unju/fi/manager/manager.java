package ar.edu.unju.fi.manager;

import ar.edu.unju.fi.model.Administrativo;
import ar.edu.unju.fi.model.Empleado;
import ar.edu.unju.fi.model.Profesional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class manager {
    private List<Empleado> empleados;
    private Map<Integer, Double> categorias; // Para almacenar las categorías de Administrativos.
    private double adicionalTitulo; // Para almacenar el adicional por título de Profesionales.

    public manager() {
        this.empleados = new ArrayList<>();
        this.categorias = new HashMap<>();
        this.adicionalTitulo = 0;
    }

    // Método para leer el archivo de adicional por título (Profesionales)
    public void leerAdicionalTitulo(String path) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            if (!lines.isEmpty()) {
                this.adicionalTitulo = Double.parseDouble(lines.get(0).trim());
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de adicional por título: " + e.getMessage());
        }
    }

    // Método para leer el archivo de categorías (Administrativos)
    public void leerCategorias(String path) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                String[] partes = line.split(":");
                if (partes.length == 2) {
                    int categoria = Integer.parseInt(partes[0].trim());
                    double valor = Double.parseDouble(partes[1].trim());
                    categorias.put(categoria, valor);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de categorías: " + e.getMessage());
        }
    }

    // Agregar un empleado profesional con adicional leído desde el archivo
    public void agregarProfesional(Profesional profesional) {
        profesional.setAdicionalTitulo(this.adicionalTitulo);
        empleados.add(profesional);
    }

    // Agregar un empleado administrativo con categoría leída desde el archivo
    public void agregarAdministrativo(Administrativo administrativo, int categoria) {
        if (categorias.containsKey(categoria)) {
            administrativo.setCategoria(categorias.get(categoria));
            empleados.add(administrativo);
        } else {
            System.out.println("La categoría " + categoria + " no existe en el archivo de categorías.");
        }
    }

    // Otros métodos de la clase Manager...

    // Devuelve una lista de empleados con antigüedad mayor a un valor dado.
    public List<Empleado> empleadosConAntiguedadMayorA(int anios) {
        return empleados.stream()
                        .filter(e -> e.getAntiguedad() > anios)
                        .collect(Collectors.toList());
    }

    // Calcula el importe neto acumulado de empleados cuya edad es mayor o igual a un valor dado.
    public double calcularImporteNetoAcumulado(int edad) {
        return empleados.stream()
                        .filter(e -> e.getEdad() >= edad)
                        .mapToDouble(Empleado::calcularSueldoNeto)
                        .sum();
    }

    // Incrementa el sueldo básico en un 10% a los empleados cuya antigüedad es menor o igual a un valor dado.
    public void incrementarSalarioBasico(int antiguedadMaxima) {
        empleados.stream()
                 .filter(e -> e.getAntiguedad() <= antiguedadMaxima)
                 .forEach(e -> e.incrementarSueldoBasico(10));
    }

    // Devuelve la lista completa de empleados.
    public List<Empleado> obtenerEmpleados() {
        return empleados;
    }

    // Muestra los empleados con antigüedad mayor al valor dado. 
    // Imprime un mensaje si no hay empleados que cumplan el criterio.
    public void mostrarEmpleadosPorAntiguedad(int anios) {
        List<Empleado> empleadosFiltrados = empleadosConAntiguedadMayorA(anios);
        if (empleadosFiltrados.isEmpty()) {
            System.out.println("No hay empleados con más de " + anios + " años de antigüedad.");
        } else {
            empleadosFiltrados.forEach(System.out::println);
        }
    }

    // Muestra los empleados con edad mayor o igual al valor dado. 
    // Imprime un mensaje si no hay empleados que cumplan el criterio.
    public void mostrarEmpleadosPorEdad(int edad) {
        List<Empleado> empleadosFiltrados = empleados.stream()
                                                    .filter(e -> e.getEdad() >= edad)
                                                    .collect(Collectors.toList());
        if (empleadosFiltrados.isEmpty()) {
            System.out.println("No hay empleados con al menos " + edad + " años de edad.");
        } else {
            empleadosFiltrados.forEach(System.out::println);
        }
    }
}
