package com.PageMarkerSite.PageMarker.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.PageMarkerSite.PageMarker.domains.Manga;
import com.PageMarkerSite.PageMarker.domains.MangaDTO;
import com.PageMarkerSite.PageMarker.domains.exceptions.MangaNotFoundException;
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

  public Manga delete(String id) {
    Manga toDeleteManga = this.mangaRepository.findById(id)
        .orElseThrow(MangaNotFoundException::new);
    this.mangaRepository.delete(toDeleteManga);
    return toDeleteManga;
  }

  public Manga update(String id, MangaDTO mangaDTO) {
    Manga manga = this.mangaRepository.findById(id)
        .orElseThrow(MangaNotFoundException::new);

    if (!mangaDTO.title().isEmpty())
      manga.setTitle(mangaDTO.title());
    if (!mangaDTO.chapter().isEmpty())
      manga.setChapter(mangaDTO.chapter());
    if (!mangaDTO.link().isEmpty())
      manga.setLink(mangaDTO.link());
    if (!mangaDTO.img().isEmpty())
      manga.setImg(mangaDTO.img());

    this.mangaRepository.save(manga);

    return manga;
  }
}
