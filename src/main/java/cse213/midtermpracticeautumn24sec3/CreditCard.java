package cse213.midtermpracticeautumn24sec3;
import javafx.scene.control.Alert;

import java.time.LocalDate;

public class CreditCard{
    private String cardNo, cardHolderName, gatewayName,cardType;
    private float cardLimit;
    private LocalDate dateOfExpiery;

    public CreditCard() {
    }

    public CreditCard(String cardNo, String cardHolderName, float cardLimit, String cardType, String gatewayName, LocalDate dateOfExpiery) {
        this.cardNo = cardNo;
        this.cardHolderName = cardHolderName;
        this.cardLimit = cardLimit;
        this.cardType = cardType;
        this.gatewayName = gatewayName;
        this.dateOfExpiery = dateOfExpiery;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public float getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(float cardLimit) {
        this.cardLimit = cardLimit;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public LocalDate getDateOfExpiery() {
        return dateOfExpiery;
    }

    public void setDateOfExpiery(LocalDate dateOfExpiery) {
        this.dateOfExpiery = dateOfExpiery;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "CreditCard{" +
                "cardNo='" + cardNo + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", gatewayName='" + gatewayName + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardLimit=" + cardLimit +
                ", dateOfExpiery=" + dateOfExpiery +
                '}';
    }



    public void showCardInfoToAlert(){

        //LocalDate dateOfApplication = LocalDate.now();

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(this.toString());
        a.showAndWait();
        //code to write
    }

}