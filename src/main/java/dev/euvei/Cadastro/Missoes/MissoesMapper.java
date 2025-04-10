package dev.euvei.Cadastro.Missoes;

import org.springframework.stereotype.Component;

// 1 - anotacoes do mapper
@Component
public class MissoesMapper {

    // 2 - entidade -> DTO
    public MissoesModel map(MissoesDTO missoesDTO) {

        MissoesModel missoesModel = new MissoesModel();

        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        missoesModel.setNinjas(missoesDTO.getNinjas());

        //2.2 -> retornar o obj instanciado
        return missoesModel;
    }

    // 3 - DTO -> entidade
    public MissoesDTO map(MissoesModel missoesModel) {

        MissoesDTO missoesDTO = new MissoesDTO();

        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNome(missoesModel.getNome());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());
        missoesDTO.setNinjas(missoesModel.getNinjas());

        //3.2 -> return obj inst
        return missoesDTO;
    }
}
