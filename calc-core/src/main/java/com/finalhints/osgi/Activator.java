package com.finalhints.osgi;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.finalhints.osgi.api.CalculatorService;
import com.finalhints.osgi.api.impl.AddService;

@SpringBootConfiguration
@EnableAutoConfiguration
@Import(CoreConfig.class)
public class Activator implements BundleActivator {

	public static BundleContext bundleContext;
	ConfigurableApplicationContext appContext;

	@Override
	public void start(BundleContext context) throws Exception {
		Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
		appContext = SpringApplication.run(Activator.class);
		bundleContext = context;
		registerServices();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		bundleContext = null;
		SpringApplication.exit(appContext, () -> 0);
	}

	public static BundleContext getBundleContext() {
		return bundleContext;
	}

	private void registerServices() {
		CalculatorService service = new AddService();
		bundleContext.registerService(CalculatorService.class.getName(), service, new Hashtable<String, Object>());
		System.out.println("Service registered: " + service.name());
	}

	public static void main(String[] args) {
		SpringApplication.run(Activator.class, args);
	}

}
