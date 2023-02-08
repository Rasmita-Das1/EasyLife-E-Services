package com.easylife.eservices.model;

import javax.persistence.*;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="srvcprovider")
public class ServiceProvider {
	
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private int contactNum;
	
	@Column(nullable = false)
	private int location;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String category;
	
	@Column(nullable = false)
	private int cost;

}
