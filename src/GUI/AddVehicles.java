package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import systemclass.VehicleSys;
import vehicle.ElectricVehicle;
import vehicle.MotorVehicle;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Color;

public class AddVehicles extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField model2;
	private JTextField type2;
	private JTextField year2;
	private JTextField km2;
	private JTextField price2;
	private JTextField model;
	private JTextField type;
	private JTextField year;
	private JTextField km;
	private JTextField price;
	private JTextField fuel;
	
	JComboBox CMBmotor1;
	JComboBox CMBmotor2;
	JComboBox CMBbattery;
	private JTextField transmission;
	
	public void fillComboBoxAdd() {
		CMBmotor1.setModel(new DefaultComboBoxModel(VehicleSys.getEngineNames()));
		CMBmotor2.setModel(new DefaultComboBoxModel(VehicleSys.getEngineNames()));
		CMBbattery.setModel(new DefaultComboBoxModel(VehicleSys.getBatteryNames()));
	}

	/**
	 * Create the frame.
	 */
	public AddVehicles(ShowVehicles showVehicles) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton BTNcomplete = new JButton("Cancel");
		
		BTNcomplete.setBounds(358, 265, 109, 23);
		contentPane.add(BTNcomplete);
		
		JRadioButton rdbtnMV = new JRadioButton("Motor Vehicle");
		
		rdbtnMV.setSelected(true);
		buttonGroup.add(rdbtnMV);
		rdbtnMV.setBounds(30, 7, 109, 23);
		contentPane.add(rdbtnMV);
		
		JRadioButton rdbtnEV = new JRadioButton("Electric Vehicle");
		buttonGroup.add(rdbtnEV);
		rdbtnEV.setBounds(141, 7, 119, 23);
		contentPane.add(rdbtnEV);
		
		JButton btnAdd = new JButton("Add Vehicle");
		
		btnAdd.setBounds(50, 265, 119, 23);
		contentPane.add(btnAdd);
		
		JPanel electric = new JPanel();
		electric.setBounds(10, 37, 491, 225);
		contentPane.add(electric);
		electric.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Electric Vehicle");
		lblNewLabel.setBounds(10, 11, 107, 14);
		electric.add(lblNewLabel);
		
		model2 = new JTextField();
		model2.setBounds(72, 101, 96, 20);
		electric.add(model2);
		model2.setColumns(10);
		
		type2 = new JTextField();
		type2.setBounds(72, 132, 96, 20);
		electric.add(type2);
		type2.setColumns(10);
		
		year2 = new JTextField();
		year2.setBounds(72, 163, 96, 20);
		electric.add(year2);
		year2.setColumns(10);
		
		km2 = new JTextField();
		km2.setBounds(72, 194, 96, 20);
		electric.add(km2);
		km2.setColumns(10);
		
		price2 = new JTextField();
		price2.setBounds(328, 101, 96, 20);
		electric.add(price2);
		price2.setColumns(10);
		
		JCheckBox first2 = new JCheckBox("First Owner");
		first2.setBounds(323, 131, 99, 23);
		electric.add(first2);
		
		CMBmotor2 = new JComboBox();
		CMBmotor2.setBounds(72, 68, 385, 22);
		electric.add(CMBmotor2);
		
		JLabel lblNewLabel_1 = new JLabel("Model");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(14, 104, 48, 14);
		electric.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Type");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(14, 135, 48, 14);
		electric.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Year");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setBounds(14, 166, 48, 14);
		electric.add(lblNewLabel_2_1);
		electric.setVisible(false);
		
		JLabel lblNewLabel_2_2 = new JLabel("KM");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_2.setBounds(14, 197, 48, 14);
		electric.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Price");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_3.setBounds(271, 104, 48, 14);
		electric.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_6 = new JLabel("Engine");
		lblNewLabel_2_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_6.setBounds(10, 72, 48, 14);
		electric.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_2_6_2 = new JLabel("Battery");
		lblNewLabel_2_6_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_6_2.setBounds(14, 36, 48, 14);
		electric.add(lblNewLabel_2_6_2);
		
		CMBbattery = new JComboBox();
		CMBbattery.setBounds(72, 36, 385, 22);
		electric.add(CMBbattery);
		
		JCheckBox regenerative = new JCheckBox("Regenerative Braking");
		regenerative.setToolTipText("");
		regenerative.setBounds(323, 155, 162, 31);
		electric.add(regenerative);
		
		JPanel motor = new JPanel();
		motor.setBounds(10, 37, 491, 198);
		contentPane.add(motor);
		motor.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Motor Vehicle");
		lblNewLabel_3.setBounds(10, 11, 107, 14);
		motor.add(lblNewLabel_3);
		
		model = new JTextField();
		model.setColumns(10);
		model.setBounds(72, 74, 96, 20);
		motor.add(model);
		
		type = new JTextField();
		type.setColumns(10);
		type.setBounds(72, 105, 96, 20);
		motor.add(type);
		
		year = new JTextField();
		year.setColumns(10);
		year.setBounds(72, 136, 96, 20);
		motor.add(year);
		
		km = new JTextField();
		km.setColumns(10);
		km.setBounds(72, 167, 96, 20);
		motor.add(km);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(361, 74, 96, 20);
		motor.add(price);
		
		JCheckBox first = new JCheckBox("First Owner");
		first.setBounds(358, 104, 99, 23);
		motor.add(first);
		
		fuel = new JTextField();
		fuel.setColumns(10);
		fuel.setBounds(361, 136, 96, 20);
		motor.add(fuel);
		
		CMBmotor1 = new JComboBox();
		CMBmotor1.setBounds(72, 41, 385, 22);
		motor.add(CMBmotor1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Model");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(14, 77, 48, 14);
		motor.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_5 = new JLabel("Type");
		lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_5.setBounds(14, 108, 48, 14);
		motor.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Year");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1.setBounds(14, 139, 48, 14);
		motor.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("KM");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_2_1.setBounds(14, 170, 48, 14);
		motor.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Price");
		lblNewLabel_2_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_3_1.setBounds(304, 77, 48, 14);
		motor.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Fuel Capacity");
		lblNewLabel_2_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_4_1.setBounds(267, 139, 84, 14);
		motor.add(lblNewLabel_2_4_1);
		
		JLabel lblNewLabel_2_6_1 = new JLabel("Engine");
		lblNewLabel_2_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_6_1.setBounds(10, 45, 48, 14);
		motor.add(lblNewLabel_2_6_1);
		
		transmission = new JTextField();
		transmission.setColumns(10);
		transmission.setBounds(361, 167, 96, 20);
		motor.add(transmission);
		
		JLabel lblNewLabel_2_4_1_1 = new JLabel("Transmission");
		lblNewLabel_2_4_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_4_1_1.setBounds(267, 170, 84, 14);
		motor.add(lblNewLabel_2_4_1_1);
		
		JLabel lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setHorizontalAlignment(SwingConstants.RIGHT);
		lblError.setBounds(266, 11, 235, 14);
		contentPane.add(lblError);
		

		rdbtnEV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				electric.setVisible(true);
				motor.setVisible(false);
			}
		});
		
		rdbtnMV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				motor.setVisible(true);
				electric.setVisible(false);
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				if(rdbtnMV.isSelected())
				{
					
					MotorVehicle mv = new MotorVehicle(model.getText(), type.getText(), Integer.parseInt(year.getText()),
							Double.parseDouble(km.getText()), Double.parseDouble(price.getText()), first.isSelected(),
							Double.parseDouble(fuel.getText()), transmission.getText(),
							VehicleSys.searchEngine(CMBmotor1.getSelectedIndex() + 1));
					model.setText("");
					type.setText("");
					year.setText("");
					km.setText("");
					first.setSelected(false);
					fuel.setText("");
					transmission.setText("");
					VehicleSys.addVehicle(mv);
					lblError.setText("");
					showVehicles.lblAdded.setText("<html> " + "Motor Vehicle<br>" + mv.getModelName() +
							"<br>is added!");
				}
				else
				{
					ElectricVehicle mv = new ElectricVehicle(model2.getText(), type2.getText(), Integer.parseInt(year2.getText()),
							Double.parseDouble(km2.getText()), Double.parseDouble(price2.getText()), first2.isSelected(),
							regenerative.isSelected(), VehicleSys.searchEngine(CMBmotor2.getSelectedIndex() + 1),
							VehicleSys.searchBattery(CMBbattery.getSelectedIndex() + 1));
					model2.setText("");
					type2.setText("");
					year2.setText("");
					km2.setText("");
					first2.setSelected(false);
					regenerative.setSelected(false);
					VehicleSys.addVehicle(mv);
					lblError.setText("");
					showVehicles.lblAdded.setText("<html> " + "Electric Vehicle<br>" + mv.getModelName() +
							"<br>is added!");
				}
				showVehicles.setVisible(true);
				showVehicles.setvehiclesCMB();
				dispose();
				
			} catch (Exception e2) {
				lblError.setText("Please fill all the areas properly!");
				System.out.println("Error!");
			}
				
			}
		});
		
		BTNcomplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showVehicles.setVisible(true);
				showVehicles.setvehiclesCMB();
				model.setText("");
				type.setText("");
				year.setText("");
				km.setText("");
				first.setSelected(false);
				fuel.setText("");
				transmission.setText("");
				model2.setText("");
				type2.setText("");
				year2.setText("");
				km2.setText("");
				first2.setSelected(false);
				regenerative.setSelected(false);
				lblError.setText("");
				dispose();
			}
		});
	}
}
