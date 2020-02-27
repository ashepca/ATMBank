//***************************************************************************
//
//  Help.java                
//  
//  Author:  Andrew Shepherd, 100153343
// 
//  Copyright (c) April 2019
//
//  GUI class to display help information from main application ATMBank.java  
//
//***************************************************************************

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class Help
{
   private Text menuTitle;
   public Stage secondaryStage = new Stage();
   
   //------------------------------------------------------------------------
   //  Presents a GUI displaying Help Information
   //------------------------------------------------------------------------
   public void start()
   {  
      Font font1 = new Font("Courier", 18);
      Font font2 = new Font("Courier", 14);
      
      menuTitle = new Text("Help");
      menuTitle.setFont(Font.font("Courier", FontWeight.BOLD, 36));
      menuTitle.setFill(Color.NAVY);
      
      Separator sep = new Separator();
      
      Text createAccount = new Text("Create Account");
      createAccount.setFont(font1);
      createAccount.setFill(Color.BLUE);
      
      Label helpText1 = new Label("Account numbers are automatically assigned.  Enter customer first " +
         "and last name.  Select 'Set Account' to confirm and create account.");
      helpText1.setFont(font2);
      helpText1.setMaxWidth(625);
      helpText1.setWrapText(true);
      
      Text deposit = new Text("Deposit");
      deposit.setFont(font1);
      deposit.setFill(Color.BLUE);
      
      Label helpText2 = new Label("Select account from the wheel by pressing up or down.  Select " +
         "'Display Account'.  Enter deposit amount using numbers and an optional decimal place.  Select 'Complete " +
         "Deposit' to perform deposit.");
      helpText2.setFont(font2);
      helpText2.setMaxWidth(625);
      helpText2.setWrapText(true);
      
      Text withdrawal = new Text("Withdrawal");
      withdrawal.setFont(font1);
      withdrawal.setFill(Color.BLUE);
      
      Label helpText3 = new Label("Select account from the wheel by pressing up or down.  Select " +
         "'Display Account'.  Enter withdrawal amount using numbers and an optional decimal place.  Select 'Complete " +
         "Withdrawal' to perform withdrawal.");
      helpText3.setFont(font2);
      helpText3.setMaxWidth(625);
      helpText3.setWrapText(true);
      
      Text accountBalance = new Text("Account Balance");
      accountBalance.setFont(font1);
      accountBalance.setFill(Color.BLUE);
      
      Label helpText4 = new Label("Select account from the wheel by pressing the up or down arrows. " +
         "Select 'Display Account' to display the Account Holder name and Account Balance.");
      helpText4.setFont(font2);
      helpText4.setMaxWidth(625);
      helpText4.setWrapText(true);
      
      Text transfer = new Text("Transfer");
      transfer.setFont(font1);
      transfer.setFill(Color.BLUE);
      
      Label helpText5 = new Label("Select accounts from the wheels by pressing up or down.  Select " +
         "'Display Accounts'.  Enter transfer amount using numbers and an optional decimal place.  Select 'Complete " +
         "Transfer' to perform transfer.");
      helpText5.setFont(font2);
      helpText5.setMaxWidth(625);
      helpText5.setWrapText(true);
      
      Separator sep2 = new Separator();
      
      Button closeGUI = new Button("Return to Menu");
      closeGUI.setOnAction(this::goToMainMenu);
      closeGUI.setFont(font2);
      
      VBox pane = new VBox(menuTitle, sep, createAccount, helpText1, deposit, helpText2, withdrawal, helpText3,
         accountBalance, helpText4, transfer, helpText5, sep2, closeGUI);
      pane.setAlignment(Pos.CENTER);
      pane.setSpacing(10);
      pane.setStyle("-fx-background-color: wheat");
      
      Scene scene = new Scene(pane, 700, 650);

      secondaryStage.setTitle("ATM Bank - Help");
      secondaryStage.setScene(scene);
      secondaryStage.show();
   }
   
   //------------------------------------------------------------------------
   //  Closes Help GUI and returns to Main Menu GUI 
   //------------------------------------------------------------------------
   public void goToMainMenu (ActionEvent event)
   {
     secondaryStage.close();
   }
}