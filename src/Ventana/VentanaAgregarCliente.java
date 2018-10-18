package Ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Persona;
import clases.ListaPersonas;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class VentanaAgregarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textRut;
	private ListaPersonas lista;
	 



	/**
	 * Create the frame.
	 */
	public VentanaAgregarCliente() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 31, 56, 16);
		contentPane.add(lblNombre);
		
		JLabel lblRut = new JLabel("Rut");
		lblRut.setBounds(12, 73, 56, 16);
		contentPane.add(lblRut);
		
		textNombre = new JTextField();
		textNombre.setBounds(80, 28, 116, 22);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textRut = new JTextField();
		textRut.setBounds(80, 70, 116, 22);
		contentPane.add(textRut);
		textRut.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textNombre.getText();
				String rut = textRut.getText();
				Persona p = new Persona(rut,nombre);
				lista.addPersona(p);
			}
		});
		btnAgregar.setBounds(286, 27, 97, 25);
		contentPane.add(btnAgregar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaClientes administrar = new VentanaClientes();
				administrar.setVisible(true);
				dispose();
			}
			
			
		});
		btnAtras.setBounds(286, 69, 97, 25);
		contentPane.add(btnAtras);
	}
}
