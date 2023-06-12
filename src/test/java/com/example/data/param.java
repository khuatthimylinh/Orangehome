package com.example.data;

import org.testng.annotations.DataProvider;

public class param {
   @DataProvider(name = "data")
    Object[][] dataAcount() {
		return new Object[][]{{"Admin", "admin123"}};
	}

	@DataProvider(name = "dataTimesheet")
    Object[][] dataTime() {
		return new Object[][]{{"Admin", "admin123", "coca", "1", "2", "3", "4", "5", "6", "7"}};
	}

	@DataProvider(name = "dataTimeInOut")
    Object[][] dataInOut() {
		return new Object[][]{{"05:45 PM", "06:00 PM"}};
	}

}
