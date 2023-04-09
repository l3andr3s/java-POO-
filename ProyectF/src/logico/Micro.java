package logico;

public class Micro extends Componente {
	private String modelo;
	private String tipoconexion;
	public Micro( String numeroSerie, int cantidad, float precio, String modelo, String tipoconexion) {
		super( numeroSerie, cantidad, precio);
		this.modelo = modelo;
		this.tipoconexion = tipoconexion;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getTipoconexion() {
		return tipoconexion;
	}
	public void setTipoconexion(String tipoconexion) {
		this.tipoconexion = tipoconexion;
	}
	

}
