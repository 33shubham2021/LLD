package design_patterns.builder.qr_code;

public class QRClient {
    public static void main(String[] args) {
        Double amount = 50.00d;
        QR qr = QR.getBuilder()
                .setVpa("33shubham@hdfc")
                .setAmount(amount)
                .setMid("12345678")
                .setTid("87456213")
                .setMerchantName("Shubham")
                .setTxnId("011120250001")
                .build();

        System.out.println(qr.getQrString());
    }
}
