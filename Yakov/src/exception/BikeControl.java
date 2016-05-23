package exception;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JOptionPane;

public class BikeControl implements ActionListener{
	private BikeForm bikeForm;
	private static final Integer maxAist=100;
	private static final Integer maxDamski=70;
	private static final Integer maxOrlenok=50;
	private Integer countBike;
	
	 BikeControl(BikeForm bikeForm){
		this.bikeForm=bikeForm;
	}
	 private void calculateOrder(){
		 
		 String nameBike=(String)bikeForm.getBike();
		 if (nameBike!=null && !nameBike.equals("") && bikeForm.getCountBike()!=null){
		
			 try {
				  countBike=Integer.parseInt(bikeForm.getCountBike());
			
			 } catch (NumberFormatException e){
				 System.out.println("Error input :" + e.getMessage());
			 }
			 
	
			 if (countBike>0){
				 switch (nameBike) {
				 	case "Aist": if(countBike<maxAist){
				 		JOptionPane.showMessageDialog(null,"Order to accept bike "+ nameBike + " count =" +countBike );
				 		}else {
				 			JOptionPane.showMessageDialog(null,"Order not  to accept" );
				 		}
				 	break;
				 	case "Damski": if(countBike<maxDamski){
				 		JOptionPane.showMessageDialog(null,"Order to accept bike "+ nameBike + " count =" +countBike );
				 		}else {
				 			JOptionPane.showMessageDialog(null,"Order not to accept" );
				 		}
				 	break;
				 	case "Orlenok": if(countBike<maxOrlenok){
				 		JOptionPane.showMessageDialog(null,"Order to accept bike "+ nameBike + " count =" +countBike );
				 		}else {
				 			JOptionPane.showMessageDialog(null,"Order not  to accept" );
				 		}
					
					break;

				 	default:JOptionPane.showMessageDialog(null,"Order not to accept" );
					break;
				} 
			 }
			 
			 
		 }
		 
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Order")){
			calculateOrder();
			//JOptionPane.showMessageDialog(null, "Press Order", "Order", JOptionPane.INFORMATION_MESSAGE);
		}else{
			System.out.println("Not Press Order");
		}
		
	}
	

}
