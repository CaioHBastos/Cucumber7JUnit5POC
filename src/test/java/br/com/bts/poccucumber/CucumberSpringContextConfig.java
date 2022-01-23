package br.com.bts.poccucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = { CucumberConfiguration.class })
public class CucumberSpringContextConfig {
}
