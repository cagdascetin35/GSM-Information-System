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
public class GSMProviderTest {
    GSMProvider prov;
    GSMProvider prov2;
    SubscriptionPlan plansu;
    SubscriptionPlan plannur;
    public GSMProviderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        prov = new GSMProvider("kofte");
        plansu = new SubscriptionPlan("A plani",prov);
        
        prov2 = new GSMProvider("ekmek");
        plannur = new SubscriptionPlan("B plani",prov2);
        
        prov2.addSubscriptionPlan(plannur);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addSubscriptionPlan method, of class GSMProvider.
     */
    @Test
    public void testAddSubscriptionPlan() {
        prov.addSubscriptionPlan(plansu);
        assertEquals(plansu, prov.findSubscriptionPlan("A plani"));
    }

    /**
     * Test of findSubscriptionPlan method, of class GSMProvider.
     */
    @Test
    public void testFindSubscriptionPlan() {
        assertEquals(plannur, prov2.findSubscriptionPlan("B plani"));
    }
}
