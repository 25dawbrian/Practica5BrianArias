package clases;
/**
 * clase OrdenadorPortatil
 * clase hija que hereda de Ordenadores los atributos generales.
 * Contiene atributos propios
 * @author Brian Arias
 */
public class OrdenadorPortatil extends Ordenadores {
	private double pulgadas;
	private double autonomia;
	private boolean webcam;

	public OrdenadorPortatil(String tipoOrdenador, String modelo, String procesador, String tarjetaGrafica,
			int capacidadMemoriaRAM, int almacenamiento, String numeroSerie, String etiqueta, double pulgadas,
			double autonomia, boolean webcam) {
		super(tipoOrdenador, modelo, procesador, tarjetaGrafica, capacidadMemoriaRAM, almacenamiento, numeroSerie,
				etiqueta);
		this.tipoOrdenador = "Portatil";
		this.pulgadas = pulgadas;
		this.autonomia = autonomia;
		this.webcam = webcam;
	}

	public double getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(double pulgadas) {
		this.pulgadas = pulgadas;
	}

	public double getAutonomia() {
		return autonomia;
	}

	public void setAutonomia(double autonomia) {
		this.autonomia = autonomia;
	}

	public boolean isWebcam() {
		return webcam;
	}

	public void setWebcam(boolean webcam) {
		this.webcam = webcam;
	}

	@Override
	public String toString() {
		return "\n===============================" +
				"\nTipo de Ordenador: " + tipoOrdenador +
			   "\nModelo: " + modelo +
			   "\nProcesador: " + procesador +
			   "\nTarjeta grafica: " + tarjetaGrafica +
			   "\nRAM: " + capacidadMemoriaRAM + " GB" +
			   "\nAlmacenamiento: " + almacenamiento + " GB" +
			   "\nNumero de serie: " + numeroSerie +
			   "\nPulgadas: "+ pulgadas +" pulgadas " +
			   "\nAutonomia: "+ autonomia + " horas " +
			   "\nWebcam: " + webcam +
			   "\nNumero de serie: " + numeroSerie +
			   "\nEtiqueta: " + etiqueta +
			   "\n===============================\n";
	}

}
