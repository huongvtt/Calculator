package appium.tasks;

import appium.ui.CalculationScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CalculateNumber implements Task {
    String operator;
    Integer firstNumber;
    Integer secondNumber;

    public CalculateNumber (String operator, Integer firstNumber, Integer secondNumber) {
        this.operator = operator;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public static CalculateBuilder withOperator(String operator) {
        return new CalculateBuilder(operator);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        char[] myDigits = this.firstNumber.toString().toCharArray();
        int countDigits = myDigits.length;
        for (int i=0; i<countDigits; i++){
            actor.attemptsTo(
                    Click.on(CalculationScreen.GET_NUMBER(myDigits[i]))
            );
        }

        actor.attemptsTo(
                Click.on(CalculationScreen.GET_OPERATOR(this.operator))
        );

        myDigits = this.firstNumber.toString().toCharArray();
        countDigits = myDigits.length;
        for (int i=0; i<countDigits; i++){
            actor.attemptsTo(
                    Click.on(CalculationScreen.GET_NUMBER(myDigits[i]))
            );
        }
    }

    public static class CalculateBuilder {
        String _operator;
        Integer _firstNumber;
        Integer _secondNumber;

        public CalculateBuilder(String operator){
            this._operator = operator;
        }

        public CalculateBuilder between(Integer number){
            this._firstNumber = number;
            return this;
        }

        public CalculateBuilder and(Integer number){
            this._secondNumber = number;
            return this;
        }

        public CalculateNumber perform(){
            return instrumented(CalculateNumber.class, this._operator, this._firstNumber, this._secondNumber);
        }
    }
}
