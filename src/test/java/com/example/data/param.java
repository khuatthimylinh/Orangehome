package com.example.data;

import org.testng.annotations.DataProvider;

public class param {
   @DataProvider(name = "account")
    Object[][] dataAcount() {
	return new Object[][]{{"Admin", "admin123"}};
}

}
