package clases;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Paciente extends Persona {
	
	private int numeroHistoriaClinica;
	private String sexo;
	private String grupoSanguineo;
	private ArrayList<String> listaMedicamentosAlergico;
	
	
	public int getNumeroHistoriaClinica() {
		return numeroHistoriaClinica;
	}
	
	public void setNumeroHistoriaClinica(int numeroHistoriaClinica) {
		this.numeroHistoriaClinica = numeroHistoriaClinica;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}
	
	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}
	
	public ArrayList<String> getListaMedicamentosAlergico() {
		return listaMedicamentosAlergico;
	}
	
	public void setListaMedicamentosAlergico(ArrayList<String> listaMedicamentosAlergico) {
		this.listaMedicamentosAlergico = listaMedicamentosAlergico;
	}
	
	@Override
	public void registrarDatos() {
		
		//llamamos al método registrar datos de la superClase para continuar llenando
		//los datos del paciente junto con los heredados.
		super.registrarDatos();
		
		//llenamos los datos especificos del paciente
		listaMedicamentosAlergico=new ArrayList<String>();
		numeroHistoriaClinica=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de la historia clínica"));
		sexo=JOptionPane.showInputDialog("Ingrese el sexo");
		grupoSanguineo=JOptionPane.showInputDialog("Ingrese el grupo sanguineo");
		
		String pregunta=JOptionPane.showInputDialog("¿Es alérgico a algún medicamento? Ingrese si o no");
		
		if (pregunta.equalsIgnoreCase("si")) {
			
			String medicamento="";
			String continuar="";
			do {
				medicamento=JOptionPane.showInputDialog("Ingrese el nombre del medicamento al que es alérgico");
				listaMedicamentosAlergico.add(medicamento);
				
				continuar=JOptionPane.showInputDialog("Ingrese 'SI', si desea continuar");
			} while (continuar.equalsIgnoreCase("si"));
			
		}
		
	}
	
	@Override
	public void imprimirDatosPersona(String datos) {
		super.imprimirDatosPersona(datos);
		
		datos="Numero historia clínica: "+numeroHistoriaClinica+"\n";
		datos+="Sexo: "+sexo+"\n";
		datos+="Grupo sanguineo: "+grupoSanguineo+"\n";
		
		if (listaMedicamentosAlergico.size()>0) {
			datos+="Lista de medicamentos a los que es alérgico\n";
			for (int i = 0; i < listaMedicamentosAlergico.size(); i++) {
				datos+="\t"+listaMedicamentosAlergico.get(i)+"\n";
			}
		}else {
			datos+="El paciente no es alérgico a ningún medicamento.";
		}
		System.out.println(datos);
		
	}
	
}
