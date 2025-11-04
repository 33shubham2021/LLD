package design_patterns.builder.qr_code;

public class PackageInfo {
    /**
     * Here is a typical example of QR code that we use for upi payment
     *
     * upi://pay?pa=7488230107@pthdfc&amp;pn=SHUBHAM
     *
     * the zigzag pattern that we see on the device is actually some string (like the above)
     * coded using some graphic algorithm to look like the QR code
     *
     * Generating a qr code string is a typical use case of builder design pattern,
     * because there are many '&' separated parameters present in the string (which the upi app like
     * Paytm, PhonePe, etc. reads), which will be sent to NPCI for procedding with the payment
     *
     * This is a static qr, in dynamic qr the amount information is also present.
     *
     * The typical information present in a qr are
     * payee vpa
     * amount
     * merchant ID (mid)
     * terminalId (tid)
     * qrType
     * merchant name
     * unique number for identification of QR
     *
     */
}
