package com.visa.fundraiser.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.fundraiser.entity.Campaign;
import com.visa.fundraiser.entity.Donation;
import com.visa.fundraiser.service.DonationService;

@RestController
public class DonationController {
	@Autowired 
	private DonationService donationService;
	
	@GetMapping("campaigns")
	public @ResponseBody List<Campaign> getCampaigns()
	{
		return donationService.getCampaigns();
	}
	
	@GetMapping("donations")
	public @ResponseBody List<Donation> getDonations()
	{
		return donationService.getDonations();
	}
	@PostMapping("campaigns")
	public ResponseEntity<Campaign> addCampaign(@RequestBody Campaign c)
	{
		donationService.makeCampaign(c);
		return new ResponseEntity<>(c,HttpStatus.CREATED);
	}
	@PostMapping("donations")
	public ResponseEntity<Donation> addDonation(@RequestBody Donation c)
	{
		donationService.makeDonation(c);
		return new ResponseEntity<>(c,HttpStatus.CREATED);
	}

}
