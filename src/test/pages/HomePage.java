import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class HomePage {

    public HomePage open() {
        Selenide.open("https://practice.automationbro.com/");
        return this;
    }

    public SelenideElement getStartedBtn() {
        return $(By.id("get-started"));
    }

    public SelenideElement headingTitle() {
        return $("h1");
    }

    public SelenideElement logoLink() {
        return $(By.xpath("//a[@class=\"custom-logo-link\"]"));
    }

    public ElementsCollection linksList() {
        return $$("#primary-menu li[id*=menu-item]");
    }

    public void assertUrl(String expectedUrl) {
        String url = WebDriverRunner.url();
        assertEquals(url, expectedUrl);
    }
}
