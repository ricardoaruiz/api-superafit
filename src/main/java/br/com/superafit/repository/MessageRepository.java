package br.com.superafit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.superafit.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
