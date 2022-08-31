package com.selfmwk.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selfmwk.pages.BaseClass;
import com.selfmwk.pages.FreeCourses;

public class TestCases extends BaseClass {
	
	@Test
	public void FreeCoursesNarrowByResultsCorrectCount() throws InterruptedException
	{
		FreeCourses fc=PageFactory.initElements(driver, FreeCourses.class);
		boolean flag1=fc.freeCourses();
		System.out.println(flag1);
		boolean flag2=fc.filterWithOneCategory();
		System.out.println(flag2);
		boolean flag3=fc.fliterWithMultipleCategory();
		System.out.println(flag3);
		boolean flag4=fc.filterByAcademyAllCheckboxes();
		System.out.println(flag4);
		Assert.assertTrue(flag1&&flag2&&flag3&&flag4);
		System.out.println("The test case is passed");
		
	}
	

}
