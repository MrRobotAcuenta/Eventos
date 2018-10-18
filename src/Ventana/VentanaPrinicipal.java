package Ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Connectar;
import clases.ListaEventos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class VentanaPrinicipal extends JFrame {
	private static ListaEventos eventos=new ListaEventos();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Connectar conexion=new Connectar();
		eventos.readListaEventos(conexion);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrinicipal frame = new VentanaPrinicipal();
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
	public VentanaPrinicipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			VentanaClientes administrar = new VentanaClientes();
			administrar.setVisible(true);
			dispose();
			}
		});
		btnClientes.setBounds(12, 13, 97, 25);
		contentPane.add(btnClientes);
		
		JButton btnEventos = new JButton("Eventos");
		btnEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaEventos administrar = new VentanaEventos();
				administrar.setVisible(true);
				dispose();
			}
		});
		btnEventos.setBounds(12, 98, 97, 25);
		contentPane.add(btnEventos);
		
		JButton btnTickets = new JButton("Tickets");
		btnTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaTickets administrar = new VentanaTickets();
				administrar.setVisible(true);
				dispose();
			}
		});
		btnTickets.setBounds(12, 191, 97, 25);
		contentPane.add(btnTickets);
	}
}
