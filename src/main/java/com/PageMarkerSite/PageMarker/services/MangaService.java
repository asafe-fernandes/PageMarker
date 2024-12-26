package com.PageMarkerSite.PageMarker.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.PageMarkerSite.PageMarker.domains.Manga;
import com.PageMarkerSite.PageMarker.domains.MangaDTO;
import com.PageMarkerSite.PageMarker.repositories.MangaRepository;

@Service
public class MangaService {
  private final MangaRepository mangaRepository;

  public MangaService(MangaRepository mangaRepository) {
    this.mangaRepository = mangaRepository;
  }

  public Manga insert(MangaDTO mangaDTO) {
    Manga newManga = new Manga(mangaDTO);
    this.mangaRepository.save(newManga);
    return newManga;
  }

  public List<Manga> getAll() {
    return this.mangaRepository.findAll();
  }

  public Manga delete(MangaDTO mangaDTO) {
    Manga toDeleteManga = new Manga(mangaDTO);
    this.mangaRepository.delete(toDeleteManga);
    return toDeleteManga;
  }

}
