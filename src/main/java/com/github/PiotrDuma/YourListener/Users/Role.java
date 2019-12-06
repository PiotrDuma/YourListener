package com.github.PiotrDuma.YourListener.Users;

public enum Role {
	USER("USER"),
	MODERATOR("MODERATOR"),
	ADMIN("ADMIN");
	
	private String role;

	public String getRole() {
		return role;
	}

	Role(String role) {
		this.role= role;
	}	
}
