package persistencia;

import java.util.ArrayList;

import entidades.ClienteEntidad;
import entidades.PersonaEntidad;

public class Singleton {
	private static Singleton instancia = null;
	private ArrayList<ClienteEntidad> listaClientes;

	private Singleton() {
		// TODO Auto-generated constructor stub
	}

	public static Singleton getInstancia() {
		if (instancia == null) {
			instancia = new Singleton();
			instancia.listaClientes = new ArrayList<ClienteEntidad>();
			
			instancia.listaClientes.add(new ClienteEntidad(1, "Pedro", 37));
			instancia.listaClientes.add(new ClienteEntidad(4, "Richar", 21));
			instancia.listaClientes.add(new ClienteEntidad(1, "Jonny", 28));
			instancia.listaClientes.add(new ClienteEntidad(4, "Kevin", 14));
			instancia.listaClientes.add(new ClienteEntidad(5, "Bryan", 44));
			
		}
		return instancia;
	}

	public ArrayList<ClienteEntidad> listarClientes() {
		return listaClientes;
	}
}
