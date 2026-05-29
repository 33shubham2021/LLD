package design_patterns.builder.qr_code;

public class QR {

    private final String separator = "&";

    private String vpa;
    private Double amount;
    private String mid;
    private String tid;
    private String merchantName;
    private String txnId;

    public static QRBuilder getBuilder() {
        return new QRBuilder();
    }

    private QR(QRBuilder builder) {
        this.vpa = builder.getVpa();
        this.amount = builder.getAmount();
        this.mid = builder.getMid();
        this.tid = builder.getTid();
        this.merchantName = builder.getMerchantName();
        this.txnId = builder.getTxnId();
    }

    public String getQrString(){
        StringBuilder sb = new StringBuilder();
        return "upi://pay?" +
                "pa=" + this.vpa + separator +
                "amt=" + this.amount.toString() + separator +
                "mid=" + this.mid + separator +
                "tid=" + this.tid + separator +
                "pn=" + this.merchantName + separator +
                "tr=" + this.txnId;

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

    // Adding the builder class
    public static class QRBuilder {
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

        public QRBuilder setAmount(Double amount) {
            this.amount = amount;
            return this;
        }

        public String getMid() {
            return mid;
        }

        public QRBuilder setMid(String mid) {
            this.mid = mid;
            return this;
        }

        public String getTid() {
            return tid;
        }

        public QRBuilder setTid(String tid) {
            this.tid = tid;
            return this;
        }

        public String getMerchantName() {
            return merchantName;
        }

        public QRBuilder setMerchantName(String merchantName) {
            this.merchantName = merchantName;
            return this;
        }

        public String getTxnId() {
            return txnId;
        }

        public QRBuilder setTxnId(String txnId) {
            this.txnId = txnId;
            return this;
        }

        public String getVpa() {
            return vpa;
        }

        public QRBuilder setVpa(String vpa) {
            this.vpa = vpa;
            return this;
        }

    }
}
