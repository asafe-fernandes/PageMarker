package com.PageMarkerSite.PageMarker.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.PageMarkerSite.PageMarker.domains.Manga;

@Repository
public interface MangaRepository extends MongoRepository<Manga, String> {

}
