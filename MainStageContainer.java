// system imports
import javafx.stage.Stage;

// project imports

/**
 * The main stage for the Brockport GUI applications. 
 * All scenes are inside this one stage only. 
 */
//==============================================================
public class MainStageContainer
{
    // data members

    private static Stage myInstance = null;

    // class constructor
    //----------------------------------------------------------
    private MainStageContainer ()
    {
    }

    //----------------------------------------------------------
    public static Stage getInstance()
    {
        return myInstance;
    }

    //-----------------------------------------------------------
    public static void setStage(Stage st, String title)
    {
        myInstance = st;
        myInstance.setTitle(title);
        myInstance.setResizable(false);
    }

}