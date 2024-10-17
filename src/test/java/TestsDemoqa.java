import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class TestsDemoqa {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Vova");
        $("#lastName").setValue("letuchikh");
        $("#userEmail").setValue("Someemail@yandex.ru");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1993");
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__day--019").click();
        $("#subjectsInput").setValue("chemistry").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("bug.png");
        $("#currentAddress").setValue("www Leningrad");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Noida")).click();
        $("#submit").click();
        //Проверка
        $(".modal-body").shouldHave(text("Vova"));
        $(".modal-body").shouldHave(text("letuchikh"));
        $(".modal-body").shouldHave(text("Someemail@yandex.ru"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("1234567890"));
        $(".modal-body").shouldHave(text("19 March,1993"));
        $(".modal-body").shouldHave(text("Chemistry"));
        $(".modal-body").shouldHave(text("Music"));
        $(".modal-body").shouldHave(text("bug.png"));
        $(".modal-body").shouldHave(text("www Leningrad"));
        $(".modal-body").shouldHave(text("NCR"));
        $(".modal-body").shouldHave(text("Noida"));
    }
}
