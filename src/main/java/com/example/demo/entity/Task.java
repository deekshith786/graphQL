package com.example.demo.entity;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
	
	@Id
	@Builder.Default
	private String id= UUID.randomUUID().toString();
	private String name,description,message,date;
	private Integer numberOfSteps,numberOfStepsCompleted,taskState;
	private boolean isApproved;
	@ManyToOne(targetEntity = ServiceProvider.class,cascade = CascadeType.ALL)
	@JoinColumn(name ="provider_id",referencedColumnName = "id")
	private ServiceProvider serviceProvider;
	@OneToOne(targetEntity = Case.class,cascade = CascadeType.ALL)
	@JoinColumn(name ="case_id",referencedColumnName = "id")
	private Case cases;
}
