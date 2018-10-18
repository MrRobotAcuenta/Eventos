package Ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import clases.Persona;
import clases.ListaPersonas;
import clases.Connectar;

public class EliminarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textRut;
	private JButton btnEliminar;
	private JButton btnAtras;
	

	/**
	 * Launch the applicatidon.
	 */


	/**
	 * Create the frame.
	 */
	public EliminarCliente() {
		ListaPersonas lista =new ListaPersonas();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRut = new JLabel("Rut");
		lblRut.setBounds(12, 54, 56, 16);
		contentPane.add(lblRut);
		
		textRut = new JTextField();
		textRut.setBounds(97, 51, 116, 22);
		contentPane.add(textRut);
		textRut.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rut = textRut.getText();
				 lista.eliminarPersona( rut);
				
			}
		});
		btnEliminar.setBounds(175, 86, 97, 25);
		contentPane.add(btnEliminar);
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaClientes administrar = new VentanaClientes();
				administrar.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(175, 124, 97, 25);
		contentPane.add(btnAtras);
	}
}
