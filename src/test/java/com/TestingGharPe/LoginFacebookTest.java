package com.TestingGharPe;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginFacebookTest {
public WebDriver driver;
LoginFacebookPage lp = new LoginFacebookPage();
DataFile df = new DataFile();
  
@BeforeMethod
public void beforeMethod() throws IOException {
lp.openBrowser(df.openBrowser());
lp.openFacebook();
}

@AfterMethod
public void afterMethod() {
lp.closeBrowser();
}

@Test
public void loginWithWrongPasswordTest() throws InterruptedException {
lp.enterEmail(df.validEmail);
lp.enterPassword(df.password);
lp.readError();
String expectedErrorMsg = df.passwordError;
Assert.assertEquals(lp.readError(), expectedErrorMsg);
}

@Test
public void loginWithWrongEmailTest() throws InterruptedException {
lp.enterEmail(df.invalidEmail);
lp.enterPassword(df.password);
lp.readError();
String expectedErrorMsg = df.emailError;
Assert.assertEquals(lp.readError(), expectedErrorMsg);
}

}
