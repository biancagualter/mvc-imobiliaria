package com.gft.imob.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails{

	private static final long serialVersionUID = 1L;

	@Id
	private String login;
	
	private String nome;
	
	private String senha;
	
	@ManyToMany
	@JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(
			name = "usuario_id", referencedColumnName = "login"),
			inverseJoinColumns = @JoinColumn(
			name = "role_id", referencedColumnName = "role")
	)
	private List<Role> roles;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return roles;
	}

	@Override
	public String getPassword() {
		
		return this.senha;
	}

	@Override
	public String getUsername() {
		
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
	
	
	
}
