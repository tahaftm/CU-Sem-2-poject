import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class DisplayResult {
    public static Scene startScene(Stage stage,String data) {
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(30, 30, 30, 30));
        layout.setHgap(10);
        layout.setVgap(10);

        Label Data = new Label("Data Scraped");
        Data.setFont(Font.font("Arial", FontWeight.BOLD, 26));
        Data.setTextFill(Color.color(0.4, 0, 0));

        Label Msg=new Label("Data shown successfully");
        Msg.setFont(Font.font("Arial",FontWeight.BOLD,16));

        TextArea ScrapData = new TextArea();
        ScrapData.setText(data);
        ScrapData.setEditable(false);
        ScrapData.setWrapText(true);
        ScrapData.setPrefSize(400, 400);

        layout.add(Data,0,0);
        layout.add(ScrapData,0,1);
        layout.setStyle("-fx-background-color: tan;");
        layout.add(Msg,0,2);
        layout.setAlignment(Pos.CENTER);

        return new Scene(layout,550,350);
    }
}