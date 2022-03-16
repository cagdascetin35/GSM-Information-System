package informationsystem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InformationSystem {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);                                               //klavyeden girdi almak için scanner tanımlıyorum
        
        System.out.println("GSM SERVICE PROVIDER ? :  ");
        GSMProvider GsmNew = new GSMProvider(scanner.nextLine());                               // adını alıp GSM provider ı oluşturuyorum
        
        System.out.println("NUMBER OF SUBSCRIPTION PLANS ? :  ");
        int number = scanner.nextInt();                                                         //subscription plan sayısını alıyorum
        scanner.nextLine();                                                                     //oluşma ihtimali olan sorunları çözmek için eklediğim bir girdi satırı
        
        for(int i=0; i<number; i++){                                                            //planları girmek için aldığım sayıyı for döngüsünde kullanıyorum
            System.out.println("NAME OF THE Plan #" + (i+1) + " ?:  ");
            SubscriptionPlan plan = new SubscriptionPlan (scanner.nextLine());                  // SubscriptionPlan türünde plan object i oluşturuyorum
            plan.setServiceProvider(GsmNew);
            GsmNew.addSubscriptionPlan(plan);                                                   //oluşturduğum plan object ini subscriptionPlan lara ekliyorum
        }
        
        System.out.println("CUSTOMER CITIZENSHIP NUMBER ? :  ");
        ExistingCustomer CusNew = new ExistingCustomer(scanner.nextLine());                     //Burada Customer oluşturuyorum
        
        System.out.println("CUSTOMER NAME ? :  ");
        CusNew.setName(scanner.nextLine());                                                     //Customer ın adını veriyorum
        
        System.out.println("NAME OF THE PLAN TO BE SUBSCRIBED ? :  ");
        String planname = scanner.nextLine();                                                   //istenilen plan adını alıyorum
        while(GsmNew.findSubscriptionPlan(planname)==null){                                     //plan adı planlar arasında yoksa while a giriyor
            System.out.println("THIS PLAN DOESN'T EXIST, TRY AGAIN:  ");                        //tekrar plan adı istiyorum
            planname = scanner.nextLine();                                                      //tekrar plan adı giriyorum
        }                                                                                       //var olan bir plan yazana kadar while dönüyor
        
        SubscriptionPlan splan = GsmNew.findSubscriptionPlan(planname);                         //seçilen plan adıyla SubscriptionPlan türünde splan object i oluşturuyorum
        System.out.println("START DATE FOR SUBSCRIPTION (MM/DD/YYYY)? :  ");
        String dateStr = scanner.nextLine();                                                    //tarihi string olarak giriyorum
        Date date = new SimpleDateFormat("MM/dd/yyyy").parse(dateStr);                          //tarih formatına dönüştürüyorum
        Subscription subscr = new Subscription(date,splan);                                     //tarih ve splan object i ile subscription object i oluşturuyorum
        CusNew.setSubscription(subscr);                                                         //customer a subscription ı bağlıyorum
        
        
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strDate = formatter.format(CusNew.getSubscription().getSubscriptionStartDate()); //tarihi yazdıracağım için geri string formatına dönüştürüyorum
        
        System.out.println("CUSTOMER CITIZENSHIP NUMBER : " + CusNew.getCitizenshipNr());
        System.out.println("CUSTOMER NAME : " + CusNew.getName());
        System.out.println("SERVICE PROVIDER : " + CusNew.getSubscription().getSubscriptionPlan().getServiceProvider().getName());
        System.out.println("SUBSCRIPTION START DATE : " + strDate);
        System.out.println("SUBSCRIPTION PLAN NAME :  " + CusNew.getSubscription().getSubscriptionPlan().getName());
        
    }
}
