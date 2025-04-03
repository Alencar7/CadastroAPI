package dev.euvei.Cadastro.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    //injecao de dependencias
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //logica para: listar todos os ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();  //SELECT = .findAll() -> JPA(interface -> ninjaRepository extends JpaRepository)
    }

    //logica para: listar todos os ninjas por ID
    public NinjaModel listarNinjasPorId(Long id) {  //passar valor do id
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id); //Optional<T>
        return ninjaPorId.orElse(null);
    }

    //logica para: adicionar ninja com JPA
    //passar o NinjaModel como parametro!
    public NinjaModel criarNinja(NinjaModel novoNinja) {
        return ninjaRepository.save(novoNinja);
    }


    //logica para: deletar ninja


}
