package com.aptech.springmvc.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;
    
    @Column(name="email")
    private String email;

    @Column(name="enabled")
    private boolean enabled;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> role;

    public User() {}
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }
    
    public User(String username, String password, String email, boolean enabled, List<Role> role) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.role = role;
	}

	public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", enabled=" + enabled
				+ ", roles=" + role + "]";
	}

}
