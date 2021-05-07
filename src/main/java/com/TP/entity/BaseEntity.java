package com.TP.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;
@MappedSuperclass
public abstract class BaseEntity {
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	
	  @CreationTimestamp
	  
	  @Temporal(TemporalType.TIMESTAMP)
	  @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")	 	
	private Date createdDate;
	
	  @UpdateTimestamp
	  
	  @Temporal(TemporalType.TIMESTAMP)
	  
	  @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")	 
	private Date updatedDate;
	
	

}
