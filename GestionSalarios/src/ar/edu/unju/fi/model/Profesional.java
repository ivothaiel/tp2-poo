package ar.edu.unju.fi.model;

import java.time.LocalDate;

public class Profesional extends Empleado {
	private double adicionalTitulo;
	
	

	public Profesional(int id, String legajo, String nombre, int cantidadHijos, LocalDate fechaNacimiento,
			int antiguedad, double adicionalTitulo) {
		super(id, legajo, nombre, cantidadHijos, fechaNacimiento, antiguedad);
		this.adicionalTitulo = adicionalTitulo;
	}



	@Override
	public double calcularSueldoNeto() {
		double remunerativosBonificables = sueldoBasico + adicionalTitulo + calcularAntiguedad();
		double descuentos = calcularDescuentos(remunerativosBonificables);
		return remunerativosBonificables + calcularSalarioFamiliar() - descuentos;
	}



	public double getAdicionalTitulo() {
		
		return adicionalTitulo;
	}



	public void setAdicionalTitulo(double adicionalTitulo) {
		this.adicionalTitulo = adicionalTitulo;
	}


	public Profesional(int id, String legajo, String nombre, int cantidadHijos, LocalDate fechaNacimiento,
			int antiguedad) {
		super(id, legajo, nombre, cantidadHijos, fechaNacimiento, antiguedad);
	}



	@Override
	public String toString() {
		return "Profesional [adicionalTitulo=" + adicionalTitulo + ", id=" + id + ", legajo=" + legajo + ", nombre="
				+ nombre + ", edad=" + edad + ", cantidadHijos=" + cantidadHijos + ", fechaNacimiento="
				+ fechaNacimiento + ", antiguedad=" + antiguedad + ", sueldoBasico=" + sueldoBasico
				+ ", calcularSueldoNeto()=" + calcularSueldoNeto() + ", getAdicionalTitulo()=" + getAdicionalTitulo()
				+ ", calcularAntiguedad()=" + calcularAntiguedad() + ", calcularSalarioFamiliar()="
				+ calcularSalarioFamiliar() + ", calcularEdad()=" + calcularEdad() + ", getId()=" + getId()
				+ ", getLegajo()=" + getLegajo() + ", getNombre()=" + getNombre() + ", getEdad()=" + getEdad()
				+ ", getCantidadHijos()=" + getCantidadHijos() + ", getFechaNacimiento()=" + getFechaNacimiento()
				+ ", getAntiguedad()=" + getAntiguedad() + ", getSueldoBasico()=" + getSueldoBasico() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
	

}