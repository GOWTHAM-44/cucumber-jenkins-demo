package com.training.steps;

import com.training.app.Calculator; 
import io.cucumber.java.en.Given; 
import io.cucumber.java.en.Then; 
import io.cucumber.java.en.When; 
import org.testng.Assert; 
 
public class CalculatorSteps { 
 
    private int a; 
    private int b; 
    private int result; 
    private Calculator calculator = new Calculator(); 
 
    @Given("I have numbers {int} and {int}") 
    public void i_have_numbers_and(Integer first, Integer second) { 
        this.a = first; 
        this.b = second; 
    } 
 
    @When("I add the numbers") 
    public void i_add_the_numbers() { 
        result = calculator.add(a, b); 
    } 
 
    @When("I subtract the numbers") 
    public void i_subtract_the_numbers() { 
        result = calculator.subtract(a, b); 
    } 
 
    @Then("the result should be {int}") 
    public void the_result_should_be(Integer expected) { 
        Assert.assertEquals(result, expected.intValue()); 
    } 
} 