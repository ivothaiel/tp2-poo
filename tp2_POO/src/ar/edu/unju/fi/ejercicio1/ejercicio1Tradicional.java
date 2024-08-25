package ar.edu.unju.fi.ejercicio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ejercicio1Tradicional {

	public static void main(String[] args) {
		int N=20; //cantidad de numeros
		int X=5;//numero x para la eliminacion de multiplos
		
		List<Integer> lista = new ArrayList<>();
		Random rand = new Random();
		
		//generando los numeros aleatorios sin repetirlos
		
		while(lista.size() < N) {
			int num = rand.nextInt(101);
			if(!lista.contains(num)) {
				lista.add(num);
			}
		}
		
		System.out.println("Lista original: " + lista);
		
		//a) eliminar multiplos de x
		Iterator<Integer> iter = lista.iterator();
		while(iter.hasNext()) {
			int num = iter.next();
			if(num % X == 0) {
				iter.remove();
			}
		}
		System.out.println("Lista sin multiplos de " + X + ": " + lista);
		
		//b)modificar el maximo numero de lista
		
		int max = Collections.max(lista);
		lista.set(lista.indexOf(max), max * max);
		System.out.println("Lista con el maximo elevado al cuadrado: " + lista);
		
		//c) sumar el factorial de los valores mayores que 10
		for(int i = 0; i < lista.size();i++) {
			int num = lista.get(i);
			if(num>10) {
				lista.set(i, num + factorial(num));
			}
		}
		
		System.out.println("Lista con factorial sumado: " + lista);
		  // d) Encontrar el número que se repite menos veces
        Map<Integer, Integer> frecuencia = new HashMap<>();
        for (int num : lista) {
            frecuencia.put(num, frecuencia.getOrDefault(num, 0) + 1);
        }
        
        int minFrecuencia = Collections.min(frecuencia.values());
        if (minFrecuencia == 1) {
            System.out.println("No hay números repetidos.");
        } else {
            for (Map.Entry<Integer, Integer> entry : frecuencia.entrySet()) {
                if (entry.getValue() == minFrecuencia) {
                    System.out.println("Número que se repite menos veces: " + entry.getKey());
                    break;
                }
            }
        }
        
        // e) Particionar en pares e impares
        List<Integer> pares = new ArrayList<>();
        List<Integer> impares = new ArrayList<>();
        
        for (int num : lista) {
            if (num % 2 == 0) {
                pares.add(num);
            } else {
                impares.add(num);
            }
        }
        System.out.println("Pares: " + pares);
        System.out.println("Impares: " + impares);
    }
    
    // metodo para calcular el factorial de un numero
    public static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

	}


