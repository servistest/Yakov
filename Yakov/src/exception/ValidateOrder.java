package exception;

import javax.swing.JOptionPane;

public class ValidateOrder {
	private BikeForm bikeForm;
	private static final Integer maxAist=100;
	private static final Integer maxDamski=70;
	private static final Integer maxOrlenok=50;
	private Integer countBike;
	
	public void calculateOrder() throws TooManyBikesException{
		 
		 String nameBike=(String)bikeForm.getBike();
		 if (nameBike!=null && !nameBike.equals("") && bikeForm.getCountBike()!=null){
		
			 try {
				  countBike=Integer.parseInt(bikeForm.getCountBike());
			
			 } catch (NumberFormatException e){
				 //System.out.println("Error input :" + e.getMessage());
				 throw new TooManyBikesException("Can not ship " + nameBike + " count =" +countBike );
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


}
