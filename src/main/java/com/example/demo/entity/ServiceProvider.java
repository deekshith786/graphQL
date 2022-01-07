package com.example.demo.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceProvider {

	@Id
	@Builder.Default
	private String id= UUID.randomUUID().toString();
	private String avatar,company,name;
	@OneToMany(targetEntity = Case.class,cascade = CascadeType.ALL)
	 @JoinColumn(name ="provider_id",referencedColumnName = "id")
	private List<Case> cases;
	
}
