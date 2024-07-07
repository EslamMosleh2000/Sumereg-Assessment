package com.sumerge;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;

public class Task1_2 {


	WebDriver driver;


	@Test(priority = 0 , groups= {"All Element are Exist"})
	public void userNameIsExist() {
		WebElement userNameField = driver.findElement(By.id("user-name"));
		assertTrue(userNameField.isDisplayed());

	}

	@Test (priority = 1 , groups= {"All Element are Exist"})
	public void passwordIsExist() {
		WebElement PasswordField = driver.findElement(By.id("password"));
		assertTrue(PasswordField.isDisplayed());
	}


	@Test (priority = 2 , groups= {"All Element are Exist"})
	public void loginButtonIsExist() {
		WebElement loginButton = driver.findElement(By.id("login-button"));
		assertTrue(loginButton.isDisplayed());
	}



	@Test (priority = 3 , dependsOnGroups = {"All Element are Exist"} )
	public void tryValidLogin() {

		WebElement userNameField = driver.findElement(By.id("user-name"));
		userNameField.sendKeys("standard_user");

		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("secret_sauce");

		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();


		WebElement loginSign = driver.findElement(By.xpath("//div[text()='Swag Labs']"));
		String content = loginSign.getText();
		assertEquals(content,"Swag Labs");


	}



	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	}


	@AfterTest
	public void afterTest() {
		driver.quit();
	}



}
