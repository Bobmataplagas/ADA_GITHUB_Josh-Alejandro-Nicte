import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class GUI_GLUCOSA extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	ArrayList<paciente> lista = new ArrayList<paciente>();
	private JTextField textField;
	private JTextField textField_1;
	
	DefaultListModel<String> modelo = new DefaultListModel<>();
	JList<String> listahistorial = new JList<>(modelo);
	
	public class paciente {
		String nombre;
		int valor;
		String fecha;
		
		paciente (String nombre, int valor, String fecha){
			this.nombre=nombre;
			this.valor=valor;
			this.fecha=fecha;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return nombre +"  -  " +valor +"  -  " + fecha;
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
		toolBar.setBounds(16, 11, 453, 16);
		contentPane.add(toolBar);
		
		JButton btnRegistrar = new JButton("Registrar");
		toolBar.add(btnRegistrar);
		toolBar.addSeparator();
		
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
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(118, 197, 89, 23);
		panel.add(btnGuardar);
		
		JPanel panelhistorial = new JPanel();
		panelglucosa.add(panelhistorial, "historial");
		panelhistorial.setLayout(null);
		
		JList list = new JList(modelo);
		list.setBounds(10, 10, 439, 329);
		panelhistorial.add(list);
		
		JButton btnHistorial = new JButton("Historial");
		btnHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (panelglucosa.getLayout());
				cl.show(panelglucosa, "historial");
				mostrarHistorial();
			}
		});
		toolBar.add(btnHistorial);
		
	}
	
	public void mostrarHistorial() {
		modelo.clear();
		
		lista.add(new paciente("Juan",8,"fecha"));
		lista.add(new paciente("Abel",10,"fecha"));
		lista.add(new paciente("Abel",8,"fecha"));
		lista.add(new paciente("Abel",9,"fecha"));
		lista.add(new paciente("Carmela",8,"fecha"));
		lista.add(new paciente("Benito",8,"fecha"));
		
		lista.sort((p1,p2)->p1.nombre.compareToIgnoreCase(p2.nombre));

		String actual = ""; 
		
		for (paciente p : lista) {
			if (!p.nombre.equals(actual)) {
				modelo.addElement("--"+p.nombre+"--");
				modelo.addElement("Tomas: ");
				actual = p.nombre;
			}
		modelo.addElement("Valor: "+p.valor+" Fecha: "+p.fecha);
		}
	}
}
