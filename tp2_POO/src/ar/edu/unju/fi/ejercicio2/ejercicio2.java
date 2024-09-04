package ar.edu.unju.fi.ejercicio2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class ejercicio2 {

	public static void main(String[] args) {
		
	//a)Declaramos la coleccion 
	Map<Integer,String> lista = new HashMap<>();
	
	Random random = new Random();
	try (Scanner sc = new Scanner(System.in)) {
		//b)generamos y agremos n numeros al azar al map
		System.out.println("Ingrese la cantidad de numeros a generar:");
		int n = sc.nextInt();
		
		while(lista.size()<n) {
			int num = random.nextInt(101); //aca se genera el numero entre 0 a 100
			String sTrNum = convertirAnombre(num); //convertimos  el num a su representacion en string
			lista.putIfAbsent(num,sTrNum); //solo agrega si la clave no esta ya en el mapa

		}
		
		//c)buscamos un valor en la coleccion y lo convertimos en mayuscula si existe
		System.out.println("Ingresamos el numero para buscar en la coleccion");
		int valorBuscado = sc.nextInt();
		
		if(lista.containsKey(valorBuscado)) {
			lista.put(valorBuscado, lista.get(valorBuscado).toUpperCase());
			System.out.println("Valor Actualizado" + valorBuscado + "->" + lista.get(valorBuscado));
			}else {
				System.out.println("El valor no se encuentra en la coleccion");
			}
	}
	
	System.out.println("Mapa final: "+lista);
	}

	private static String convertirAnombre(int num) {
		return Integer.toString(num);
	}

}
