package dev.euvei.Cadastro.Missoes.Controller.Services;

import org.springframework.data.jpa.repository.JpaRepository;

// ORM vai escanear a entidade `MissoesModel`
public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {

}
