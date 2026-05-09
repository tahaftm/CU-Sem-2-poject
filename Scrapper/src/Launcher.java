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


import static javafx.application.Application.launch;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("Scrapper_GUI");
        stage.setResizable(false);


        GridPane layout = new GridPane();
        layout.setPadding(new Insets(30,10,30,30));
        layout.setHgap(10);
        layout.setVgap(10);


        Label scrapper = new Label("Scrapper");
        scrapper.setTextFill(Color.color(0.4,0,0));
        scrapper.setFont(Font.font("Arial", FontWeight.BOLD,34));
//        stage.getIcons().add(new Image(getClass().getResourceAsStream("/download.jpg")));


        Label WebUrl = new Label("Website Url:");
        WebUrl.setTextFill(Color.color(0.4,0,0));
        WebUrl.setFont(Font.font("Arial",FontWeight.BOLD,20));
        Label FileLoc = new Label("File location:");
        FileLoc.setTextFill(Color.color(0.4,0,0));
        FileLoc.setFont(Font.font("Arial",FontWeight.BOLD,20));


        TextField web=new TextField();
        web.setFont(Font.font(14));
        TextField file=new TextField();
        file.setFont(Font.font(14));


        Label message=new Label();
        Button extract = new Button("Extract");
        Button cancel = new Button("Cancel");
        extract.setOnAction(e -> {

            String link = web.getText();
            String filepath = file.getText();

            Scraper scraper = new Scraper(link, filepath);

            scraper.start_scrape();

            SetControl(
                    message,
                    "Data scraped successfully and File written successfully.",
                    stage,
                    extract,
                    cancel
            );
        });        cancel.setOnAction(e-> SetControl(message,"Program exited successfully",stage,extract,cancel));
        extract.setFont(Font.font(14));
        cancel.setFont(Font.font(14));


        HBox Buttonbox = new HBox();
        Buttonbox.getChildren().addAll(extract, cancel);


        layout.add(scrapper, 1,0);
        layout.add(WebUrl, 0, 1);
        layout.add(FileLoc, 0, 2);
        layout.add(Buttonbox, 1, 3);
        layout.add(message,1,4);
        layout.setStyle("-fx-background-color: tan;");
        layout.add(web,1,1);
        layout.add(file,1,2);


        Scene scene1 = new Scene(layout, 500, 300);
        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void SetControl(Label label,String text,Stage stage,Button extract,Button cancel){
        label.setText(text);
        label.setFont(Font.font("Arial",FontWeight.BOLD,16));

        extract.setDisable(true);
        cancel.setDisable(true);
    }



}