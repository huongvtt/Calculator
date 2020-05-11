package appium.features.calculator;

import appium.question.CalculationResults;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
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
        anna.attemptsTo(Open.url("https://www.desmos.com/scientific"));
    }

    @Test
    public void Addition(){
        anna.attemptsTo(
                CalculateNumber.withOperator("Plus").between(190).and(5).perform()
        );

        anna.should(
                seeThat(CalculationResults.Result(), equalTo("195"))
        );
    }

    @Test
    public void Subtract(){
        anna.attemptsTo(
                CalculateNumber.withOperator("Minus").between(9).and(2).perform()
        );
        anna.should(
                seeThat(CalculationResults.Result(), equalTo("7"))
        );
    }

    @Test
    public void Multiply(){
        anna.attemptsTo(
                CalculateNumber.withOperator("Times").between(3).and(5).perform()
        );

        anna.should(
                seeThat(CalculationResults.Result(), equalTo("15"))
        );
    }

    @Test
    public void Divide(){
        anna.attemptsTo(
                CalculateNumber.withOperator("Divide").between(8).and(2).perform()
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