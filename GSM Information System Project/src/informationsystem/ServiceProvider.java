package informationsystem;

public interface ServiceProvider {

    public void addSubscriptionPlan(SubscriptionPlan subscriptionPlans);

    public SubscriptionPlan findSubscriptionPlan(String name);

    public String getName();

    public void setName(String name);
}
