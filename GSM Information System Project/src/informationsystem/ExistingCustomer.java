package informationsystem;

public class ExistingCustomer extends Customer {

    private Subscription subscription;

    public ExistingCustomer(String CitizenshipNr) {
        super(CitizenshipNr);
    }

    public ExistingCustomer(Subscription subscription, String CitizenshipNr) {
        super(CitizenshipNr);
        this.subscription = subscription;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    
}
