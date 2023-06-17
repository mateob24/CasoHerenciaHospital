package clases.empleado;

import javax.swing.JOptionPane;

public class Medico extends EmpleadoPlanilla {
	
	private String especialidad;
	private int numeroDeConsultorio;
	
	public String getEspecialidad() {
		return especialidad;
	}
	
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	public int getNumeroDeConsultorio() {
		return numeroDeConsultorio;
	}
	
	public void setNumeroDeConsultorio(int numeroDeConsultorio) {
		this.numeroDeConsultorio = numeroDeConsultorio;
	}
	
	@Override
	public void registrarDatos() {
		super.registrarDatos();
		
		especialidad=JOptionPane.showInputDialog("Ingrese su especialidad");
		numeroDeConsultorio=Integer.parseInt(JOptionPane.showInputDialog("Número de consultorio"));
	}
	
	@Override
	public void imprimirDatosPersona(String datos) {
		super.imprimirDatosPersona(datos);
		
		datos="Especialidad: "+especialidad+"\n";
		datos+="Número de consultorio: "+numeroDeConsultorio+"\n";
		
		System.out.println(datos);
	}
	
}	
