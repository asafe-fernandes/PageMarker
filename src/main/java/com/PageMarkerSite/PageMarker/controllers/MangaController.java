package com.PageMarkerSite.PageMarker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
  @CrossOrigin(origins = "*", allowedHeaders = "*")
  public ResponseEntity<List<Manga>> getAll() {
    List<Manga> mangas = this.mangaService.getAll();
    mangas.forEach((manga) -> System.out.println(manga.toString()));
    return ResponseEntity.ok().body(mangas);
  }

  @PostMapping
  @CrossOrigin(origins = "*", allowedHeaders = "*")
  public ResponseEntity<Manga> insert(@RequestBody MangaDTO mangaDTO) {
    System.out.println("mangaDTO=" + mangaDTO.toString());
    Manga newManga = this.mangaService.insert(mangaDTO);
    System.out.println(newManga.toString());
    return ResponseEntity.ok().body(newManga);
  }

  @DeleteMapping("/{id}")
  @CrossOrigin(origins = "*", allowedHeaders = "*")
  public ResponseEntity<Manga> delete(@PathVariable("id") String id) {
    Manga deletedManga = this.mangaService.delete(id);
    System.out.println(deletedManga.toString());
    return ResponseEntity.ok().body(deletedManga);
  }

  @PutMapping("/{id}")
  @CrossOrigin(origins = "*", allowedHeaders = "*")
  public ResponseEntity<Manga> update(@PathVariable("id") String id, @RequestBody MangaDTO mangaDTO) {
    System.out.println("mangaDTO=" + mangaDTO.toString());
    Manga updatedManga = this.mangaService.update(id, mangaDTO);
    System.out.println(updatedManga.toString());
    return ResponseEntity.ok().body(updatedManga);

  }
}
