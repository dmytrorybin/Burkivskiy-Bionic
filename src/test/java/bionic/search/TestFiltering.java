package bionic.search;

import bionic.AbstractTest;
import bionic.steps.UnregisteredUser;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestFiltering extends AbstractTest {
    
    @Test
    public void testFilteringByVisualCategory() {
        UnregisteredUser user = new UnregisteredUser(window);
        user.openHomePage();
        user.goToChildrensWorldCategory();
        user.goToChildrensWearCategory();
        returnDriverFrom(user);
    }
    
    @Test
    public void testFilteringByStatusNew() {
        UnregisteredUser user = new UnregisteredUser(window);
        user.openChildrensWearCategory();
        user.selectFilterNewProducts();
        user.openRandomProduct();
        user.assertThatProductHasStateNew();
        returnDriverFrom(user);
    }
    
    @Test
    public void testFilteringByPrice() {
        UnregisteredUser user = new UnregisteredUser(window);
        user.openChildrensWearCategory();
        user.setPriceLimits();
        user.assertThatPriceOfProductOnFirstPageIsInFilterLimits();
        returnDriverFrom(user);
    }
}
