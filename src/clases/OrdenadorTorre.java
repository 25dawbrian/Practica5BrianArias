package clases;

public class OrdenadorTorre extends Ordenadores {
	private String refrigeracion;
	private int potenciaFuenteAlimentacion;
	private boolean graficosIntegrados;
	
	public OrdenadorTorre(String tipoOrdenador, String modelo, String procesador, boolean graficosIntegrados, String tarjetaGrafica,
			int capacidadMemoriaRAM, int almacenamiento, String refrigeracion, String numeroSerie, String etiqueta,
			int potenciaFuenteAlimentacion) {
		super(tipoOrdenador, modelo, procesador, graficosIntegrados, tarjetaGrafica, capacidadMemoriaRAM, almacenamiento, numeroSerie,
				etiqueta);
		this.tipoOrdenador="Torre";
		this.refrigeracion = refrigeracion;
		this.potenciaFuenteAlimentacion = potenciaFuenteAlimentacion;
		this.graficosIntegrados = graficosIntegrados;
	}
	
	public boolean isGraficosIntegrados() {
		return graficosIntegrados;
	}

	public void setGraficosIntegrados(boolean graficosIntegrados) {
		this.graficosIntegrados = graficosIntegrados;
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
			   "\nGraficos integrados: " + graficosIntegrados +
			   "\nTarjeta grafica: " + tarjetaGrafica +
			   "\nRAM: " + capacidadMemoriaRAM + " GB" +
			   "\nAlmacenamiento: " + almacenamiento + " GB" +
			   "\nPotencia de la fuente de alimentacion: " + potenciaFuenteAlimentacion + " W " +
			   "\nRefrigeracion: "+ refrigeracion +
			   "\nNumero de serie: " + numeroSerie +
			   "\nEtiqueta: " + etiqueta +
			   "\n===============================\n";
	}

}
