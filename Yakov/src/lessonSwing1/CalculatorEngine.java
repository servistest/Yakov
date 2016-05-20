package lessonSwing1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class CalculatorEngine implements ActionListener {
	
	Calculator calculator;
	
	public CalculatorEngine(Calculator calculator) {
		this.calculator=calculator;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
			
			JButton button= (JButton)e.getSource();
			//System.out.println(button.getText());
			String number=calculator.getResultText();
			System.out.println("нажали кнопку = " + calculator.getResultText());
			switch (button.getText()) {
			case "C": calculator.setResultText("");calculator.setNumber1("");calculator.setNumber2("");break;
			case "+": 		calculator.frame.setTitle("Operand + ");
							calculator.operand="+";
							if(calculator.getResult()!=""){
								if (calculator.getNumber1()==""){
									  calculator.setNumber1(number);
								}else calculator.setNumber2(number);
							  	calculator.setResultText("");
							}
													   
					break;
			case "-":	calculator.frame.setTitle("Operand - ");
						calculator.operand="-";
						if(calculator.getResult()!=""){
							if (calculator.getNumber1()==""){
								  calculator.setNumber1(number);
							}else calculator.setNumber2(number);
						  	calculator.setResultText("");
						}					   
	break; 
				
			case "=": 
				
				if(!calculator.getResultText().equals("")){
				
						if(calculator.getNumber1().equals(""))	{
							calculator.setNumber1(calculator.getResultText());
						}else{
							calculator.setNumber2(calculator.getResultText());
						}
						
						if (calculator.getNumber1()!="" && calculator.getNumber2()!="" && calculator.operand!=""){
							Double result;
							System.out.println("Первое число=" +calculator.getNumber1());
							System.out.println("Второе число=" +calculator.getNumber2());
							System.out.println("Операнд ="+ calculator.operand);
								if (calculator.operand=="+"){
									 result = Double.parseDouble(calculator.getNumber1())+Double.parseDouble(calculator.getNumber2());
									
								}else 
								{  result = Double.parseDouble(calculator.getNumber1())-Double.parseDouble(calculator.getNumber2());}
									
							calculator.setResultText(result.toString());
							calculator.operand="";
							calculator.setNumber1("");
							calculator.setNumber2("");
								
					} 
									
						break;
						
					 }else {
						 System.out.println("Первое число =" + calculator.getNumber1());
						 System.out.println("Второе число =" + calculator.getNumber2());
						 System.out.println("Операнд=" +calculator.operand);
						 JOptionPane.showMessageDialog(null, "Не введено первое или второе число или же операция!!!");
				} 
					break;

			default:calculator.setResultText(calculator.getResultText()+button.getText());
				break;
			}  

			
	}
	
	public void operation() {
		
	}

}
