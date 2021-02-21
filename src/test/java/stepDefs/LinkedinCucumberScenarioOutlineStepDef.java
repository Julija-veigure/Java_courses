package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;


public class LinkedinCucumberScenarioOutlineStepDef {
    int initialBillAmount;
    double taxRate;

    @Given("I have a Customer")
    public void i_have_a_customer() {
    }

    @Given("user enters initial bill amount as {int}")
    public void user_enters_initial_bill_amount_as_bill_amout(Integer initialBillAmount) {
        this.initialBillAmount = initialBillAmount;
        System.out.println("Bill amount: " + initialBillAmount);
    }

    @Given("Sales Tax Rate is {double} percent")
    public void sales_tax_rate_is_tax_rate_percent(Double taxRate) {
        this.taxRate = taxRate;
        System.out.println("Tax rate: " + taxRate);
    }
    private void invokeWebPage() {
        System.out.println();
    }
    @Then("final bill amount calculate is {double}")
    public void final_bill_amount_calculate_is_calculated_bill_amount(Double expectedValue) {
//        BillCalculationHelper.caculateBillForCustomer(this.initialBillAmount, this.taxRate)

        double systemCalcValue = initialBillAmount + (initialBillAmount / 100 * taxRate);
        System.out.println("Expected Value: " + expectedValue);
        System.out.println("Calculated Value: " + systemCalcValue);
        Assertions.assertEquals(expectedValue, systemCalcValue, "Error!");
        Assertions.assertTrue(expectedValue.equals(systemCalcValue), "Error");



    }
}
