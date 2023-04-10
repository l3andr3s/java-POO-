package Visual;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.BorderLayout;



public class Principal extends JFrame{
	
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				}catch (Exception e){
					e.printStackTrace();
				}
			}
			
		});
	}
	

		
	{

/**
 * Create the frame
 */

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 478);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentpane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JMenuBar menuBar = new JMenuBar();
		panel_1.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Componente");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registrar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroComponente dialog = new RegistroComponente();
				dialog.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Listado");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaComponentes dialog = new ListaComponentess();
				dialog.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JmenuBar menuBar_2 = new JMenuBar();
		panel_1.add(menuBar_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Registrar");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarCliente dialog = new RegistrarCliente();
				dialog.setVisible(true);
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Listado");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoDeCliente dialog = new ListadoDeClientes();
				dialog.setVisible(true);
				
			}
		});
		mnNewMenu_2.add(mnntmNewMenuItem_3);
		
		JMenuBar menuBar_1 = new JMenuBar();
		panel_1.add(menuBar_1);
		
		JMenu mnNewMenu_1 = new JMenu("Factura");
		menuBar_1.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
	}	
		
		
	}


