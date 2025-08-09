package DesignPatterns.Abstract;

interface PaymentGateway {
    void processPayment(double amount);
}

interface Invoice {
    void generateInvoice(double amount);
}

interface RegionFactory {
    PaymentGateway createPaymentGateway(String type);

    Invoice createInvoice();
}

class RazorPay implements PaymentGateway {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount + " through RazorPay.");
    }
}

class PayU implements PaymentGateway {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount + " through PayU.");
    }
}

class Stripe implements PaymentGateway {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount + " through Stripe.");
    }
}

class GSTInvoice implements Invoice {

    @Override
    public void generateInvoice(double amount) {
        System.out.println("Generating GST invoice for " + amount);
    }
}

class VATInvoice implements Invoice {

    @Override
    public void generateInvoice(double amount) {
        System.out.println("Generating VAT invoice for " + amount);
    }
}

class IndiaRegionFactory implements RegionFactory {
    @Override
    public PaymentGateway createPaymentGateway(String paymentType) {
        switch (paymentType) {
            case "RazorPay":
                return new RazorPay();
            case "PayU":
                return new PayU();
            default:
                return null;
        }
    }

    @Override
    public Invoice createInvoice() {
        return new GSTInvoice();
    }
}

class USRegionFactory implements RegionFactory {

    @Override
    public PaymentGateway createPaymentGateway(String type) {
        switch (type) {
            case "Stripe":
                return new Stripe();
            default:
                return null;
        }
    }

    @Override
    public Invoice createInvoice() {
        return new VATInvoice();
    }
}

class CheckOutService {
    private String paymentType;
    private Invoice invoice;
    private PaymentGateway paymentGateway;

    public CheckOutService(RegionFactory factory, String paymentType) {
        this.paymentType = paymentType;
        this.invoice = factory.createInvoice();
        this.paymentGateway = factory.createPaymentGateway(paymentType);
    }

    public void calculate(double amount) {
        paymentGateway.processPayment(amount);
        invoice.generateInvoice(amount);
    }
}

public class Payment {
    public static void main(String[] args) {
        RegionFactory indiaFactory = new IndiaRegionFactory();
        CheckOutService indiaCheckOut = new CheckOutService(indiaFactory, "RazorPay");
        indiaCheckOut.calculate(1000);

        RegionFactory usFactory = new USRegionFactory();
        CheckOutService usCheckOut = new CheckOutService(usFactory, "Stripe");
        usCheckOut.calculate(2000);

    }
}