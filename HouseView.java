import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Formatter;

public class HouseView extends View
{

    //Model, which this View talks to
    private HouseList myModel;

    // GUI components
    private ComboBox<String> salesTaxValue;
    private TextField shirtSales;
    private TextField pantsSales;
    private TextField tiesSales;
    private TextField shoesSales;
    private TextField totalBill;
    private Button submitButton;
    private Button cancelButton;
    double shirts = 0.0;
    double pants = 0.0;
    double ties = 0.0;
    double shoes = 0.0;
    double salesTax = 0.0;
    double total = 0.0;

    // GUI components
    private TextField minPrice;
    private TextField maxPrice;
    private TextField minArea;
    private TextField maxArea;
    private TextField minBed;
    private TextField maxBed;
    private TextArea chosen;


    // For showing error message
    private MessageView statusLog;

    // constructor for this class -- takes a model object
    //----------------------------------------------------------
    public HouseView(HouseList houseList) // SAME PATTERN AS LoginView
    {
        super("InvoiceView");
        myModel = houseList;

        // create a container for showing the contents
        VBox container = new VBox(10);
        container.setPadding(new Insets(15, 5, 5, 5));

        // create our GUI components, add them to this panel
        container.getChildren().add(createTitle());
        container.getChildren().add(createFormContent());

        // Error message area
        container.getChildren().add(createStatusLog("  "));

        getChildren().add(container);

        populateFields();
    }


    // Create the title container
    //-------------------------------------------------------------
    private Node createTitle()
    {
        HBox container = new HBox();
        container.setAlignment(Pos.CENTER);

        Text titleText = new Text(" Invoice Calculator ");
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        titleText.setWrappingWidth(300);
        titleText.setTextAlignment(TextAlignment.CENTER);
        titleText.setFill(Color.PURPLE);
        container.getChildren().add(titleText);

        return container;
    }


