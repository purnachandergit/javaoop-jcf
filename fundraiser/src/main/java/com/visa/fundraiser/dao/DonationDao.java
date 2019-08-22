package com.visa.fundraiser.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa.fundraiser.entity.Donation;

public interface DonationDao extends JpaRepository<Donation, Integer> {

}
