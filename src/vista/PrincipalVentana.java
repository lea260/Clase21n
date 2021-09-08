package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class PrincipalVentana extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JButton btnListarCliente;
	private ClienteSubVentana ClienteListaSubVentana;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalVentana frame = new PrincipalVentana();
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
	public PrincipalVentana() {
		// hace que la ventana aparezca maximizada
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(mnClientes);

		JMenuItem mntmListarCliente = new JMenuItem("Listar");
		mntmListarCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mntmListarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verListaCliente();
			}

		});
		mnClientes.add(mntmListarCliente);

		JMenuItem mntmCrearCliente = new JMenuItem("Crear");
		mnClientes.add(mntmCrearCliente);

		JMenu mnEmpleados = new JMenu("Empleados");
		menuBar.add(mnEmpleados);

		JMenuItem mntmListarEmpleado = new JMenuItem("Listar");
		mnEmpleados.add(mntmListarEmpleado);

		JMenuItem mntmCrearEmpleado = new JMenuItem("Crear");
		mnEmpleados.add(mntmCrearEmpleado);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);

		btnListarCliente = new JButton("Listar Cliente");
		btnListarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verListaCliente();
			}
		});

		toolBar.add(btnListarCliente);

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(233, 150, 122));
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}

	private void verListaCliente() {
		// TODO Auto-generated method stub
		// ClienteSubVentana subVentana = new ClienteSubVentana();
		// subVentana.setVisible(true);
		// desktopPane.add(subVentana);
		if (ClienteListaSubVentana == null || ClienteListaSubVentana.isClosed()) {
			ClienteListaSubVentana = new ClienteSubVentana();
			desktopPane.add(ClienteListaSubVentana);
			Dimension tamVentanaDimension = ClienteListaSubVentana.getSize();
			int posX = (int) (desktopPane.getWidth() - tamVentanaDimension.width) / 2;
			ClienteListaSubVentana.setLocation(posX, 0);
			ClienteListaSubVentana.setVisible(true);
		}
	}
}
