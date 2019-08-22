package com.visa.fundraiser.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="campaigns")
public class Campaign {
	@Id
	private String title;
	private Double donated;
	private Double target;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date deadLine;
	private String status;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getDonated() {
		return donated;
	}
	public void setDonated(Double donated) {
		this.donated = donated;
	}
	public Double getTarget() {
		return target;
	}
	public void setTarget(Double target) {
		this.target = target;
	}
	public Date getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
