//***************************************************************************
//
//  CreateAccount.java                
//  
//  Author:  Andrew Shepherd, 100153343
// 
//  Copyright (c) April 2019
//
//  GUI class to create account from main application ATMBank.java  
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
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class CreateAccount
{
   private Text menuTitle;
   private Text accountNum;
   public TextField fName;
   private TextField lName;
   private Label firstName;
   private Label lastName;
   public Stage secondaryStage = new Stage();
   
   //------------------------------------------------------------------------
   //  Presents a GUI containing the fields for Creating Accounts
   //------------------------------------------------------------------------
   public void start()
   {  
      Font font2 = new Font("Courier", 20);
      
      menuTitle = new Text("Create Account");
      menuTitle.setFont(Font.font("Courier", FontWeight.BOLD, 36));
      menuTitle.setFill(Color.NAVY);
      
      Separator sep = new Separator();
      
      accountNum = new Text("Account Number: " + ATMBank.accountNumber);
      accountNum.setFont(font2);
      
      firstName = new Label("Enter First Name: ");
      firstName.setFont(font2);
      fName = new TextField();
      fName.setMaxWidth(400);
      
      lastName = new Label("Enter Last Name: ");
      lastName.setFont(font2);
      lName = new TextField();
      lName.setMaxWidth(400);
         
      Button setAccount = new Button("Set Account");
      setAccount.setOnAction(this::setUpAccount);
      setAccount.setFont(font2);
      
      Separator sep2 = new Separator();
      
      Button closeGUI = new Button("Return to Menu");
      closeGUI.setOnAction(this::goToMainMenu);
      closeGUI.setFont(font2);
      
      VBox pane = new VBox(menuTitle, sep, accountNum, firstName, fName, lastName, lName, setAccount, sep2, closeGUI);
      pane.setAlignment(Pos.CENTER);
      pane.setSpacing(30);
      pane.setStyle("-fx-background-color: wheat");
      
      Scene scene = new Scene(pane, 700, 600);

      secondaryStage.setTitle("ATM Bank - Create Account");
      secondaryStage.setScene(scene);
      secondaryStage.show();
   }

   //------------------------------------------------------------------------
   //  Creates the account with user entered information 
   //------------------------------------------------------------------------
   public void setUpAccount (ActionEvent event)
   {
      firstName.setText("Enter First Name: ");
      lastName.setText("Enter Last Name");
      String nameFirst = fName.getText();
      String nameLast = lName.getText();
      if(nameFirst.length() == 0) {
         firstName.setText("Invalid - A First Name Must Be Entered");
      } else if(nameLast.length() == 0) {
         lastName.setText("Invalid - A Last Name Must Be Entered");   
      } else {
         ATMBank.accountFNames[ATMBank.accountNumber - 1000] = fName.getText();
         fName.clear();
         ATMBank.accountLNames[ATMBank.accountNumber - 1000] = lName.getText();
         lName.clear();
         ATMBank.accountTotals[ATMBank.accountNumber - 1000] = 0.00;
         ATMBank.accountNumber += 1;
         accountNum.setText("Account Number: " + ATMBank.accountNumber);
         firstName.setText("Enter First Name: ");
         lastName.setText("Enter Last Name");
      }
   }
   
   //------------------------------------------------------------------------
   //  Closes Create Account GUI and returns to Main Menu GUI 
   //------------------------------------------------------------------------
   public void goToMainMenu (ActionEvent event)
   {
     secondaryStage.close();
   }
}