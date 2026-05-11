import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
        title.setFont(Font.font("Arial", FontWeight.BOLD,26));

        Label name = new Label("Enter your name: ");
        name.setTextFill(Color.color(0.4,0,0));
        name.setFont(Font.font("Arial",FontWeight.BOLD,14));

        Label phone = new Label("Enter your Phone Number: ");
        phone.setTextFill(Color.color(0.4,0,0));
        phone.setFont(Font.font("Arial",FontWeight.BOLD,14));

        Label email = new Label("Enter your email: ");
        email.setTextFill(Color.color(0.4,0,0));
        email.setFont(Font.font("Arial",FontWeight.BOLD,14));

        TextField phoneNumberField = new TextField();
        phoneNumberField.setFont(Font.font(12));

        TextField emailField = new TextField();
        emailField.setFont(Font.font(12));

        TextField nameField = new TextField();
        nameField.setFont(Font.font(12));


        layout.add(title, 0, 0);
        layout.add(name, 0,1);
        layout.add(nameField, 0,2);
        layout.add(phone, 0,3);
        layout.add(phoneNumberField, 0,4);
        layout.add(email, 0,5);
        layout.add(emailField, 0,6);
        layout.setStyle("-fx-background-color: tan;");
        layout.setAlignment(Pos.CENTER);

        Button create = new Button("Submit");
        Label message=new Label();
        create.setFont(Font.font(12));

        create.setOnAction(e -> {
            SetControl(
                    message,
                    "We will contact you shortly.",
                    stage,
                    create
            );
            layout.add(message, 0, 8);
        });


        layout.add(create,0,7);
        return new Scene(layout,550,350);
    }
    public static void SetControl(Label label, String text, Stage stage, Button create){
        label.setText(text);
        label.setFont(Font.font("Arial", FontWeight.BOLD,14));

        create.setDisable(true);
    }
}