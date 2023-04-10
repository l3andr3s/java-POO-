package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import logico.Cliente;
import logico.Tienda;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarCliente extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textDireccion;
	private JTextField textCedula;
	private JButton btnRegistrar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarCliente dialog = new RegistrarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public RegistrarCliente() {
		setUndecorated(true);
		setBounds (100, 100, 546,432);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color (230, 230, 250));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Cedula:");
				lblNewLabel.setBounds(100, 100, 56, 16);
				panel.add(lblNewLabel);
			}
			{
				textCedula = new JTextField();
				textCedula.setBounds(100, 100, 56, 1);
				panel.add(textCedula);
				textCedula.setColumns(10);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(250, 240, 230));
				panel_1.setBorder(new LineBorder(new Color(135, 206, 235)));
				panel_1.setBounds(77, 74, 393, 275);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					textNombre = new JTextField();
					textNombre.setEditable(false);
					textNombre.setBounds(91, 108, 273,22);
					panel_1.add(textNombre);
					textNombre.setColumns(10);
				}
				{
					JLabel lblNombre = new JLabel("Nombre:");
					lblNombre.setBounds(23, 111, 56, 16);
					panel_1.add(lblNombre);
				}
				{
					JLabel lblTelefono = new JLabel("Telefono");
					lblTelefono.setBounds(23, 171, 56, 16);
					panel_1.add(lblTelefono);
				}
				{
					textTelefono = new JTextField();
					textTelefono.setEditable(false);
					textTelefono.setBounds(91, 168, 273, 22);
					panel_1.add(textTelefono);
					textTelefono.setColumns(10);
				}
				{
					JLabel lblDireccion = new JLabel("Direccion:");
					lblDireccion.setBounds(23, 243, 75, 16);
					panel_1.add(lblDireccion);					
				}
				{
					textDireccion = new JTextField();
					textDireccion.setEditable(false);
					textDireccion.setBounds(91, 240, 273, 22);
					panel_1.add(textDireccion);
					textDireccion.setColumns(10);
				}
				{
					JButton btnBuscar = new JButton("Buscar");
					btnBuscar.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							if(Tienda.getInstance().BuscarClienteByCedula(textCedula.getText())!= null) {
								JOptionPane.showMessageDialog(contentPanel, "Cliente Encontrado");
								Cliente aux = Tienda.getInstance().BuscarClienteByCedula(textCedula.getText());
								textDireccion.setText(aux.getDireccion());
								textNombre.setText(aux.getNombre());
								textTelefono.setText(aux.getTelefono());
								textCedula.setText(aux.getCedula());
								btnRegistrar.setEnabled(false);
							}
							else {
								JOptionPane.showMessageDialog(contentPanel,"Cliente no encontrado.");
								textCedula.setEditable(true);
								textDireccion.setEditable(true);
								textNombre.setEditable(true);
								textTelefono.setEditable(true);
							}
						}
					});
					btnBuscar.setBorder(null);
					btnBuscar.setBackground(new Color(250, 240, 230));
					btnBuscar.setBounds(168, 61, 97, 25);
					panel_1.add(btnBuscar);
				}
			}
			{
				btnRegistrar = new JButton("Registar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Cliente aux = new Cliente(textCedula.getText(),textNombre.getText(), textTelefono.getText(), textDireccion.getText());
						Tienda.gerInstance().RegistrarCliente(aux);
						JOptionPane.showMessageDialog(contentPanel, "Registro Exitoso");
					}
				});
				btnRegistrar.setBacground(new Color(124, 252, 0));
				btnRegistrar.setBounds(236, 362, 97, 25);
				panel_1.add(btnRegistrar);
			}
			{
				JBoutton btnVolver = new JButton("Volver");
				btnVolver.setBackground(new Color(230, 230, 250))
				btnVolver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					
					}
				});
				btnVolver.setBounds(457, 397, 97, 25);
				panel.add(btnVolver);
			}
			
		}
	}

}
