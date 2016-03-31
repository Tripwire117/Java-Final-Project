import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.text.*;
import java.awt.event.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;



public class CP extends JFrame implements ActionListener
{
	private JFrame frame;
	private JTextField txtHourInput;
	private JLabel Date_Display;
	private JLabel LHourlyPayrate;
	private JTextField txtPayrate;
	private JLabel LWadge;
	private JTextField ExpenseNameInput;
	private JTextField ExpenseCost;
	private JTextField ExpenseDate;
   private JLabel LCityTaxInput;
   private JTextField txtCityTaxInput;
   private JLabel LStateTaxInput;
   private JTextField txtStateTaxInput;
   private JLabel LFederalTaxInput;
   private JButton btnCalc;
   private JButton btnExit;
   private JTextField txtFederalTaxInput;
   private JLabel totalPayBT;
   
	/**
	 * Launch the application.
	 */
    
	public static void main(String[] args)
   {
		CP window = new CP();
		window.frame.setVisible(true);
	}

	public CP()
   {  
		initialize();
	}

/*******************************
 Click Listeners
 These will detect if any
 of the "Tax" Buttons have been
 activated, giving the desired
 output.
********************************/

   class ccTaxL implements ActionListener 
   {
      public void actionPerformed(ActionEvent e)
      {
      Costs tinput = new Costs();
      Scanner input = new Scanner(System.in);
   
      System.out.println("What's the new tax ammount?");
      //JOptionPane.showInputDialog("What's the new tax ammount?");
      int inputstorage = input.nextInt();
      tinput.setCTax(inputstorage);
      }
   }  

 /***********************************************************
 Working on figuring out the invoke and wait command
 Right now it freezes after you enter a new city tax ammount.
 Doing research it has something to do with threads in java
 Till then im commenting this out
 ************************************************************
   
final Runnable RunCcTax = new Runnable(){
   public void run()
    {
      JOptionPane.showInputDialog("Whats the new tax ammount?");
      int inputstorage = input.nextInt();
      tinput.setCTax(inputstorage);
    }
   };
   
Thread testThread = new Thread()
{
public void run()
 {
   try 
    {
       SwingUtilities.invokeAndWait(RunCcTax);
    }
       catch (Exception e) {e.printStackTrace();
    }
       System.out.println("Finished on " + Thread.currentThread());
  }
};   */

    
/* ********* End Of Listeners ***********/
	
