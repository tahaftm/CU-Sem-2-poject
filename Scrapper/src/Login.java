import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;


import static javafx.application.Application.launch;

public class Login extends Application {
    @Override
    public void start(Stage stage) {

        stage.setTitle("Login page");
        stage.setResizable(false);


        GridPane layout = new GridPane();
        layout.setPadding(new Insets(30,10,30,30));
        layout.setHgap(10);
        layout.setVgap(10);


        Label scrapper = new Label("Welcome to webscraper!");
        scrapper.setTextFill(Color.color(0.4, 0, 0));
        scrapper.setFont(Font.font("Arial", FontWeight.BOLD, 34));
//        stage.getIcons().add(new Image(getClass().getResourceAsStream("/download.jpg")));


        Label Email = new Label("Enter Email: ");
        Email.setTextFill(Color.color(0.4,0,0));
        Email.setFont(Font.font("Arial",FontWeight.BOLD,20));
        Label passwordLabel = new Label("Enter Password: ");
        passwordLabel.setTextFill(Color.color(0.4,0,0));
        passwordLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));


        TextField web=new TextField();
        web.setFont(Font.font(14));
        PasswordField file=new PasswordField();
        file.setFont(Font.font(14));


        Label message=new Label();
        Button login = new Button("Login");
        Button cancel = new Button("Cancel");
        Button createAccount = new Button("New here?");
        Button forgotPassword = new Button("Forgot Password?");
        login.setOnAction(e -> {

            Scene launcherScene = Launcher.startScene(stage);
            stage.setScene(launcherScene);

            SetControl(
                    message,
                    "Data scraped successfully and File written successfully.",
                    stage,
                    login,
                    cancel,
                    forgotPassword,
                    createAccount
            );
        });

        forgotPassword.setOnAction(e -> {

            Scene launcherScene = ForgotPassword.startScene(stage);
            stage.setScene(launcherScene);

            SetControl(
                    message,
                    "Data scraped successfully and File written successfully.",
                    stage,
                    login,
                    cancel,
                    forgotPassword,
                    createAccount
            );
        });


        createAccount.setOnAction(e -> {

            Scene CreateAccountScene = CreateAccount.startScene(stage);
            stage.setScene(CreateAccountScene);

            SetControl(
                    message,
                    "Data scraped successfully and File written successfully.",
                    stage,
                    login,
                    cancel,
                    forgotPassword,
                    createAccount
            );
        });

        cancel.setOnAction(e-> SetControl(message,"Program exited successfully",stage,login,cancel,forgotPassword,createAccount));
        login.setFont(Font.font(14));
        cancel.setFont(Font.font(14));
        forgotPassword.setFont(Font.font(14));
        createAccount.setFont(Font.font(14));



        HBox Buttonbox = new HBox();
        Buttonbox.getChildren().addAll(login, cancel,forgotPassword,createAccount);


        layout.add(scrapper, 1,0);
        layout.add(Email, 0, 1);
        layout.add(passwordLabel, 0, 2);
//        layout.add(FileLoc, 0, 2);
        layout.add(Buttonbox, 1, 3);
        layout.add(message,1,4);
        layout.setStyle("-fx-background-color: tan;");
        layout.add(web,1,1);
        layout.add(file,1,2);


        Scene scene1 = new Scene(layout, 800, 400);
        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void SetControl(Label label,String text,Stage stage,Button extract,Button cancel, Button forgot, Button createAccount){
        label.setText(text);
        label.setFont(Font.font("Arial",FontWeight.BOLD,16));

        extract.setDisable(true);
        cancel.setDisable(true);
        forgot.setDisable(true);
        createAccount.setDisable(true);
    }



}