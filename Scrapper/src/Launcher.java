import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class Launcher {
    public static Scene startScene(Stage stage) {

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(30,10,30,30));
        layout.setHgap(10);
        layout.setVgap(10);


        Label scrapper = new Label("Scrapper");
        scrapper.setTextFill(Color.color(0.4,0,0));
        scrapper.setFont(Font.font("Arial", FontWeight.BOLD,30));
//        stage.getIcons().add(new Image(getClass().getResourceAsStream("/download.jpg")));


        Label WebUrl = new Label("Website Url:");
        WebUrl.setTextFill(Color.color(0.4,0,0));
        WebUrl.setFont(Font.font("Arial",FontWeight.BOLD,16));
        Label FileLoc = new Label("File location:");
        FileLoc.setTextFill(Color.color(0.4,0,0));
        FileLoc.setFont(Font.font("Arial",FontWeight.BOLD,16));


        TextField web=new TextField();
        web.setFont(Font.font(12));
        web.setMaxWidth(150);
        TextField file=new TextField();
        file.setMaxWidth(150);
        file.setFont(Font.font(12));


        Label message=new Label();
        Button SelectType = new Button("Select Type");
        Button cancel = new Button("Cancel");
        SelectType.setOnAction(e -> {
            stage.setScene(Type.startScene(stage,web.getText(),file.getText()));
        });

        cancel.setOnAction(e-> SetControl(message,"Program exited successfully",stage,SelectType,cancel));
        SelectType.setFont(Font.font(12));
        cancel.setFont(Font.font(12));


        HBox Buttonbox = new HBox();
        Buttonbox.setSpacing(5);
        Buttonbox.getChildren().addAll(SelectType, cancel);


        layout.add(scrapper, 1,0);
        layout.add(WebUrl, 1, 1);
        layout.add(web,1,2);
        layout.add(FileLoc, 1, 3);
        layout.add(file,1,4);
        layout.add(Buttonbox, 1, 5);
        layout.add(message,1,6);
        layout.setStyle("-fx-background-color: tan;");
        layout.setAlignment(Pos.CENTER);

        return new Scene(layout,550,350);
    }

    public static void SetControl(Label label,String text,Stage stage,Button extract,Button cancel){
        label.setText(text);
        label.setFont(Font.font("Arial",FontWeight.BOLD,16));

        extract.setDisable(true);
        cancel.setDisable(true);
    }



}

