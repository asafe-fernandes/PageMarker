package com.PageMarkerSite.PageMarker.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PageMarkerSite.PageMarker.domains.Manga;
import com.PageMarkerSite.PageMarker.domains.MangaDTO;
import com.PageMarkerSite.PageMarker.services.MangaService;

@RestController
@RequestMapping("/mangas")
public class MangaController {

  private final MangaService mangaService;

  public MangaController(MangaService mangaService) {
    this.mangaService = mangaService;
  }

  @GetMapping
  public ResponseEntity<List<Manga>> getAll() {
    List<Manga> mangas = this.mangaService.getAll();
    return ResponseEntity.ok().body(mangas);
  }

  @PostMapping
  public ResponseEntity<Manga> insert(@RequestBody MangaDTO mangaDTO) {

    Manga newManga = new Manga(mangaDTO);
    return ResponseEntity.ok().body(newManga);
  }

  @DeleteMapping
  public ResponseEntity<Manga> delete(@RequestBody MangaDTO mangaDTO) {
    Manga deletedManga = this.mangaService.delete(mangaDTO);
    return ResponseEntity.ok().body(deletedManga);
  }
}
