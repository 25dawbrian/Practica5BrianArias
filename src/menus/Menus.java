package menus;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Clase Menus
 * Aqui gestionaremos los diferentes menus delp programa,
 * cada uno metido en un metodo
 */
import clases.GestorOrdenadores;

public class Menus {
	
	Scanner input = new Scanner(System.in);
	private GestorOrdenadores gestor;

	public Menus(GestorOrdenadores gestor) {
		this.gestor = gestor;
	}
	
	/**
	 * Menu de altas
	 */
	public void menuAltas() {
		int opcionAlta;
		do {
			System.out.println("============================================");
			System.out.println("||---------------MENU ALTAS---------------||");
			System.out.println("============================================");
			System.out.println("||      1.-Dar de alta una torre.         ||");
			System.out.println("||      2.-Dar de alta un sobremesa.      ||");
			System.out.println("||      3.-Dar de alta un portatil.       ||");
			System.out.println("||      4.-Volver al menu principal.      ||");
			System.out.println("============================================");
			System.out.print("Selecciona una accion: ");
			opcionAlta = input.nextInt();
			switch (opcionAlta) {
			case 1:
				System.out.println("1.-Dar de alta una torre");
				gestor.altaOrdenadorTorre();
				;
				break;
			case 2:
				System.out.println("2.-Dar de alta un sobremesa");
				gestor.altaOrdenadorSobremesa();
				break;
			case 3:
				System.out.println("3.-Dar de alta un portatil");
				gestor.altaOrdenadorPortatil();
				break;
			case 4:
				System.out.println("4.-Volver al menu principal");
				System.out.println("Has vuelto al menu principal");
				System.out.println("");
				break;
			default:
				System.out.println("Opcion no contemplada");
				break;
			}

		} while (opcionAlta != 4);
	}
	
	/**
	 * Menu de listar
	 */
	public void menuListar() {
		int opcionListar;
		do {
			System.out.println("====================================================");
			System.out.println("||------------------MENU LISTAR-------------------||");
			System.out.println("====================================================");
			System.out.println("||      1.-Listar por torres.                     ||");
			System.out.println("||      2.-Listar por sobremesas.                 ||");
			System.out.println("||      3.-Listar por portatil.                   ||");
			System.out.println("||      4.-Listar ordenadores por departamento.   ||");
			System.out.println("||      5.-Listar todos los ordenadores.          ||");
			System.out.println("||      6.-Volver al menu principal.              ||");
			System.out.println("====================================================");
			System.out.print("Selecciona una accion: ");
			opcionListar = input.nextInt();
			switch (opcionListar) {
			case 1:
				System.out.println("1.-Listar por torres");
				gestor.listarTorres();
				break;
			case 2:
				System.out.println("2.-Listar por sobremesas");
				gestor.listarSobremesas();
				break;
			case 3:
				System.out.println("3.-Listar por portatil");
				gestor.listarPortatiles();
				break;
			case 4:
				gestor.listarOrdenadoresPorDepartamento();
				break;
			case 5:
				System.out.println("5.-Listar todos los ordenadores");
				gestor.listarOrdenadores();
				break;
			case 6:
				System.out.println("Volver al menu principal");
				break;
			default:
				System.out.println("Opcion no contemplada");
				break;
			}

		} while (opcionListar != 6);
	}
	
	/**
	 * Menu de buscar usuario
	 */
	public void menuBuscarUsuario() {
		int opcionBuscarUsuario = 0;
		do {
			System.out.println("============================================");
			System.out.println("||-----------MENU BUSCAR USUARIO----------||");
			System.out.println("============================================");
			System.out.println("||      1.-Buscar por ID.                 ||");
			System.out.println("||      2.-Buscar por su ordenador.       ||");
			System.out.println("||      3.-Volver al menu principal.      ||");
			System.out.println("============================================");
			System.out.print("Selecciona una accion: ");
			try {
				opcionBuscarUsuario = input.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Error: debes introducir un numero");
				input.nextLine();
			}
			switch (opcionBuscarUsuario) {
			case 1:
				System.out.println("1.-Buscar por nombre");
				gestor.buscarUsuarioID();
				break;
			case 2:
				System.out.println("2.-Buscar por su ordenador");
				gestor.buscarUsuarioPorEtiquetaOrdenador();
				break;
			case 3:
				System.out.println("Has vuelto al menu principal");
				break;
			default:
				System.out.println("Opcion no contemplada");
				break;
			}
		} while (opcionBuscarUsuario != 3);
	}
	
	/**
	 * Menu de buscar ordenador
	 */
	public void menuBuscarOrdenador() {
		int opcionBuscarOrdenador = 0;
		do {
			System.out.println("============================================");
			System.out.println("||----------MENU BUSCAR ORDENADOR----------||");
			System.out.println("=============================================");
			System.out.println("||      1.-Buscar por etiqueta.            ||");
			System.out.println("||      2.-Buscar por numero de serie.     ||");
			System.out.println("||      3.-Volver al menu principal.       ||");
			System.out.println("=============================================");
			System.out.print("Selecciona una accion: ");
			try {
				opcionBuscarOrdenador = input.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Error: debes introducir un numero");
				input.nextLine();
			}
			switch (opcionBuscarOrdenador) {
			case 1:
				System.out.println("1.-Buscar por etiqueta");
				gestor.buscarOrdenadorPorEtiqueta();
				break;
			case 2:
				System.out.println("2.-Buscar por numeros de serie");
				gestor.buscarOrdenadorPorNumeroSerie();
				break;
			case 3:
				System.out.println("Has vuelto al menu principal");
				break;
			default:
				System.out.println("Opcion no contemplada");
				break;
			}

		} while (opcionBuscarOrdenador != 3);
	}
}
