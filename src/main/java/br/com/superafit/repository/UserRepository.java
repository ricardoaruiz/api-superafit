package br.com.superafit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.superafit.model.User;

public interface UserRepository extends JpaRepository<User, String>  {
	
	User findByLoginAndPassword(String login, String password);
	
	User findByLogin(String login);

}
