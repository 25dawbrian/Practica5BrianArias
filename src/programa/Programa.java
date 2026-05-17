package programa;

import java.util.InputMismatchException;
import java.util.Scanner;
import clases.GestorOrdenadores;
import menus.Menus;

public class Programa {
	static Scanner input = new Scanner(System.in);

	/**
	 * @author Brian Arias
	 */
	public static void main(String[] args) {
		GestorOrdenadores gestor = new GestorOrdenadores();
		Menus menu = new Menus(gestor);

		/**
		 * Carga de datos iniciales :
		 * Menu principal con las difentes funcionalidades.
		 */
		gestor.datosIniciales();

		System.out.println("========================================");
		System.out.println("||          DEPARTAMENTO TIC          ||");
		System.out.println("||      GESTION DE INVENTARIO IT      ||");
		System.out.println("========================================");
		int opcion = 0;
		boolean opcionCorrecta = false;
		do {
			System.out.println("==========================================");
			System.out.println("||----------MENU PRINCIPAL--------------||");
			System.out.println("==========================================");
			System.out.println("||      1.-Dar de alta un usuario.      ||");
			System.out.println("||      2.-Dar de alta un ordenador.    ||");
			System.out.println("||      3.-Listar usuarios.             ||");
			System.out.println("||      4.-Listar ordenadores.          ||");
			System.out.println("||      5.-Buscar usuario.              ||");
			System.out.println("||      6.-Buscar ordenador.            ||");
			System.out.println("||      7.-Dar de baja un usuario.      ||");
			System.out.println("||      8.-Eliminar un ordenador.       ||");
			System.out.println("||      9.-Asignar ordenador.           ||");
			System.out.println("||     10.-Salir del gestor.            ||");
			System.out.println("==========================================");
			try {
				System.out.print("Selecciona una accion: ");
				opcion = input.nextInt();
				input.nextLine();
				opcionCorrecta = true;
			} catch (InputMismatchException e) {
				System.out.println("Error: debes introducir un numero");
				input.nextLine();
			}
			if (opcionCorrecta) {
				switch (opcion) {
				case 1:
					System.out.println("1.-Dar de alta un usuario");
					gestor.altaUsuario();
					break;
				case 2:
					System.out.println("2.-Dar de alta un ordenador");
					menu.menuAltas();
					break;
				case 3:
					System.out.println("3.-Listar usuarios");
					gestor.listarUsuarios();
					break;
				case 4:
					System.out.println("4.-Listar ordenadores");
					menu.menuListar();
					break;
				case 5:
					System.out.println("5.-Buscar usuarios");
					menu.menuBuscarUsuario();
					break;
				case 6:
					System.out.println("6.-Buscar ordenador");
					menu.menuBuscarOrdenador();
					break;
				case 7:
					System.out.println("7.-Dar de baja un usuario");
					gestor.darDeBajaUsuario();
					break;
				case 8:
					System.out.println("8.-Eliminar un ordenador");
					gestor.eliminarOrdenadorPorEtiqueta();
					break;
				case 9:
					System.out.println("9.-Asignar ordenador");
					gestor.asignarOrdenadorAUsuario();
					break;
				case 10:
					System.out.println("=========================================");
					System.out.println("   _____ _____ _____ ");
					System.out.println("  |_   _|_   _/ ____|");
					System.out.println("    | |   | || |     ");
					System.out.println("    | |   | || |     ");
					System.out.println("   _| |_ _| || |____ ");
					System.out.println("  |_____|_____\\____|");
					System.out.println();
					System.out.println(" Inventario IT cerrado correctamente");
					System.out.println(" Hasta la proxima.");
					System.out.println("=========================================");
					break;
				default:
					System.out.println("Opcion no contemplada");
					break;
				}
			}

		} while (opcion != 10);
	}

}
