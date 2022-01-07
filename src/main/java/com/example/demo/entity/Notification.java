package com.example.demo.entity;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
@Table(name = "notification_table")
public interface Notification {

//	@Builder.Default
//	private String createdOn = ZonedDateTime.now().plusSeconds(5)
//			.format(DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH));
//	
//	private boolean isRead;
//	
//	private String title;

}
