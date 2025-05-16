package cse213.midtermpracticeautumn24sec3;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class CreditCardViewController
{
    @javafx.fxml.FXML
    private TextField cardNoTextField;
    @javafx.fxml.FXML
    private DatePicker doeDatePicker;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, String> nameTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> gatewayToFilterComboBox;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TextField limitTextField;
    @javafx.fxml.FXML
    private TableView<CreditCard> creditCardTableView;
    @javafx.fxml.FXML
    private ComboBox<String> gatewayTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, Float> limitTableColumn;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, String> gatewayTableColumn;
    @javafx.fxml.FXML
    private TextField limitToFilterTextField;
    @javafx.fxml.FXML
    private ComboBox<String> cardTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, String> cardNoTableColumn;

    private ArrayList<CreditCard> cardList;
    @javafx.fxml.FXML
    private Label avgLimitLabel;

    @javafx.fxml.FXML
    public void initialize() {
        gatewayTypeComboBox.getItems().addAll("Visa","MasterCard");
        gatewayToFilterComboBox.getItems().addAll("ALL","Visa","MasterCard");
        cardTypeComboBox.getItems().addAll("Silver","Gold","Platinum","Titanium");

        cardNoTableColumn.setCellValueFactory(new PropertyValueFactory<CreditCard,String>("cardNo"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<CreditCard,String>("cardHolderName"));
        gatewayTableColumn.setCellValueFactory(new PropertyValueFactory<CreditCard,String>("gatewayName"));
        limitTableColumn.setCellValueFactory(new PropertyValueFactory<CreditCard,Float>("cardLimit"));

        cardList = new ArrayList<CreditCard>();
    }

    private boolean idValidCardNo(){
        String cardNoStr = cardNoTextField.getText();
        if(cardNoStr.length() == 16){
            int i;
            for(i=0;i<16;i++){
                if (cardNoStr.charAt(i)<'0' || cardNoStr.charAt(i)>'9')
                    return false;
            }

            if(cardNoStr.charAt(0) == '4'
                    && gatewayTypeComboBox.getValue().equals("Visa"))
                return true;
            if(cardNoStr.charAt(0) == '5'
                    && gatewayTypeComboBox.getValue().equals("MasterCard"))
                return true;
            else
                return false;
        }
        return false;
    }

    @javafx.fxml.FXML
    public void validateAndAddButtonOnAction(ActionEvent actionEvent) {

        if(idValidCardNo()){

            cardList.add(
                new CreditCard(
                    cardNoTextField.getText(),
                    nameTextField.getText(),
                    Float.parseFloat(limitTextField.getText()),
                    cardTypeComboBox.getValue(),
                    gatewayTypeComboBox.getValue(),
                    doeDatePicker.getValue()
                )
            );

        }
        else{
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Oops! Invalid card No. can't create new CreditCard");
            a.showAndWait();
        }

    }

    @javafx.fxml.FXML
    public void filterAnddLoadTableViewOnAction(ActionEvent actionEvent) {

        creditCardTableView.getItems().clear();

        for(CreditCard c: cardList) {
            if( c.getGatewayName().equals(gatewayToFilterComboBox.getValue())){
                if ( c.getCardLimit() >= Float.parseFloat(limitToFilterTextField.getText()) ) {
                    creditCardTableView.getItems().add(c);
                }
            }
        }
        
        //if(creditCardTableView.getItems().size()==0){
        if(creditCardTableView.getItems().isEmpty()){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Oops! No data found as per filter criteria");
            a.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void showAvgLimitButtonOnAction(ActionEvent actionEvent) {
        float avgLimit = 0f;
        for(CreditCard c: creditCardTableView.getItems()){
            avgLimit += c.getCardLimit();
        }
        avgLimitLabel.setText(
                "Average Credit Limit of Filtered Credit Cards: "
                + (avgLimit / creditCardTableView.getItems().size() )
        );
    }
}