package logico;

import java.util.ArrayList;
public class Combo {
	
	private ArrayList<Componente> componentes;

	public Combo(ArrayList<Componente> componentes) {
	super();
	this.componentes = componentes;
	}

	public ArrayList<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}
}
