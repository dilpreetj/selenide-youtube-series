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

    @Test
    public void testPageUrlAndTitle() {
        // Open page url
        open("https://practice.automationbro.com/");

        // Assert the url matches
        String url = WebDriverRunner.url();
        assertEquals(url, "https://practice.automationbro.com/");

        // Assert the title matches
        String title = title();
        assertEquals(title, "Practice E-Commerce Site – Automation Bro");
    }

    @Test
    public void testInteractingWithElements() {
        // Open page url
        open("https://practice.automationbro.com/");

        // By ID
        $(By.id("get-started")).click();

        // verify url contains
        String url = WebDriverRunner.url();
        assertTrue(url.contains("get-started"));

        // verify heading by CssSelector
        $("h1")
            .shouldHave(text("Think different. Make different."));

        // verify by XPath
        $(By.xpath("//a[@class=\"custom-logo-link\"]"))
            .should(be(visible));
    }

    @Test
    public void testMultipleElements() {
        // Open page url
        open("https://practice.automationbro.com/");

        List<String> expectedLinks = List.of("Home", "About", "Shop", "Blog", "Contact", "My account");

        ElementsCollection linkLists = $$("#primary-menu li[id*=menu-item]");

//        List<String> linkListsText = linkLists.texts();

        // assertion
        linkLists.shouldHave(CollectionCondition.texts(expectedLinks));
//        assertEquals(linkListsText, expectedLinks);
    }
}
