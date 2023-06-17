package clases.empleado;

import javax.swing.JOptionPane;

public class EmpleadoEventual extends Empleado {
	
	private double honorariosPorHora;
	private String fechaTerminoContrato;
	
	public double getHonorariosPorHora() {
		return honorariosPorHora;
	}
	
	public void setHonorariosPorHora(double honorariosPorHora) {
		this.honorariosPorHora = honorariosPorHora;
	}
	
	public String getFechaTerminoContrato() {
		return fechaTerminoContrato;
	}
	
	public void setFechaTerminoContrato(String fechaTerminoContrato) {
		this.fechaTerminoContrato = fechaTerminoContrato;
	}
	
	@Override
	public void registrarDatos() {
		super.registrarDatos();
		
		honorariosPorHora=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario mensual"));
		fechaTerminoContrato=JOptionPane.showInputDialog("Ingrese fecha de nacimiento (dd/mm/aaaa)");
		
	}
	
	@Override
	public void imprimirDatosPersona(String datos) {
		super.imprimirDatosPersona(datos);
		
		datos="Honorarios por hora: "+honorariosPorHora+"\n";
		datos+="Fecha termino del contraro: "+fechaTerminoContrato+"\n";
		
		System.out.println(datos);
	}
}	
