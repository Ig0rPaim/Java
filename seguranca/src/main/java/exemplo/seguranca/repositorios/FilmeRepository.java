package exemplo.seguranca.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import exemplo.seguranca.entidades.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
