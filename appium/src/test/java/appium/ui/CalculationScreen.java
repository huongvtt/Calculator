package appium.ui;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

public class CalculationScreen{
    public static final Target GET_NUMBER(char number){
        return Target.the("The number " + number)
                .located(By.xpath("//span[@dcg-command=\"" + number + "\"]"));
    }
    public static final Target GET_OPERATOR(String operator){
        return Target.the("The operator " + operator)
                .located(By.xpath("//span[@dcg-command=\"" + operator + "\"]"));
    }

    public static final Target RESULT = Target.the("calculation result")
            .located(By.cssSelector("div.dcg-exp-output-container span.dcg-mq-root-block"));
}
