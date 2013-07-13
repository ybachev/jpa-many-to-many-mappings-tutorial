package com.jpa.many.to.many.mappings.tutorial;

import com.jpa.many.to.many.mappings.tutorial.domain.Artist;
import com.jpa.many.to.many.mappings.tutorial.domain.Genre;
import com.jpa.many.to.many.mappings.tutorial.service.ArtistService;
import com.jpa.many.to.many.mappings.tutorial.service.GenreService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaManyToManyMappingsTutorial {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaManyToManyMappingsTutorial");
        EntityManager em = emf.createEntityManager();
        ArtistService artistService = new ArtistService(em);
        GenreService genreService = new GenreService(em);

        System.out.println("--- Finding genre ---");
        Genre genre = genreService.findGenre(1);
        System.out.println(String.format("Found genre: %s", genre));
        for (Artist artist : genre.getArtists()) {
            System.out.println(String.format("Genre artist: %s", artist));
        }
        System.out.println();

        System.out.println("--- Finding artist ---");
        Artist artist = artistService.findArtist(1);
        System.out.println(String.format("Found artist: %s", artist));
        for (Genre foundGenre : artist.getGenres()) {
            System.out.println(String.format("Artist genre: %s", foundGenre));
        }
    }
}
