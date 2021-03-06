//***************************************************************************
//
//  AccountBalance.java                
//  
//  Author:  Andrew Shepherd, 100153343
// 
//  Copyright (c) April 2019
//
//  GUI class to display account balance from main application ATMBank.java  
//
//***************************************************************************

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class AccountBalance
{
   private Text menuTitle;
   private Text accountBalance;
   private Text customerName;
   private Spinner<Integer> accountSpinner;
   private int accountNum;
   public Stage secondaryStage = new Stage();
   
   //------------------------------------------------------------------------
   //  Presents a GUI displaying Account Balance
   //------------------------------------------------------------------------
   public void start()
   {  
      Font font2 = new Font("Courier", 24);
      
      menuTitle = new Text("AccountBalance");
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
      
      Button closeGUI = new Button("Return to Menu");
      closeGUI.setOnAction(this::goToMainMenu);
      closeGUI.setFont(font2);
      
      VBox pane = new VBox(menuTitle, sep, accountChoice, accountSpinner, displayAccount, customerName,
         accountBalance, sep2, closeGUI);
      pane.setAlignment(Pos.CENTER);
      pane.setSpacing(30);
      pane.setStyle("-fx-background-color: wheat");
      
      Scene scene = new Scene(pane, 700, 600);

      secondaryStage.setTitle("ATM Bank - Account Balance");
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
   }
   
   //------------------------------------------------------------------------
   //  Closes Account Balance GUI and returns to Main Menu GUI 
   //------------------------------------------------------------------------
   public void goToMainMenu (ActionEvent event)
   {
     secondaryStage.close();
   }
}