package appium.ui;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

public class CalculationScreen{
    public static final Target NUMBER_0 = Target.the("#0 number")
            .located(By.id("com.google.android.calculator:id/digit_0"));

    public static final Target NUMBER_1 = Target.the("#1 number")
            .located(By.id("com.google.android.calculator:id/digit_1"));

    public static final Target NUMBER_2 = Target.the("#2 number")
            .located(By.id("com.google.android.calculator:id/digit_2"));

    public static final Target NUMBER_3 = Target.the("#3 number")
            .located(By.id("com.google.android.calculator:id/digit_3"));

    public static final Target NUMBER_4 = Target.the("#4 number")
            .located(By.id("com.google.android.calculator:id/digit_4"));

    public static final Target NUMBER_5 = Target.the("#5 number")
            .located(By.id("com.google.android.calculator:id/digit_5"));

    public static final Target NUMBER_6 = Target.the("#6 number")
            .located(By.id("com.google.android.calculator:id/digit_6"));

    public static final Target NUMBER_7 = Target.the("#7 number")
            .located(By.id("com.google.android.calculator:id/digit_7"));

    public static final Target NUMBER_8 = Target.the("#8 number")
            .located(By.id("com.google.android.calculator:id/digit_8"));

    public static final Target NUMBER_9 = Target.the("#9 number")
            .located(By.id("com.google.android.calculator:id/digit_9"));

    public static final Target ADD_OPERATOR = Target.the("add operator")
            .located(By.id("com.google.android.calculator:id/op_add"));

    public static final Target DIV_OPERATOR = Target.the("divide operator")
            .located(By.id("com.google.android.calculator:id/op_div"));

    public static final Target MUL_OPERATOR = Target.the("multiply operator")
            .located(By.id("com.google.android.calculator:id/op_mul"));

    public static final Target SUB_OPERATOR = Target.the("subtract operator")
            .located(By.id("com.google.android.calculator:id/op_sub"));

    public static final Target RESULT = Target.the("calculation result")
            .located(By.id("com.google.android.calculator:id/result_preview"));
}
