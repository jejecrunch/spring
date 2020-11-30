package net.skhu.dto;

import java.util.List;

import lombok.Data;

@Data
public class District {
	int id;
	String districtName;


	List<City> cities;
}
