package persistencia;

import java.util.ArrayList;
import entidades.ClienteEntidad;
import entidades.PersonaEntidad;

public interface IClienteRepositorio {
	ArrayList<ClienteEntidad> listarCliente();

	ArrayList<ClienteEntidad> agregarCliente();

	ArrayList<ClienteEntidad> eliminarCliente();
	
	ArrayList<ClienteEntidad> modificarCliente();
}
