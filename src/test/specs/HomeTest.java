import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.*;

public class HomeTest {

    HomePage home = new HomePage();

    @Test
    public void testPageUrlAndTitle() {
        // Open page url
        home
            .open()
            .assertUrl("https://practice.automationbro.com/");

        // Assert the title matches
        String title = title();
        assertEquals(title, "Practice E-Commerce Site – Automation Bro");
    }

    @Test
    public void testInteractingWithElements() {
        // Open page url
        open("https://practice.automationbro.com/");

        // By ID
        home.getStartedBtn().click();

        // verify url contains
        String url = WebDriverRunner.url();
        assertTrue(url.contains("get-started"));

        // verify heading by CssSelector
        home.headingTitle()
            .shouldHave(text("Think different. Make different."));

        // verify by XPath
        home.logoLink()
            .should(be(visible));
    }

    @Test
    public void testMultipleElements() {
        // Open page url
        open("https://practice.automationbro.com/");

        List<String> expectedLinks = List.of("Home", "About", "Shop", "Blog", "Contact", "My account");

//        ElementsCollection linkLists = home.linksList();
//        List<String> linkListsText = linkLists.texts();

//        ElementsCollection linkLists = $$(By.xpath("//*[@id=\"primary-menu\"] //li[starts-with(@id, \"menu-item\")]"));

        // assertion
        home.linksList().shouldHave(CollectionCondition.texts(expectedLinks));
//        assertEquals(linkListsText, expectedLinks);
    }
}
