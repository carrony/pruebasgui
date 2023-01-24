package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaMultiplicar extends JFrame {

	private JPanel contentPane;
	private JTextField txtNum1;
	private JTextField txtNum2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMultiplicar frame = new VentanaMultiplicar();
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
	public VentanaMultiplicar() {
		setTitle("Multiplicar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow]", "[][][][][][][][][]"));
		
		JLabel lblNum1 = new JLabel("Número 1:");
		contentPane.add(lblNum1, "cell 1 1");
		
		txtNum1 = new JTextField();
		contentPane.add(txtNum1, "cell 2 1,growx");
		txtNum1.setColumns(10);
		
		JLabel lblNum2 = new JLabel("Número 2:");
		contentPane.add(lblNum2, "cell 1 3,alignx trailing");
		
		txtNum2 = new JTextField();
		contentPane.add(txtNum2, "cell 2 3,growx");
		txtNum2.setColumns(10);
		
		JLabel lblOperacion = new JLabel("Operación:");
		contentPane.add(lblOperacion, "cell 1 5,alignx trailing");
		
		JComboBox comboOperacion = new JComboBox();
		comboOperacion.setModel(new DefaultComboBoxModel(new String[] {"Suma", "Resta", "Multiplicación", "División"}));
		contentPane.add(comboOperacion, "cell 2 5,growx");
		
		JLabel lblProducto = new JLabel("Producto:");
		contentPane.add(lblProducto, "cell 1 6");
		
		JLabel lblResultado = new JLabel("");
		contentPane.add(lblResultado, "cell 2 6");
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				if (txtNum1.getText()==null || txtNum1.getText().isBlank() ||
					txtNum2.getText()==null || txtNum2.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Debe introducir un número",
							"Datos no introducidos", JOptionPane.WARNING_MESSAGE);
					return;
				}
				double num1= Double.parseDouble(txtNum1.getText());
				double num2 = Double.parseDouble(txtNum2.getText());
				
				lblResultado.setText(""+num1*num2); */
				try {
					double num1= Double.parseDouble(txtNum1.getText());
					double num2 = Double.parseDouble(txtNum2.getText());
					
					String operacion = (String) comboOperacion.getSelectedItem();
					double resultado=0;
					switch(operacion) {
					case "Suma": resultado=num1+num2; break;
					case "Resta": resultado=num1-num2; break;
					case "Multiplicación": resultado = num1*num2;break;
					case "División": resultado=num1/num2;break;
					}
					lblResultado.setText(""+resultado);
				}catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Debe introducir un número válido",
							"Datos no introducidos", JOptionPane.WARNING_MESSAGE);
				}
				
				
			}
		});
		contentPane.add(btnCalcular, "cell 0 8 3 1,alignx center");
	}

}
