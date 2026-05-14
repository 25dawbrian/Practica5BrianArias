package programa;

import java.util.Scanner;
import clases.GestorOrdenadores;
import menus.Menus;

public class Programa {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		GestorOrdenadores gestor = new GestorOrdenadores();
		Menus menu = new Menus(gestor);

		// cargamos datos iniciales
		gestor.datosIniciales();

		System.out.println("========================================");
		System.out.println("||          DEPARTAMENTO TIC          ||");
		System.out.println("||      GESTION DE INVENTARIO IT      ||");
		System.out.println("========================================");
		int opcion;
		do {
			System.out.println("==========================================");
			System.out.println("||----------MENU PRINCIPAL--------------||");
			System.out.println("==========================================");
			System.out.println("||      1.-Dar de alta un ordenador     ||");
			System.out.println("||      2.-Listar ordenadores           ||");
			System.out.println("||      3.-Dar de alta un usuario       ||");
			System.out.println("||      4.-Listar usuarios              ||");
			System.out.println("||      5.-Buscar usuario               ||");
			System.out.println("||      6.-Buscar ordenador             ||");
			System.out.println("||      7.-Dar de baja un usuario       ||");
			System.out.println("||      8.-Eliminar un ordenador        ||");
			System.out.println("==========================================");
			System.out.print("Selecciona una accion: ");
			opcion = input.nextInt();
			System.out.println();
			switch (opcion) {
			case 1:
				System.out.println("1.-Dar de alta un ordenador");
				menu.menuAltas();
				break;
			case 2:
				System.out.println("2.-Listar ordenadores");
				menu.menuListar();
				break;
			case 3:
				System.out.println("3.-Dar de alta un usuario");
				gestor.altaUsuario();
				break;
			case 4:
				System.out.println("4.-Listar usuarios");
				gestor.listarUsuarios();
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
			default:
				System.out.println("Opcion no contemplada");
				break;
			}

		} while (opcion != 8);
	}

}
