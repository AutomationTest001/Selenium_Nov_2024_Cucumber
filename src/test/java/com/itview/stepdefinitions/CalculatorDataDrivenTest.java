package com.itview.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculatorDataDrivenTest {

	WebDriver w;

	@Before("@DataDriven")
	public void preCondition() {

		w = new EdgeDriver();
	}

	@Given("Open chrome and navigate to calculate page")
	public void open_chrome_and_navigate_to_calculate_page() {

		w.get("https://juliemr.github.io/protractor-demo/");

	}

	@When("Enter two numbers {string} and {string} with operator {string}")
	public void enter_two_numbers_and_with_operator(String firstNumber, String secondNumber, String operator)
			throws Exception {

		w.findElement(By.xpath("/html/body/div/div/form/input[1]")).clear();
		w.findElement(By.xpath("/html/body/div/div/form/input[1]")).sendKeys(firstNumber);

		WebElement operator_dropdown = w.findElement(By.xpath("/html/body/div/div/form/select"));
		Select sc = new Select(operator_dropdown);
		sc.selectByVisibleText(operator);

		w.findElement(By.xpath("/html/body/div/div/form/input[2]")).clear();
		w.findElement(By.xpath("/html/body/div/div/form/input[2]")).sendKeys(secondNumber);

		w.findElement(By.id("gobutton")).click();
		Thread.sleep(2000);
	}

	@Then("Validate output {string}")
	public void validate_output(String OutputValue) throws Exception {

		String output = w.findElement(By.xpath("/html/body/div/div/form/h2")).getText();
		Thread.sleep(2000);
		Assert.assertEquals(OutputValue, output);
		Thread.sleep(2000);

	}

	@After("@DataDriven")
	public void postCondition() {
		w.quit();
	}

}
