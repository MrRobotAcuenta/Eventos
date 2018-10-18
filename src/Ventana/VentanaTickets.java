package Ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class VentanaTickets extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaTickets frame = new VentanaTickets();
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
	public VentanaTickets() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAgregar = new JButton("agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAgregarTicket administrar = new VentanaAgregarTicket();
				administrar.setVisible(true);
				dispose();
			}
		});
		btnAgregar.setBounds(150, 107, 97, 25);
		contentPane.add(btnAgregar);
		
		JButton btnNewButton = new JButton("modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaTickets administrar = new ListaTickets();
				administrar.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(150, 145, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("eliminar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarTicket administrar = new EliminarTicket();
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
		
		JLabel lblTickets = new JLabel("Tickets");
		lblTickets.setBounds(174, 13, 56, 16);
		contentPane.add(lblTickets);
	}

}
