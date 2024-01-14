package com.Ecommerce.dataProvider;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
	
    @DataProvider(name = "usernames")
    public Object[][] usernames() {
        return new Object[][] {
            {"standard_user"},
            {"locked_out_user"},
            {"problem_user"},
            {"performance_glitch_user"},
            {"error_user"},
            {"visual_user"}
        };
    }

}
