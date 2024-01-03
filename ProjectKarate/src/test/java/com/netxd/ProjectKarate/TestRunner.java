package com.netxd.ProjectKarate;

import com.intuit.karate.junit5.Karate;

public class TestRunner {

	  @Karate.Test
	    Karate runAllTests() {
	        return Karate.run("classpath:features/businessCustomerOnboard.feature").relativeTo(getClass());
	    }
}
