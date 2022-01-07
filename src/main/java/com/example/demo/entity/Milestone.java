package com.example.demo.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Milestone {
	
	@Id
	@Builder.Default
	private String id= UUID.randomUUID().toString();
	private String description,icon,name,state;
	private Integer numberOfPendingTasks,numberOfTasks,progress;
	
}
