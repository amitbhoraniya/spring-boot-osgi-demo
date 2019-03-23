package com.finalhints.osgi.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finalhints.osgi.Activator;
import com.finalhints.osgi.api.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

	@GetMapping
	public List<String> getAllOperations() {
		BundleContext bundleContext = Activator.getBundleContext();
		List<String> operations = new ArrayList<String>();
		try {
			Collection<ServiceReference<CalculatorService>> references = bundleContext
					.getServiceReferences(CalculatorService.class, null);
			for (ServiceReference<CalculatorService> reference : references) {
				CalculatorService calcService = bundleContext.getService(reference);
				operations.add(calcService.name());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return operations;
	}

	@GetMapping("/{operation}")
	public int execute(@PathVariable("operation") String operation, @RequestParam("n1") int n1,
			@RequestParam("n2") int n2) {
		BundleContext bundleContext = Activator.getBundleContext();
		try {
			Collection<ServiceReference<CalculatorService>> references = bundleContext
					.getServiceReferences(CalculatorService.class, null);
			for (ServiceReference<CalculatorService> reference : references) {
				CalculatorService calcService = bundleContext.getService(reference);
				if (calcService.name().equalsIgnoreCase(operation)) {
					return calcService.execute(n1, n2);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException("Invalid Operation");
	}
}
