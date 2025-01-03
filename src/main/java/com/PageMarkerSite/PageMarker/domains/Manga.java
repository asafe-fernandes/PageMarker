package com.PageMarkerSite.PageMarker.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "PageMarkerSite")
@Getter
@Setter
@NoArgsConstructor
public class Manga {
  @Id
  String id;
  String title;
  String chapter;
  String link;

  public Manga(MangaDTO mangaDTO) {
    this.title = mangaDTO.title();
    this.chapter = mangaDTO.chapter();
    this.link = mangaDTO.link();
  }

}
