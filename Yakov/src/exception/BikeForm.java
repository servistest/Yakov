package exception;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BikeForm extends JFrame{
	String[] listBikeNames={"Aist","Damski","Orlenok"};
	
	public BikeForm() {
		
		https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/GridLayoutDemoProject/src/layout/GridLayoutDemo.java
		setTitle("Bike order");
		setLayout(new GridBagLayout());
		GridBagConstraints constraints=new GridBagConstraints();
		
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.gridwidth=2;
		constraints.insets=new Insets(10, 10, 10, 10);
		JComboBox<String> listBike=new JComboBox<>(listBikeNames);
		add(listBike,constraints);
		
		JLabel lblCounBike=new JLabel("Count bike");	
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.gridwidth=1;
		add(lblCounBike,constraints);
		
		TextField countBike=new TextField("0");	
		constraints.gridx=1;
		constraints.gridy=1;
		constraints.gridwidth=1;
		add(countBike,constraints);
		
		constraints.gridx=0;
		constraints.gridy=2;
		constraints.gridwidth=2;
		JButton btnOrder=new JButton("Make an Order");
		add(btnOrder,constraints);			
		
		
		setVisible(true);
		setBounds(400, 300, 300, 200);
		
	}

	public static void main(String[] args) {
		new BikeForm();

	}

}