    // Create the main form content
    //-------------------------------------------------------------
    private VBox createFormContent()
    {
        VBox vbox = new VBox(10);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text salesTaxLabel = new Text("Sales Tax: ");
        salesTaxLabel.setWrappingWidth(150);
        salesTaxLabel.setTextAlignment(TextAlignment.RIGHT);
        grid.add(salesTaxLabel, 0, 5);

        salesTaxValue = new ComboBox<String>();
        salesTaxValue.setMinSize(100, 20);
        grid.add(salesTaxValue, 1, 5);

        Text shirtsLabel = new Text("Shirt sales: ");
        shirtsLabel.setWrappingWidth(150);
        shirtsLabel.setTextAlignment(TextAlignment.RIGHT);
        grid.add(shirtsLabel, 0, 1);

        shirtSales = new TextField();
        grid.add(shirtSales, 1, 1);

        Text pantsLabel = new Text("Pants Sales: ");
        pantsLabel.setWrappingWidth(150);
        pantsLabel.setTextAlignment(TextAlignment.RIGHT);
        grid.add(pantsLabel, 0, 2);

        pantsSales = new TextField();
        grid.add(pantsSales, 1, 2);

        Text tiesLabel = new Text("Ties Sales: ");
        tiesLabel.setWrappingWidth(150);
        tiesLabel.setTextAlignment(TextAlignment.RIGHT);
        grid.add(tiesLabel, 0, 3);

        tiesSales = new TextField();
        grid.add(tiesSales, 1, 3);


        Text shoesLabel = new Text("Shoes sales: ");
        shoesLabel.setWrappingWidth(150);
        shoesLabel.setTextAlignment(TextAlignment.RIGHT);
        grid.add(shoesLabel, 0, 4);

        shoesSales = new TextField();
        grid.add(shoesSales, 1, 4);

        Text totalBillLabel = new Text("Total Bill: ");
        totalBillLabel.setWrappingWidth(150);
        totalBillLabel.setTextAlignment(TextAlignment.RIGHT);
        grid.add(totalBillLabel, 0, 6);

        totalBill = new TextField();
        grid.add(totalBill, 1, 6);

        Text errorMessage = new Text("");

        submitButton = new Button("Calculate");
        submitButton.setOnAction(new EventHandler<ActionEvent>() {

                                     @Override
                                     public void handle(ActionEvent e) {
                                         clearErrorMessage();
                                         if(shirtSales.getText().trim().isEmpty() == false &&
                                                 pantsSales.getText().trim().isEmpty() == false &&
                                                 tiesSales.getText().trim().isEmpty() == false  &&
                                                 shoesSales.getText().trim().isEmpty() == false) {

                                             errorMessage.setText("");

                                             shirts = Double.parseDouble(shirtSales.getText());
                                             pants = Double.parseDouble(pantsSales.getText());
                                             ties = Double.parseDouble(tiesSales.getText());
                                             shoes = Double.parseDouble(shoesSales.getText());
                                             salesTax = (Double.parseDouble(salesTaxValue.getValue()))/100;


                                             total = ((shirts + pants + ties + shoes) * salesTax) + (shirts + pants + ties + shoes);
                                             Formatter formatter = new Formatter();
                                             formatter.format("%.2f", total);
                                             totalBill.setText(formatter.toString());
                                             formatter.close();
                                         }else {

                                             errorMessage.setText("Error: Blank fields");
                                             errorMessage.setFill(Color.RED);

                                         }

                                     }
                                 }


        );

        cancelButton = new Button("Back");
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {

                //--------------------------------------------
                clearErrorMessage();
              //  myModel.cancelTransaction();
            }
        });

        HBox btnContainer = new HBox(100);
        btnContainer.setAlignment(Pos.CENTER);
        btnContainer.getChildren().add(submitButton);
        btnContainer.getChildren().add(cancelButton);

        HBox errorContainer = new HBox(100);
        errorContainer.setAlignment(Pos.CENTER);
        errorContainer.getChildren().add(errorMessage);

        vbox.getChildren().add(grid);
        vbox.getChildren().add(btnContainer);
        vbox.getChildren().add(errorContainer);

        return vbox;
    }


    // Create the status log field
    //-------------------------------------------------------------
    private MessageView createStatusLog(String initialMessage)
    {
        statusLog = new MessageView(initialMessage);

        return statusLog;
    }

    //-------------------------------------------------------------
    public void populateFields()
    {

        salesTaxValue.getItems().add("3.00");
        salesTaxValue.getItems().add("3.25");
        salesTaxValue.getItems().add("3.50");
        salesTaxValue.getItems().add("3.75");
        salesTaxValue.getItems().add("4.00");
        salesTaxValue.getItems().add("4.25");
        salesTaxValue.getItems().add("4.50");
        salesTaxValue.getItems().add("4.75");
        salesTaxValue.getItems().add("5.00");
        salesTaxValue.getItems().add("5.25");
        salesTaxValue.getItems().add("5.50");
        salesTaxValue.getItems().add("5.75");
        salesTaxValue.getItems().add("6.00");
        salesTaxValue.getItems().add("6.25");
        salesTaxValue.getItems().add("6.50");
        salesTaxValue.getItems().add("6.75");
        salesTaxValue.getItems().add("7.00");
        salesTaxValue.getItems().add("7.25");
        salesTaxValue.getItems().add("7.50");
        salesTaxValue.getItems().add("7.75");
        salesTaxValue.getItems().add("8.00");
        salesTaxValue.getItems().add("8.25");
        salesTaxValue.getItems().add("8.50");
        salesTaxValue.getItems().add("8.75");
        salesTaxValue.getItems().add("9.00");
        salesTaxValue.getItems().add("9.25");
        salesTaxValue.getItems().add("9.50");

        salesTaxValue.setValue(salesTaxValue.getItems().get(0));

        //amount.setText("");
    }

    // process events generated from our GUI components
    //-------------------------------------------------------------


    /**
     * Display error message
     */
    //----------------------------------------------------------
    public void displayErrorMessage(String message)
    {
        statusLog.displayErrorMessage(message);
    }

    /**
     * Clear error message
     */
    //----------------------------------------------------------
    public void clearErrorMessage()
    {
        statusLog.clearErrorMessage();
    }


    @Override
    public void updateState(String key, Object value) {
        // TODO Auto-generated method stub

    }
}
