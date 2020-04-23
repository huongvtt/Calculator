package appium.question;

import appium.ui.CalculationScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class CalculationResults implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(CalculationScreen.RESULT).viewedBy(actor).asString();
    }

    public static Question<String> Result(){
        return new CalculationResults();
    }
}
