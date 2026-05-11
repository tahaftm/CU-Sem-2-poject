import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/*
import static com.example.scarpper.Launcher.SetControl;
*/

public class Type {
    public static Scene startScene(Stage stage,String webUrl,String Fileloc){
        GridPane layout=new GridPane();
        layout.setPadding(new Insets(30,30,30,30));
        layout.setVgap(10);
        layout.setHgap(10);

        Label Options=new Label("Choose the following Options :");
        Options.setFont(Font.font("Arial", FontWeight.BOLD,26));
        Options.setTextFill(Color.color(0.4,0,0));


        Button cancel=new Button("Cancel");
        cancel.setFont(Font.font(14));

        Scraper scraper=new Scraper(webUrl,Fileloc);
        MenuItem H1=new MenuItem("H1 TAG");
        MenuItem H3=new MenuItem("H3 TAG");
        MenuItem Links=new MenuItem("Extract links");

        SplitMenuButton split=new SplitMenuButton();
        split.setText("Headings");
        split.getItems().addAll(H1,H3);
        split.setFont(Font.font(14));

        SplitMenuButton splitLinks=new SplitMenuButton();
        splitLinks.setText("Links");
        splitLinks.getItems().add(Links);
        splitLinks.setFont(Font.font(14));

        H1.setOnAction(event -> {
            try {
                String data = scraper.scrapeH1();
                stage.setScene(DisplayResult.startScene(stage, data));
            } catch (Exception e) {
                stage.setScene(DisplayResult.startScene(stage, "H1 error"));
            }
        });

        H3.setOnAction(event -> {
            try {
                String data = scraper.scrapeH3();
                stage.setScene(DisplayResult.startScene(stage, data));
            } catch (Exception e) {
                stage.setScene(DisplayResult.startScene(stage, "H3 error"));
            }
        });

        Links.setOnAction(event -> {
            try {
                String data = scraper.scrapeLinks();
                stage.setScene(DisplayResult.startScene(stage, data));
            } catch (Exception e) {
                stage.setScene(DisplayResult.startScene(stage, "Links error"));
            }
        });

        cancel.setOnAction(event -> {
            stage.setScene(Launcher.startScene(stage));
        });


        layout.add(Options,0,0);
        layout.add(split,0,1);
        layout.add(splitLinks,0,2);
        layout.setStyle("-fx-background-color: tan;");
        layout.add(cancel,0,3);
        layout.setAlignment(Pos.CENTER);


        return new Scene(layout,550,350);



    }

}