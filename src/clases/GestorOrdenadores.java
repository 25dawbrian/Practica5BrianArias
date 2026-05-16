package clases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class GestorOrdenadores {
	Scanner input = new Scanner(System.in);
	private ArrayList<Ordenadores> listaOrdenadores;
	private ArrayList<Usuarios> listaUsuarios;
	private ArrayList<Departamentos> listaDepartamentos;

	public GestorOrdenadores() {
		listaOrdenadores = new ArrayList<Ordenadores>();
		listaUsuarios = new ArrayList<Usuarios>();
		listaDepartamentos = new ArrayList<>();

	}

	public void datosIniciales() {
		// damos de alta 2 ordenadores de cada tipo
		altaOrdenadorTorre("Torre", "Legion T5", "Ryzen 7 7600G", true, "RTX 4070", 32, 1000, "Liquida", "265EIR",
				"TOR/2025/001", 850);
		altaOrdenadorTorre("Torre", "HP Omen 45L", "Intel i7 13700K", false, "RTX 4080", 64, 2000, "Ventilador",
				"098UPE", "TOR/2026/001", 1000);

		altaOrdenadorSobremesa("Sobremesa", "HP ProDesk 600", "Intel Core i5 9700K", "GTX 1650", 8, 500, "164PSO",
				"SOB/2025/001", "Mini");
		altaOrdenadorSobremesa("Sobremesa", "HP EliteDesk 600", "Intel Core i7 10800F", "RTX 2060", 16, 1250, "876HYU",
				"SOB/2026/001", "Barebone");

		altaOrdenadorPortatil("Portatil", "Surface Laptop 4", "AMD Ryzen 5 3600", "RTX 3060", 16, 1000, "052JOE",
				"POR/2025/001", 15, 30, true);
		altaOrdenadorPortatil("Portatil", "Galaxy Book 4", "Intel Core i7 11900K", "GTX 1660", 16, 500, "086GEQ",
				"POR/2026/001", 20, 20, true);

		// damos de alta 3 departamentos(Financiero, Diseño 3D y Marketing)
		Departamentos financiero = new Departamentos("Financiero");
		Departamentos disennio3d = new Departamentos("Diseño 3D");
		Departamentos marketing = new Departamentos("Marketing");

		// damos de alta 3 usuarios
		altaUsuario("Eva", "Lopez", financiero, "evalopez@briancompany.com", 26, listaOrdenadores.get(0));
		altaUsuario("Luis", "Perez", disennio3d, "luisperez@briancompany.com", 32, listaOrdenadores.get(2));
		altaUsuario("Pepe", "Villanueva", marketing, "pepevillanueva@gmail.com", 43, listaOrdenadores.get(4));
	}

	// alta departamento
	public void altaDepartamento(String nombreDepartamento) {
		Departamentos nuevoDepartamento = new Departamentos(nombreDepartamento);
		listaDepartamentos.add(nuevoDepartamento);
	}

	// alta Ordenador Torre por teclado
	public void altaOrdenadorTorre() {
		String tipoOrdenador = "";

		System.out.print("Introduce el modelo: ");
		String modelo = input.nextLine();

		System.out.print("Introduce el procesador: ");
		String procesador = input.nextLine();
		String seleccionGraficosIntegrados;
		boolean graficosIntegrados = false;

		do {
			System.out.print("El procesador tiene graficos integrados (si/no)? ");
			seleccionGraficosIntegrados = input.nextLine();

			if (seleccionGraficosIntegrados.equalsIgnoreCase("si")) {
				graficosIntegrados = true;
			} else if (seleccionGraficosIntegrados.equalsIgnoreCase("no")) {
				graficosIntegrados = false;
			} else {
				System.out.println("Debes escribir si o no: ");
			}

		} while (!seleccionGraficosIntegrados.equalsIgnoreCase("si")
				&& !seleccionGraficosIntegrados.equalsIgnoreCase("no"));

		String tarjetaGrafica = "";

		System.out.print("¿El ordenador tiene tarjeta grafica? ");
		String seleccionTarjetaGrafica = input.nextLine();

		if (seleccionTarjetaGrafica.equalsIgnoreCase("si")) {

			System.out.print("Introduce la tarjeta grafica: ");
			tarjetaGrafica = input.nextLine();
		}

		System.out.print("Potencia de la fuente de alimentacion (W): ");
		int potenciaFuenteAlimentacion = input.nextInt();
		input.nextLine();

		System.out.print("Cantidad de RAM (GB): ");
		int capacidadMemoriaRAM = input.nextInt();
		input.nextLine();

		System.out.print("Cantidad de almacenamiento (GB): ");
		int almacenamiento = input.nextInt();
		input.nextLine();

		System.out.print("Tipo de refrigeracion (ventilador/liquida): ");
		String refrigeracion = input.nextLine();

		System.out.print("Numero de serie: ");
		String numeroSerie = input.nextLine();

		System.out.print("Etiqueta: ");
		String etiqueta = input.nextLine();

		OrdenadorTorre nuevoOrdenadorTorre = new OrdenadorTorre(tipoOrdenador, modelo, procesador, graficosIntegrados,
				tarjetaGrafica, capacidadMemoriaRAM, almacenamiento, refrigeracion, numeroSerie, etiqueta,
				potenciaFuenteAlimentacion);

		listaOrdenadores.add(nuevoOrdenadorTorre);

		System.out.println("Ordenador añadido correctamente");
		System.out.println();
	}

	// alta Ordenador Torre
	public void altaOrdenadorTorre(String tipoOrdenador, String modelo, String procesador, boolean graficosIntegrados,
			String tarjetaGrafica, int capacidadMemoriaRAM, int almacenamiento, String refrigeracion,
			String numeroSerie, String etiqueta, int potenciaFuenteAlimentacion) {

		OrdenadorTorre nuevoOrdenadorTorre = new OrdenadorTorre(tipoOrdenador, modelo, procesador, graficosIntegrados,
				tarjetaGrafica, capacidadMemoriaRAM, almacenamiento, refrigeracion, numeroSerie, etiqueta,
				potenciaFuenteAlimentacion);

		listaOrdenadores.add(nuevoOrdenadorTorre);
	}

	// alta ordenador sobremesa por teclado
	public void altaOrdenadorSobremesa() {
		String tipoOrdenador = "";

		System.out.print("Introduce el modelo: ");
		String modelo = input.nextLine();

		System.out.print("Introduce el procesador: ");
		String procesador = input.nextLine();

		System.out.println("Introduce la tarjeta grafica");
		String tarjetaGrafica = input.nextLine();

		System.out.print("Cantidad de RAM (GB): ");
		int capacidadMemoriaRAM = input.nextInt();
		input.nextLine();

		System.out.print("Cantidad de almacenamiento (GB): ");
		int almacenamiento = input.nextInt();
		input.nextLine();

		System.out.println("Tipo de caja: ");
		String tipoCaja = input.nextLine();

		System.out.print("Numero de serie: ");
		String numeroSerie = input.nextLine();

		System.out.print("Etiqueta: ");
		String etiqueta = input.nextLine();

		OrdenadorSobremesa nuevoOrdenadorSobremesa = new OrdenadorSobremesa(tipoOrdenador, modelo, procesador,
				tarjetaGrafica, capacidadMemoriaRAM, almacenamiento, numeroSerie, etiqueta, tipoCaja);
		listaOrdenadores.add(nuevoOrdenadorSobremesa);
	}

	// alta ordenador sobremesa
	public void altaOrdenadorSobremesa(String tipoOrdenador, String modelo, String procesador, String tarjetaGrafica,
			int capacidadMemoriaRAM, int almacenamiento, String numeroSerie, String etiqueta, String tipoCaja) {
		OrdenadorSobremesa nuevoOrdenadorSobremesa = new OrdenadorSobremesa(tipoOrdenador, modelo, procesador,
				tarjetaGrafica, capacidadMemoriaRAM, almacenamiento, numeroSerie, etiqueta, tipoCaja);
		listaOrdenadores.add(nuevoOrdenadorSobremesa);
	}

	// alta ordenador portatil por teclado
	public void altaOrdenadorPortatil() {
		String tipoOrdenador = "";

		System.out.print("Introduce el modelo: ");
		String modelo = input.nextLine();

		System.out.print("Introduce el procesador: ");
		String procesador = input.nextLine();

		System.out.println("Introduce la tarjeta grafica");
		String tarjetaGrafica = input.nextLine();

		System.out.print("Cantidad de RAM (GB): ");
		int capacidadMemoriaRAM = input.nextInt();
		input.nextLine();

		System.out.print("Cantidad de almacenamiento (GB): ");
		int almacenamiento = input.nextInt();
		input.nextLine();

		System.out.println("Cantidad de pulgadas: ");
		double pulgadas = input.nextInt();

		System.out.println("Tiempo de autonomía (horas): ");
		double autonomia = input.nextInt();

		System.out.println("Introduce el numero de serie: ");
		String numeroSerie = input.nextLine();

		System.out.println("Introduce la etiqueta: ");
		String etiqueta = input.nextLine();

		boolean webcam = true;
		OrdenadorPortatil nuevoOrdenadorPortatil = new OrdenadorPortatil(tipoOrdenador, modelo, procesador, false,
				tarjetaGrafica, capacidadMemoriaRAM, almacenamiento, numeroSerie, etiqueta, pulgadas, autonomia,
				webcam);
		listaOrdenadores.add(nuevoOrdenadorPortatil);
	}

	// alta ordenador portatil
	public void altaOrdenadorPortatil(String tipoOrdenador, String modelo, String procesador, String tarjetaGrafica,
			int capacidadMemoriaRAM, int almacenamiento, String numeroSerie, String etiqueta, double pulgadas,
			double autonomia, boolean webcam) {
		OrdenadorPortatil nuevoOrdenadorPortatil = new OrdenadorPortatil(tipoOrdenador, modelo, procesador, false,
				tarjetaGrafica, capacidadMemoriaRAM, almacenamiento, numeroSerie, etiqueta, pulgadas, autonomia,
				webcam);
		listaOrdenadores.add(nuevoOrdenadorPortatil);
	}

	// alta usuario por teclado
	public void altaUsuario() {

		System.out.print("Introduce el nombre: ");
		String nombre = input.nextLine();

		System.out.print("Introduce los apellidos: ");
		String apellidos = input.nextLine();

		String email = "";
		int opcionEmail;
		System.out.println("Selecciona modo de introduccion del email: ");
		do {
			System.out.println("1.-Introducir email por teclado");
			System.out.println("2.-Generar email con nombre y apellidos");
			System.out.println();

			opcionEmail = input.nextInt();
			input.nextLine();

			switch (opcionEmail) {
			case 1:
				boolean emailValido;
				do {
					System.out.print("Introduce el email: ");
					email = input.nextLine();
					emailValido = Usuarios.validarEmail(email);
					if (!emailValido) {
						System.out.println("Formato incorrecto");
					}
				} while (!emailValido);
				break;

			case 2:
				email = Usuarios.generarEmailEmpresa(nombre, apellidos);
				System.out.println("Email generado: " + email);
				break;

			default:
				System.out.println("Opcion no contemplada");
				break;
			}
		} while (opcionEmail < 1 || opcionEmail > 2);

		System.out.print("Introduce la edad: ");
		int edad = input.nextInt();
		input.nextLine();

		// asignacion del departamento
		Usuarios nuevoUsuario = new Usuarios(nombre, apellidos, null, email, edad, null);
		int opcionDepartamento;
		do {
			System.out.println("Selecciona un departamento");
			System.out.println("1. Financiero");
			System.out.println("2. Diseño 3D");
			System.out.println("3. Marketing");

			opcionDepartamento = input.nextInt();
			switch (opcionDepartamento) {
			case 1:
				nuevoUsuario.setDepartamento(listaDepartamentos.get(0));
				break;
			case 2:
				nuevoUsuario.setDepartamento(listaDepartamentos.get(1));
				break;
			case 3:
				nuevoUsuario.setDepartamento(listaDepartamentos.get(2));
				break;
			default:
				System.out.println("Opcion incorrecta");
				System.out.println();
			}
		} while (opcionDepartamento < 1 || opcionDepartamento > 3);

		// mostrar ordenadores disponibles
		listarOrdenadores();
		System.out.print("Selecciona un ordenador de los disponibles: ");

		// asignacion del ordenador
		int opcionOrdenador = input.nextInt();
		input.nextLine();
		nuevoUsuario.setOrdenador(listaOrdenadores.get(opcionOrdenador - 1));

		// creacion del usuario
		listaUsuarios.add(nuevoUsuario);
		System.out.println("Usuario añadido correctamente");
	}

	// alta usuario
	public void altaUsuario(String nombre, String apellidos, Departamentos departamento, String email, int edad,
			Ordenadores ordenador) {

		Usuarios nuevoUsuario = new Usuarios(nombre, apellidos, departamento, email, edad, ordenador);
		listaUsuarios.add(nuevoUsuario);

	}

	// listar todos los ordanadores
	public void listarOrdenadores() {
		int contador = 1;
		for (Ordenadores ordenadores : listaOrdenadores) {
			if (ordenadores != null) {
				System.out.println("Ordenador " + contador + ".- " + ordenadores);
				contador++;
			}
		}
	}

	// listar torres
	public void listarTorres() {
		for (Ordenadores torres : listaOrdenadores) {
			if (torres.getTipoOrdenador().equalsIgnoreCase("torre")) {
				System.out.println(torres);
			}
		}
	}

	// listar sobremesas
	public void listarSobremesas() {
		for (Ordenadores sobremesa : listaOrdenadores) {
			if (sobremesa.getTipoOrdenador().equalsIgnoreCase("sobremesa")) {
				System.out.println(sobremesa);
			}
		}
	}

	// listar portatiles
	public void listarPortatiles() {
		for (Ordenadores portatil : listaOrdenadores) {
			if (portatil.getTipoOrdenador().equalsIgnoreCase("portatil")) {
				System.out.println(portatil);
			}
		}
	}

	// listar usuarios
	public void listarUsuarios() {
		for (Usuarios usu : listaUsuarios) {
			if (usu != null) {
				System.out.println(usu);
			}
		}
	}

	// buscarUsurioPorNombre
	public void buscarUsuarioNombre() {
		System.out.print("Introduce el nombre del usuario: ");
		String nombreBuscar = input.nextLine();
		boolean nombreEncontrado = false;
		for (Usuarios usu : listaUsuarios) {
			if (usu.getNombre().equalsIgnoreCase(nombreBuscar)) {
				System.out.println("Usuario encontrado");
				System.out.println(usu);
				nombreEncontrado = true;
			}
		}
		if (!nombreEncontrado) {
			System.out.println("No existe ningun usuario con ese nombre");
		}
	}
	
	public Usuarios buscarUsuarioNombre(String nombre) {
	    for (Usuarios usu : listaUsuarios) {
	        if (usu.getNombre().equalsIgnoreCase(nombre)) {
	            return usu;
	        }
	    }
	    return null;
	}

	// buscar usuario por etiqueta del ordenador de uso
	public void buscarUsuarioPorEtiquetaOrdenador() {
		System.out.print("Introduce la etiqueta del ordenador que usa el usuario: ");
		String etiquetaUsuarioBuscar = input.nextLine();
		boolean etiquetaUsuarioEncontrada = false;
		for (Usuarios usu : listaUsuarios) {
			if (usu.getOrdenador() != null) {
				if (usu.getOrdenador().getEtiqueta().equalsIgnoreCase(etiquetaUsuarioBuscar)) {
					System.out.println("Usuario encontrado:");
					System.out.println(usu);
					etiquetaUsuarioEncontrada = true;
				}
			}
		}
		if (!etiquetaUsuarioEncontrada) {
			System.out.println("Ningun usuario tiene asignado ese ordenador");
		}
	}

	// buscar ordenador por etiqueta
	public void buscarOrdenadorPorEtiqueta() {
		System.out.print("Introduce la etiqueta del ordenador: ");
		String buscarEtiqueta = input.nextLine();
		boolean etiquetaPCEncontrada = false;
		for (Ordenadores ord : listaOrdenadores) {
			if (ord.getEtiqueta().equals(buscarEtiqueta)) {
				System.out.println("Ordenador encontrado:");
				System.out.println(ord);
				etiquetaPCEncontrada = true;
			}
		}
		if (!etiquetaPCEncontrada) {
			System.out.println("Este ordenador no existe");
		}
	}
	
	public Ordenadores buscarOrdenadorPorEtiqueta(String etiqueta) {
	    for (Ordenadores ord : listaOrdenadores) {
	        if (ord.getEtiqueta().equalsIgnoreCase(etiqueta)) {
	            return ord;
	        }
	    }
	    return null;
	}

	// buscar ordendador por numero de serie
	public void buscarOrdenadorPorNumeroSerie() {
		System.out.print("Introduce el numero de serie del ordenador:");
		String buscarNumeroSerie = input.nextLine();
		boolean numeroSerieEncontrado = false;
		for (Ordenadores ord : listaOrdenadores) {
			if (ord.getNumeroSerie().equals(buscarNumeroSerie)) {
				System.out.print("Odenador encontrado:");
				System.out.println(ord);
				numeroSerieEncontrado = true;
			}
		}
		if (!numeroSerieEncontrado) {
			System.out.println("Este ordenador no existe");
		}
	}

	// eliminar usuario
	public void darDeBajaUsuario() {
		System.out.print("Introduce el nombre del usuario que quieras dar de baja: ");
		String nombre = input.nextLine();
		boolean usuarioExiste = false;
		Iterator<Usuarios> iteradorUsuarios = listaUsuarios.iterator();
		while (iteradorUsuarios.hasNext()) {
			Usuarios usuario = iteradorUsuarios.next();
			if (usuario.getNombre().equalsIgnoreCase(nombre)) {
				iteradorUsuarios.remove();
				System.out.println("El usuario: [" + nombre + "] ha sido dado de baja de la empresa.");
				usuarioExiste = true;
			}
		}
		if (!usuarioExiste) {
			System.out.println("El usuario " + nombre + " no existe");
		}
	}

	// eliminar ordenador
	public void eliminarOrdenadorPorEtiqueta() {
		System.out.print("Introduce la etiqueta del ordenador: ");
		String etiqueta = input.nextLine();
		Ordenadores ordenadorEliminar = null;
		boolean ordenadorExiste = false;

		Iterator<Ordenadores> iteradorOrdenadores = listaOrdenadores.iterator();
		while (iteradorOrdenadores.hasNext()) {
			Ordenadores ordenador = iteradorOrdenadores.next();
			if (ordenador.getEtiqueta().equalsIgnoreCase(etiqueta)) {
				ordenadorEliminar = ordenador;
				iteradorOrdenadores.remove();

				System.out.println("El ordenador con la etiqueta [ " + etiqueta + " ] ha sido eliminado del inventario.");
				ordenadorExiste = true;
			}
		}
		if (!ordenadorExiste) {
			System.out.println("No existe nigun ordenador con la etiqueta [" + etiqueta + "]");
		}
		if (ordenadorEliminar != null) {
			desasignarOrdenadorDeUsuarios(ordenadorEliminar);
		}
	}

	public void desasignarOrdenadorDeUsuarios(Ordenadores ordenador) {
		for (Usuarios ord : listaUsuarios) {
			if (ord.getOrdenador() != null && ord.getOrdenador().equals(ordenador)) {
				ord.setOrdenador(null);
			}
		}
	}
	public void asignarOrdenadorAUsuario() {
	    System.out.print("Nombre del usuario: ");
	    String usuario = input.nextLine();
	    System.out.print("Etiqueta del ordenador a asignar: ");
	    String etiquetaPC = input.nextLine();

	    // Llamadas a otros métodos
	    Usuarios user = buscarUsuarioNombre(usuario);
	    Ordenadores pc = buscarOrdenadorPorEtiqueta(etiquetaPC);

	    if (user != null && pc != null) {
	        // Asignamos el objeto Ordenadores al atributo del objeto Usuarios
	        user.setOrdenador(pc); 
	        System.out.println("El ordenador " + etiquetaPC + " ha sido asignado a " + usuario);
	    } else {
	        System.out.println("Error: No se encontró el usuario o el ordenador.");
	    }
	}

}
