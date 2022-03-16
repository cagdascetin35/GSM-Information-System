/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationsystem;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cagdas
 */
public class CableProviderTest {
    CableProvider prov;
    CableProvider prov2;
    SubscriptionPlan plannaz;
    SubscriptionPlan plancan;
    public CableProviderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        prov = new CableProvider("sucuk");
        plannaz = new SubscriptionPlan("C plani",prov);
        
        prov2 = new CableProvider("yumurta");
        plancan = new SubscriptionPlan("D plani",prov2);
        
        prov2.addSubscriptionPlan(plancan);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addSubscriptionPlan method, of class CableProvider.
     */
    @Test
    public void testAddSubscriptionPlan() {
        prov.addSubscriptionPlan(plannaz);
        assertEquals(plannaz, prov.findSubscriptionPlan("C plani"));
    }

    /**
     * Test of findSubscriptionPlan method, of class CableProvider.
     */
    @Test
    public void testFindSubscriptionPlan() {
        assertEquals(plancan, prov2.findSubscriptionPlan("D plani"));
    }
}
