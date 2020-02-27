//***************************************************************************
//
//  Deposit.java                
//  
//  Author:  Andrew Shepherd, 100153343
// 
//  Copyright (c) April 2019
//
//  GUI class to permit deposits from main application ATMBank.java  
//
//***************************************************************************

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import java.lang.Math;

public class Deposit
{
   private Text menuTitle;
   private Text accountBalance;
   private Text customerName;
   private Label deposit;
   private String depositString;
   private Double depositDouble;
   private TextField enterDeposit;
   private Spinner<Integer> accountSpinner;
   private int accountNum;
   public Boolean accountSelected = false;
   public Stage secondaryStage = new Stage();
 
   //------------------------------------------------------------------------
   //  Presents a GUI containing the fields for Deposit transaction
   //------------------------------------------------------------------------
   public void start()
   {  
      Font font2 = new Font("Courier", 20);
      
      menuTitle = new Text("Deposit");
      menuTitle.setFont(Font.font("Courier", FontWeight.BOLD, 36));
      menuTitle.setFill(Color.NAVY);
      
      Separator sep = new Separator();
      
      Label accountChoice = new Label("Select Your Account Number:");
      accountChoice.setFont(font2);
      
      IntegerSpinnerValueFactory spinner = new IntegerSpinnerValueFactory(1000, 1099);
      accountSpinner = new Spinner<Integer>(spinner);
      
      Button displayAccount = new Button("Display Account");
      displayAccount.setOnAction(this::showAccount);
      displayAccount.setFont(font2);
      
      customerName = new Text("Account Holder: ");
      customerName.setFont(font2);
      
      accountBalance = new Text("Your balance is: ");
      accountBalance.setFont(font2);
      
      Separator sep2 = new Separator();
      
      deposit = new Label("Enter Deposit Amount: ");
      deposit.setFont(font2);
      
      enterDeposit = new TextField();
      enterDeposit.setMaxWidth(400);
      
      Button calculateDeposit = new Button("Complete Deposit");
      calculateDeposit.setOnAction(this::addDeposit);
      calculateDeposit.setFont(font2);
      
      Separator sep3 = new Separator();
      
      Button closeGUI = new Button("Return to Menu");
      closeGUI.setOnAction(this::goToMainMenu);
      closeGUI.setFont(font2);
      
      VBox pane = new VBox(menuTitle, sep, accountChoice, accountSpinner, displayAccount, customerName, accountBalance,
         sep2, deposit, enterDeposit, calculateDeposit, sep3, closeGUI);
      pane.setAlignment(Pos.CENTER);
      pane.setSpacing(20);
      pane.setStyle("-fx-background-color: wheat");
      
      Scene scene = new Scene(pane, 700, 650);

      secondaryStage.setTitle("ATM Bank - Deposit");
      secondaryStage.setScene(scene);
      secondaryStage.show();
   }

   //------------------------------------------------------------------------
   //  Shows the name and account balance of chosen account number 
   //------------------------------------------------------------------------   
   public void showAccount (ActionEvent event)
   {  
      accountNum = accountSpinner.getValue();
      customerName.setText("Account Holder: " + ATMBank.accountFNames[accountNum - 1000] + " " +
         ATMBank.accountLNames[accountNum - 1000]);
      accountBalance.setText("Your balance is: $" + ATMBank.accountTotals[accountNum - 1000]);
      accountSelected = true;
      deposit.setText("Enter Deposit Amount: ");
   }
   
   //------------------------------------------------------------------------
   //  Calculates new balance after deposit
   //------------------------------------------------------------------------   
   public double addDeposit (ActionEvent event)
   {
      if(accountSelected == true && ATMBank.accountTotals[accountNum - 1000] != null) { 
         depositString = enterDeposit.getText();
         enterDeposit.clear();         
         try {
            depositDouble = Double.parseDouble(depositString);
            ATMBank.accountTotals[accountNum - 1000] = ATMBank.accountTotals[accountNum - 1000] + depositDouble;
            ATMBank.accountTotals[accountNum - 1000] = Math.floor(ATMBank.accountTotals[accountNum - 1000] * 100) / 100;
            accountBalance.setText("Your new balance is: $" + ATMBank.accountTotals[accountNum - 1000]);
            deposit.setText("Enter Deposit Amount: ");
         } catch(NumberFormatException e) {
            deposit.setText("Invalid - use only numbers/decimal. Enter amount: ");
         }
      } else {
         deposit.setText("Select Valid Account Before Deposit");
      }
      return depositDouble;
   }
   
   //------------------------------------------------------------------------
   //  Closes Deposit GUI and returns to Main Menu GUI 
   //------------------------------------------------------------------------
   public void goToMainMenu (ActionEvent event)
   {
      secondaryStage.close();
   }
}