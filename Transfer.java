//***************************************************************************
//
//  Transfer.java                
//  
//  Author:  Andrew Shepherd, 100153343
// 
//  Copyright (c) April 2019
//
//  GUI class to permit transfer from main application ATMBank.java  
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

public class Transfer
{
   private Text menuTitle;
   private Text customerName1;
   private Text customerName2;
   private Label transfer;
   private String transferString; 
   private Double transferDouble;
   private TextField enterTransfer;
   private Spinner<Integer> accountSpinner1;
   private Spinner<Integer> accountSpinner2;
   private int accountNum1;
   private int accountNum2;  
   private Boolean accountSelected = false;
   public Stage secondaryStage = new Stage();
   
   //------------------------------------------------------------------------
   //  Presents a GUI containing the fields for transfer transactions.
   //------------------------------------------------------------------------
   public void start()
   {  
      Font font2 = new Font("Courier", 20);
      
      menuTitle = new Text("Transfer");
      menuTitle.setFont(Font.font("Courier", FontWeight.BOLD, 36));
      menuTitle.setFill(Color.NAVY);
      
      Separator sep = new Separator();
         
      Label account1Choice = new Label("Select Account to Transfer FROM:");
      account1Choice.setFont(font2);
      
      IntegerSpinnerValueFactory spinner1 = new IntegerSpinnerValueFactory(1000, 1099);
      accountSpinner1 = new Spinner<Integer>(spinner1);
      
      Label account2Choice = new Label("Select Account to Transfer TO:");
      account2Choice.setFont(font2);
      
      IntegerSpinnerValueFactory spinner2 = new IntegerSpinnerValueFactory(1000, 1099);
      accountSpinner2 = new Spinner<Integer>(spinner2);
      
      customerName1 = new Text("FROM - Account Holder: ");
      customerName1.setFont(font2);
       
      customerName2 = new Text("TO - Account Holder: ");
      customerName2.setFont(font2);
      
      Button displayAccounts = new Button("Display Accounts");
      displayAccounts.setOnAction(this::showAccount);
      displayAccounts.setFont(font2);      
      
      Separator sep2 = new Separator();
      
      transfer = new Label("Enter Transfer Amount: ");
      transfer.setFont(font2);
      
      enterTransfer = new TextField();
      enterTransfer.setMaxWidth(400);
      
      Button calculateTransfer = new Button("Complete Transfer");
      calculateTransfer.setOnAction(this::addTransfer);
      calculateTransfer.setFont(font2);
      
      Separator sep3 = new Separator();
      
      Button closeGUI = new Button("Return to Menu");
      closeGUI.setOnAction(this::goToMainMenu);
      closeGUI.setFont(font2);
      
      VBox pane = new VBox(menuTitle, sep, account1Choice, accountSpinner1, account2Choice, accountSpinner2,
         displayAccounts, customerName1, customerName2, sep2, transfer, enterTransfer, calculateTransfer, sep3,
         closeGUI);
      pane.setAlignment(Pos.CENTER);
      pane.setSpacing(12);
      pane.setStyle("-fx-background-color: wheat");
      
      Scene scene = new Scene(pane, 700, 650);

      secondaryStage.setTitle("ATM Bank - Transfer");
      secondaryStage.setScene(scene);
      secondaryStage.show();
   }

   //------------------------------------------------------------------------
   //  Shows the names and account balances of chosen account numbers 
   //------------------------------------------------------------------------   
   public void showAccount (ActionEvent event)
   {  
      accountNum1 = accountSpinner1.getValue();
      customerName1.setText("FROM: " + ATMBank.accountFNames[accountNum1 - 1000] + " " +
         ATMBank.accountLNames[accountNum1 - 1000] + "   BALANCE: " + ATMBank.accountTotals[accountNum1 - 1000]);
      
      accountNum2 = accountSpinner2.getValue();
      customerName2.setText("FROM: " + ATMBank.accountFNames[accountNum2 - 1000] + " " +
         ATMBank.accountLNames[accountNum2 - 1000] + "   BALANCE: " + ATMBank.accountTotals[accountNum2 - 1000]);     
      
      accountSelected = true; 
      transfer.setText("Enter Transfer Amount: ");
   }
     
   //------------------------------------------------------------------------
   //  Calculates new balances after transfer
   //------------------------------------------------------------------------   
   public double addTransfer (ActionEvent event)
   {
      if(accountSelected == true && ATMBank.accountTotals[accountNum1 - 1000] != null &&
         ATMBank.accountTotals[accountNum2 - 1000] != null) {
         transferString = enterTransfer.getText();
         enterTransfer.clear();         
         try {
            transferDouble = Double.parseDouble(transferString);
            if(transferDouble < ATMBank.accountTotals[accountNum1 - 1000]) { 
               ATMBank.accountTotals[accountNum1 - 1000] = ATMBank.accountTotals[accountNum1 - 1000] - transferDouble;
               ATMBank.accountTotals[accountNum1 - 1000] = Math.floor(ATMBank.accountTotals[accountNum1 - 1000] * 100) / 100;  
               ATMBank.accountTotals[accountNum2 - 1000] = ATMBank.accountTotals[accountNum2 - 1000] + transferDouble;
               ATMBank.accountTotals[accountNum2 - 1000] = Math.floor(ATMBank.accountTotals[accountNum2 - 1000] * 100) / 100; 
               customerName1.setText("FROM: " + ATMBank.accountFNames[accountNum1 - 1000] + " " +
                  ATMBank.accountLNames[accountNum1 - 1000] + "  NEW BALANCE: " +
                  ATMBank.accountTotals[accountNum1 - 1000]);
               customerName2.setText("TO: " + ATMBank.accountFNames[accountNum2 - 1000] + " " +
                  ATMBank.accountLNames[accountNum2 - 1000] + "  NEW BALANCE: " + 
                  ATMBank.accountTotals[accountNum2 - 1000]);
               transfer.setText("Enter Transfer Amount: ");
            } else {
              transfer.setText("Amount exceeds funds. Enter new amount: ");
            }
         } catch(NumberFormatException e) {
            transfer.setText("Invalid - use only numbers/decimal. Enter amount: ");
         }
      } else {
         transfer.setText("Select Valid Accounts Before Transfer");
      }
      return transferDouble;
   }
    
   //------------------------------------------------------------------------
   //  Closes Transfer GUI and returns to Main Menu GUI 
   //------------------------------------------------------------------------
   public void goToMainMenu (ActionEvent event)
   {
     secondaryStage.close();
   }
}