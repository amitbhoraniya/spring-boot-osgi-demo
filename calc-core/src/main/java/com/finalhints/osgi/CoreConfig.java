package com.finalhints.osgi;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.finalhints.osgi.controller.ControllerConfig;

@Configuration
@ComponentScan("com.finalhints.osgi")
@Import(ControllerConfig.class)
public class CoreConfig {

}
