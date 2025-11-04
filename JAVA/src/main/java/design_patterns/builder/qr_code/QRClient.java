package design_patterns.builder.qr_code;

public class QRClient {
    public static void main(String[] args) {
        Double amount = 50.00d;
        QRBuilder builder = QRBuilder.getBuilder();
        builder.setVpa("33shubham@hdfc");
        builder.setAmount(amount);
        builder.setMid("12345678");
        builder.setTid("87456213");
        builder.setMerchantName("Shubham");
        builder.setTxnId("011120250001");
        QR qr = builder.build();
        System.out.println(qr.getQrString());
    }
}
