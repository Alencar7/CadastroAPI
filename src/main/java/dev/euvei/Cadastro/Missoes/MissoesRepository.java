package dev.euvei.Cadastro.Missoes;

import org.springframework.data.jpa.repository.JpaRepository;

// ORM vai escanear a entidade `MissoesModel`
public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {

}
