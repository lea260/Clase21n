package persistencia;

import java.util.ArrayList;
import java.util.Iterator;

import entidades.ClienteEntidad;
import entidades.PersonaEntidad;


public class FakeClientePersistencia implements IClienteRepositorio {

	
	@Override
	public ArrayList<ClienteEntidad> listarCliente() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Singleton singleton = Singleton.getInstancia();
		ArrayList<ClienteEntidad> lista = singleton.listarClientes();
		return lista;
	}

	@Override
	public ArrayList<ClienteEntidad> agregarCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ClienteEntidad> eliminarCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ClienteEntidad> modificarCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public ArrayList<PersonaEntidad> listarPersonas() { // TODO
	 * Auto-generated method stub Singleton singleton = Singleton.getInstancia();
	 * ArrayList<PersonaEntidad> lista = singleton.listarCliente(); return lista; }
	 * 
	 * @Override public ArrayList<PersonaEntidad> agregarPersona() { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public ArrayList<PersonaEntidad> eliminarPersona() { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * public void modificarPersona(PersonaEntidad persona) { // TODO Auto-generated
	 * method stub Singleton singleton = Singleton.getInstancia();
	 * ArrayList<PersonaEntidad> lista = singleton.listarCliente();
	 * Iterator<PersonaEntidad> iterator=lista.iterator(); while
	 * (iterator.hasNext()) { PersonaEntidad elem= iterator.next(); if
	 * (persona.getId()==elem.getId()) { iterator.remove(); } } lista.add(persona);
	 * }
	 */

}
