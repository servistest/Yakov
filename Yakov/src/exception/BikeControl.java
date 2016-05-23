package exception;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class BikeControl implements ActionListener{
	private BikeForm bikeForm;
	private Integer countBike;
	private ValidateOrder validateOrder;
	private static Logger logger=Logger.getLogger("com.wombat.nose") ;
	private static FileHandler fileLog; 
	
	 BikeControl(BikeForm bikeForm){
		this.bikeForm=bikeForm;
	}
	 private void extractModel(){
		 try {
			 fileLog= new FileHandler("mylog.xml");
		 }catch(IOException e){
			 JOptionPane.showMessageDialog(null,"Error openfile mylog.txt " +e.getMessage());
		 }
		 logger.addHandler(fileLog);
		 logger.fine("Start log");
		 
		 String nameBike=(String)bikeForm.getBike();
		 if (nameBike!=null && !nameBike.equals("") && bikeForm.getCountBike()!=null){
			 try {
				  countBike=Integer.parseInt(bikeForm.getCountBike()); 
			
			 } catch (NumberFormatException e){
				 logger.log(Level.ALL, "Error input: ", e);
				 System.out.println("Error number format  :" + e.getMessage());
			  }
			 			 
			 try {
				 validateOrder=new ValidateOrder();
				 validateOrder.calculateOrder(nameBike, countBike);
			 }catch (TooManyBikesException e) {
				logger.log(Level.SEVERE, "Very many count Bikes : ", e);
				//JOptionPane.showMessageDialog(null,e.getMessage());
			}
		 }
		 logger.fine("done");
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
