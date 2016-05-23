package exception;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.MaskFormatter;

public class BikeForm extends JFrame{
	/**
	 * 
	 */
	private GridBagLayout gridBagLayot=new GridBagLayout();
	private final static String[] listBikeNames={"Aist","Damski","Orlenok"};
	private JComboBox<String> listBike;
	private BikeControl bikeControl;
	private JFormattedTextField countBike;
	
	public BikeForm(String title){
		super(title);
		setResizable(false);
	}
	
	public  Object getBike() {
		return listBike.getSelectedItem();
	}

	public void setListBike(JComboBox<String> listBike) {
		this.listBike = listBike;
	}

	public String getCountBike() {
		return countBike.getText();
	}

	

	public void addComponentToPanel(JFrame frame){
		
		setLayout(gridBagLayot);
		GridBagConstraints constraints=new GridBagConstraints();
		
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.gridwidth=2;
		constraints.insets=new Insets(10, 5, 10, 10);
		constraints.ipadx=40;
		listBike=new JComboBox<>(listBikeNames);
		frame.add(listBike,constraints);
		
		JLabel lblCounBike=new JLabel("Count bike");
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.gridwidth=1;
		constraints.ipadx=0;
		frame.add(lblCounBike,constraints);
		
		try {
		MaskFormatter formatCountBikes = new MaskFormatter("***");
		 
	    formatCountBikes.setValidCharacters("0123456789");	  
	    
		countBike=new JFormattedTextField(formatCountBikes);
		}catch (ParseException e) {
			System.out.println("Error input :" + e.getMessage());
		}		
		countBike.setColumns(2);
		countBike.setValue("000");
		constraints.gridx=1;
		constraints.gridy=1;
		constraints.gridwidth=1;
		frame.add(countBike,constraints);
		
		
		constraints.gridx=0;
		constraints.gridy=2;
		constraints.gridwidth=2;
		JButton btnOrder=new JButton("Make an Order");
		// set controls
		bikeControl=new BikeControl(this);
		btnOrder.setActionCommand("Order");
		btnOrder.addActionListener(bikeControl);
		frame.add(btnOrder,constraints);			
	
	}
	public static void createAndShowGUI() {
		
		//https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/GridLayoutDemoProject/src/layout/GridLayoutDemo.java
		BikeForm frame=new BikeForm("Bike order");
		frame.setBounds(400, 300, 300, 200);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.addComponentToPanel(frame);
		//frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				 createAndShowGUI();
				
			}
		});
		

	}

}
