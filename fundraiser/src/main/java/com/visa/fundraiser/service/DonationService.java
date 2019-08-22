package com.visa.fundraiser.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.fundraiser.dao.CampaignDao;
import com.visa.fundraiser.dao.DonationDao;
import com.visa.fundraiser.entity.Campaign;
import com.visa.fundraiser.entity.Donation;

@Service
public class DonationService {
	@Autowired
	private CampaignDao campaignDao;
	
	@Autowired
	private DonationDao donationDao;
	
	public List<Donation> getDonations()
	{
		return donationDao.findAll();
	}
	
	public List<Campaign> getCampaigns()
	{
		return campaignDao.findAll();
	}
	
	@Transactional
	
	public int makeDonation(Donation d)
	{
		String s=d.getCampaign().getTitle();
		donationDao.save(d);
		Campaign c= campaignDao.findByTitle(s);
		c.setDonated(c.getDonated()+d.getAmount());
		return d.getId();	
	}
	
	@Transactional
	
	public void makeCampaign(Campaign c)
	{
		campaignDao.save(c);
	}

}
