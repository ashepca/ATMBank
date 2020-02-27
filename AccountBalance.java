//***************************************************************************
//
//  AccountBalance.java                
//  
//  Author:  Andrew Shepherd, 100153343
// 
//  COMP 2663 - Project - Winter 2019
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
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccountBalance
{
   private Text menuTitle;
   private Text accountBalance;
   public Stage secondaryStage = new Stage();
   
   //------------------------------------------------------------------------
   //  Presents a GUI displaying Account Balance
   //------------------------------------------------------------------------
   public void start(Double balance)
   {  
      Font font2 = new Font("Courier", 24);
      ATMBank.currentBalance = Math.floor(balance * 100) / 100;
      
      menuTitle = new Text("AccountBalance");
      menuTitle.setFont(Font.font("Courier", FontWeight.BOLD, 36));
      menuTitle.setFill(Color.NAVY);
      
      Separator sep = new Separator();
      
      accountBalance = new Text("Your balance is: $" + ATMBank.currentBalance);
      accountBalance.setFont(font2);
      
      Button closeGUI = new Button("Return to Menu");
      closeGUI.setOnAction(this::goToMainMenu);
      closeGUI.setFont(font2);
      
      VBox pane = new VBox(menuTitle, sep, accountBalance, closeGUI);
      pane.setAlignment(Pos.CENTER);
      pane.setSpacing(40);
      pane.setStyle("-fx-background-color: wheat");
      
      Scene scene = new Scene(pane, 700, 600);

      secondaryStage.setTitle("ATM Bank - Account Balance");
      secondaryStage.setScene(scene);
      secondaryStage.show();
   }

   //------------------------------------------------------------------------
   //  Closes Account Balance GUI and returns to Main Menu GUI 
   //------------------------------------------------------------------------
   public void goToMainMenu (ActionEvent event)
   {
     secondaryStage.close();
   }
}