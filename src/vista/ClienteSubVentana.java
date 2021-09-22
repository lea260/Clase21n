package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;

import entidades.ClienteEntidad;
import modelo.Empresa;
import utilidades.*;

public class ClienteSubVentana extends JInternalFrame {
	private JTable tablaClientes;
	private ArrayList<ClienteEntidad> listaClientes;
	private ModeloTabla modelo;
	private JScrollPane scrollPane;
	private Empresa empresa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteSubVentana frame = new ClienteSubVentana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClienteSubVentana() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("ListarClientes");
		setBounds(0, 0, 880, 500);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 30, 800, 300);
		getContentPane().add(scrollPane);

		tablaClientes = new JTable();
		tablaClientes.setForeground(Color.GRAY);
		tablaClientes.setBackground(Color.WHITE);
		scrollPane.setColumnHeaderView(tablaClientes);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(30, 358, 800, 100);
		getContentPane().add(panel);
		panel.setLayout(null);
		construirTabla();

	}

	private void construirTabla() {
		// llamamos
		empresa = new Empresa();
		listaClientes = empresa.mostrarDatosCliente();
		// utiliza el metodo compareTo implementado en personaEntidad
		// listaPersonas.sort(null);
		// listaPersonas.sort(new OrdenarPersonaEdad());
		// listaPersonas.sort(new OrdenarPersonaEdadId());
		/*
		 * listaPersonas.sort((p1, p2) -> { int valor = 0; if (p1.getEdad() <
		 * p2.getEdad()) { valor = -1; } else if (p1.getEdad() > p1.getEdad()) { valor =
		 * 1; } else if (p1.getId() < p1.getId()) { valor = -1; } else if (p1.getId() >
		 * p1.getId()) { valor = 1; } else { valor = 0; } return valor; });
		 */

		// listaPersonas.sort((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));

		ArrayList<String> titulosList = new ArrayList<>();

		titulosList.add("ID");
		titulosList.add("Nombre");
		titulosList.add("Edad");

		// se asignan las columnas al arreglo para enviarse al momento de construir la
		// tabla

		String titulos[] = new String[titulosList.size()];
		for (int i = 0; i < titulos.length; i++) {
			titulos[i] = titulosList.get(i);
		}
		/*
		 * obtenemos los datos de la lista y los guardamos en la matriz que luego se
		 * manda a construir la tabla
		 */
		Object[][] data = obtenerMatrizDatos(titulosList);
		construirTabla(titulos, data);
	}

	private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {

		/*
		 * se crea la matriz donde las filas son dinamicas pues corresponde a todos los
		 * usuarios, mientras que las columnas son estaticas correspondiendo a las
		 * columnas definidas por defecto
		 */
		String informacion[][] = new String[listaClientes.size()][titulosList.size()];

		for (int x = 0; x < informacion.length; x++) {
			informacion[x][UtilidadesTC.ID] = listaClientes.get(x).getId() + "";
			informacion[x][UtilidadesTC.NOMBRE] = listaClientes.get(x).getNombre() + "";
			informacion[x][UtilidadesTC.EDAD] = listaClientes.get(x).getEdad() + "";
		}
		return informacion;
	}

	private void construirTabla(String[] titulos, Object[][] data) {
		modelo = new ModeloTabla(data, titulos);
		// se asigna el modelo a la tabla
		tablaClientes.setModel(modelo);

		// filasTabla=tablaPersonas.getRowCount();
		// columnasTabla=tablaPersonas.getColumnCount();

		// se asigna el tipo de dato que tendrán las celdas de cada columna definida
		// respectivamente para validar su personalización

		// tablaPersonas.getColumnModel().getColumn(Utilidades.ID).setCellRenderer(new
		// GestionCeldas02("texto"));
		// tablaPersonas.getColumnModel().getColumn(Utilidades.NOMBRE).setCellRenderer(new
		// GestionCeldas02("texto"));
		for (int i = 0; i < titulos.length; i++) {// se resta 7 porque las ultimas 7 columnas se definen arriba
			// System.out.println(i);
			tablaClientes.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas02("texto"));
		}
		// tablaClientes.getColumnModel().getColumn(UtilidadesTC.SALDO).setCellRenderer(new
		// GestionCeldas02("numerico"));

		// se recorre y asigna el resto de celdas que serian las que almacenen datos de
		// tipo texto

		tablaClientes.getTableHeader().setReorderingAllowed(false);
		tablaClientes.setRowHeight(25);// tamaño de las celdas
		tablaClientes.setGridColor(new java.awt.Color(0, 0, 0));
		// Se define el tamaño de largo para cada columna y su contenido
		tablaClientes.getColumnModel().getColumn(UtilidadesTC.ID).setPreferredWidth(100);// documento
		tablaClientes.getColumnModel().getColumn(UtilidadesTC.NOMBRE).setPreferredWidth(200);// nombre
		tablaClientes.getColumnModel().getColumn(UtilidadesTC.EDAD).setPreferredWidth(200);// direccion

		// personaliza el encabezado
		JTableHeader jtableHeader = tablaClientes.getTableHeader();
		jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
		tablaClientes.setTableHeader(jtableHeader);

		// limitar seleccion a una fila
		tablaClientes.setRowSelectionAllowed(true);
		tablaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// se asigna la tabla al scrollPane
		scrollPane.setViewportView(tablaClientes);

		
		JScrollBar vertical = scrollPane.getVerticalScrollBar();
		vertical.setValue(vertical.getMaximum());

	}

}
