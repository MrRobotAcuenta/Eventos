package Ventana;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clases.Evento;
import clases.Persona;
import clases.ListaEventos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAgregarEvento extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textTipo;
	private JTextField textLugar;
	private ListaEventos lista = new ListaEventos();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgregarEvento frame = new VentanaAgregarEvento();
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
	public VentanaAgregarEvento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre Evento");
		lblNombre.setBounds(12, 31, 99, 16);
		contentPane.add(lblNombre);
		
		JLabel lblRut = new JLabel("Tipo");
		lblRut.setBounds(12, 60, 56, 16);
		contentPane.add(lblRut);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textNombre.getText();
				String tipo = textTipo.getText();
				String lugar = textLugar.getText();
				Evento p = new Evento(nombre,tipo,lugar);//revisar
				lista.addEvento(p);//revisar
			}
		});
		btnAgregar.setBounds(286, 27, 97, 25);
		contentPane.add(btnAgregar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaEventos administrar = new VentanaEventos();
				administrar.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(286, 69, 97, 25);
		contentPane.add(btnAtras);
		
		textNombre = new JTextField();
		textNombre.setBounds(123, 28, 116, 22);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textTipo = new JTextField();
		textTipo.setBounds(123, 57, 116, 22);
		contentPane.add(textTipo);
		textTipo.setColumns(10);
		
		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(12, 89, 56, 16);
		contentPane.add(lblLugar);
		
		textLugar = new JTextField();
		textLugar.setBounds(123, 92, 116, 22);
		contentPane.add(textLugar);
		textLugar.setColumns(10);
	}

}
