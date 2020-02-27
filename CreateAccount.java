//***************************************************************************
//
//  CreateAccount.java                
//  
//  Author:  Andrew Shepherd, 100153343
// 
//  COMP 2663 - Project - Winter 2019
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
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreateAccount
{
   private Text menuTitle;
   public Stage secondaryStage = new Stage();
   
   //------------------------------------------------------------------------
   //  Presents a GUI containing the fields for Creating Accounts
   //------------------------------------------------------------------------
   public void start()
   {  
      Font font2 = new Font("Courier", 24);
      
      menuTitle = new Text("Create Account");
      menuTitle.setFont(Font.font("Courier", FontWeight.BOLD, 36));
      menuTitle.setFill(Color.NAVY);
      
      Separator sep = new Separator();
      
      Button closeGUI = new Button("Set Account");
      closeGUI.setOnAction(this::goToMainMenu);
      closeGUI.setFont(font2);
      
      VBox pane = new VBox(menuTitle, sep, closeGUI);
      pane.setAlignment(Pos.CENTER);
      pane.setSpacing(40);
      pane.setStyle("-fx-background-color: wheat");
      
      Scene scene = new Scene(pane, 700, 600);

      secondaryStage.setTitle("ATM Bank - Create Account");
      secondaryStage.setScene(scene);
      secondaryStage.show();
   }

   //------------------------------------------------------------------------
   //  Closes Create Account GUI and returns to Main Menu GUI 
   //------------------------------------------------------------------------
   public void goToMainMenu (ActionEvent event)
   {
     secondaryStage.close();
   }
}