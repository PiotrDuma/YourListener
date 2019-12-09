package com.github.PiotrDuma.YourListener.users;

public enum Role {
	USER("USER"),
	MODERATOR("MODERATOR"),
	ADMIN("ADMIN");
	
	private String role;

	public String getRole() {
		return role;
	}

	private Role(String role) {
		this.role= role;
	}	
}
