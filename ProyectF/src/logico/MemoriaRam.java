package logico;

public class MemoriaRam extends Componente {
	private float memoria;
	private String tipoMemoria;
	
	public MemoriaRam( String numeroSerie, int cantidad, float precio, float memoria, String tipoMemoria) {
		super( numeroSerie, cantidad, precio);
		this.memoria = memoria;
		this.tipoMemoria = tipoMemoria;
	}

	public float getMemoria() {
		return memoria;
	}

	public void setMemoria(float memoria) {
		this.memoria = memoria;
	}

	public String getTipoMemoria() {
		return tipoMemoria;
	}

	public void setTipoMemoria(String tipoMemoria) {
		this.tipoMemoria = tipoMemoria;
	}
	
}
