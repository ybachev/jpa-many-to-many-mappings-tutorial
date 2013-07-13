package com.jpa.many.to.many.mappings.tutorial.service;

import com.jpa.many.to.many.mappings.tutorial.domain.Genre;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class GenreService {

    private EntityManager em;

    public GenreService(EntityManager em) {
        this.em = em;
    }

    public Genre createGenre(int id, String name) {
        Genre genre = new Genre(id, name);
        em.persist(genre);

        return genre;
    }

    public void removeGenre(int id) {
        Genre genre = em.find(Genre.class, id);

        if (genre != null) {
            em.remove(genre);
        }
    }

    public Genre changeGenreName(int id, String name) {
        Genre genre = em.find(Genre.class, id);

        if (genre != null) {
            genre.setName(name);
        }

        return genre;
    }

    public Genre findGenre(int id) {
        return em.find(Genre.class, id);
    }

    public List<Genre> findAllGenres() {
        TypedQuery<Genre> query = em.createQuery("SELECT g FROM Genre g", Genre.class);
        return query.getResultList();
    }
}
