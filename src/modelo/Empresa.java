package modelo;

import java.util.ArrayList;

import entidades.ClienteEntidad;
import persistencia.FakeClientePersistencia;
import persistencia.IClienteRepositorio;

public class Empresa {
	
	public ArrayList<ClienteEntidad> mostrarDatosCliente() {
		IClienteRepositorio repositorio = new FakeClientePersistencia();
		ArrayList<ClienteEntidad> lista = repositorio.listarCliente();
		return lista;
	}

	public Empresa() {

	}

}
