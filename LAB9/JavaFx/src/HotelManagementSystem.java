import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HotelManagementSystem extends Application {


ObservableList<Room> roomList = FXCollections.observableArrayList();
ObservableList<Customer> customerList = FXCollections.observableArrayList();

TableView<Room> roomTable = new TableView<>();
TableView<Customer> customerTable = new TableView<>();

@Override
public void start(Stage stage) {

    // -------- ROOM FORM --------
    Label roomNoLabel = new Label("Room Number:");
    TextField roomNoField = new TextField();

    Label roomTypeLabel = new Label("Room Type:");
    ComboBox<String> roomTypeBox = new ComboBox<>();
    roomTypeBox.getItems().addAll("Single","Double","Deluxe");

    Label priceLabel = new Label("Price per Day:");
    TextField priceField = new TextField();

    Button addRoomBtn = new Button("Add Room");
    Button showAvailableBtn = new Button("Show Available Rooms");
    Button viewAllBtn = new Button("View All Rooms");

    GridPane roomGrid = new GridPane();
    roomGrid.setHgap(10);
    roomGrid.setVgap(10);

    roomGrid.add(roomNoLabel,0,0);
    roomGrid.add(roomNoField,1,0);
    roomGrid.add(roomTypeLabel,0,1);
    roomGrid.add(roomTypeBox,1,1);
    roomGrid.add(priceLabel,0,2);
    roomGrid.add(priceField,1,2);

    HBox roomButtons = new HBox(10,addRoomBtn,showAvailableBtn,viewAllBtn);

    // -------- ROOM TABLE --------
    TableColumn<Room,Integer> colRoomNo = new TableColumn<>("Room No");
    colRoomNo.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));

    TableColumn<Room,String> colType = new TableColumn<>("Type");
    colType.setCellValueFactory(new PropertyValueFactory<>("roomType"));

    TableColumn<Room,Double> colPrice = new TableColumn<>("Price");
    colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

    TableColumn<Room,String> colStatus = new TableColumn<>("Status");
    colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

    roomTable.getColumns().addAll(colRoomNo,colType,colPrice,colStatus);
    roomTable.setItems(roomList);
    roomTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    // -------- CUSTOMER FORM --------
    Label nameLabel = new Label("Customer Name:");
    TextField nameField = new TextField();

    Label contactLabel = new Label("Contact Number:");
    TextField contactField = new TextField();

    Label roomSelectLabel = new Label("Room Number:");
    TextField roomSelectField = new TextField();

    Button bookBtn = new Button("Book Room");
    Button checkoutBtn = new Button("Checkout");

    GridPane customerGrid = new GridPane();
    customerGrid.setHgap(10);
    customerGrid.setVgap(10);

    customerGrid.add(nameLabel,0,0);
    customerGrid.add(nameField,1,0);
    customerGrid.add(contactLabel,0,1);
    customerGrid.add(contactField,1,1);
    customerGrid.add(roomSelectLabel,0,2);
    customerGrid.add(roomSelectField,1,2);

    HBox bookingButtons = new HBox(10,bookBtn,checkoutBtn);

    // -------- CUSTOMER TABLE --------
    TableColumn<Customer,String> colName = new TableColumn<>("Name");
    colName.setCellValueFactory(new PropertyValueFactory<>("name"));

    TableColumn<Customer,String> colContact = new TableColumn<>("Contact");
    colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));

    TableColumn<Customer,Integer> colBookedRoom = new TableColumn<>("Room No");
    colBookedRoom.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));

    customerTable.getColumns().addAll(colName,colContact,colBookedRoom);
    customerTable.setItems(customerList);
    customerTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    // -------- EVENTS --------

    addRoomBtn.setOnAction(e -> {
        int roomNo = Integer.parseInt(roomNoField.getText());
        String type = roomTypeBox.getValue();
        double price = Double.parseDouble(priceField.getText());

        roomList.add(new Room(roomNo,type,price,"Available"));

        roomNoField.clear();
        priceField.clear();
    });

    showAvailableBtn.setOnAction(e -> {
        ObservableList<Room> available = FXCollections.observableArrayList();

        for(Room r: roomList){
            if(r.getStatus().equals("Available")){
                available.add(r);
            }
        }

        roomTable.setItems(available);
    });

    viewAllBtn.setOnAction(e -> roomTable.setItems(roomList));

    bookBtn.setOnAction(e -> {

        String name = nameField.getText();
        String contact = contactField.getText();
        int roomNo = Integer.parseInt(roomSelectField.getText());

        for(Room r: roomList){
            if(r.getRoomNumber()==roomNo && r.getStatus().equals("Available")){

                r.setStatus("Occupied");

                customerList.add(new Customer(name,contact,roomNo));

                roomTable.refresh();

                nameField.clear();
                contactField.clear();
                roomSelectField.clear();
                return;
            }
        }

        new Alert(Alert.AlertType.ERROR,"Room not available").show();
    });

    checkoutBtn.setOnAction(e -> {

        int roomNo = Integer.parseInt(roomSelectField.getText());

        for(Room r: roomList){
            if(r.getRoomNumber()==roomNo){
                r.setStatus("Available");
            }
        }

        customerList.removeIf(c -> c.getRoomNumber()==roomNo);

        roomTable.refresh();
    });

    VBox layout = new VBox(20,
            new Label("Room Management"),
            roomGrid,
            roomButtons,
            roomTable,
            new Label("Customer Booking"),
            customerGrid,
            bookingButtons,
            customerTable);

    layout.setPadding(new Insets(20));

    Scene scene = new Scene(layout,800,700);

    stage.setTitle("Hotel Management System");
    stage.setScene(scene);
    stage.show();
}

public static void main(String[] args){
    launch(args);
}

// -------- ROOM CLASS --------
public static class Room{

    private int roomNumber;
    private String roomType;
    private double price;
    private String status;

    public Room(int roomNumber,String roomType,double price,String status){
        this.roomNumber=roomNumber;
        this.roomType=roomType;
        this.price=price;
        this.status=status;
    }

    public int getRoomNumber(){ return roomNumber; }
    public String getRoomType(){ return roomType; }
    public double getPrice(){ return price; }
    public String getStatus(){ return status; }

    public void setStatus(String status){ this.status=status; }
}

// -------- CUSTOMER CLASS --------
public static class Customer{

    private String name;
    private String contact;
    private int roomNumber;

    public Customer(String name,String contact,int roomNumber){
        this.name=name;
        this.contact=contact;
        this.roomNumber=roomNumber;
    }

    public String getName(){ return name; }
    public String getContact(){ return contact; }
    public int getRoomNumber(){ return roomNumber; }
}


}
