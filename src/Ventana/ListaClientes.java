package Ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaClientes extends JFrame {

	private JPanel contentPane;
	private JTable table;
	JTable miTabla;
	JScrollPane miBarra;
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public ListaClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 13, 365, 171);
		contentPane.add(scrollPane);
		miBarra=new JScrollPane();
		miBarra.setBounds(27, 72, 379, 30);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Nombre", "Rut"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaClientes administrar = new VentanaClientes();
				administrar.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(260, 215, 97, 25);
		contentPane.add(btnAtras);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(76, 215, 97, 25);
		contentPane.add(btnModificar);
		
		
	}
}
