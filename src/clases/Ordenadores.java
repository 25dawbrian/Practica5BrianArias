package clases;

/**
 * Clase padre con los atributos generales de todos los ordenadores
 * 
 * @author Brian Arias
 */
public class Ordenadores {
	protected String tipoOrdenador;
	protected String modelo;
	protected String procesador;
	protected String tarjetaGrafica;
	protected int capacidadMemoriaRAM;
	protected int almacenamiento;
	protected String numeroSerie;
	protected String etiqueta;
	protected boolean asignado;

	public Ordenadores() {
		this.tipoOrdenador = "";
		this.modelo = "";
		this.procesador = "";
		this.tarjetaGrafica = "";
		this.capacidadMemoriaRAM = 0;
		this.almacenamiento = 0;
		this.numeroSerie = "";
		this.etiqueta = "";
		this.asignado = false;
	}

	public Ordenadores(String tipoOrdenador, String modelo, String procesador, String tarjetaGrafica,
			int capacidadMemoriaRAM, int almacenamiento, String numeroSerie, String etiqueta, boolean asignado) {
		this.tipoOrdenador = tipoOrdenador;
		this.modelo = modelo;
		this.procesador = procesador;
		this.tarjetaGrafica = tarjetaGrafica;
		this.capacidadMemoriaRAM = capacidadMemoriaRAM;
		this.almacenamiento = almacenamiento;
		this.numeroSerie = numeroSerie;
		this.etiqueta = etiqueta;
		this.asignado = false;
	}

	public boolean isAsignado() {
		return asignado;
	}

	public void setAsignado(boolean asignado) {
		this.asignado = asignado;
	}

	public String getTipoOrdenador() {
		return tipoOrdenador;
	}

	public void setTipoOrdenador(String tipoOrdenador) {
		this.tipoOrdenador = tipoOrdenador;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getProcesador() {
		return procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public String getTarjetaGrafica() {
		return tarjetaGrafica;
	}

	public void setTarjetaGrafica(String tarjetaGrafica) {
		this.tarjetaGrafica = tarjetaGrafica;
	}

	public int getCapacidadMemoriaRAM() {
		return capacidadMemoriaRAM;
	}

	public void setCapacidadMemoriaRAM(int capacidadMemoriaRAM) {
		this.capacidadMemoriaRAM = capacidadMemoriaRAM;
	}

	public int getAlmacenamiento() {
		return almacenamiento;
	}

	public void setAlmacenamiento(int almacenamiento) {
		this.almacenamiento = almacenamiento;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	@Override
	public String toString() {
		return "\n========== ORDENADOR ==========" +
			   "\nModelo: " + modelo +
			   "\nProcesador: " + procesador +
			   "\nTarjeta grafica: " + tarjetaGrafica +
			   "\nRAM: " + capacidadMemoriaRAM + " GB" +
			   "\nAlmacenamiento: " + almacenamiento + " GB" +
			   "\nNumero de serie: " + numeroSerie +
			   "\nEtiqueta: " + etiqueta +
			   "\nAsignador: " + asignado +
			   "\n===============================\n";
	}
	/**
	 * Metodo para validar el numero de serie y que cumpla formato de 3 numeros y 3
	 * letras
	 * Ejemplo de numero de serie: 123ABC
	 */
	public static boolean validarNumeroSerie(String numeroSerie) {
		boolean correcto = true;
		if (numeroSerie.length() != 6) {
			correcto = false;
		} else {
			for (int i = 0; i < 3; i++) {
				char numero = numeroSerie.charAt(i);
				if (numero < '0' || numero > '9') {
					correcto = false;
				}
			}
			for (int i = 3; i < 6; i++) {
				char letra = numeroSerie.charAt(i);
				if ((letra < 'A' || letra > 'Z')) {
					correcto = false;
				}
			}
		}
		return correcto;
	}

	/**
	 * Metodo para validar la etiqueta del ordenador
	 * Recibe la etiqueta y el prefijo segun el ordenador
	 * Fomato: prefijo / añon de alta / numero de 3 digitos
	 * Prefijo Torre: TOR
	 * Prefijo Sobremesa: SOB
	 * Prefijo Portatil: POR
	 * Ejemplo de etiqueta: POR/2025/008
	 * 
	 * @param etiqueta
	 * @param prefijo
	 * @return
	 */
	public static boolean validarEtiqueta(String etiqueta, String prefijo) {
		boolean correcta = true;
		if (etiqueta.length() != 12) {
			correcta = false;
		} else {
			String inicio = etiqueta.substring(0, 3);
			if (!inicio.equalsIgnoreCase(prefijo)) {
				correcta = false;
			}
			if (etiqueta.charAt(3) != '/' || etiqueta.charAt(8) != '/') {
				correcta = false;
			}
			for (int i = 4; i < 8; i++) {
				char numero = etiqueta.charAt(i);
				if (numero < '0' || numero > '9') {
					correcta = false;
				}
			}
			for (int i = 9; i < 12; i++) {
				char numero = etiqueta.charAt(i);
				if (numero < '0' || numero > '9') {
					correcta = false;
				}
			}
		}
		return correcta;
	}
}
