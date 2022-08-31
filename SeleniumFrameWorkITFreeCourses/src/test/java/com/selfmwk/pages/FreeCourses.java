package com.selfmwk.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mongodb.internal.operation.SyncOperations;

public class FreeCourses {
	WebDriver driver;
	JavascriptExecutor js;
	public FreeCourses(WebDriver lDriver)
	{
		this.driver=lDriver;
	}

	@FindBy(xpath="//li[@id='menu-item-13318']/a/span[contains(text(),'Free Courses')]") WebElement freeCourses;
	@FindBy(xpath="//div[@id='courses-panel']//p/span[@data-cy='search-showing-results-counter']") WebElement resultCount;
	@FindBy(xpath="//*[@id=\"lp-archive-courses\"]/div[3]/ul/li[1]/label") WebElement codeAcademyCheck;
	@FindBy(xpath="//*[@id=\"lp-archive-courses\"]/div[3]/ul/li[2]/label") WebElement chk2Data;
		@FindBy(xpath="//*[@id=\"lp-archive-courses\"]/div[3]/ul/li[3]/label") WebElement agileAndScrumCheck;
		@FindBy(xpath="//*[@id=\"lp-archive-courses\"]/div[3]/ul/li[4]/label") WebElement chk4Web;
		@FindBy(xpath="//*[@id=\"lp-archive-courses\"]/div[3]/ul/li[5]/label") WebElement chk5Database;
	@FindBy(xpath="//*[@id=\"lp-archive-courses\"]/div[3]/ul/li[6]/label") WebElement cyberSecurity;
	@FindBy(xpath="//*[@id=\"lp-archive-courses\"]/div[3]/ul/li[7]/label") WebElement chk7Software;
	@FindBy(xpath="//*[@id=\"lp-archive-courses\"]/div[3]/ul/li[8]/label") WebElement chk8Devops;
	@FindBy(xpath="//*[@id=\"lp-archive-courses\"]/div[3]/ul/li[9]/label") WebElement chk9cloud;
	@FindBy(xpath="//*[@id=\"lp-archive-courses\"]/div[3]/ul/li[10]/label") WebElement chk10Digital;
	@FindBy(xpath="//*[@id=\"lp-archive-courses\"]/div[3]/ul/li[11]/label") WebElement chk11K12;
	@FindBy(xpath="//*[@id=\"lp-archive-courses\"]/div[3]/ul/li[12]/label") WebElement chk12DataScience;
	@FindBy(xpath="//*[@id=\"lp-archive-courses\"]/div[3]/ul/li[13]/label") WebElement chk13Career;
	@FindBy(xpath="//div[@class='learn-press-message error']/p") WebElement noResulttext;
	@FindBy(xpath="//div[@class='col-md-3 col-xs-12 mobilepad0']/h5") WebElement filterText;
	@FindBy(xpath="//li[@for='aca_9247']") WebElement codeAcademy;

	//This method clicks on free courses and check if it goes to next page
	public boolean freeCourses()
	{
		boolean flag=false;
		System.out.println("the current url is: "+driver.getCurrentUrl());
		String beforeUrl=driver.getCurrentUrl();
		freeCourses.click();
		System.out.println("the number of courses shown is:"+resultCount.getText());
		System.out.println("the current url is: "+driver.getCurrentUrl());
		String afterUrl=driver.getCurrentUrl();
		if(!beforeUrl.equalsIgnoreCase(afterUrl))
		{
			System.out.println("Click is successfull and moved to next page");
			flag=true;
		}
		return flag;


	}

	//This method clicks on one filter : the codeacademy and checks if the result Count is changed accordingly

	public boolean filterWithOneCategory() throws InterruptedException
	{
		boolean flag1=false;
		int expectedCodeAcademyCount=16;
		
		Thread.sleep(3000);
		//System.out.println(filterText.getText());
		//System.out.println(codeAcademy.getText());
		String initialCount=resultCount.getText();
		int initCount=Integer.parseInt(initialCount);
		System.out.println("the initial count is: "+initCount);
		//codeAcademy.click();
		codeAcademyCheck.click();
		Thread.sleep(2000);
		String finalCount=resultCount.getText();
		int finCount=Integer.parseInt(finalCount);
		System.out.println("expected count:"+expectedCodeAcademyCount);

		System.out.println("the number of courses shown is:"+finCount);

		if (finCount==expectedCodeAcademyCount) {
			
			
				
				System.out.println("The count is expected  fliter count");
				flag1=true;
			
			
		}

		return flag1;



	}

	//clicking on additonal filter with previous one :agile and scrum and check if result count is showing both counts
	//added one more cyber security academy so now filter is three and checking the count shown.
	public boolean fliterWithMultipleCategory() throws InterruptedException
	{
		boolean flag2=false;
		int expectedAgileCount=4;
		int expectedcyberSecurity=8;
		String initialCount=resultCount.getText();
	
		int initCount=Integer.parseInt(initialCount);
		System.out.println("the initial count is: "+initCount);
		
		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", agileAndScrumCheck);

		agileAndScrumCheck.click();
		Thread.sleep(2000);
		cyberSecurity.click();
		Thread.sleep(2000);
		String finalCount=resultCount.getText();
		int finCount=Integer.parseInt(finalCount);
		System.out.println("the number of courses shown is:"+finCount);
		int expectedFinCount=initCount+expectedAgileCount+expectedcyberSecurity;
		
		if (finCount==expectedFinCount) {

			System.out.println("The count is changed to expected filter count");
			flag2=true;
		}
		
		return flag2;
	}
	
	//to check if the total count is same when selecting all the filter by academy
	//first clearing earlier selected ones.
	
	public boolean filterByAcademyAllCheckboxes() throws InterruptedException
	{
		boolean flag3=false;
		codeAcademyCheck.click();
		agileAndScrumCheck.click();
		cyberSecurity.click();
		Thread.sleep(5000);
		
		String initialCount=resultCount.getText();
		int initCount=Integer.parseInt(initialCount);
		System.out.println("the initial count is: "+initCount);
		
		codeAcademyCheck.click();
		
		chk2Data.click();
		agileAndScrumCheck.click();
		Thread.sleep(3000);
		chk4Web.click();
		chk5Database.click();
		cyberSecurity.click();
		Thread.sleep(3000);
		chk7Software.click();
		chk8Devops.click();
		chk9cloud.click();
		Thread.sleep(3000);
		chk10Digital.click();
		chk11K12.click();
		chk12DataScience.click();
		Thread.sleep(3000);
		chk13Career.click();
		Thread.sleep(2000);
		
		
		
		System.out.println("All checkboxes selected for filter by academy");
		String finalCount=resultCount.getText();
		int finCount=Integer.parseInt(finalCount);
		System.out.println("the number of courses shown is:"+finCount);
		if (finCount==initCount) {

			System.out.println("The count is same as full count");
			flag3=true;
		}
		
		
		
		
		
		return flag3;
	}




}
