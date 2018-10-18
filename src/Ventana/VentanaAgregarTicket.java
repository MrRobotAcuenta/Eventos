package Ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clases.Ticket;
import clases.TicketsVendidos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAgregarTicket extends JFrame {

	private JPanel contentPane;
	private JTextField textAsiento;
	private JTextField textPrecio;
	private JTextField textEvento;
	private JTextField textRut;
	private TicketsVendidos lista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgregarTicket frame = new VentanaAgregarTicket();
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
	public VentanaAgregarTicket() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAsiento = new JLabel("Asiento");
		lblAsiento.setBounds(12, 31, 56, 16);
		contentPane.add(lblAsiento);
		
		JLabel lblRut = new JLabel("Precio");
		lblRut.setBounds(12, 60, 56, 16);
		contentPane.add(lblRut);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String asiento = textAsiento.getText();
				int precio =Integer.parseInt(textPrecio.getText());
				String evento = textEvento.getText();
				String rut = textRut.getText();
				Ticket t = new Ticket();
				t.setAsiento(asiento);
				t.setPrecio(precio);
				t.setNameEvento(evento);
				t.setRut(rut);
				lista.agregarTicket(t);
			}
		});
		btnAgregar.setBounds(286, 27, 97, 25);
		contentPane.add(btnAgregar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaTickets administrar = new VentanaTickets();
				administrar.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(286, 69, 97, 25);
		contentPane.add(btnAtras);
		
		textAsiento = new JTextField();
		textAsiento.setBounds(80, 28, 116, 22);
		contentPane.add(textAsiento);
		textAsiento.setColumns(10);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(80, 57, 116, 22);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);
		
		JLabel lblEvento = new JLabel("Evento");
		lblEvento.setBounds(12, 89, 56, 16);
		contentPane.add(lblEvento);
		
		JLabel lblRut_1 = new JLabel("Rut");
		lblRut_1.setBounds(12, 118, 56, 16);
		contentPane.add(lblRut_1);
		
		textEvento = new JTextField();
		textEvento.setBounds(80, 86, 116, 22);
		contentPane.add(textEvento);
		textEvento.setColumns(10);
		
		textRut = new JTextField();
		textRut.setBounds(80, 115, 116, 22);
		contentPane.add(textRut);
		textRut.setColumns(10);
	}

}
