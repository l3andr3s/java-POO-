package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import logico.Componente;
import logico.DiscoDuro;
import logico.MemoriaRam;
import logico.Micro;
import logico.MotherBoard;
import logico.Tienda;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.Color;

public class ListaComponentes extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object rows[];
	private JComboBox comboBox;
	
	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		try {
			ListaComponentes dialog = new ListaComponentes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog
	 */
	public ListaComponentes() {
		setBounds(100, 100, 581, 345);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(240, 248, 255));
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 15));
			{
				JLabel lblTipoDeQueso = new JLabel("Tipo de Queso");
				lblTipoDeQueso.setHorizontalAlignment(SwingConstants.LEFT);
				panel.add(lblTipoDeQueso);
			}
			{
				comboBox = new JComboBox();
				comboBox.setForeground(new Color(176, 196, 222));
				comboBox.setBackground(new Color(240, 248, 255));
				comboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						loadQuesos(comboBox.getSelectedIndex());
					}
				});
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Memoria Ram", "Disco duro","Micro Procesador", "MotherBoard"}));
	           panel.add(comboBox);		
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null," ", TitledBorder.LEADING, TitledBorder.TOP,null,null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0,0));
			{
				JScrollPane scrollpane = new JScrollPane();
				panel.add(panel, BorderLayout.CENTER);
				{
					String[] headers = {"Codigo", " Modelo/tipo","Precio","Componente/tipo"};
					
					table = new JTable();
					table.setForeground(new Color (112, 128,144));
					table.setBackground(new Color (222, 184, 135));
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollpane.setViewportView(table);
					
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table.setModel(model);
					
				}
			}
		}
		{	JPanel buttonPane= new JPanel();
			buttonPane.setBackground(new Color (176, 196, 222));
			buttonPane.setBorder(new TitledBorder(null,"", TitledBorder.LEADING,TitledBorder.TOP, null, null ));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnDelete = new JButton ("Eliminar");
				btnDelete.setForeground(new Color (0, 0, 128));
				btnDelete.setBackground(new Color(176,196,222));
				buttonPane.add(btnDelete);	
			}
			{
				JButton btnUpdate = new JButton("Modoficar");
				btnUpdate.setBackground(new Color (176, 196,222));
				btnUpdate.setForeground(new Color (0,0, 128));
				btnUpdate.setActionCommand("Ok");
				buttonPane.add(btnUpdate);
				getRootPane().setDefaultButton(btnUpdate);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setForeground(new Color(0, 0, 128));
				btnCancelar.setBackground(new Color(176, 196, 222));
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		loadQuesos(0);		
	}
	
	private void loadQuesos(int index) {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		if(index == 0 ) {
			for(Componente aux: Tienda.getInstane().getComponentes()) {
				rows[0] = aux.getNumeroSerie();
				rows[1] = aux.getCantidad();
				rows[2] = aux.getPrecio();
				if(aux instanceof MemoriaRam) {
					rows[3]="Memoria Ram";
				}
				if(aux instanceof DiscoDuro) {
					rows[3]="Disco Duro";
				}
				if(aux instanceof Micro) {
					rows[3]="Micro Procesador";
				}
				if(aux instanceof MotherBoard) {
					rows[3]="MotherBoard";
				}
				model.addRow(rows);
					
			}
		}
		
		if(index == 1) {
			for(Componente aux: Tienda.getInstane().getComponentes()) {
				if(aux instanceof MemoriaRam) {
					rows[0] = aux.getNumeroSerie();
					rows[1] = ((MemoriaRam) aux).getTipoMemoria();
					rows[2] = aux.getPrecio();
					rows[3] = "Memoria Ram";
					model.addRow(rows);
				}
			}
		}
		if(index == 3) {
			for(Componente aux: Tienda.getInstane().getComponentes()) {
				if(aux instanceof DiscoDuro) {
					rows[0] = aux.getNumeroSerie();
					rows[1] = ((DiscoDuro) aux).getModelo();
					rows[2] = aux.getPrecio();
					rows[3] = "Disco Duro";
					model.addRow(rows);
				}
			}
		}
		if(index == 2) {
			for(Componente aux: Tienda.getInstane().getComponentes()) {
				if(aux instanceof Micro) {
					rows[0] = aux.getNumeroSerie();
					rows[1] = ((Micro) aux).getTipoMemoria();
					rows[2] = aux.getPrecio();
					rows[3] = "Micro Procesador";
					model.addRow(rows);
				}
			}
		}
		if(index == 2) {
			for(Componente aux: Tienda.getInstane().getComponentes()) {
				if(aux instanceof MotherBoard) {
					rows[0] = aux.getNumeroSerie();
					rows[1] = ((MotherBoard) aux).getTipoMemoria();
					rows[2] = aux.getPrecio();
					rows[3] = "MotherBoard";
					model.addRow(rows);
				}
			}
		}
	}
	

}
