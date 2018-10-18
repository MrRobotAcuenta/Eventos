package Ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class VentanaClientes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaClientes frame = new VentanaClientes();
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
	public VentanaClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAgregar = new JButton("agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAgregarCliente administrar = new VentanaAgregarCliente();
				administrar.setVisible(true);
				dispose();
			}
		});
		btnAgregar.setBounds(150, 76, 97, 25);
		contentPane.add(btnAgregar);
		
		JButton btnNewButton = new JButton("modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaClientes administrar = new ListaClientes();
				administrar.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(150, 126, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("eliminar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarCliente administrar = new EliminarCliente();
				administrar.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(150, 183, 97, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnAtras = new JButton("atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrinicipal administrar = new VentanaPrinicipal();
				administrar.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(305, 183, 97, 25);
		contentPane.add(btnAtras);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setBounds(174, 13, 56, 16);
		contentPane.add(lblClientes);
	}

}
