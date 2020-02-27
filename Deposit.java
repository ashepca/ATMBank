//***************************************************************************
//
//  Deposit.java                
//  
//  Author:  Andrew Shepherd, 100153343
// 
//  COMP 2663 - Project - Winter 2019
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
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.lang.Math;

public class Deposit
{
   private Text menuTitle;
   private Text accountBalance;
   private String depositString;
   private Double depositDouble;
   private TextField enterDeposit;
   public Double currentBalance;
   public Stage secondaryStage = new Stage();
 
   //------------------------------------------------------------------------
   //  Presents a GUI containing the fields for Deposit transaction
   //------------------------------------------------------------------------
   public void start(Double balance)
   {  
      Font font2 = new Font("Courier", 24);
      currentBalance = Math.floor(balance * 100) / 100;
      
      menuTitle = new Text("Deposit");
      menuTitle.setFont(Font.font("Courier", FontWeight.BOLD, 36));
      menuTitle.setFill(Color.NAVY);
      
      Separator sep = new Separator();
      
      Label deposit = new Label("Enter Deposit Amount: ");
      deposit.setFont(font2);
      
      enterDeposit = new TextField();

      accountBalance = new Text("Your balance is: $" + currentBalance);
      accountBalance.setFont(font2);
      
      Button calculateDeposit = new Button("Complete Deposit");
      calculateDeposit.setOnAction(this::addDeposit);
      calculateDeposit.setFont(font2);
      
      Button closeGUI = new Button("Return to Menu");
      closeGUI.setOnAction(this::goToMainMenu);
      closeGUI.setFont(font2);
      
      VBox pane = new VBox(menuTitle, sep, deposit, enterDeposit, accountBalance, calculateDeposit, closeGUI);
      pane.setAlignment(Pos.CENTER);
      pane.setSpacing(40);
      pane.setStyle("-fx-background-color: wheat");
      
      Scene scene = new Scene(pane, 700, 600);

      secondaryStage.setTitle("ATM Bank - Deposit");
      secondaryStage.setScene(scene);
      secondaryStage.show();
   }

   //------------------------------------------------------------------------
   //  Calculates new balance after deposit 
   //------------------------------------------------------------------------   
   public void addDeposit (ActionEvent event)
   {
      depositString = enterDeposit.getText();
      
      try {
         depositDouble = Double.parseDouble(depositString);
         currentBalance = currentBalance + depositDouble;
         currentBalance = Math.floor(currentBalance * 100) / 100;
         accountBalance.setText("Your new balance is: $" + currentBalance);
      } catch(NumberFormatException e) {
         accountBalance.setText("Enter a valid number.");
      }
   }
   
   //------------------------------------------------------------------------
   //  Closes Deposit GUI and returns to Main Menu GUI 
   //------------------------------------------------------------------------
   public void goToMainMenu (ActionEvent event)
   {
      secondaryStage.close();
   }
}