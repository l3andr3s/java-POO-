package logico;

import java.util.ArrayList;

public class Tienda {
	private ArrayList<Componente> componentes;
	private ArrayList<Factura> facturas;
	private ArrayList<Cliente> clientes;
	private ArrayList<Combo> combos;
	public  static Tienda tienda;
	public static int codigo = 1;
	public Tienda() {
		componentes = new ArrayList<Componente>();
		facturas = new ArrayList<Factura>();
		clientes = new ArrayList<Cliente>();
		combos = new ArrayList<Combo>();
	}
	public ArrayList<Componente> getComponentes() {
		return componentes;
	}
	public static Tienda getInstance() {
		if(tienda == null) {
			tienda = new Tienda();
		}
		return tienda;
	}
	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}
	public ArrayList<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	public ArrayList<Combo> getCombos() {
		return combos;
	}
	public void setCombos(ArrayList<Combo> combos) {
		this.combos = combos;
	}
	public static Tienda getTienda() {
		return tienda;
	}
	public static void setTienda(Tienda tienda) {
		Tienda.tienda = tienda;
	}
	public static int getCodigo() {
		return codigo;
	}
	public static void setCodigo(int codigo) {
		Tienda.codigo = codigo;
	}
	public void RegistrarComponente(Componente componente) {
		componentes.add(componente);
		codigo++;
	}
		public Cliente BuscarClienteByCedula(String cedula) {
			Cliente aux = null;
			for(int i = 0; i <clientes.size();i++) {
				if (clientes.get(i).getCedula().equalsIgnoreCase(cedula)) {
					aux = clientes.get(i);
				}
			}
			return aux;
		}
		public void RegistrarCliente(Cliente aux) {
			clientes.add(aux);
		}
}
	
	
	
	
	


