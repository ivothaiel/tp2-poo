package ar.edu.unju.fi.ejercicio1;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ejercicio1Lambda {

	public static void main(String[] args) {
		 int N = 20;  // Cantidad de números
	        int X = 5;   // Número X para la eliminación de múltiplos

	        // Generar N números aleatorios sin repetición
	        List<Integer> lista = new Random().ints(0, 101)
	                .distinct()
	                .limit(N)
	                .boxed()
	                .collect(Collectors.toList());

	        System.out.println("Lista original: " + lista);

	        // a) Eliminar múltiplos de X
	        lista.removeIf(num -> num % X == 0);
	        System.out.println("Lista sin múltiplos de " + X + ": " + lista);

	        // b) Modificar el máximo número de la lista
	        lista.replaceAll(num -> num.equals(Collections.max(lista)) ? num * num : num);
	        System.out.println("Lista con el máximo elevado al cuadrado: " + lista);

	        // c) Sumar el factorial a los valores mayores que 10
	        lista.replaceAll(num -> num > 10 ? num + factorial(num) : num);
	        System.out.println("Lista con factorial sumado: " + lista);

	        // d) Encontrar el número que se repite menos veces
	        Map<Integer, Long> frecuencia = lista.stream()
	                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

	        Long minFrecuencia = Collections.min(frecuencia.values());

	        if (minFrecuencia == 1) {
	            System.out.println("No hay números repetidos.");
	        } else {
	            int numMenosRepetido = frecuencia.entrySet().stream()
	                    .filter(entry -> entry.getValue().equals(minFrecuencia))
	                    .map(Map.Entry::getKey)
	                    .findFirst()
	                    .orElseThrow();
	            System.out.println("Número que se repite menos veces: " + numMenosRepetido);
	        }

	        // e) Particionar en pares e impares
	        List<Integer> pares = lista.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
	        List<Integer> impares = lista.stream().filter(num -> num % 2 != 0).collect(Collectors.toList());

	        System.out.println("Pares: " + pares);
	        System.out.println("Impares: " + impares);
	    }

	    // Método para calcular el factorial de un número
	    public static int factorial(int n) {
	        return n <= 1 ? 1 : n * factorial(n - 1);
	    }
	}


