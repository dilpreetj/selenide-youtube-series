import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTest {

    @Test
    public void testFormFields() {
        // Open url
        open("https://practice.automationbro.com/support-form");

        // fill in all the fields
        $(".support-name input").val("Luffy");
        $(".support-email input").val("luffy@onepiece.com");
        $(".support-subject input").val("Need help with repairing my ship");

        // dropdown and checkbox
        $(".support-dropdown select").selectOption("Technical Team");
        $(".support-checkboxes ul li:nth-child(2) input").click();

        // date input field
        $(".support-date input").click();
        $(".flatpickr-day.nextMonthDay").click();

        // click the submit button
        $("button[type=submit]").click();

        // verify the submit message
        $("div[role=alert]").shouldHave(Condition.text("Thanks for contacting us! We will be in touch with you shortly"));
    }
}
