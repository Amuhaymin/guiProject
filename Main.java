import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.layout.FlowPane;
public class Main extends Application {
    private ListView<String> cartItems;
    private Text text;
    private TextField itemField;
    private ObservableList<String> items;



    public void start(Stage primaryStage) {
        primaryStage.setTitle("Shopping Cart");
        text = new Text("Item:");
        // Create a cart list
        cartItems = new ListView<>();
        items = FXCollections.observableArrayList();

        cartItems.setItems(items);

        // Create form elements
         itemField = new TextField();
         itemField.setPrefWidth(200.0);


        Button addButton = new Button("Add item to Cart");
        addButton.setOnAction(this::addRequest);

        Button clearButton = new Button("Clear items");
        clearButton.setOnAction(this::clearRequest);

        // Create a grid layout
        FlowPane flowpane = new FlowPane(text,itemField,addButton,clearButton,cartItems);
        flowpane.setAlignment(Pos.CENTER);
        flowpane.setHgap(10.0);
        flowpane.setVgap(20.0);
        // Create the scene
        Scene scene = new Scene(flowpane, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addToCart(String item) {
        items.add(item);
    }

    private void clearCart() {
        items.clear();
    }
    public void addRequest(ActionEvent event){
        addToCart(itemField.getText());
    }
    public void clearRequest(ActionEvent event){
        clearCart();
    }
    public static void main(String[] args) {
        launch(args);
    }
}