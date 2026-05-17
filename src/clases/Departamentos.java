package clases;

public class Departamentos {
	/**
	 * Clase Departamentos. Este se le asignara a cada usuario
	 * 
	 * @author Brian Arias
	 */
	private String nombreDepartamento;

	public Departamentos(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	@Override
	public String toString() {
		return nombreDepartamento;
	}
}
