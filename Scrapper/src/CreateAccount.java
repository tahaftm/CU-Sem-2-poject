import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class CreateAccount extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) {
//    public Scene getCreateAccountScreen(Stage stage){
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(30,10,30,30));
        layout.setHgap(10);
        layout.setVgap(10);

        Label firstName = new Label("Enter your first name: ");
        Label lastName = new Label("Enter your last name: ");
        Label phone = new Label("Enter your Phone Number: ");
        Label email = new Label("Enter your email: ");
        Label password = new Label("Enter your Password: ");


        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField phoneNumberField = new TextField();
        TextField emailField = new TextField();
        PasswordField passwordField = new PasswordField();


        layout.add(firstName, 0,0);
        layout.add(firstNameField, 1,0);
        layout.add(lastName, 0,1);
        layout.add(lastNameField, 1,1);
        layout.add(phone, 0,2);
        layout.add(phoneNumberField, 1,2);
        layout.add(email, 0,3);
        layout.add(emailField, 1,3);
        layout.add(password, 0,4);
        layout.add(passwordField, 1,4);

        Button create = new Button("Create");
        Label message=new Label();

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


        layout.add(create,0,6);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
//        return new Scene(layout,300,600);
    }
    public static void SetControl(Label label,String text,Stage stage,Button create){
        label.setText(text);
        label.setFont(Font.font("Arial", FontWeight.BOLD,16));

        create.setDisable(true);
    }

}
