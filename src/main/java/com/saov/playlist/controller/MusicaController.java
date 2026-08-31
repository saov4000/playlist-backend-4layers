package com.saov.playlist.controller;

import com.saov.playlist.models.MusicaModel;
import com.saov.playlist.services.MusicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //REST - estrutura das operações do CRUD
@RequestMapping("/musicas")
@CrossOrigin(origins = "*") // libera acesso (Android/Postman)
public class MusicaController {

    private final MusicaService service;

    public MusicaController(MusicaService service) {
        this.service = service;
    }

    @GetMapping //usa /musicas
    public ResponseEntity<List<MusicaModel>> listarTodos() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<MusicaModel> criar(@RequestBody MusicaModel musica) {
        return ResponseEntity.ok(service.cadastrar(musica));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MusicaModel> buscarPorId(@PathVariable String id) {
        MusicaModel musica = service.buscarPorId(id);
        return ResponseEntity.ok(musica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MusicaModel> atualizar(@PathVariable String id, @RequestBody MusicaModel musica) {
        MusicaModel musicaAtualizada = service.atualizar(id, musica);
        return ResponseEntity.ok(musicaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}


