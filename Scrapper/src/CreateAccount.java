import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class CreateAccount {
    public static Scene startScene(Stage stage){
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(30,10,30,30));
        layout.setHgap(10);
        layout.setVgap(5);

        Label title  = new Label("Create new account!");
        title.setTextFill(Color.color(0.4,0,0));
        title.setFont(Font.font("Arial", FontWeight.BOLD,22));


        Label firstName = new Label("Enter your first name: ");
        firstName.setTextFill(Color.color(0.4,0,0));
        firstName.setFont(Font.font("Arial",FontWeight.BOLD,14));

        Label lastName = new Label("Enter your last name: ");
        lastName.setTextFill(Color.color(0.4,0,0));
        lastName.setFont(Font.font("Arial",FontWeight.BOLD,14));

        Label phone = new Label("Enter your Phone Number: ");
        phone.setTextFill(Color.color(0.4,0,0));
        phone.setFont(Font.font("Arial",FontWeight.BOLD,14));

        Label email = new Label("Enter your email: ");
        email.setTextFill(Color.color(0.4,0,0));
        email.setFont(Font.font("Arial",FontWeight.BOLD,14));

        Label password = new Label("Enter your Password: ");
        password.setTextFill(Color.color(0.4,0,0));
        password.setFont(Font.font("Arial",FontWeight.BOLD,14));



        TextField firstNameField = new TextField();
        firstNameField.setFont(Font.font(10));

        TextField lastNameField = new TextField();
        lastNameField.setFont(Font.font(10));

        TextField phoneNumberField = new TextField();
        phoneNumberField.setFont(Font.font(10));

        TextField emailField = new TextField();
        emailField.setFont(Font.font(10));

        PasswordField passwordField = new PasswordField();
        passwordField.setFont(Font.font(10));

        layout.add(title, 0, 0);
        layout.add(firstName, 0,1);
        layout.add(firstNameField, 0,2);
        layout.add(lastName, 0,3);
        layout.add(lastNameField, 0,4);
        layout.add(phone, 0,5);
        layout.add(phoneNumberField, 0,6);
        layout.add(email, 0,7);
        layout.add(emailField, 0,8);
        layout.add(password, 0,9);
        layout.add(passwordField, 0,10);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: tan;");

        Button create = new Button("Create");
        Label message=new Label();
        create.setFont(Font.font(12));

        Button Cancel=new Button("Cancel");
        Cancel.setFont(Font.font(12));

        create.setOnAction(e -> {

            Scene launcherScene = Launcher.startScene(stage);
            stage.setScene(launcherScene);

            SetControl(
                    message,
                    "Data scraped successfully and File written successfully.",
                    stage,
                    create
            );
        });


        layout.add(create,0,11);
        return new Scene(layout,550,350);
    }
    public static void SetControl(Label label,String text,Stage stage,Button create){
        label.setText(text);
        label.setFont(Font.font("Arial", FontWeight.BOLD,16));

        create.setDisable(true);
    }

}