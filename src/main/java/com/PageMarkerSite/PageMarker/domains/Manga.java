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
  String img;

  public Manga(MangaDTO mangaDTO) {
    this.title = mangaDTO.title();
    this.chapter = mangaDTO.chapter();
    this.link = mangaDTO.link();
    this.img = mangaDTO.img();
  }

  @Override
  public String toString() {
    return "Manga{id=" + id + ", title='" + title + "', chapter='" + chapter + "', link='" + link + "', img='" + img
        + "'}";
  }

}
