package com.sip.ams;

import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.sip.ams.entities.Provider;
import com.sip.ams.services.ProviderService;

import java.util.*;
@SpringBootApplication
@EnableDiscoveryClient
public class MiProviderServiceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MiProviderServiceApplication.class, args);
	}
	@Autowired
	ProviderService providerService;
	@Override
	public void run(String... args) throws Exception {
		List<Provider> providers = Arrays.asList(
				new Provider(null,"Samsung","Korea Sud"),
				new Provider(null,"Huawei","Chine"),
				new Provider(null,"HP","USA"),
				new Provider(null,"Toshiba","Japon")
				);
		Stream<Provider> sproviders = providers.stream();
		sproviders.forEach((Provider p) -> { providerService.saveProvider(p);});
		providerService.findAllProvider().forEach(System.out::println);
	}

}
