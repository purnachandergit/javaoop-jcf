package com.visa.fundraiser.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa.fundraiser.entity.Campaign;

public interface CampaignDao extends JpaRepository<Campaign, String> {
	Campaign findByTitle(String title);
}
