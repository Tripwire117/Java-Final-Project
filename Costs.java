/**************************************************************

Authors:Daniel Kramer & Lori Gregg

Purpose:This file is a class that manages and soon will store
user data input, primarily bills, and services.

This file includes:
                     Total
                     Cost
                     Description
                     Taxes
                     Date

**************************************************************/

//Imports for the calander date
import java.util.Calendar;
import java.util.Scanner;
import java.text.*;
import javax.swing.*;

public class Costs  //Name that gets called (Class Name)
{
   private String Description;   // Description of the cost. (Is it a bill, service, fee?)
   private int cost;             // How much did this service cost?
   private int total;            // What is the total of all the services currently?
   private double cTax = 1.36;
   private double sTax = .02;
   private double fTax = .03;
   
   //Name Set and get
   public void setDesc(String d)
   {
      Description = d;
   }
   
   // Description of the Service
   public String getDesc()
   {
      return Description;
   }
      
   //Set the current cost (Possibly be used to store data at a later date. Not currently used)
   public void setCost(int c)
   {
      cost = c;
   }
   
   // Return the cost of the item
   public int getCost()
   {
      return cost;
   }
      
   
   //Set a total to a starting ammount or reset
   public void setTotal(int t)
   {
      total = t;
   }
      
   // aTotal is add To Total, This will store cost on top of total.
   
   public int aTotal()
   {
      return total += cost;
   }
      
   // This will output the current Total value Stored.
      
   public int getTotal()
   {
      return total;
   }
      
    
/***********************
         Taxes
***********************/
      
      
   //City Tax
   public void setCTax(double ct)
      {
         cTax = ct;
      }
      
      
      
   public double ucTax()
   {
      Scanner input = new Scanner(System.in);
   
      JOptionPane.showInputDialog("What's the new tax ammount?");
      cTax = input.nextInt();
   
   //input = NumberFormat.getPercentInstance().format(cTax);
   
   //double cTax = input.nextInt();
     
     return cTax;
      }
      
   public Double cTax()
      {
         return cTax;
      }
      
   //State Tax
   public void setSTax(double st)
      {
         sTax = st;
      }
      
   public double sTax()
      {
         return sTax;
      }
      
   //Federal Tax
   public void setFTax(double ft)
      {
         fTax = ft;
      }
      
   public double fTax()
      {
         return fTax;
      }
/***********************
         Date
***********************/
   public String cDate()
   {
       //Date Format
       DateFormat df = new SimpleDateFormat("MM/dd/yy");
       //Inputing current time into format
       Calendar c = Calendar.getInstance();
       return df.format(c.getTime());
    }
    
    
    
    
    

}
   
   
   
   

