package com.saov.playlist.services;

import com.saov.playlist.models.MusicaModel;
import com.saov.playlist.repositories.MusicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService{
    //objeto da classe MusicaRepository
    private final MusicaRepository musicaRepository;

    public MusicaService(MusicaRepository musicaRepository) {
        this.musicaRepository = musicaRepository;
    }

    public MusicaModel cadastrar(MusicaModel musicaModel){
        return musicaRepository.save(musicaModel);
    }

    public List<MusicaModel> listar(){
        return musicaRepository.findAll(); //lista todas as músicas
    }

    public MusicaModel buscarPorId(String id){
        return musicaRepository.findById(id).orElse(null);
    }

    public MusicaModel atualizar(String id, MusicaModel musicaModel){
        MusicaModel musicaExistente = musicaRepository.findById(id).orElse(null);
        musicaExistente.setId(musicaModel.getId());
        musicaExistente.setNome(musicaModel.getNome());
        musicaExistente.setArtista((musicaModel.getArtista()));
        musicaExistente.setAlbum(musicaModel.getAlbum());
        musicaExistente.setAno(musicaModel.getAno());
        return musicaRepository.save(musicaExistente);
    }

    public boolean excluir(String id){
        if(!musicaRepository.existsById(id))
            return false;
        musicaRepository.deleteById(id);
        return true;
    }
}
