package lessonSwing1;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;

public class Calculator  {
private	JTextField resultField;
private	JButton button0;
private JButton button1;
private JButton button2;
private JButton button3;
private JButton button4;
private JButton button5;
private JButton button6;
private JButton button7;
private JButton button8;
private JButton button9;
private JButton sum;
private JButton minus;
private JButton equally;
private JButton multiply;
private JButton clear;
private JButton dot;
private CalculatorEngine engine;
private String result;
private String number1;
private String number2;
private Boolean isNumber1;
public JFrame frame;
public String operand;
	
	

	public Boolean getIsNumber1() {
		return isNumber1;
	}
	public void setIsNumber1(Boolean isNumber1) {
		this.isNumber1 = isNumber1;
	}
	public String getResult() {
	return result;
	}
	public void setResult(String result) {
	this.result = result;
	}
	public void setNumber1(String number1) {
		this.number1 = number1;
	}
	public String getNumber1() {
		return number1;
	}
	public String getNumber2() {
		return number2;
	}
	public void setNumber2(String number2) {
		this.number2 = number2;
	}
	
	public Calculator(){
		//instance components
		button0=new JButton("0");
		button1=new JButton("1");
		button2=new JButton("2");
		button3=new JButton("3");
		button4=new JButton("4");
		button5=new JButton("5");
		button6=new JButton("6");
		button7=new JButton("7");
		button8=new JButton("8");
		button9=new JButton("9");
		clear=new JButton("C");
		sum=new JButton("+");
		minus=new JButton("-");
		dot=new JButton(".");
		equally=new JButton("=");
		resultField=new JTextField(16);
		
		
		// create frame and properties
		//JFrame frame =new JFrame();
		frame =new JFrame();
		frame.setTitle("Calculator");
		
		// create LayoutManager  
		GridBagLayout gb =new GridBagLayout();
		GridBagConstraints constrains=new GridBagConstraints();
		
		//set Layout for Panel
		frame.setLayout(gb);
				
		engine=new CalculatorEngine(this);
		
		constrains.gridheight=1;
		constrains.gridwidth=4;
		constrains.insets = new Insets(1,3,5,1);
		constrains.gridx=0;
		constrains.gridy=0;
		frame.add(resultField, constrains);
		
		constrains.gridheight=1;
		constrains.gridwidth=1;
		
		addComponentToPanel(frame,button1,constrains,0,1);
		addComponentToPanel(frame,button2,constrains,1,1);
		addComponentToPanel(frame,button3,constrains,2,1);
		addComponentToPanel(frame,clear,constrains,3,1);
		addComponentToPanel(frame,button4,constrains,0,2);
		addComponentToPanel(frame,button5,constrains,1,2);
		addComponentToPanel(frame,button6,constrains,2,2);
		addComponentToPanel(frame,sum,constrains,3,2);
		addComponentToPanel(frame,button7,constrains,0,3);
		addComponentToPanel(frame,button8,constrains,1,3);
		addComponentToPanel(frame,button9,constrains,2,3);
		addComponentToPanel(frame,minus,constrains,3,3);
		addComponentToPanel(frame,button0,constrains,0,4);
		addComponentToPanel(frame,dot,constrains,1,4);
		addComponentToPanel(frame,equally,constrains,3,4);
	
		setIsNumber1(true);	
		setNumber1("");
		setNumber2("");
		operand="";
		
		frame.setResizable(false);
		frame.setBounds(300,200,250,230);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	void addComponentToPanel(JFrame calculator,JButton button,GridBagConstraints constrains, int column,int row){
		constrains.gridx=column;
		constrains.gridy=row;
		button.addActionListener(engine);
		calculator.add(button, constrains);
		
	}
	public String getResultText(){
	
		return resultField.getText();
	}
	public void setResultText(String text){
		resultField.setText(text);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new Calculator();
		 //test error54
		 //patch 54
	}
	

}
