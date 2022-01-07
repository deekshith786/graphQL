package com.example.demo.entity;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.w3c.dom.DocumentType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "document_table")

public class Document {

	private String file, title;

	private DocumentType type;

	@Builder.Default
	private String createdOn = ZonedDateTime.now().plusSeconds(5)
			.format(DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH));

}
