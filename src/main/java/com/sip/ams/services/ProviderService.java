package com.sip.ams.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.Provider;
import com.sip.ams.repositories.ProviderRepository;

@Service
public class ProviderService {
	
	@Autowired
	ProviderRepository providerRepository;
	
	public Provider saveProvider(Provider provider)
	{
		return providerRepository.save(provider);
	}
	
	public Provider findProviderById(Long id)
	{
		return providerRepository.findProviderById(id);
	}
	
	public Provider findProviderByName(String name)
	{
		return providerRepository.findProviderByName(name);
	}
	
	public Provider findProviderByAddress(String address)
	{
		return providerRepository.findProviderByAddress(address);
	}
	
	public List<Provider> findAllProvider()
	{
		return providerRepository.findAll();
	}

}
