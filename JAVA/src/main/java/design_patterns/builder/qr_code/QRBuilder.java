package design_patterns.builder.qr_code;

public class QRBuilder {
    //QR parameters
    private String vpa;
    private Double amount;
    private String mid;
    private String tid;
    private String merchantName;
    private String txnId;

    //getBuilder method
    public static QRBuilder getBuilder(){
        return new QRBuilder();
    }


    //build method
    public QR build(){
        return new QR(this);
    }

    //Getter and Setter
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public String getVpa() {
        return vpa;
    }

    public void setVpa(String vpa) {
        this.vpa = vpa;
    }



}