	private void initialize() 
   {
      Costs costs1 = new Costs();
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Hour Input text field
		JTextField txtHourInput = new JTextField(10);
		txtHourInput.setBounds(175, 110, 71, 26);
      txtHourInput.addActionListener(this);
		frame.getContentPane().add(txtHourInput);
		
		//Hours worked label
		JLabel LHourInput = new JLabel("Hours Worked:");
		LHourInput.setBounds(50, 110, 107, 20);
		frame.getContentPane().add(LHourInput);
		
      //Date completed, linked to "Costs.Java"
		Date_Display = new JLabel(costs1.cDate());
		Date_Display.setBounds(435, 16, 78, 20);
		frame.getContentPane().add(Date_Display);
		
		LHourlyPayrate = new JLabel("Hourly Payrate:");
		LHourlyPayrate.setBounds(50, 145, 119, 20);
		frame.getContentPane().add(LHourlyPayrate);
		
		//txtPayrate text field
      JTextField txtPayrate = new JTextField(10);
		txtPayrate.setBounds(175, 145, 71, 26);
      txtPayrate.addActionListener(this);
		frame.getContentPane().add(txtPayrate);
      //String txtPayRate = txtPayRate.getText();
		
		LWadge = new JLabel("Salary:");
		LWadge.setBounds(108, 75, 49, 20);
		frame.getContentPane().add(LWadge);
		
		JCheckBox chckbxSalary = new JCheckBox("");
		chckbxSalary.setBounds(175, 75, 29, 29);
		frame.getContentPane().add(chckbxSalary);
		
      //Title, Please ignore
		JLabel TitleTaxes = new JLabel("Taxes:");
		TitleTaxes.setBounds(350, 39, 89, 20);
		frame.getContentPane().add(TitleTaxes);
		
      //City Tax Label
      LCityTaxInput = new JLabel("City Tax %");
		LCityTaxInput.setBounds(289, 75, 101, 26);
		frame.getContentPane().add(LCityTaxInput);
      
      //City Tax Input
      String cTaxRate = String.format ("%.2f", costs1.cTax());
		txtCityTaxInput = new JTextField(cTaxRate);
		txtCityTaxInput.setBounds(405, 75, 69, 20);
		frame.getContentPane().add(txtCityTaxInput);
		txtCityTaxInput.setColumns(10);
      
      //State Tax Label
      LStateTaxInput = new JLabel("State Tax %");
		LStateTaxInput.setBounds(289, 110, 101, 26);
		frame.getContentPane().add(LStateTaxInput);
      
      //State Tax Input
      String sTaxRate = String.format ("%.2f", costs1.sTax());
		txtStateTaxInput = new JTextField(sTaxRate);
		txtStateTaxInput.setBounds(405, 110, 69, 20);
		frame.getContentPane().add(txtStateTaxInput);
		txtStateTaxInput.setColumns(10);
      
      //Federal Tax Label
      LFederalTaxInput = new JLabel("Federal Tax %");
		LFederalTaxInput.setBounds(289, 145, 101, 26);
		frame.getContentPane().add(LFederalTaxInput);
      
      //State Tax Input
      String fTaxRate = String.format ("%.2f", costs1.fTax());
		txtFederalTaxInput = new JTextField(fTaxRate);
		txtFederalTaxInput.setBounds(405, 146, 69, 20);
		frame.getContentPane().add(txtFederalTaxInput);
		txtFederalTaxInput.setColumns(10);

      //Calculate button
      /*JButton btnCalc = new JButton("Calculate");
      btnCalc.setBounds(50, 500, 106, 26);
      btnCalc.addActionListener(this);
      add(btnCalc);
      frame.getContentPane().add(btnCalc);*/
      
      //Exit button
      JButton btnExit = new JButton("Exit");
      btnExit.setBounds(200, 500, 106, 26);
      btnExit.addActionListener(this);
      add(btnExit);
      frame.getContentPane().add(btnExit);
		
		JLabel LExpenses = new JLabel("Expenses [Unsure on bottom half]");
		LExpenses.setBounds(123, 215, 298, 20);
		frame.getContentPane().add(LExpenses);
      
      JLabel totalPayBT = new JLabel();
      totalPayBT.setBounds(123, 415, 298, 20);
      frame.getContentPane().add(totalPayBT);
		
		/*JTextPane textPane = new JTextPane();
		textPane.setBounds(50, 298, 424, 179);
		frame.getContentPane().add(textPane);
		
      
      Replacing with a dropdown menu
		ExpenseNameInput = new JTextField();
		ExpenseNameInput.setBounds(58, 256, 146, 26);
		frame.getContentPane().add(ExpenseNameInput);
		ExpenseNameInput.setColumns(10);
		
		ExpenseCost = new JTextField();
		ExpenseCost.setColumns(10);
		ExpenseCost.setBounds(205, 256, 146, 26);
		frame.getContentPane().add(ExpenseCost);
		
		ExpenseDate = new JTextField();
		ExpenseDate.setColumns(10);
		ExpenseDate.setBounds(350, 256, 146, 26);
		frame.getContentPane().add(ExpenseDate);*/
	}
   public void actionPerformed(ActionEvent a)
   {
      System.exit(0);
   }
   
   /*public void calculate(ActionEvent b)
   {
      double totalPay;
      
      //String txtPayrate = txtPayrate.getText();
      double payRate = Double.parseDouble(txtPayrate);
      String txtHourInput = txtHourInput.getText();
      double hourInput = Double.parseDouble(txtHourInput);
      
      totalPay = payRate * hourInput;
      
   }*/
}