package com.qa.quickstart.Tax;

public class RealTax {
	
	
	public double calcTax(double salary) {
		if (salary >0 && salary<15000) {
			return 0;
		}
		else if (salary >= 15000 && salary<20000) {
			return 0.1;
		}
		else if (salary >= 20000 && salary<30000) {
			return 0.15;
		}
		else if (salary >= 30000 && salary<45000) {
			return 0.2;
		}
		else if (salary >= 45000) {
			return 0.25;
		}
		else {
			return 1d;
		}
	}
	
	public double calcNet(double salary) {
		double percent = calcTax(salary);
		if (percent == 0) {
			return salary;
		}
		if (percent == 0.1) {
			return 14999 + ((salary-14999)*(1-percent));
		}
		if (percent == 0.15) {
			return 19499 + ((salary-19999)*(1-percent));
		}
		if (percent == 0.2) {
			return 27999 + ((salary-29999)*(1-percent));
		}
		if (percent == 0.25) {
			return 39999 + ((salary-44999)*(1-percent));
		}
		else {
			return 0;
		}
		
		

	}
}
