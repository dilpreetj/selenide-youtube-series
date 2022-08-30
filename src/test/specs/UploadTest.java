import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class UploadTest {
    @Test
    public void testUploadFileOnVisibleInput() {
        // open url
        open("https://the-internet.herokuapp.com/upload");

        // upload file
        $("#file-upload").uploadFile(new File("src/test/data/sample.png"));

        // click the upload button
        $("#file-submit").click();

        // verify successful text
        $("h3").shouldHave(text("File Uploaded!"));
    }

    @Test
    public void testUploadFileOnHiddenInput() {
        // open url
        open("https://practice.automationbro.com/cart/");

        // execute js code
        executeJavaScript("document.getElementById(\"upfile_1\").classList.remove(\"file_input_hidden\")");

        // upload file
        $("#upfile_1").uploadFile(new File("src/test/data/sample.png"));

        // click the upload button
        $("#upload_1").click();

        // verify successful text
        $("#wfu_messageblock_header_1_label_1").shouldHave(text("uploaded successfully"));
    }
}
