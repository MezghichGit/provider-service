package com.sip.ams.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sip.ams.entities.Provider;
import com.sip.ams.services.ProviderService;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
@Slf4j
@RestController
@RequestMapping("/providers")
public class ProviderController {
	
	@Autowired
	private ProviderService providerService;
	
	@GetMapping("/")
	public List<Provider> getAllProvider(){
		log.info("Liste des providers chargée");
		return providerService.findAllProvider();
	}

	@PostMapping("/")
	public Provider addProvider(@RequestBody Provider provider)
	{
		log.info("Création de provider avec succès");
		return providerService.saveProvider(provider);
	}
	
	@GetMapping("/{id}")
	public Provider getProviderById(@PathVariable("id")Long id){
		log.info("Recherche du provider ayant l'id : "+ id+" avec succès");
		return providerService.findProviderById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProviderById(@PathVariable("id")Long id){
		log.info("Delete du provider ayant l'id : "+ id+" avec succès");
		 providerService.deleteProvider(id);
	}
	
	@PutMapping("/{id}")
	public void updateProviderById(@PathVariable("id")Long id, @RequestBody Provider newProvider){
		log.info("Update du provider ayant l'id : "+ id+" avec succès");
		 providerService.updateProvider(id, newProvider);
	}
}
