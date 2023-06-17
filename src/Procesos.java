import javax.swing.JOptionPane;

import clases.CitaMedica;
import clases.ModeloDatos;
import clases.Paciente;
import clases.empleado.EmpleadoEventual;
import clases.empleado.EmpleadoPlanilla;
import clases.empleado.Medico;

public class Procesos {
	
	ModeloDatos miModeloDatos;
	
	public Procesos() {
		miModeloDatos=new ModeloDatos();
		presentarMenuOpciones();
	}

	private void presentarMenuOpciones() {
		
		String menu="MENU HOSPITAL\n";
		menu+="1. Registrar paciente\n";
		menu+="2. Registrar empleado\n";
		menu+="3. Registrar cita médica\n";
		menu+="4. Imprimir información\n";
		menu+="5. Salir\n";
		menu+="Ingrese una opción:\n";
		
		int opcion=0;
		
		do {
			opcion=Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch (opcion) {
			
			case 1: registrarPaciente(); break;
			case 2: registrarEmpleado(); break;
			case 3: registrarCitaMedica(); break;
			case 4: imprimirInformacion(); break;
			case 5: System.out.println("El sistema ha terminado."); break;
			default: System.out.println("No existe la opción, verifique nuevamente.");
				break;
			}
			
		} while (opcion!=5);
	}
	
	private void registrarPaciente() {
		
		Paciente miPaciente=new Paciente();
		miPaciente.registrarDatos();
		
		miModeloDatos.registrarPersona(miPaciente);
		
	}
	
	private void registrarEmpleado() {
		
		String menuTipoEmpleado="REGISTRO DE EMPLEADO\n";
		menuTipoEmpleado+="1. Empleado eventual\n";
		menuTipoEmpleado+="2. Empleado por plantilla\n";
		menuTipoEmpleado+="Seleccione el tipo de empleado a registrar:\n";
		
		int tipoEmpleado=Integer.parseInt(JOptionPane.showInputDialog(menuTipoEmpleado));
		
		switch (tipoEmpleado) {
		case 1:	//Registro Empleado Eventual
				EmpleadoEventual miEmpleadoEventual=new EmpleadoEventual();
				miEmpleadoEventual.registrarDatos();
				miModeloDatos.registrarPersona(miEmpleadoEventual);
			break;
			
		case 2:	
				String resp=JOptionPane.showInputDialog("Ingrese 'SI', si es un médico, de lo contrario es otro tipo de empleado");
				if (resp.equalsIgnoreCase("si")) {
					//Registro medico
					Medico miMedico=new Medico();
					miMedico.registrarDatos();
					miModeloDatos.registrarPersona(miMedico);
				}else {
					//Registro empleado planilla
					EmpleadoPlanilla miEmpleadoPlanilla=new EmpleadoPlanilla();
					miEmpleadoPlanilla.registrarDatos();
					miModeloDatos.registrarPersona(miEmpleadoPlanilla);
				}
		break;
			
		default: System.out.println("El tipo de empleado no es válido, inténtelo nuevamente.");
			break;
		}
		
	}
	
	private void imprimirInformacion() {
		String menuImprimir="MENÚ INFORMACIONES\n";
		menuImprimir+="1. Listar pacientes\n";
		menuImprimir+="2. Listar empleados eventuales\n";
		menuImprimir+="3. Listar empleados por planilla\n";
		menuImprimir+="4. Listar medicos\n";
		menuImprimir+="5. Listar citas programadas\n";
		menuImprimir+="Ingrese una opción:\n";
		
		System.out.println("--------------------------------------------------------------------------");

		int opcion=Integer.parseInt(JOptionPane.showInputDialog(menuImprimir));
		
		switch (opcion) {
		case 1: miModeloDatos.imprimirPacientes(); break;
		case 2: miModeloDatos.imprimirEmpleadosEventuales(); break;
		case 3: miModeloDatos.imprimirEmpleadosPorPlanilla(); break;
		case 4: miModeloDatos.imprimirMedicos(); break;
		case 5: miModeloDatos.imprimirCitasMedicasProgramadas(); break;

		default: System.out.println("No existe esa opción.");
			break;
		}
		
	}
	
	private void registrarCitaMedica() {
		String documentoPaciente=JOptionPane.showInputDialog("Ingrese el documento del paciente");
		
		Paciente pacienteEncontrado=miModeloDatos.consultarPacientePorDocumento(documentoPaciente);
		
		if (pacienteEncontrado!=null) {
			String nombreMedico=JOptionPane.showInputDialog("Ingrese el nombre del médico");
			Medico medicoEncontrado=miModeloDatos.consultarMedicoPorNombre(nombreMedico);
			
			if (medicoEncontrado!=null) {
				
				String servicio=JOptionPane.showInputDialog("Ingrese el servicio o motivo de la consulta");
				String fechaConsulta=JOptionPane.showInputDialog("Ingrese la fecha de la consulta");
				String horaConsulta=JOptionPane.showInputDialog("Ingrese la hora de la consulta");
				String lugar="La cita será en el consultorio "+medicoEncontrado.getNumeroDeConsultorio();
				CitaMedica miCita=new CitaMedica(pacienteEncontrado, medicoEncontrado, servicio, fechaConsulta, horaConsulta, lugar);
				miModeloDatos.registrarCitaMedica(miCita);
				
			}else {
				System.out.println("El médico no se encuentra registrado en el sistema");
			}
		}else {
			System.out.println("El paciente no se encuentra registrado en el sistema");
		}
		
	}
	
}
