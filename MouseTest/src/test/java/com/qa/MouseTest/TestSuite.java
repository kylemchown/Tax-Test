package com.qa.MouseTest;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.relevantcodes.extentreports.ExtentReports;

@RunWith(Suite.class)
@SuiteClasses({AccordianTest.class, DragDropTest.class, SelectTest.class})


public class TestSuite {
	public static String dateTime()	{
		LocalDateTime current = LocalDateTime.now();
		String currentStr = current.toString();
		String out = "";
		for (int i = 0; i < currentStr.length()-4; i++)	{
			if (currentStr.charAt(i) == ':') out += '_';
			else if (currentStr.charAt(i) == 'T') out += ' ';
			else out += currentStr.charAt(i);
		}
		return out;
	}
	
	
	public static ExtentReports report  = new 
			ExtentReports("C:\\Users\\Admin\\Desktop\\Report\\ReportTest "+ dateTime() +".html", true);
	
}
