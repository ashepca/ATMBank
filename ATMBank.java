//***************************************************************************
//
//  ATMBank.java                
//  
//  Author:  Andrew Shepherd, 100153343
// 
//  Copyright (c) April 2019
//
//  GUI application to set up bank customers and allow transactions.  
//
//***************************************************************************

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class ATMBank extends Application
{
   private Text menuTitle;
   public static String[] accountFNames = new String[100];
   public static String[] accountLNames = new String[100];
   public static Double[] accountTotals = new Double[100];
   public static int accountNumber = 1001;
   
   //------------------------------------------------------------------------
   //  Presents a GUI containing a menu with basic bank transactions
   //------------------------------------------------------------------------
   public void start(Stage primaryStage)
   {
      //---------------------------------------------------------------------
      //  Setting up Bank Owner as first account holder
      //---------------------------------------------------------------------
      accountFNames[0] = "Bank";
      accountLNames[0] = "Owner";
      accountTotals[0] = 1234567.89;
     
      Font font2 = new Font("Courier", 24);
      
      menuTitle = new Text("ATM Bank - Main Menu");
      menuTitle.setFont(Font.font("Courier", FontWeight.BOLD, 36));
      menuTitle.setFill(Color.NAVY);
      
      Separator sep = new Separator();
      
      Button createAccount = new Button("Create Account");
      createAccount.setOnAction(this::goToCreateAccount);
      createAccount.setFont(font2);
      
      Button withdrawal = new Button("Withdrawal");
      withdrawal.setOnAction(this::goToWithdrawal);
      withdrawal.setFont(font2);
      
      Button deposit = new Button("Deposit");
      deposit.setOnAction(this::goToDeposit);
      deposit.setFont(font2);
      
      Button accountBalance = new Button("Account Balance");
      accountBalance.setOnAction(this::goToAccountBalance);
      accountBalance.setFont(font2);
      
      Button transfer = new Button("Transfer");
      transfer.setOnAction(this::goToTransfer);
      transfer.setFont(font2);
      
      Separator sep2 = new Separator();
      
      Button help = new Button("Help");
      help.setOnAction(this::goToHelp);
      help.setFont(font2);
      
      VBox pane = new VBox(menuTitle, sep, createAccount, withdrawal, deposit, accountBalance, transfer, sep2, help);
      pane.setAlignment(Pos.CENTER);
      pane.setSpacing(25);
      pane.setStyle("-fx-background-color: lightsteelblue");
      
      Scene scene = new Scene(pane, 800, 650);
      
      primaryStage.setTitle("ATM Bank - Main Menu");
      primaryStage.setScene(scene);
      primaryStage.show();
   }
   
   //------------------------------------------------------------------------
   //  Launches the Create Account GUI Class 
   //------------------------------------------------------------------------
   public void goToCreateAccount(ActionEvent event)
   {
      CreateAccount createAccountGUI = new CreateAccount();
      createAccountGUI.start();
   }
   
   //------------------------------------------------------------------------
   //  Launches the Withdrawal GUI Class
   //------------------------------------------------------------------------
   public void goToWithdrawal (ActionEvent event)
   {
      Withdrawal withdrawalGUI = new Withdrawal();
      withdrawalGUI.start();   
   }
   
   //------------------------------------------------------------------------
   //  Launches the Deposit GUI Class
   //------------------------------------------------------------------------
   public void goToDeposit (ActionEvent event)
   {
      Deposit depositGUI = new Deposit();
      depositGUI.start();
   }
   
   //------------------------------------------------------------------------
   //  Launches the Account Balance GUI Class
   //------------------------------------------------------------------------
   public void goToAccountBalance (ActionEvent event)
   {
      AccountBalance accountBalanceGUI = new AccountBalance();
      accountBalanceGUI.start();   
   }
   
   //------------------------------------------------------------------------
   //  Launches the Transfer GUI Class
   //------------------------------------------------------------------------
   public void goToTransfer (ActionEvent event)
   {
      Transfer transferGUI = new Transfer();
      transferGUI.start();   
   }
   
   //------------------------------------------------------------------------
   //  Launches the Help GUI Class
   //------------------------------------------------------------------------
   public void goToHelp (ActionEvent event)
   {
      Help helpGUI = new Help();
      helpGUI.start();   
   }
   
   //-----------------------------------------------------------------
   //  Launches the Main Application GUI
   //-----------------------------------------------------------------
   public static void main(String[] args)
   {
      launch(args);  
   }
}
