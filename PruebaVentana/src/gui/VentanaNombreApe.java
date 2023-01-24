package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaNombreApe extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JButton btnAceptar;
	private JLabel lblTuNombre;
	private JLabel lblResultado;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JPanel panel;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaNombreApe frame = new VentanaNombreApe();
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
	public VentanaNombreApe() {
		setTitle("Introduce tus datos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][grow]", "[][][20px,shrink 150][][grow][][grow 85][grow]"));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBackground(Color.RED);
		lblNombre.setForeground(Color.BLUE);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNombre, "cell 1 1,alignx trailing");
		
		txtNombre = new JTextField();
		contentPane.add(txtNombre, "cell 2 1 4 1,grow");
		txtNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellidos.setForeground(Color.BLUE);
		contentPane.add(lblApellidos, "cell 1 3,alignx trailing");
		
		txtApellidos = new JTextField();
		contentPane.add(txtApellidos, "cell 2 3 4 1,growx");
		txtApellidos.setColumns(10);
		
		lblTuNombre = new JLabel("Tu nombre es:");
		contentPane.add(lblTuNombre, "cell 1 5 2 1,alignx left");
		
		lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblResultado, "cell 3 5 3 1,alignx left,growy");
		
		panel = new JPanel();
		contentPane.add(panel, "cell 0 7 6 1,grow");
		
		btnAceptar = new JButton("Aceptar");
		panel.add(btnAceptar);
		
		btnLimpiar = new JButton("Limpiar Datos");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText("");
				txtApellidos.setText("");
				lblResultado.setText("");
			}
		});
		panel.add(btnLimpiar);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText();
				String apellidos = txtApellidos.getText();
				lblResultado.setText(apellidos+", "+nombre);
				
//				lblResultado.setText(txtNombre.getText());
			}
		});
	}

}
