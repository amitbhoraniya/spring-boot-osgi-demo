package com.finalhints.plugin;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.finalhints.osgi.api.CalculatorService;
import com.finalhints.plugin.impl.SubService;

public class Activator implements BundleActivator {

	public static BundleContext bundleContext;

	@Override
	public void start(BundleContext context) throws Exception {
		bundleContext = context;
		registerServices();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		bundleContext = null;
	}

	public static BundleContext getBundleContext() {
		return bundleContext;
	}

	private void registerServices() {
		CalculatorService service = new SubService();
		bundleContext.registerService(CalculatorService.class.getName(), service, new Hashtable<String, Object>());
		System.out.println("Service registered: " + service.name());
	}

}
