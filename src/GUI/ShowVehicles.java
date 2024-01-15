package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import systemclass.VehicleSys;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class ShowVehicles extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JComboBox vehiclesCMB;
	JTextArea textArea;
	JLabel lblAdded;

	AddVehicles addVehicle;
	UseVehicle useVehicle;
	
	public static void setvehiclesCMB() {
		int i = vehiclesCMB.getSelectedIndex();
		vehiclesCMB.setModel(new DefaultComboBoxModel(VehicleSys.getVehicleNames()));
		vehiclesCMB.setSelectedIndex(i);
    }
	
	public void setTextArea(String s) {
		textArea.setText(s);
    }
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		VehicleSys.readFromFile();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowVehicles frame = new ShowVehicles();
					setvehiclesCMB();
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
	public ShowVehicles() {
		addVehicle = new AddVehicles(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton BTNaddVehicle = new JButton("Add Vehicle");
		BTNaddVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addVehicle.setVisible(true);
				addVehicle.fillComboBoxAdd();
				setVisible(false);
			}
		});
		BTNaddVehicle.setBounds(396, 79, 133, 23);
		contentPane.add(BTNaddVehicle);
		
		vehiclesCMB = new JComboBox();
		vehiclesCMB.setBounds(99, 11, 287, 22);
		contentPane.add(vehiclesCMB);
		
		JLabel lblNewLabel = new JLabel("Select Vehicle:");
		lblNewLabel.setBounds(10, 15, 85, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Show Specs");
		
		btnNewButton.setBounds(396, 11, 133, 23);
		contentPane.add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 44, 376, 252);
		contentPane.add(textArea);
		
		JButton BTNuseVehicle = new JButton("Use This Vehicle!");
		
		BTNuseVehicle.setBounds(396, 238, 133, 58);
		contentPane.add(BTNuseVehicle);
		
		lblAdded = new JLabel("");
		lblAdded.setVerticalAlignment(SwingConstants.TOP);
		lblAdded.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdded.setBounds(396, 115, 133, 115);
		contentPane.add(lblAdded);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(VehicleSys.displayVehicle(vehiclesCMB.getSelectedIndex() + 1));
					lblAdded.setText("");
				} catch (Exception e2) {
					// TODO: handle exception
					lblAdded.setText("<html>You should<br>choose a vehicle.");
				}
				
			}
		});
		
		useVehicle = new UseVehicle(this);
		BTNuseVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					useVehicle.setVehicle(VehicleSys.searchVehicle(vehiclesCMB.getSelectedIndex() + 1));
					useVehicle.setVisible(true);
					setVisible(false);
					lblAdded.setText("");
				} catch (Exception e2) {
					// TODO: handle exception
					lblAdded.setText("<html>You should<br>choose a vehicle.");
				}
				
			}
		});
	}
}
