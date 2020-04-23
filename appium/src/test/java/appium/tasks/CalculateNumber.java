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
        actor.attemptsTo(
                Click.on(getNumber(this.firstNumber)),
                Click.on(getOperator(this.operator)),
                Click.on(getNumber(this.secondNumber))
        );
    }

    private Target getNumber(Integer number){
        Target myTarget;
        switch (number) {
            case 1:
                myTarget = CalculationScreen.NUMBER_1;
                break;
            case 2:
                myTarget = CalculationScreen.NUMBER_2;
                break;
            case 3:
                myTarget = CalculationScreen.NUMBER_3;
                break;
            case 4:
                myTarget = CalculationScreen.NUMBER_4;
                break;
            case 5:
                myTarget = CalculationScreen.NUMBER_5;
                break;
            case 6:
                myTarget = CalculationScreen.NUMBER_6;
                break;
            case 7:
                myTarget = CalculationScreen.NUMBER_7;
                break;
            case 8:
                myTarget = CalculationScreen.NUMBER_8;
                break;
            case 9:
                myTarget = CalculationScreen.NUMBER_9;
                break;
            default:
                myTarget = CalculationScreen.NUMBER_0;
                break;
        }
        return myTarget;
    }

    private Target getOperator(String operator){
        Target myTarget;
        switch (operator) {
            case "add":
                myTarget = CalculationScreen.ADD_OPERATOR;
                break;
            case "sub":
                myTarget =  CalculationScreen.SUB_OPERATOR;
                break;
            case "div":
                myTarget =  CalculationScreen.DIV_OPERATOR;
                break;
            default:
                myTarget =  CalculationScreen.MUL_OPERATOR;
                break;
        }
        return myTarget;
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
