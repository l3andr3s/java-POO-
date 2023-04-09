package logico;

public class DiscoDuro extends Componente {
	private String modelo;
	private int almacenamiento;
	private String tipoConector;

	public DiscoDuro( String numeroSerie, int cantidad, float precio, String modelo, int almacenamiento, String tipoConector) {
		super( numeroSerie, cantidad, precio);
		this.modelo = modelo;
		this.almacenamiento = almacenamiento;
		this.tipoConector = tipoConector;
			
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAlmacenamiento() {
		return almacenamiento;
	}

	public void setAlmacenamiento(int almacenamiento) {
		this.almacenamiento = almacenamiento;
	}

	public String getTipoConector() {
		return tipoConector;
	}

	public void setTipoConector(String tipoConector) {
		this.tipoConector = tipoConector;
	}

}