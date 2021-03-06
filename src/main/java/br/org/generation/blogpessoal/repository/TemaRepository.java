package br.org.generation.blogpessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.blogpessoal.model.Tema;

@Repository
public interface TemaRepository  extends JpaRepository<Tema, Long>{
	Object findAllByDescricaoContainingIgnoreCase(String descricao);

}
