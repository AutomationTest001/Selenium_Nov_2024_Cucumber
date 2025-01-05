package com.itview.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {
	
WebDriver w;
	
	@Given("Browser should be open with login page")
	public void browser_should_be_open_with_login_page() {
	    
		w=new EdgeDriver();
		w.get("http://altoromutual.com:8080/login.jsp");
		
	}

	@When("User should enter Username and Password and click on login button")
	public void user_should_enter_username_and_password_and_click_on_login_button() throws Exception {
	    
		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(2000);
		
	}

	@Then("Home Page should get open and title should be Altoro Mutual")
	public void home_page_should_get_open_and_title_should_be_altoro_mutual() {
		
		String pageTitle=w.getTitle();		
		Assert.assertEquals("Altoro Mutual", pageTitle);
		w.quit();
	   
	}


}
