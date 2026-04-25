import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;



public class GUI_GLUCOSA extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	ArrayList<paciente> lista = new ArrayList<paciente>();
	private JTextField textField;
	private JTextField textField_1;
	public class paciente {
		String nombre;
		int valor;
		String fecha;
		
		paciente (String nombre, int valor, String fecha){
			this.nombre=nombre;
			this.valor=valor;
			this.fecha=fecha;
		}
	
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_GLUCOSA frame = new GUI_GLUCOSA();
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
	public GUI_GLUCOSA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(16, 11, 87, 16);
		contentPane.add(toolBar);
		
		JButton btnRegistrar = new JButton("Registrar");
		toolBar.add(btnRegistrar);
		
		
		JPanel panelglucosa = new JPanel();
		panelglucosa.setBounds(10, 38, 459, 349);
		contentPane.add(panelglucosa);
		panelglucosa.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panelglucosa.add(panel, "name_737072192421100");
		panel.setLayout(null);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(28, 110, 71, 14);
		panel.add(lblFecha);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(28, 77, 71, 14);
		panel.add(lblValor);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(28, 47, 46, 14);
		panel.add(lblNombre);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(121, 44, 86, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(121, 75, 86, 20);
		panel.add(textField_1);
		
		JLabel lblmg = new JLabel("mg/dL");
		lblmg.setBounds(213, 81, 46, 14);
		panel.add(lblmg);
		
		LocalDate h = LocalDate.now();
		
		JComboBox<Integer> comboBox = new JComboBox<Integer>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox.setBounds(123, 105, 86, 22);
		comboBox.setSelectedIndex(h.getDayOfMonth()-1);
		panel.add(comboBox);
		
		JComboBox<Integer> comboBoxMes = new JComboBox<Integer>();
		comboBoxMes.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBoxMes.setBounds(218, 105, 86, 22);
		comboBoxMes.setSelectedIndex(h.getMonthValue()-1);
		panel.add(comboBoxMes);
		
		JComboBox<String> comboBoxAño = new JComboBox<String>();
		comboBoxAño.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		comboBoxAño.setBounds(314, 105, 86, 22);
		comboBoxAño.setSelectedItem(String.valueOf(h.getYear()));
		panel.add(comboBoxAño);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		        paciente pacienteNuevo;		        
		        String nom = textField.getText();
		        int val = Integer.parseInt(textField_1.getText());
		        
		        String dia = String.valueOf(comboBox.getSelectedItem());
		        String mes = String.valueOf(comboBoxMes.getSelectedItem());
		        String año = String.valueOf(comboBoxAño.getSelectedItem());
		        String fecha = dia+"/"+mes+"/"+año;
		        
		        pacienteNuevo = new paciente (nom, val, fecha);
		        lista.add(pacienteNuevo);
		        
		        textField.setText("");
		        textField_1.setText("");
		        JOptionPane.showMessageDialog(null, "Registro completado");
				
			}
		});
		btnGuardar.setBounds(118, 197, 89, 23);
		panel.add(btnGuardar);
		
		
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (panelglucosa.getLayout());
				cl.show(panelglucosa, "registro");
			}
		});
		
		
	}
}