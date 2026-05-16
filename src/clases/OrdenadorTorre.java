package clases;
/**
 * clase OrdenadorTorre
 * clase hija que hereda de Ordenadores los atributos generales.
 * Contiene atributos propios
 * @author Brian Arias
 */
public class OrdenadorTorre extends Ordenadores {
	private String refrigeracion;
	private int potenciaFuenteAlimentacion;
	
	public OrdenadorTorre(String tipoOrdenador, String modelo, String procesador, String tarjetaGrafica,
			int capacidadMemoriaRAM, int almacenamiento, String refrigeracion, String numeroSerie, String etiqueta,
			int potenciaFuenteAlimentacion) {
		super(tipoOrdenador, modelo, procesador, tarjetaGrafica, capacidadMemoriaRAM, almacenamiento, numeroSerie,
				etiqueta, false);
		this.tipoOrdenador="Torre";
		this.refrigeracion = refrigeracion;
		this.potenciaFuenteAlimentacion = potenciaFuenteAlimentacion;
	}
	

	public String getRefrigeracion() {
		return refrigeracion;
	}
	
	public void setRefrigeracion(String refrigeracion) {
		this.refrigeracion = refrigeracion;
	}
	
	public int getPotenciaFuenteAlimentacion() {
		return potenciaFuenteAlimentacion;
	}

	public void setPotenciaFuenteAlimentacion(int potenciaFuenteAlimentacion) {
		this.potenciaFuenteAlimentacion = potenciaFuenteAlimentacion;
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
			   "\nPotencia de la fuente de alimentacion: " + potenciaFuenteAlimentacion + " W " +
			   "\nRefrigeracion: "+ refrigeracion +
			   "\nNumero de serie: " + numeroSerie +
			   "\nEtiqueta: " + etiqueta +
			   "\nAsignado: " + asignado +
			   "\n===============================\n";
	}

}
