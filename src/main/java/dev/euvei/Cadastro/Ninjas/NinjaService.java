package dev.euvei.Cadastro.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    //injecao de dependencias
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    //construtor do OBj, que vem da injecao de dependencias
    public NinjaService(NinjaMapper ninjaMapper, NinjaRepository ninjaRepository) {
        this.ninjaMapper = ninjaMapper;
        this.ninjaRepository = ninjaRepository;
    }

    //logica para: LISTAR todos os ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();  //SELECT = .findAll() -> JPA(interface -> ninjaRepository extends JpaRepository)
    }

    //logica para: LISTAR todos os ninjas por ID
    public NinjaModel listarNinjasPorId(Long id) {  //passar valor do id
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id); //Optional<T>
        return ninjaPorId.orElse(null);
    }

    //logica para: ADICIONAR ninjaDTO com JPA
    //passar o NinjaModel como parametro!
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
      NinjaModel ninja = ninjaMapper.map(ninjaDTO);
      ninja = ninjaRepository.save(ninja);
      return ninjaMapper.map(ninja);
    }


    //logica para: DELETAR ninja por ID -> tem que ser um metodo `void`, pois nao precisa retornar dados
    // DELETE FROM TB_CADASTRO WHERE id=10; -> Command SQL
    public void deletarNinjaPorId(Long id) {
        //acessar a instancia do repositorio, no JPA
        ninjaRepository.deleteById(id);
    }

    //logica para: Atualizar dados dos Ninjas -> PUT -> SQL
    // PUT -> juncao do .getByID + Method POST -> achar o dado e sobre-escrever
    public NinjaModel atualizarNinjaPorId(Long id, NinjaModel ninjaAtualizado) {
        //condicao para id
        if (ninjaRepository.existsById(id)) {
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;

    }



}
