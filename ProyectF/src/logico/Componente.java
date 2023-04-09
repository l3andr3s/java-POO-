package logico;

public class Componente {
	
	
	protected String marca;
	protected String numeroSerie;
	protected int cantidad;
	protected float precio;
	
	public Componente(String marca, String numeroSerie, int cantidad, float precio) {
		super();
		this.numeroSerie = numeroSerie;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

}
