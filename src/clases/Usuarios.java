package clases;
	/**
	 * clase Usuarios
	 * contiene los objetos Departamento y Ordenadores
	 * @author brian
	 *
	 */
public class Usuarios {
	private int idUsuario;
	private String nombre;
	private String apellidos;
	Departamentos departamento;
	private String email;
	private int edad;
	Ordenadores ordenador;

	public Usuarios(int idUsuario ,String nombre, String apellidos, Departamentos departamento, String email, int edad,
			Ordenadores ordenador) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.departamento = departamento;
		this.email = email;
		this.edad = edad;
		this.ordenador = ordenador;
	}
	public Usuarios() {
		this.idUsuario = 0;
		this.nombre = "";
		this.apellidos = "";
		this.departamento = null;
		this.email = "";
		this.edad = 0;
		this.ordenador = null;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Departamentos getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamentos departamento) {
		this.departamento = departamento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Ordenadores getOrdenador() {
		return ordenador;
	}

	public void setOrdenador(Ordenadores ordenador) {
		this.ordenador = ordenador;
	}

	@Override
	public String toString() {
		/**
		 * obtenemos la etiqueta del ordenador
		 * y la mostramos.
		 * Se mostrara "Sin asignar"
		 * si el usuario no tiene ordenador asignado
		 */
		String etiquetaOrdenador = "Sin asignar";
		
		if(ordenador != null) {
			etiquetaOrdenador = ordenador.getEtiqueta();
		}

		return "\n=============================" +
			   "\nID Usuario: " + idUsuario +
			   "\nNombre: " + nombre + " " + apellidos +
			   "\nDepartamento: " + departamento +
			   "\nEmail: " + email +
			   "\nEdad: " + edad +
			   "\nOrdenador asignado: " + etiquetaOrdenador +
			   "\n=============================\n";
	}
	
	/**
	 * 
	 * metodo validaEmail para validar el email introducido por teclado
	 * debe contener una "@" y un "." despues del "@"
	 * @param email
	 * @return
	 */
	public static boolean validarEmail(String email) {
		int posArroba = 0;
	    int posPunto = 0;

	    boolean arrobaEncontrada = false;
	    boolean puntoEncontrado = false;

	    // buscar @ y .

	    for (int i = 0; i < email.length(); i++) {
	        if (email.charAt(i) == '@' && !arrobaEncontrada) {
	            posArroba = i;
	            arrobaEncontrada = true;
	        }
	        if (email.charAt(i) == '.' && !puntoEncontrado) {
	            posPunto = i;
	            puntoEncontrado = true;
	        }
	    }

	    // validar email
	    if (arrobaEncontrada && puntoEncontrado
	            && posArroba < posPunto) {
	        System.out.println("Correo valido");
	      
	        System.out.println();
	        return true;
	    }
	    else {
	        return false;
	    }
	}
	
	/**
	 * Metodo para validar el nombre y apellidos introducido por teclado
	 * solo permite meter letras
	 * @param nombre
	 * @return
	 */
	public static boolean validarNombreYapellidos(String nombre) {
	    boolean correcto = true;
	    for(int i = 0; i < nombre.length(); i++) {
	        char letra = nombre.charAt(i);
	        if((letra < 'A' || letra > 'Z')
	                && (letra < 'a' || letra > 'z')
	                && letra != ' ') {
	            correcto = false;
	        }
	    }
	    return correcto;
	}

	/**
	 * Metodo para generar email automatico mediante
	 * nombre y apellidos introducidos, añadiendo el dominio
	 * "@briancompany.com"
	 * 
	 * @param nombre
	 * @param apellidos
	 * @return
	 */
	public static String generarEmailEmpresa(String nombre, String apellidos) {
		  return nombre.replace(" ", "").toLowerCase()
		            + apellidos.replace(" ", "").toLowerCase()
		            + "@briancompany.com";
	}
	
	/**
	 * Metodo para validar que el usuario sea mayor de edad
	 * @param edad
	 * @return
	 */
	public static boolean validarEdad(int edad) {
	    boolean correcta = true;
	    if(edad < 18) {
	        correcta = false;
	    }
	    return correcta;
	}

}
