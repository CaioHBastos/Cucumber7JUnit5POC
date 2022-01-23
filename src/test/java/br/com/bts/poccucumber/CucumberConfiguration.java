package br.com.bts.poccucumber;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@Configuration
@PropertySource({"classpath:application-test.properties"})
public class CucumberConfiguration {


}
