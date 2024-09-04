package ar.edu.unju.fi.model;

import java.time.LocalDate;

public class Administrativo extends Empleado{
	private double categoria;
	
	public Administrativo(int id, String legajo, String nombre, int cantidadHijos, LocalDate fechaNacimiento,
			int antiguedad, double categoria) {
		super(id, legajo, nombre, cantidadHijos, fechaNacimiento, antiguedad);
		this.categoria = categoria;
	}
	
	@Override
	public double calcularSueldoNeto() {
		double remunerativosBonificables = sueldoBasico + categoria + calcularAntiguedad();
		double descuentos = calcularDescuentos(remunerativosBonificables);
		return remunerativosBonificables + calcularSalarioFamiliar() - descuentos;
	}

	public double getCategoria() {
		
		return categoria;
	}

	public void setCategoria(double categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Administrativo [categoria=" + categoria + ", id=" + id + ", legajo=" + legajo + ", nombre=" + nombre
				+ ", edad=" + edad + ", cantidadHijos=" + cantidadHijos + ", fechaNacimiento=" + fechaNacimiento
				+ ", antiguedad=" + antiguedad + ", sueldoBasico=" + sueldoBasico + ", calcularSueldoNeto()="
				+ calcularSueldoNeto() + ", getCategoria()=" + getCategoria() + ", calcularAntiguedad()="
				+ calcularAntiguedad() + ", calcularSalarioFamiliar()=" + calcularSalarioFamiliar()
				+ ", calcularEdad()=" + calcularEdad() + ", getId()=" + getId() + ", getLegajo()=" + getLegajo()
				+ ", getNombre()=" + getNombre() + ", getEdad()=" + getEdad() + ", getCantidadHijos()="
				+ getCantidadHijos() + ", getFechaNacimiento()=" + getFechaNacimiento() + ", getAntiguedad()="
				+ getAntiguedad() + ", getSueldoBasico()=" + getSueldoBasico() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}