package exception;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class BikeControl implements ActionListener{
	private BikeForm bikeForm;
	private Integer countBike;
	private ValidateOrder validateOrder;
	
	 BikeControl(BikeForm bikeForm){
		this.bikeForm=bikeForm;
	}
	 private void extractModel(){
		 
		 String nameBike=(String)bikeForm.getBike();
		 if (nameBike!=null && !nameBike.equals("") && bikeForm.getCountBike()!=null){
			 try {
				  countBike=Integer.parseInt(bikeForm.getCountBike()); 
			
			 } catch (NumberFormatException e){
				 System.out.println("Error input :" + e.getMessage());
			  }
			 			 
			 try {
				 validateOrder=new ValidateOrder();
				 validateOrder.calculateOrder(nameBike, countBike);
			 }catch (TooManyBikesException e) {
				JOptionPane.showMessageDialog(null,e.getMessage());
			}
		 }
	

	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Order")){
			extractModel();
		}else{
			System.out.println("Not Press Order");
		}
		
	}
	

}
