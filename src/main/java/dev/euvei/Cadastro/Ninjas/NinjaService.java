package dev.euvei.Cadastro.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<NinjaDTO> listarNinjas() {
        // return ninjaRepository.findAll();  //SELECT = .findAll() -> JPA(interface -> ninjaRepository extends JpaRepository)
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        //percorrendo a lista ja feita para fazer a nova com as informacoes ja contidas
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    //logica para: LISTAR todos os ninjas por ID
    public NinjaDTO listarNinjasPorId(Long id) {  //passar valor do id
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id); //Optional<T>
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
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
    public NinjaDTO atualizarNinjaPorId(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }
    // antigo atualizarNinjaPorId
//    public NinjaModel atualizarNinjaPorId(Long id, NinjaModel ninjaAtualizado) {
//        if (ninjaRepository.existsById(id)) {
//            ninjaAtualizado.setId(id); //sobre escrever ID
//            return ninjaRepository.save(ninjaAtualizado);
//        }
//        return null;
//    }



}
