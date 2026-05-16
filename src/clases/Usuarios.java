package clases;

public class Usuarios {
	private String nombre;
	private String apellidos;
	Departamentos departamento;
	private String email;
	private int edad;
	Ordenadores ordenador;

	public Usuarios(String nombre, String apellidos, Departamentos departamento, String email, int edad,
			Ordenadores ordenador) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.departamento = departamento;
		this.email = email;
		this.edad = edad;
		this.ordenador = ordenador;
	}
	public Usuarios() {
		this.nombre = "";
		this.apellidos = "";
		this.departamento = null;
		this.email = "";
		this.edad = 0;
		this.ordenador = null;
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

		String etiquetaOrdenador = "Sin asignar";

		if(ordenador != null) {
			etiquetaOrdenador = ordenador.getEtiqueta();
		}

		return "\n=============================" +
			   "\nNombre: " + nombre + " " + apellidos +
			   "\nDepartamento: " + departamento +
			   "\nEmail: " + email +
			   "\nEdad: " + edad +
			   "\nOrdenador asignado: " + etiquetaOrdenador +
			   "\n=============================\n";
	}
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
	
	public static boolean validarNombre(String nombre) {
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
	
	public static String generarEmailEmpresa(String nombre, String apellidos) {
		return nombre.toLowerCase() + apellidos.toLowerCase() + "@briancompany.com";
	}

}
