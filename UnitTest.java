//***************************************************************************
//
//  UnitTest.java                
//  
//  Author:  Andrew Shepherd, 100153343
// 
//  Copyright (c) April 2019
//
//  Unit Test Cases - testing the ATMBank application  
//
//***************************************************************************

import junit.framework.TestCase;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.event.ActionEvent;

public class UnitTest extends TestCase {
   
   public Boolean pass;
   public Boolean fail;
   public ActionEvent calculate;
   
   protected void setUp() {
      pass = false;
      fail = true;
      calculate = new ActionEvent();
   }
  
   //------------------------------------------------------------------------
   //  Unit Test Case - Account Number
   //------------------------------------------------------------------------  
   public void testAccountNumber() {
      ATMBank bank = new ATMBank();
      int expected = 1001;
      int actual = bank.accountNumber;
      assertEquals("Account Number Test: ", expected, actual); 
   }

   //------------------------------------------------------------------------
   //  Unit Test Case - Account Totals
   //------------------------------------------------------------------------
   public void testAccountTotals() {
      ATMBank bank = new ATMBank();
      Double expected = null;
      Double actual = bank.accountTotals[0];
      assertEquals("Account Totals Test: ", expected, actual); 
   }
   
   //------------------------------------------------------------------------
   //  Unit Test Case - Account First Names
   //------------------------------------------------------------------------
   public void testAccountFNames() {
      ATMBank bank = new ATMBank();
      String expected = null;
      String actual = bank.accountFNames[0];
      assertEquals("Account First Names Test: ", expected, actual); 
   }
   
   //------------------------------------------------------------------------
   //  Unit Test Case - Account Last Names
   //------------------------------------------------------------------------
   public void testAccountLNames() {
      ATMBank bank = new ATMBank();
      String expected = null;
      String actual = bank.accountLNames[0];
      assertEquals("Account Last Names Test: ", expected, actual); 
   }  
 
   //------------------------------------------------------------------------
   //  Unit Test Case - CreateAccount method start()
   //------------------------------------------------------------------------   
   public void testCreateAccountStart() {
     if(pass) {
        CreateAccount createAccount = new CreateAccount();
        createAccount.start();
     } else { 
        assertTrue("CreateAccount method start() failed", fail);            
     }                         
   }
   
   //------------------------------------------------------------------------
   //  Unit Test Case - Withdrawal method start()
   //------------------------------------------------------------------------   
   public void testWithdrawalStart() {
     if(pass) {
        Withdrawal withdrawal = new Withdrawal();
        withdrawal.start();
     } else { 
        assertTrue("Withdrawal method start() failed", fail);            
     }                         
   }
   
   //------------------------------------------------------------------------
   //  Unit Test Case - Deposit method start()
   //------------------------------------------------------------------------   
   public void testDepositStart() {
     if(pass) {
        Deposit deposit = new Deposit();
        deposit.start();
     } else { 
        assertTrue("Deposit method start() failed", fail);            
     }                         
   }
 
   //------------------------------------------------------------------------
   //  Unit Test Case - AccountBalance method start()
   //------------------------------------------------------------------------   
   public void testAccountBalanceStart() {
     if(pass) {
        AccountBalance accountBalance = new AccountBalance();
        accountBalance.start();
     } else { 
        assertTrue("AccountBalance method start() failed", fail);            
     }                         
   }

   //------------------------------------------------------------------------
   //  Unit Test Case - Transfer method start()
   //------------------------------------------------------------------------   
   public void testTransferStart() {
     if(pass) {
        Transfer transfer = new Transfer();
        transfer.start();
     } else { 
        assertTrue("Transfer method start() failed", fail);            
     }                         
   }
   
   //------------------------------------------------------------------------
   //  Unit Test Case - Help method start()
   //------------------------------------------------------------------------   
   public void testHelpStart() {
     if(pass) {
        Help help = new Help();
        help.start();
     } else { 
        assertTrue("Help method start() failed", fail);            
     }                         
   }  
   
   //------------------------------------------------------------------------
   //  Unit Test Case - Withdrawal method addWithdrawal()
   //------------------------------------------------------------------------   
   public void testAddWithdrawal() {
     if(pass) {
        Withdrawal withdrawal = new Withdrawal();
        Double expected = null;
        Double actual = withdrawal.addWithdrawal(calculate);
        assertEquals("Withdrawal addWithdrawal Test: ", expected, actual);      
     } else { 
        assertTrue("Withdrawal method addWithdrawal() failed", fail);            
     }                         
   }  
   
   //------------------------------------------------------------------------
   //  Unit Test Case - Deposit method addDeposit()
   //------------------------------------------------------------------------   
   public void testAddDeposit() {
     if(pass) {
        Deposit deposit = new Deposit();
        Double expected = null;
        Double actual = deposit.addDeposit(calculate);
        assertEquals("Deposit addDeposit Test: ", expected, actual);      
     } else { 
        assertTrue("Deposit method addDeposit() failed", fail);            
     }                         
   }
   
   //------------------------------------------------------------------------
   //  Unit Test Case - Transfer method addTransfer()
   //------------------------------------------------------------------------   
   public void testAddTransfer() {
     if(pass) {
        Transfer transfer = new Transfer();
        Double expected = null;
        Double actual = transfer.addTransfer(calculate);
        assertEquals("Transfer addTransfer Test: ", expected, actual);      
     } else { 
        assertTrue("Transfer method addTransfer() failed", fail);            
     }                         
   }   
}
