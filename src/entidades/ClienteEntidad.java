package entidades;

public class ClienteEntidad implements Comparable<ClienteEntidad> {
	private int id;
	private String nombre;
	private int edad;

	public ClienteEntidad(int id, String nombre, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public int compareTo(ClienteEntidad cli) {
		// TODO Auto-generated method stub
		int valor = 0;
		if (this.id < cli.id) {
			valor = -1;
		} else if (this.id > cli.id) {
			valor = 1;
		}
		return valor;
	}

}
