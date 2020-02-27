//***************************************************************************
//
//  ATMBank.java                
//  
//  Author:  Andrew Shepherd, 100153343
// 
//  COMP 2663 - Project - Winter 2019
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
import javafx.stage.Stage;

public class ATMBank extends Application
{
   private Text menuTitle;
   public Double balance = 0.00;
   public static Double currentBalance = 5.67;
   
   //------------------------------------------------------------------------
   //  Presents a GUI containing a menu with basic bank transactions
   //------------------------------------------------------------------------
   public void start(Stage primaryStage)
   {
      Font font2 = new Font("Courier", 24);
      
      menuTitle = new Text("ATM Bank - Main Menu");
      menuTitle.setFont(Font.font("Courier", FontWeight.BOLD, 36));
      menuTitle.setFill(Color.NAVY);
      
      Separator sep = new Separator();
      
      Button createAccount = new Button("Create Account");
      createAccount.setOnAction(this::goToCreateAccount);
      createAccount.setFont(font2);
      
      Button withdrawl = new Button("Withdrawl");
      withdrawl.setOnAction(this::goToWithdrawl);
      withdrawl.setFont(font2);
      
      Button deposit = new Button("Deposit");
      deposit.setOnAction(this::goToDeposit);
      deposit.setFont(font2);
      
      Button accountBalance = new Button("Account Balance");
      accountBalance.setOnAction(this::goToAccountBalance);
      accountBalance.setFont(font2);
      
      Button accountHistory = new Button("Account History");
      accountHistory.setOnAction(this::goToAccountHistory);
      accountHistory.setFont(font2);
      
      VBox pane = new VBox(menuTitle, sep, createAccount, withdrawl, deposit, accountBalance, accountHistory);
      pane.setAlignment(Pos.CENTER);
      pane.setSpacing(40);
      pane.setStyle("-fx-background-color: lightsteelblue");
      
      Scene scene = new Scene(pane, 800, 700);
      
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
   //  Launches the Withdrawl GUI Class
   //------------------------------------------------------------------------
   public void goToWithdrawl (ActionEvent event)
   {
      Withdrawl withdrawlGUI = new Withdrawl();
      withdrawlGUI.start();   
   }
   
   //------------------------------------------------------------------------
   //  Launches the Deposit GUI Class
   //------------------------------------------------------------------------
   public void goToDeposit (ActionEvent event)
   {
      Deposit depositGUI = new Deposit();
      depositGUI.start(balance);
   }
   
   //------------------------------------------------------------------------
   //  Launches the Account Balance GUI Class
   //------------------------------------------------------------------------
   public void goToAccountBalance (ActionEvent event)
   {
      AccountBalance accountBalanceGUI = new AccountBalance();
      accountBalanceGUI.start(currentBalance);   
   }
   
   //------------------------------------------------------------------------
   //  Launches the Account History GUI Class
   //------------------------------------------------------------------------
   public void goToAccountHistory (ActionEvent event)
   {
      AccountHistory accountHistoryGUI = new AccountHistory();
      accountHistoryGUI.start();   
   }
   
   //-----------------------------------------------------------------
   //  Launches the Main Application GUI
   //-----------------------------------------------------------------
   public static void main(String[] args)
   {
      launch(args);  
   }
}
