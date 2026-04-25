import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class GUI_GLUCOSA extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	ArrayList<paciente> lista = new ArrayList<paciente>();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextArea areaResultados;
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
		
		JComboBox<Integer> comboBox = new JComboBox<Integer>();
		
		comboBox.setBounds(121, 106, 86, 22);
		panel.add(comboBox);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(118, 197, 89, 23);
		panel.add(btnGuardar);
		
		JLabel lblNewLabel = new JLabel("Buscador:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(28, 11, 71, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreBuscar = textField_2.getText().toLowerCase();
				String resultados = "";
				for (paciente i : lista) {
					if (i.nombre.toLowerCase().contains(nombreBuscar)) {
						resultados += i.nombre + " " + i.valor + " " + i.fecha + "\n";
					}
					
				}
				if (resultados.isEmpty()) {
					areaResultados.setText ("No se encontraron resultados");
				} else {
		         areaResultados.setText(resultados);
				}
			
			}
		});
		btnNewButton.setBounds(293, 8, 88, 22);
		panel.add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setBounds(109, 9, 174, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		areaResultados = new JTextArea();
		areaResultados.setBounds(254, 140, 170, 198);
		panel.add(areaResultados);
		
		
	}
}
