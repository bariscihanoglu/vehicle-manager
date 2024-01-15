package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import systemclass.VehicleSys;
import vehicle.Vehicle;
import vehicle.ElectricVehicle;
import vehicle.MotorVehicle;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class UseVehicle extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	
	Vehicle selectedVehicle;
	public void setVehicle(Vehicle v) {
		selectedVehicle = v;
	}
	
	/**
	 * Create the frame.
	 */
	public UseVehicle(ShowVehicles showVehicles) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton BTNstart = new JButton("START");
	
		BTNstart.setBounds(148, 11, 132, 46);
		contentPane.add(BTNstart);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 68, 418, 94);
		contentPane.add(textArea);
		
		JButton BTNtravel = new JButton("Travel");
		
		BTNtravel.setBounds(200, 184, 89, 23);
		contentPane.add(BTNtravel);
		
		JLabel lblNewLabel = new JLabel("Kilometers:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 188, 73, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(94, 185, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton BTNhonk = new JButton("HONK");
		BTNhonk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(selectedVehicle.honk() + "\n");
			}
		});
		BTNhonk.setBounds(339, 184, 89, 23);
		contentPane.add(BTNhonk);
		
		JButton BTNexit = new JButton("EXIT");
		BTNexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showVehicles.setvehiclesCMB();
				showVehicles.setVisible(true);
				textArea.setText("");
				textField.setText("");
				BTNstart.setText("START");
				showVehicles.setTextArea(VehicleSys.displayVehicle(showVehicles.vehiclesCMB.getSelectedIndex() + 1));
				dispose();
			}
		});
		BTNexit.setBounds(176, 231, 89, 23);
		contentPane.add(BTNexit);
		
		BTNstart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BTNstart.getText().equals("START"))
				{
					BTNstart.setText("STOP");
					textArea.setText("Vehicle " + selectedVehicle.getModelName() + " has started.\nNow, you can travel or honk!");
					if(selectedVehicle instanceof ElectricVehicle)
					{
						((ElectricVehicle) selectedVehicle).start();
					}
					else
					{
						((MotorVehicle) selectedVehicle).start();
					}
					
				}
					
				else
				{
					BTNstart.setText("START");
					textArea.setText("");
					if(selectedVehicle instanceof ElectricVehicle)
					{
						((ElectricVehicle) selectedVehicle).stop();
					}
					else
					{
						((MotorVehicle) selectedVehicle).stop();
					}
				}
					
			}
		});
		
		BTNtravel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(""))
					textArea.setText("You should enter kilometers!");
				else
				{
					if(selectedVehicle instanceof ElectricVehicle)
						textArea.setText(selectedVehicle.getModelName() + "\n" +
							((ElectricVehicle)selectedVehicle).travels(Double.parseDouble(textField.getText())));
					else
					{
						textArea.setText(selectedVehicle.getModelName() + "\n" +
								((MotorVehicle)selectedVehicle).travels(Double.parseDouble(textField.getText())));
					}
					textField.setText("");
				}
				
				
			}
		});
	}
}
