package com.mobile.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="Resource",glue="com.mobileProgramming.test",tags= "@Test1")
public class TestRunner {

}
