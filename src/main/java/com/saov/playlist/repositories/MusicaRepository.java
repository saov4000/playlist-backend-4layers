package com.saov.playlist.repositories;

import com.saov.playlist.models.MusicaModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends MongoRepository<MusicaModel,String> {
}



