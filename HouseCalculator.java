import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// project imports

/** The class containing the main program for the Loan application */
//==============================================================
public class HouseCalculator extends Application
{
    private HouseList myHouseList;
    // the main behavior for the application

    /** Main frame of the application */
    private Stage mainStage;

    // start method for this class, the main application object
    //----------------------------------------------------------
    public void start(Stage primaryStage)
    {
        System.out.println("Brockport Zillow");

        // Create the top-level container (main stage) and add
        // contents to it.
        MainStageContainer.setStage
                (primaryStage, "Brockport Zillow Version 1.00");
        mainStage = MainStageContainer.getInstance();

        // Finish setting up the stage
        // (ENABLE THE GUI TO BE CLOSED USING THE TOP RIGHT 'X' IN THE
        //  WINDOW), and show it.
        mainStage.setOnCloseRequest(new EventHandler<javafx.stage.WindowEvent>() {
            @Override
            public void handle(javafx.stage.WindowEvent event) {
                System.exit(0);
            }
        });

        try
        {
            myHouseList = new HouseList("houses.txt");
        }
        catch(Exception exc)
        {
            System.err.println
                    ("Failure to create the list of houses from the text file");
            exc.printStackTrace();
        }


        WindowPosition.placeCenter(mainStage);

        mainStage.show();
    }

    /**
     * The "main" entry point for the application. Carries out
     * actions to set up the application
     */
    //----------------------------------------------------------
    public static void main(String[] args)
    {
        launch(args);
    }

}
