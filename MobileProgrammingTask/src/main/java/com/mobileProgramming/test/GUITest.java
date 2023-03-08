package com.mobileProgramming.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.utility.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GUITest extends Base {

	
	List<String> data1 = new ArrayList<String>();
	List<String> data2 = new ArrayList<String>() ;
	
	@Given("user is on chromeBrowser")
	public void launch() throws Throwable {
		launchBrowser("Chrome");
		
	}
	
	@Given("user is on reactjs page")
	public void user_is_on_google_page() {
	openApp("https://reactjs.org/");
		
	}
	

	@Given("user is clicks on docs tab")
	public void docsClick() {
		driver.findElement(By.xpath("//a[text()='Docs']")).click();

	}

	@Then("user expand main concept")
	public void mainExpand() throws Throwable {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Main Concepts']/parent::button")).click();

	}

	@Then("user write main concept all data into file")
	public void writeData() throws Throwable {
		List<WebElement> list = driver
				.findElements(By.xpath("//div[text()='Main Concepts']/parent::button//following-sibling::ul/li/a"));

		for (int i = 0; i < list.size(); i++) {
			data1.add(list.get(i).getText());

		}
		
		
		File f=new File(System.getProperty("user.dir")+"//Output//Output.txt");
		BufferedWriter f1 = new BufferedWriter(new FileWriter(f, true));
		for (String s : data1) {
			f1.write(s);
			f1.newLine();
			
		}
		f1.close();
	}
	
	@Then("user write all Advanced guide data into file")
	public void writeData1() throws Throwable {
		driver.findElement(By.xpath("//div[text()='Main Concepts']/parent::button")).click();
		
		List<WebElement> list = driver
				.findElements(By.xpath("//div[text()='Advanced Guides']/parent::button//following-sibling::ul/li/a"));

		for (int i = 0; i < list.size(); i++) {
			data1.add(list.get(i).getText());

		}
		
		
		File f=new File(System.getProperty("user.dir")+"//Output//Output.txt");
		BufferedWriter f1 = new BufferedWriter(new FileWriter(f, true));
		for (String s : data1) {
			f1.write(s);
			f1.newLine();
			
		}
		f1.close();
	}

	@Then("user expand Advanced guide")
	public void advancedExpand() throws Throwable {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Advanced Guides']/parent::button")).click();

	}
	@Then("user close browser")
	public void close() throws Throwable {

		driver.quit();
	}

	@Given("user is clicks on tutorial tab")
	public void tutorialClick() {
		driver.findElement(By.xpath("//a[text()='Tutorial']")).click();

	}

	@Then("user verify scroll down function")
	public void scroll() throws Throwable {

		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		List<WebElement> findElements = driver
				.findElements(By.xpath("//div[text()='Tutorial']//parent::button//following-sibling::ul/li/a"));
		for (WebElement e : findElements) {
			js.executeScript("arguments[0].scrollIntoView(true)", e);
		}
	}
}
