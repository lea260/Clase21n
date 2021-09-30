package ordenar;

import java.util.Comparator;

import entidades.*;

public class ClienteIdEdadDesc implements Comparator<ClienteEntidad> {

	public ClienteIdEdadDesc() {

	}

	@Override
	public int compare(ClienteEntidad o1, ClienteEntidad o2) {
		// TODO Auto-generated method stub
		int valor = 0;
		if (o1.getId() < o2.getId()) {
			valor = -1;
		} else if (o1.getId() > o2.getId()) {
			valor = 1;
		} else if (o1.getEdad() < o2.getEdad()) {
			valor = 1;
		} else if (o1.getEdad() > o2.getEdad()) {
			valor = -1;
		}
		return valor;
	}
}
