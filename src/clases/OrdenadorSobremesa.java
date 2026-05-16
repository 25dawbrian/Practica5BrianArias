package clases;

public class OrdenadorSobremesa extends Ordenadores {
	private String tipoCaja;

	public OrdenadorSobremesa(String tipoOrdenador,String modelo, String procesador, String tarjetaGrafica,
			int capacidadMemoriaRAM, int almacenamiento, String numeroSerie, String etiqueta, String tipoCaja) {
		super(tipoOrdenador, modelo, procesador, tarjetaGrafica, capacidadMemoriaRAM, almacenamiento, numeroSerie,
				etiqueta);
		this.tipoOrdenador="Sobremesa";
		this.tipoCaja = tipoCaja;
	}

	public String getTipoCaja() {
		return tipoCaja;
	}

	public void setTipoCaja(String tipoCaja) {
		this.tipoCaja = tipoCaja;
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
			   "\nTipo de caja: "+ tipoCaja +
			   "\nNumero de serie: " + numeroSerie +
			   "\nEtiqueta: " + etiqueta +
			   "\n===============================\n";
	}

}
