package logico;

public class MotherBoard extends Componente {
	private String modelo;
	private String tipoConector;
	private String tipoRam;
	private String conexion;
	
	public MotherBoard( String numeroSerie, int cantidad, float precio, String modelo, String tipoConector,
			String tipoRam, String conexion) {
		super( numeroSerie, cantidad, precio);
		this.modelo = modelo;
		this.tipoConector = tipoConector;
		this.tipoRam = tipoRam;
		this.conexion = conexion;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipoConector() {
		return tipoConector;
	}

	public void setTipoConector(String tipoConector) {
		this.tipoConector = tipoConector;
	}

	public String getTipoRam() {
		return tipoRam;
	}

	public void setTipoRam(String tipoRam) {
		this.tipoRam = tipoRam;
	}

	public String getConexion() {
		return conexion;
	}

	public void setConexion(String conexion) {
		this.conexion = conexion;
	}
	
}
