package appium.features.search;

import appium.question.CalculationResults;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import appium.tasks.CalculateNumber;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class CalculateNumberByKeywordStory {
    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void Addition(){
        anna.attemptsTo(
                CalculateNumber.withOperator("add").between(1).and(5).perform()
        );

        anna.should(
                seeThat(CalculationResults.Result(), equalTo("6"))
        );
    }

    @Test
    public void Subtract(){
        anna.attemptsTo(
                CalculateNumber.withOperator("sub").between(9).and(2).perform()
        );

        anna.should(
                seeThat(CalculationResults.Result(), equalTo("7"))
        );
    }

    @Test
    public void Multiply(){
        anna.attemptsTo(
                CalculateNumber.withOperator("mul").between(3).and(5).perform()
        );

        anna.should(
                seeThat(CalculationResults.Result(), equalTo("15"))
        );
    }

    @Test
    public void Divide(){
        anna.attemptsTo(
                CalculateNumber.withOperator("div").between(8).and(2).perform()
        );

        anna.should(
                seeThat(CalculationResults.Result(), equalTo("4"))
        );
    }

    @After
    public void AfterTest(){
        this.herBrowser.quit();
    }
}