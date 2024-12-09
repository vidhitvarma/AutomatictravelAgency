package com.travel.agency.base.constants;

import com.travel.agency.base.exceptions.GenderNotFoundException;

public enum Gender {
	MALE, FEMALE, OTHERS;
	
	public static Gender toEnum(String gender) throws Exception{
		Gender[] genders = Gender.values();
		for(Gender g : genders) {
			String genderString = g.name();
			if(genderString.equalsIgnoreCase(gender)) {
				return g;
			}
		}
		throw new GenderNotFoundException("Invalid Gender given: "+gender);
	}

	
}
