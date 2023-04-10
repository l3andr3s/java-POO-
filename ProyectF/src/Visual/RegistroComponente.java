package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import logico.Componente;
import logico.DiscoDuro;
import logico.MemoriaRam;
import logico.Micro;
import logico.MotherBoard;
import logico.Tienda;

import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JSpinner;

public class RegistroComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private JTextField textMemoriaRam;
	private JTextField textTipoMemoriaRam;
	private JTextField textModeloMicro;
	private JTextField textTipoConexionMicro;
	private JTextField textVelocidadMicro;
	private JTextField textModeloDisco;
	private JTextField textTipoConexionDisco;
	private JTextField textAlmacenamientoDisco;
	private JTextField textModeloMother;
	private JTextField textTipoConectorMother;
	private JTextField textTipoRamMother;
	private JTextField textConexionesMother;
	private JRadioButton rdbRam;
	private JRadioButton rdbMicro;
	private JRadioButton rdbMother;
	private JRadioButton rdbDisco;
	private JPanel panelRam;
	private JPanel panelMicro;
	private JPanel panelDiscoD;
	private JPanel panelMotherBoard;
	private JTextField textPrecio;
	private JLabel lblNewLabel_1;
	private JLabel lblCantidad;
	private JSpinner spinnerCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroComponente dialog = new RegistroComponente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroComponente() {
		setTitle("Registro Componente");
		setBounds(100, 100, 663, 472);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(173, 216, 230));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 255, 255));
			panel_1.setBorder(new LineBorder(new Color(218, 165, 32)));
			panel_1.setBounds(12, 13, 611, 127);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			rdbRam = new JRadioButton("Ram");
			rdbRam.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					rdbDisco.setSelected(false);
					rdbMicro.setSelected(false);
					rdbMother.setSelected(false);
					rdbRam.setSelected(true);
					if(rdbRam.isSelected()) {
						panelRam.setVisible(true);
						panelDiscoD.setVisible(false);
						panelMotherBoard.setVisible(false);
						panelMicro.setVisible(false);
						
					}
					CargarCodigo();
				}
			});
			rdbRam.setBackground(new Color(255, 255, 255));
			rdbRam.setBounds(8, 93, 127, 25);
			panel_1.add(rdbRam);
			rdbRam.setSelected(true);
			
			rdbMicro = new JRadioButton("Micro procesador");
			rdbMicro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbDisco.setSelected(false);
					rdbMicro.setSelected(true);
					rdbMother.setSelected(false);
					rdbRam.setSelected(false);
					if(rdbMicro.isSelected()) {
						panelRam.setVisible(false);
						panelDiscoD.setVisible(false);
						panelMotherBoard.setVisible(false);
						panelMicro.setVisible(true);
						
					}
					CargarCodigo();
				}
			});
			rdbMicro.setBackground(new Color(255, 255, 255));
			rdbMicro.setBounds(139, 93, 127, 25);
			panel_1.add(rdbMicro);
			
			rdbMother = new JRadioButton("MotherBoard");
			rdbMother.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbDisco.setSelected(false);
					rdbMicro.setSelected(false);
					rdbMother.setSelected(true);
					rdbRam.setSelected(false);
					if(rdbMother.isSelected()) {
						panelRam.setVisible(false);
						panelDiscoD.setVisible(false);
						panelMotherBoard.setVisible(true);
						panelMicro.setVisible(false);
						
					}
					CargarCodigo();
				}
			});
			rdbMother.setBackground(new Color(255, 255, 255));
			rdbMother.setBounds(312, 93, 127, 25);
			panel_1.add(rdbMother);
			
			rdbDisco = new JRadioButton("Disco Duro");
			rdbDisco.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbDisco.setSelected(true);
					rdbMicro.setSelected(false);
					rdbMother.setSelected(false);
					rdbRam.setSelected(false);
					if(rdbDisco.isSelected()) {
						panelRam.setVisible(false);
						panelDiscoD.setVisible(true);
						panelMotherBoard.setVisible(false);
						panelMicro.setVisible(false);
						
					}
					CargarCodigo();
				}
			});
			rdbDisco.setBackground(new Color(255, 255, 255));
			rdbDisco.setBounds(476, 93, 127, 25);
			panel_1.add(rdbDisco);
			
			JButton btnRegistrar = new JButton("Registrar");
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int cantidad = (int) spinnerCantidad.getValue();
					float precio = Float.valueOf(textPrecio.getText());
					String codigo = textCodigo.getText();
					Componente aux = null;
					if(rdbRam.isSelected()) {
			
						float memoria = Float.valueOf(textMemoriaRam.getText());
						aux = new MemoriaRam(codigo,cantidad,precio,memoria,textTipoMemoriaRam.getText());
					}
					else if(rdbMicro.isSelected()) {
	
						aux = new Micro(codigo,cantidad,precio, textModeloMicro.getText(),textTipoConexionMicro.getText());
					}
					else if(rdbMother.isSelected()) {