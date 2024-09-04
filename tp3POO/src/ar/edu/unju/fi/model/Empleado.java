package ar.edu.unju.fi.model;

import java.time.LocalDate;



public abstract class Empleado {
	protected int id;
	protected String legajo;
	protected String nombre;
	protected int edad;
	protected int cantidadHijos;
	protected LocalDate fechaNacimiento;
	protected int antiguedad;
	protected double sueldoBasico = 150000;
	
	public Empleado() {
		super();
		
	}

	public Empleado(int id, String legajo, String nombre, int cantidadHijos, LocalDate fechaNacimiento,
			int antiguedad) {
		super();
		this.id = id;
		this.legajo = legajo;
		this.nombre = nombre;
		this.cantidadHijos = cantidadHijos;
		this.fechaNacimiento = fechaNacimiento;
		this.antiguedad = antiguedad;
	}

	public abstract double calcularSueldoNeto();
	
	

	
	public double calcularAntiguedad() {
		return antiguedad * 7000;
	}
	
	public double calcularSalarioFamiliar() {
		return cantidadHijos * 8000;
	}
	
	public double calcularDescuentos(double remunerativosBonificables) {
		return remunerativosBonificables * 0.15;
	}
	
	public void incrementarSueldoBasico(double porcentaje) {
	    if (this.antiguedad <= 2) {
	        this.sueldoBasico += this.sueldoBasico * (porcentaje / 100);
	    }
	}
	public double calcularRemunerativosBonificables(double adicional) {
	    return this.sueldoBasico + adicional + calcularAntiguedad();
	}


	public int calcularEdad() {
	    return LocalDate.now().getYear() - this.fechaNacimiento.getYear();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getCantidadHijos() {
		return cantidadHijos;
	}

	public void setCantidadHijos(int cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public double getSueldoBasico() {
		return sueldoBasico;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", legajo=" + legajo + ", nombre=" + nombre + ", edad=" + edad
				+ ", cantidadHijos=" + cantidadHijos + ", fechaNacimiento=" + fechaNacimiento + ", antiguedad="
				+ antiguedad + ", sueldoBasico=" + sueldoBasico + ", calcularSueldoNeto()=" + calcularSueldoNeto()
				+ ", calcularAntiguedad()=" + calcularAntiguedad() + ", calcularSalarioFamiliar()="
				+ calcularSalarioFamiliar() + ", calcularEdad()=" + calcularEdad() + ", getId()=" + getId()
				+ ", getLegajo()=" + getLegajo() + ", getNombre()=" + getNombre() + ", getEdad()=" + getEdad()
				+ ", getCantidadHijos()=" + getCantidadHijos() + ", getFechaNacimiento()=" + getFechaNacimiento()
				+ ", getAntiguedad()=" + getAntiguedad() + ", getSueldoBasico()=" + getSueldoBasico() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
	
	

} 
