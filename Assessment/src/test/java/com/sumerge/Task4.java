package com.sumerge;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Task4 {

	WebDriver driver;
	@Test(priority = 0,dependsOnGroups = {"All Element are Exist"})
	public void tryEmptyUserName() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


		WebElement userNameField = driver.findElement(By.id("user-name"));
		userNameField.sendKeys("");

		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("");

		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();


		WebElement errorElement = driver.findElement(By.className("error-message-container"));
		String errorMessage = errorElement.getText();
		assertTrue(errorElement.isDisplayed());
		assertEquals(errorMessage,"Epic sadface: Username is required");




	}

	@Test(priority = 1,dependsOnGroups = {"All Element are Exist"})
	public void tryEmptyPassword() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


		WebElement userNameField = driver.findElement(By.id("user-name"));
		userNameField.sendKeys("RandomUserName");

		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("");

		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		WebElement errorElement = driver.findElement(By.className("error-message-container"));
		String errorMessage = errorElement.getText();
		assertTrue(errorElement.isDisplayed());
		assertEquals(errorMessage,"Epic sadface: Password is required");

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
