package br.com.bts.poccucumber;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasspathResource("features")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "json:target/cucumber-reports/cucumber.json")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "br.com.bts.poccucumber")
@ConfigurationParameter(key = Constants.SNIPPET_TYPE_PROPERTY_NAME, value = "camelcase")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@ConsultarUsuario")
public class CucumberRunnerTest {
}
