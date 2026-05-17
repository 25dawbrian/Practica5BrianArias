package clases;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class GestorOrdenadores {
	/**
	 * En esta clase almacenamos los metodos y funcionalidades del programaç
	 * Metodos: altas, buscar, eliminar, listar y desasignar
	 */
	Scanner input = new Scanner(System.in);
	private ArrayList<Ordenadores> listaOrdenadores;
	private ArrayList<Usuarios> listaUsuarios;
	private ArrayList<Departamentos> listaDepartamentos;

	public GestorOrdenadores() {
		listaOrdenadores = new ArrayList<Ordenadores>();
		listaUsuarios = new ArrayList<Usuarios>();
		listaDepartamentos = new ArrayList<>();
	}

	/**
	 * Metodo para tener datos en el programa
	 * 
	 */
	public void datosIniciales() {
		// damos de alta 2 ordenadores de cada tipo
		altaOrdenadorTorre("Torre", "Legion T5", "Ryzen 7 7600G", "RTX 4070", 32, 1000, "Liquida", "265EIR",
				"TOR/2025/001", 850);
		altaOrdenadorTorre("Torre", "HP Omen 45L", "Intel i7 13700K", "RTX 4080", 64, 2000, "Ventilador", "098UPE",
				"TOR/2026/001", 1000);

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

		listaDepartamentos.add(financiero);
		listaDepartamentos.add(disennio3d);
		listaDepartamentos.add(marketing);

		// damos de alta 3 usuarios
		altaUsuario(1, "Eva", "Lopez", financiero, "evalopez@briancompany.com", 26, listaOrdenadores.get(0));
		altaUsuario(2, "Luis", "Perez", disennio3d, "luisperez@briancompany.com", 32, listaOrdenadores.get(2));
		altaUsuario(3, "Pepe", "Villanueva", marketing, "pepevillanueva@gmail.com", 43, listaOrdenadores.get(4));
	}

	/**
	 * Metodo para dar de alta departamentpo por codigo
	 */
	public void altaDepartamento(String nombreDepartamento) {
		Departamentos nuevoDepartamento = new Departamentos(nombreDepartamento);
		listaDepartamentos.add(nuevoDepartamento);
	}

	/**
	 * Metodo para dar de alta usuario por teclado
	 * 
	 */
	public void altaUsuario() {
		int idUsuario = 0;
		boolean idCorrecto = false;
		do {
			try {
				System.out.print("Introduce el ID del usuario: ");
				idUsuario = input.nextInt();
				input.nextLine();
				idCorrecto = true;
			} catch (InputMismatchException e) {
				System.err.println("Error: debes introducir un numero");
				input.nextLine();
			}
		} while (!idCorrecto);

		String nombre;
		boolean nombreCorrecto;
		do {
			System.out.print("Introduce el nombre: ");
			nombre = input.nextLine();
			nombreCorrecto = Usuarios.validarNombreYapellidos(nombre);
			/** Llamada al metodo ValidarNombre para solo introducir letras */
			if (!nombreCorrecto) {
				System.err.println("Error: solo se permiten letras");
			}
		} while (!nombreCorrecto);

		String apellidos;
		boolean apellidosCorrecto;
		do {
			System.out.print("Introduce los apellidos: ");
			apellidos = input.nextLine();
			apellidosCorrecto = Usuarios.validarNombreYapellidos(apellidos);
			/** Llamada al metodo ValidarApellidos para solo introducir letras */
			if (!apellidosCorrecto) {
				System.err.println("Error: solo se permiten letras");
			}
		} while (!apellidosCorrecto);

		String email = "";
		int opcionEmail;
		System.out.println("Selecciona el modo de introduccion del email: ");
		do {
			System.out.println("1.-Introducir email por teclado");
			System.out.println("2.-Generar email con nombre y apellidos");
			System.out.print("Selecciona una opcion: ");

			opcionEmail = input.nextInt();
			input.nextLine();

			switch (opcionEmail) {
			case 1:
				boolean emailValido;
				do {
					System.out.print("Introduce el email: ");
					email = input.nextLine();
					emailValido = Usuarios.validarEmail(email);
					/**
					 * Llamada al metodo ValidarEmail para que cumpla con el formato
					 * "nombre@gmail.com"
					 */
					if (!emailValido) {
						System.err.println("Formato incorrecto");
					}
				} while (!emailValido);
				break;
			case 2:
				email = Usuarios.generarEmailEmpresa(nombre, apellidos);
				/**
				 * Llamada al metodo generarEmailEmpresa para generar email mediante nombre y
				 * apellidos
				 */
				System.out.println("Email generado: " + email);
				break;

			default:
				System.err.println("Opcion no contemplada");
				break;
			}
		} while (opcionEmail < 1 || opcionEmail > 2);

		boolean edadCorrecta = false;
		int edad = 0;
		do {
			try {
				System.out.print("Introduce la edad: ");
				edad = input.nextInt();
				input.nextLine();
				edadCorrecta = Usuarios.validarEdad(edad);
				if (!edadCorrecta) {
					System.err.println("Error: el usuario debe ser mayor de edad.");
				}
			} catch (InputMismatchException e) {
				System.err.println("Error: debes introducir un numero.");
				input.nextLine();
			}
		} while (!edadCorrecta);

		// asignacion del departamento
		Usuarios nuevoUsuario = new Usuarios(idUsuario, nombre, apellidos, null, email, edad, null);
		int opcionDepartamento;
		do {
			System.out.println("Asignacion del departamento");
			System.out.println("1. Financiero");
			System.out.println("2. Diseño 3D");
			System.out.println("3. Marketing");
			System.out.print("Selecciona un departamento: ");
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
				System.err.println("Opcion incorrecta");
				System.out.println();
			}
		} while (opcionDepartamento < 1 || opcionDepartamento > 3);

		// mostrar ordenadores disponibles
		ArrayList<Ordenadores> disponibles = ordenadoresDisponibles();

		// asignacion del ordenador
		boolean opcionCorrecta = false;
		do {
			try {
				System.out.print("Selecciona un ordenador disponible: ");
				int opcionOrdenador = input.nextInt();
				input.nextLine();
				if (opcionOrdenador >= 1 && opcionOrdenador <= disponibles.size()) {
					nuevoUsuario.setOrdenador(disponibles.get(opcionOrdenador - 1));
					disponibles.get(opcionOrdenador - 1).setAsignado(true);
					opcionCorrecta = true;
				} else {
					System.err.println("Error: ordenador no disponible");
				}
			} catch (Exception e) {
				System.err.println("Error: debes introducir un numero");
				input.nextLine();
			}
		} while (!opcionCorrecta);

		// creacion del usuario
		listaUsuarios.add(nuevoUsuario);
		System.out.println("Usuario añadido correctamente");
	}

	/**
	 * Alta usuario por codigo
	 * 
	 * @param idUsuario
	 * @param nombre
	 * @param apellidos
	 * @param departamento
	 * @param email
	 * @param edad
	 * @param ordenador
	 */
	public void altaUsuario(int idUsuario, String nombre, String apellidos, Departamentos departamento, String email,
			int edad, Ordenadores ordenador) {
		ordenador.setAsignado(true);
		Usuarios nuevoUsuario = new Usuarios(idUsuario, nombre, apellidos, departamento, email, edad, ordenador);
		listaUsuarios.add(nuevoUsuario);
	}

	/**
	 * Metodo para pedir datos generales de los ordenadores
	 * 
	 * @return
	 */
	public Ordenadores pedirDatosGenerales(String prefijo) {
		String etiqueta;
		boolean etiquetaCorrecta;
		do {
			System.out.print("Etiqueta: ");
			etiqueta = input.nextLine();
			etiquetaCorrecta = Ordenadores.validarEtiqueta(etiqueta, prefijo);
			if (!etiquetaCorrecta) {
				System.err.println("Formato incorrecto: prefijo / año de alta / numero de tres digitos");
				System.out.println("Ejemplo valido: " + prefijo + "/2025/001");
			}
		} while (!etiquetaCorrecta);

		String numeroSerie;
		boolean numeroSerieCorrecta;
		do {
			System.out.print("Introduce el numero de serie: ");
			numeroSerie = input.nextLine();
			numeroSerieCorrecta = Ordenadores.validarNumeroSerie(numeroSerie);
			if (!numeroSerieCorrecta) {
				System.err.println("Formato incorrecto: 3 numeros y 3 letras");
				System.out.println("Ejemplo valido: 123ABC");
			}
		} while (!numeroSerieCorrecta);

		System.out.print("Introduce el modelo del ordenador: ");
		String modelo = input.nextLine();

		System.out.print("Introduce el procesador: ");
		String procesador = input.nextLine();

		System.out.print("Introduce la tarjeta grafica: ");
		String tarjetaGrafica = input.nextLine();

		/**
		 * Introduccion de la cantidad de memoria RAM controlando la excepcion para
		 * introducir numeros unicamente
		 */
		int capacidadMemoriaRAM = 0;
		boolean ramCorrecta = false;
		do {
			try {
				System.out.print("Cantidad de RAM (GB): ");
				capacidadMemoriaRAM = input.nextInt();
				ramCorrecta = true;
			} catch (InputMismatchException e) {
				System.err.println("Error: debes introducir numeros");
				input.nextLine();
			}
		} while (!ramCorrecta);

		/**
		 * Introduccion de la cantidad del almacenamiento controlando la excepcion para
		 * introducir numeros unicamente
		 */
		int almacenamiento = 0;
		boolean almacenamientoCorrecto = false;
		do {
			try {
				System.out.print("Cantidad de almacenamiento (GB): ");
				almacenamiento = input.nextInt();
				almacenamientoCorrecto = true;
			} catch (InputMismatchException e) {
				System.err.println("Error: debes introducir numeros");
				input.nextLine();
			}
		} while (!almacenamientoCorrecto);
		Ordenadores ordenador = new Ordenadores(null, modelo, procesador, tarjetaGrafica, capacidadMemoriaRAM,
				almacenamiento, numeroSerie, etiqueta, false);
		return ordenador;
	}

	/**
	 * Alta ordenador torre por teclado: pedimos datos generales y despues los
	 * especificos de la torre.
	 *
	 */
	public void altaOrdenadorTorre() {
		Ordenadores generales = pedirDatosGenerales("TOR");
		/**
		 * Introduccion de la cantidad de potencia de la fuente controlando la excepcion
		 * para introducir numeros unicamente
		 */
		int potenciaFuenteAlimentacion = 0;
		boolean fuenteCorrecta = false;
		do {
			try {
				System.out.print("Potencia de la fuente de alimentacion (W): ");
				potenciaFuenteAlimentacion = input.nextInt();
				input.nextLine();
				fuenteCorrecta = true;
			} catch (InputMismatchException e) {
				System.err.println("Error: debes introducir numeros");
				input.nextLine();
			}
		} while (!fuenteCorrecta);

		String refrigeracion;
		boolean refrigeracionCorrecta = false;
		do {
			System.out.print("Tipo de refrigeracion (ventilador/liquida): ");
			refrigeracion = input.nextLine();
			if (refrigeracion.equalsIgnoreCase("ventilador") || refrigeracion.equalsIgnoreCase("liquida")) {
				refrigeracionCorrecta = true;
			} else {
				System.err.println("Error: debes elegir entre ventilador o liquida.");
			}

		} while (!refrigeracionCorrecta);

		OrdenadorTorre nuevoOrdenadorTorre = new OrdenadorTorre(generales.getTipoOrdenador(), generales.getModelo(),
				generales.getProcesador(), generales.getTarjetaGrafica(), generales.getCapacidadMemoriaRAM(),
				generales.getAlmacenamiento(), refrigeracion, generales.getNumeroSerie(), generales.getEtiqueta(),
				potenciaFuenteAlimentacion);

		listaOrdenadores.add(nuevoOrdenadorTorre);

		System.out.println("Ordenador añadido correctamente");
		System.out.println();
	}

	/**
	 * Alta Ordenador Torre por codigo
	 * 
	 * @param tipoOrdenador
	 * @param modelo
	 * @param procesador
	 * @param tarjetaGrafica
	 * @param capacidadMemoriaRAM
	 * @param almacenamiento
	 * @param refrigeracion
	 * @param numeroSerie
	 * @param etiqueta
	 * @param potenciaFuenteAlimentacion
	 */
	public void altaOrdenadorTorre(String tipoOrdenador, String modelo, String procesador, String tarjetaGrafica,
			int capacidadMemoriaRAM, int almacenamiento, String refrigeracion, String numeroSerie, String etiqueta,
			int potenciaFuenteAlimentacion) {

		OrdenadorTorre nuevoOrdenadorTorre = new OrdenadorTorre(tipoOrdenador, modelo, procesador, tarjetaGrafica,
				capacidadMemoriaRAM, almacenamiento, refrigeracion, numeroSerie, etiqueta, potenciaFuenteAlimentacion);

		listaOrdenadores.add(nuevoOrdenadorTorre);
	}

	/**
	 * alta ordenador portatil por teclado pedimos datos generales y despues los
	 * especificos de sobremesa
	 *
	 */
	public void altaOrdenadorSobremesa() {
		Ordenadores generales = pedirDatosGenerales("SOB");

		String tipoCaja;
		boolean tipoCajaCorrecta = false;
		do {
			System.out.println("Tipo de caja (Mini/Barebone/Slim): ");
			tipoCaja = input.nextLine();
			if (tipoCaja.equalsIgnoreCase("Mini") || tipoCaja.equalsIgnoreCase("Barebone")
					|| tipoCaja.equalsIgnoreCase("Slim")) {
				tipoCajaCorrecta = true;
			} else {
				System.out.println("Error: debes elegir entre mini, barebone o slim");
			}
		} while (!tipoCajaCorrecta);

		OrdenadorSobremesa nuevoOrdenadorSobremesa = new OrdenadorSobremesa(generales.getTipoOrdenador(),
				generales.getModelo(), generales.getProcesador(), generales.getTarjetaGrafica(),
				generales.getCapacidadMemoriaRAM(), generales.getAlmacenamiento(), generales.getNumeroSerie(),
				generales.getEtiqueta(), tipoCaja);
		listaOrdenadores.add(nuevoOrdenadorSobremesa);
	}

	/**
	 * Alta Ordenador sobremesa por codigo
	 * 
	 */
	public void altaOrdenadorSobremesa(String tipoOrdenador, String modelo, String procesador, String tarjetaGrafica,
			int capacidadMemoriaRAM, int almacenamiento, String numeroSerie, String etiqueta, String tipoCaja) {
		OrdenadorSobremesa nuevoOrdenadorSobremesa = new OrdenadorSobremesa(tipoOrdenador, modelo, procesador,
				tarjetaGrafica, capacidadMemoriaRAM, almacenamiento, numeroSerie, etiqueta, tipoCaja);
		listaOrdenadores.add(nuevoOrdenadorSobremesa);
	}

	/**
	 * alta ordenador portatil por teclado pedimos datos generales y despues los
	 * especificos de portatil
	 *
	 */

	public void altaOrdenadorPortatil() {
		Ordenadores generales = pedirDatosGenerales("POR");

		double pulgadas = 0;
		boolean pulgadasCorrectas = false;
		do {
			try {
				System.out.println("Cantidad de pulgadas de la pantalla: ");
				pulgadas = input.nextInt();
				pulgadasCorrectas = true;
			} catch (InputMismatchException e) {
				System.err.println("Error: debes introducir numeros.");
				input.nextLine();
			}
		} while (!pulgadasCorrectas);

		double autonomia = 0;
		boolean autonomiaCorrecta = false;
		do {
			try {
				System.out.println("Tiempo de autonomía (horas): ");
				autonomia = input.nextInt();
				autonomiaCorrecta = true;
			} catch (InputMismatchException e) {
				System.out.println("Error: debes introducir numeros.");
				input.nextLine();
			}
		} while (!autonomiaCorrecta);
		boolean webcam = true;

		OrdenadorPortatil nuevoOrdenadorPortatil = new OrdenadorPortatil(generales.getTipoOrdenador(),
				generales.getModelo(), generales.getProcesador(), generales.getTarjetaGrafica(),
				generales.getCapacidadMemoriaRAM(), generales.getAlmacenamiento(), generales.getNumeroSerie(),
				generales.getEtiqueta(), pulgadas, autonomia, webcam);
		listaOrdenadores.add(nuevoOrdenadorPortatil);
	}

	/**
	 * alta ordenador portatil
	 * 
	 * @param tipoOrdenador
	 * @param modelo
	 * @param procesador
	 * @param tarjetaGrafica
	 * @param capacidadMemoriaRAM
	 * @param almacenamiento
	 * @param numeroSerie
	 * @param etiqueta
	 * @param pulgadas
	 * @param autonomia
	 * @param webcam
	 */
	public void altaOrdenadorPortatil(String tipoOrdenador, String modelo, String procesador, String tarjetaGrafica,
			int capacidadMemoriaRAM, int almacenamiento, String numeroSerie, String etiqueta, double pulgadas,
			double autonomia, boolean webcam) {
		OrdenadorPortatil nuevoOrdenadorPortatil = new OrdenadorPortatil(tipoOrdenador, modelo, procesador,
				tarjetaGrafica, capacidadMemoriaRAM, almacenamiento, numeroSerie, etiqueta, pulgadas, autonomia,
				webcam);
		listaOrdenadores.add(nuevoOrdenadorPortatil);
	}

	/**
	 * Metodo para mostrar los ordenadores que estan sin asignar
	 * 
	 * @return
	 */
	public ArrayList<Ordenadores> ordenadoresDisponibles() {
		ArrayList<Ordenadores> disponibles = new ArrayList<>();
		int contador = 1;
		for (Ordenadores ord : listaOrdenadores) {
			if (!ord.isAsignado()) {
				disponibles.add(ord);
				System.out.println("Ordenador " + contador + ".- " + ord);
				contador++;
			}
		}
		return disponibles;
	}

	/**
	 * Metodo para listar todos los ordenadores y numerarlos recorremos array, si no
	 * esta vacion lo muestra, y en cada vuelta del bucle me sumas 1 al contador
	 * para numerarlos
	 * 
	 */
	public void listarOrdenadores() {
		int contador = 1;
		for (Ordenadores ordenadores : listaOrdenadores) {
			if (ordenadores != null) {
				System.out.println("Ordenador " + contador + ".- " + ordenadores);
				contador++;
			}
		}
	}

	/**
	 * Metodo para lista ordenadores por torres, donde me compara el atributo
	 * tipoOrdenador con "torre" si coincida lo muestra.
	 */
	public void listarTorres() {
		for (Ordenadores torres : listaOrdenadores) {
			if (torres.getTipoOrdenador().equalsIgnoreCase("torre")) {
				System.out.println(torres);
			}
		}
	}

	/**
	 * Metodo para lista ordenadores por torres, donde me compara el atributo
	 * tipoOrdenador con "sobremesa" si coincida lo muestra.
	 */
	public void listarSobremesas() {
		for (Ordenadores sobremesa : listaOrdenadores) {
			if (sobremesa.getTipoOrdenador().equalsIgnoreCase("sobremesa")) {
				System.out.println(sobremesa);
			}
		}
	}

	/**
	 * Metodo para lista ordenadores por torres, donde me compara el atributo
	 * tipoOrdenador con "portatil" si coincida lo muestra.
	 */
	public void listarPortatiles() {
		for (Ordenadores portatil : listaOrdenadores) {
			if (portatil.getTipoOrdenador().equalsIgnoreCase("portatil")) {
				System.out.println(portatil);
			}
		}
	}

	/**
	 * Metodo para listar ordenador por departamento segun la opcion seleccionado,
	 * mostrara los ordenador que hay en cada departamento recorremos el array de
	 * usuarios, y comparamos su departamento con el seleccionado. Si coincide me
	 * mostrara los ordenadores y el usuario que lo esta usando
	 * 
	 */
	public void listarOrdenadoresPorDepartamento() {
		int opcionDepartamento = 0;
		boolean opcionCorrecta;
		do {
			opcionCorrecta = false;
			System.out.println("Listar por departamento");
			System.out.println("1. Financiero");
			System.out.println("2. Diseño 3D");
			System.out.println("3. Marketing");
			System.out.println("4. Salir");
			System.out.print("Selecciona un departamento: ");
			try {
				opcionDepartamento = input.nextInt();
				input.nextLine();
				opcionCorrecta = true;
			} catch (InputMismatchException e) {
				System.err.println("Error: debes introducir numeros.");
				input.nextLine();
			}
			if (opcionCorrecta) {
				Departamentos departamentoSeleccionado = null;
				switch (opcionDepartamento) {
				case 1:
					departamentoSeleccionado = listaDepartamentos.get(0);
					break;
				case 2:
					departamentoSeleccionado = listaDepartamentos.get(1);
					break;
				case 3:
					departamentoSeleccionado = listaDepartamentos.get(2);
					break;
				case 4:
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("Opcion incorrecta");
				}
				if (departamentoSeleccionado != null) {
					System.out.println(
							"Ordenadores del departamento de " + departamentoSeleccionado.getNombreDepartamento());
					boolean hayOrdenadores = false;
					for (Usuarios usuario : listaUsuarios) {
						if (usuario.getDepartamento().equals(departamentoSeleccionado)) {
							hayOrdenadores = true;
							System.out.println("Usuario: " + usuario.getNombre() + " " + usuario.getApellidos());
							System.out.println(usuario.getOrdenador());
						}
					}
					if (!hayOrdenadores) {
						System.out.println("No hay ordenadores asignados en este departamento.");
					}
				}
			}
		} while (opcionDepartamento != 4);
	}

	/**
	 * Metodo para listar usuarios recorremos array, si no esta vacio se muestra
	 * 
	 */
	public void listarUsuarios() {
		for (Usuarios usu : listaUsuarios) {
			if (usu != null) {
				System.out.println(usu);
			}
		}
	}

	/**
	 * Metodo para buscar por nombre recorremos array, si el nombre del usuario
	 * introducido coincide con el obtenido (.getNombre) se muestra, sino, imprime
	 * que no existe
	 * 
	 */
	public void buscarUsuarioID() {
		System.out.print("Introduce el ID del usuario: ");
		int idBuscar = input.nextInt();
		boolean idEncontrado = false;
		for (Usuarios usu : listaUsuarios) {
			if (usu.getIdUsuario() == idBuscar) {
				System.out.println("Usuario encontrado");
				System.out.println(usu);
				idEncontrado = true;
			}
		}
		if (!idEncontrado) {
			System.out.println("No existe ningun usuario con ese ID");
		}
	}

	/**
	 * Metodo para buscar usuario por el nombre recorremos el array, si coincide el
	 * nombre recibido con el obtenido (.getNombre) lo devuelve, sino devuelve null
	 * 
	 * @param nombre
	 * @return
	 */
	public Usuarios buscarUsuarioID(int idUsuario) {
		for (Usuarios usu : listaUsuarios) {
			if (usu.getIdUsuario() == idUsuario) {
				return usu;
			}
		}
		return null;
	}

	/**
	 * Metodo para buscar usuario por etiqueta del ordenador de uso: introducimos
	 * etiqueta por teclado, recorremos el arrayList listaUsuarios si no esta vacio,
	 * hacemos comparacion con la etiqueta el ordenador y la introducida. Lo imprime
	 * si coincide, sino, imprime que no hay asignacion
	 * 
	 */
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

	/**
	 * metodo para buscar ordenador por etiqueta introducida por teclado recorremos
	 * arrayList listaOrdenadores, si la etiqueta introducida es igual a la obtenida
	 * (.getEtiqueta) lo devolvera, sino imprimira que no existe
	 * 
	 */
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

	/**
	 * Metodo para buscar ordenador por etiquete
	 * 
	 * @param Ordenador
	 * @return
	 */
	public Ordenadores buscarOrdenadorPorEtiqueta(String etiqueta) {
		for (Ordenadores ord : listaOrdenadores) {
			if (ord.getEtiqueta().equalsIgnoreCase(etiqueta)) {
				return ord;
			}
		}
		return null;
	}

	/**
	 * @param numeroSere Metodo para buscar ordenador por numero de serie:
	 *                   introducimos por teclado el numero de serie, hacemos un
	 *                   booleano en false por defecto para luego comprobar si se ha
	 *                   encontrado. Recorremo array ArrayList de listaOrdenadores,
	 *                   si el numero der serie introducido es igual al obtenido
	 *                   (.getNumeroSerie) lo devuelve si no imprimira que no existe
	 * 
	 */
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

	/**
	 * 
	 * creamos iterador para recorer de forma segura el arrayList Usuarios. mientras
	 * haya usuarios (.hasNext)seguira recorriendo (.next) y despues con .next
	 * avanzamos hacia el siguiente usuario
	 * 
	 */

	public void darDeBajaUsuario() {
		System.out.print("Introduce el ID del usuario que quieras dar de baja: ");
		int idUsuario = input.nextInt();
		boolean usuarioExiste = false;
		Iterator<Usuarios> iteradorUsuarios = listaUsuarios.iterator();
		while (iteradorUsuarios.hasNext()) {
			Usuarios usuario = iteradorUsuarios.next();
			if (usuario.getIdUsuario() == idUsuario) {
				if (usuario.getOrdenador() != null) {
					usuario.getOrdenador().setAsignado(false);
				}
				iteradorUsuarios.remove();
				System.out.println("El usuario: [ " + usuario.getNombre() + " " + usuario.getApellidos() + " ] "
						+ "con el ID [ " + idUsuario + " ] ha sido dado de baja de la empresa.");
				usuarioExiste = true;
			}
		}
		if (!usuarioExiste) {
			System.out.println("No existe ningun usuario con el ID [" + idUsuario);
		}
	}

	/**
	 * Metodo para desasignar a un usuario su ordenador: Recorremos el arrayList
	 * listaUsuarios, si un usuario tiene un ordenador y es igual al objeto
	 * Ordenadores recibido pasara a ser null
	 * 
	 */
	public void desasignarOrdenadorDeUsuarios(Ordenadores ordenador) {
		for (Usuarios ord : listaUsuarios) {
			if (ord.getOrdenador() != null && ord.getOrdenador().equals(ordenador)) {
				ord.setOrdenador(null);
				ordenador.setAsignado(false);
			}
		}
	}

	/**
	 * Metodos eliminar Ordenador por la etiqueta recibida: Recorre la lista de
	 * ordenadores mediante un Iterator para buscar y eliminar un ordenador según su
	 * etiqueta.
	 * 
	 */
	public void eliminarOrdenadorPorEtiqueta() {
		System.out.print("Introduce la etiqueta del ordenador: ");
		String etiqueta = input.nextLine();
		Ordenadores ordenadorEliminar = null; /** Lo dejamos como null ya que no apunta a ningun objeto */
		boolean ordenadorExiste = false; /** booleano en false para comprobar si el ordenador se ha encontrado */

		Iterator<Ordenadores> iteradorOrdenadores = listaOrdenadores.iterator();
		/**
		 * creamos iterador para recorer de forma segura el arrayList Ordenadores.
		 * mientras haya ordenadores (.hasNext)seguira recorriendo (.next) y despues con
		 * .next avanzamos hacia el siguiente ordenador
		 */
		while (iteradorOrdenadores.hasNext()) {
			Ordenadores ordenador = iteradorOrdenadores.next();
			if (ordenador.getEtiqueta().equalsIgnoreCase(etiqueta)) {
				ordenadorEliminar = ordenador;
				iteradorOrdenadores.remove();

				System.out
						.println("El ordenador con la etiqueta [ " + etiqueta + " ] ha sido eliminado del inventario.");
				ordenadorExiste = true;
			}
		}
		/**
		 * Si el ordenador es distinto de true, imprimimos que no existe
		 */
		if (!ordenadorExiste) {
			System.out.println("No existe ningun ordenador con la etiqueta [" + etiqueta + "]");
		}
		/**
		 * Si el ordenador no esta vacio, llamamos al metodo desasignar desasignarlos de
		 * los usuario al haber sido eliminado
		 */
		if (ordenadorEliminar != null) {
			desasignarOrdenadorDeUsuarios(ordenadorEliminar);
		}
	}

	/**
	 * Asignacion de un ordenador a un usuario
	 */
	public void asignarOrdenadorAUsuario() {
		System.out.print("ID del usuario: ");
		int usuarioid = input.nextInt();
		System.out.print("Etiqueta del ordenador a asignar: ");
		String etiquetaPC = input.nextLine();

		/**
		 * Llamada a los metodos buscarUsuarioNombre y buscarOrdenadorPorEtiqueta para
		 * comparar los parametros metidos por teclado con los existentes
		 */

		Usuarios user = buscarUsuarioID(usuarioid);
		Ordenadores pc = buscarOrdenadorPorEtiqueta(etiquetaPC);

		if (user != null && pc != null) {
			user.setOrdenador(pc);
			/**
			 * Asignamos el objeto Ordenadores al atributo del objeto Usuarios si el usuario
			 * y el pc introducidos por teclado existen
			 * 
			 */
			System.out.println("El ordenador [" + etiquetaPC + "] ha sido asignado a " + usuarioid);
		} else {
			System.out.println("Error: No se encontró el usuario o el ordenador.");
		}
	}

}
