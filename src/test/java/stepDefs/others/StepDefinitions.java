package stepDefs.others;

import io.cucumber.java.en.Given;

public class StepDefinitions {
    @Given("Text from Given")
    public void print_hello_world() {
        System.out.println("Hello, world - Given");
    }

    @Given("printed {string}")
    public void print_string(String stringToPrint) {
        System.out.println(stringToPrint);
    }
}
