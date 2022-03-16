package informationsystem;

public class GSMProvider implements ServiceProvider {

    private String name;

    private final SubscriptionPlan[] subscriptionPlans;

    int a=0;                                                                //dizide kullanmak için eleman tanımlıyorum
    
    public GSMProvider(String name) {
        this.name = name;
        this.subscriptionPlans = new SubscriptionPlan[30];                  //eklenecek planlar için dizi oluşturuyorum
    }

    @Override
    public void addSubscriptionPlan(SubscriptionPlan subscriptionPlans) {
        this.subscriptionPlans[a]=subscriptionPlans;                        //InformationSystem den gönderdiğim planları diziyi atıyorum
        a++;                                                                //dizisinin sonraki elemanına geçmek için artırıyorum
    }

    
    @Override
    public SubscriptionPlan findSubscriptionPlan(String name) {
        for(int i = 0; i<a; i++){                                           //a değişkeninin son hali dizinin uzunluğunu belirttiği için for döngüsü tanımlıyorum
            if(subscriptionPlans[i].getName().equals(name)){                //dizinin içerisinde bulmak istediğim plan adını arıyorum
                return subscriptionPlans[i];                                //planı bulunca return ediyorum
            }
        }
        return null;                                                        //planı bulamazsa geri null gönderiyorum
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }
}
