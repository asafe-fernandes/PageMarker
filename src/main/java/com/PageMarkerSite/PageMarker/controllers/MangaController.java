package com.PageMarkerSite.PageMarker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PageMarkerSite.PageMarker.domains.Manga;
import com.PageMarkerSite.PageMarker.domains.MangaDTO;
import com.PageMarkerSite.PageMarker.services.MangaService;

@RestController
@RequestMapping("/mangas")
public class MangaController {

  @Autowired
  private MangaService mangaService;

  // public MangaController(MangaService mangaService) {
  // this.mangaService = mangaService;
  // }

  @GetMapping
  public ResponseEntity<List<Manga>> getAll() {
    List<Manga> mangas = this.mangaService.getAll();
    return ResponseEntity.ok().body(mangas);
  }

  @PostMapping
  public ResponseEntity<Manga> insert(@RequestBody MangaDTO mangaDTO) {
    Manga newManga = this.mangaService.insert(mangaDTO);
    return ResponseEntity.ok().body(newManga);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Manga> delete(@PathVariable("id") String id) {
    System.out.println(id);
    Manga deletedManga = this.mangaService.delete(id);
    return ResponseEntity.ok().body(deletedManga);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Manga> update(@PathVariable("id") String id, @RequestBody MangaDTO mangaDTO) {
    Manga updatedManga = this.mangaService.update(id, mangaDTO);
    return ResponseEntity.ok().body(updatedManga);

  }
}
