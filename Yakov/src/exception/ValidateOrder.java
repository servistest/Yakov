package exception;

import javax.swing.JOptionPane;

public class ValidateOrder {
	
	private static final Integer maxAist=100;
	private static final Integer maxDamski=70;
	private static final Integer maxOrlenok=50;

	
	public void calculateOrder(String nameBike,Integer countBike) throws TooManyBikesException{
		
		if(nameBike!=null && countBike!=null){
			if (countBike>0){
				 switch (nameBike) {
				 	case "Aist": if(countBike<maxAist){
				 		JOptionPane.showMessageDialog(null,"Order to accept bike "+ nameBike + " count =" +countBike );
				 		}else {
				 			throw new TooManyBikesException("Order not accept bike "+ nameBike + ". Very many bikes =" +countBike );
				 			
				 		}
				 	break;
				 	case "Damski": if(countBike<maxDamski){
				 		JOptionPane.showMessageDialog(null,"Order to accept bike "+ nameBike + " count =" +countBike );
				 		}else {
				 			throw new TooManyBikesException("Order not accept bike "+ nameBike + ". Very many bikes =" +countBike );
				 		}
				 	break;
				 	case "Orlenok": if(countBike<maxOrlenok){
				 		JOptionPane.showMessageDialog(null,"Order to accept bike "+ nameBike + " count =" +countBike );
				 		}else {
				 			throw new TooManyBikesException("Order not accept bike "+ nameBike + ". Very many bikes =" +countBike );
				 		}
					
					break;

				 	default:JOptionPane.showMessageDialog(null,"Order not to accept" );
					break;
				} 
			 }
			 
			 
		 }
		 
	 }
				
}
	
			 



