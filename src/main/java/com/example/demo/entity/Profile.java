package com.example.demo.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "profile_table")
public class Profile {

	private String avatar;

	private String email;

	private String firstName;

	private Id id;

	private String lastName;

//	private Notification notifications;

	private Integer numberOfNotifications;

	private Integer numberOfOpenCases;

	private Integer numberOFPendingTasks;

	private List<Profile> partners;

	private List<Task> task;

	private List<Vault> vault;

}
