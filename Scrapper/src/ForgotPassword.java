import javafx.geometry.Insets;
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

public class ForgotPassword {
    public static Scene startScene(Stage stage){
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(30,10,30,30));
        layout.setHgap(10);
        layout.setVgap(10);

        Label title  = new Label("Contact Us by filling in the form!");
        title.setTextFill(Color.color(0.4,0,0));
        title.setFont(Font.font("Arial", FontWeight.BOLD,34));

        Label name = new Label("Enter your name: ");
        name.setTextFill(Color.color(0.4,0,0));
        name.setFont(Font.font("Arial",FontWeight.BOLD,20));

        Label phone = new Label("Enter your Phone Number: ");
        phone.setTextFill(Color.color(0.4,0,0));
        phone.setFont(Font.font("Arial",FontWeight.BOLD,20));

        Label email = new Label("Enter your email: ");
        email.setTextFill(Color.color(0.4,0,0));
        email.setFont(Font.font("Arial",FontWeight.BOLD,20));

        TextField phoneNumberField = new TextField();
        phoneNumberField.setFont(Font.font(14));

        TextField emailField = new TextField();
        emailField.setFont(Font.font(14));

        TextField nameField = new TextField();
        nameField.setFont(Font.font(14));


        layout.add(title, 0, 0, 2, 1);
        layout.add(name, 0,1);
        layout.add(nameField, 1,1);
        layout.add(phone, 0,2);
        layout.add(phoneNumberField, 1,2);
        layout.add(email, 0,3);
        layout.add(emailField, 1,3);
        layout.setStyle("-fx-background-color: tan;");

        Button create = new Button("Submit");
        Label message=new Label();
        create.setFont(Font.font(14));

        create.setOnAction(e -> {
            SetControl(
                    message,
                    "We will contact you shortly.",
                    stage,
                    create
            );
            layout.add(message, 0, 7);
        });


        layout.add(create,0,6);
        return new Scene(layout,600,300);
    }
    public static void SetControl(Label label, String text, Stage stage, Button create){
        label.setText(text);
        label.setFont(Font.font("Arial", FontWeight.BOLD,16));

        create.setDisable(true);
    }
}
