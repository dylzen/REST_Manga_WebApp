package com.demo.manga.dao;

import java.util.List;

import javax.persistence.*;

import com.demo.manga.model.Manga;

public class MangaDAO {
	
	public static void createMangaRecord(Manga manga) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		
		Manga newManga = new Manga();
		newManga.setTitle(manga.getTitle());
		newManga.setAuthor(manga.getAuthor());
		newManga.setPrice(manga.getPrice());
		newManga.setVolumes(manga.getVolumes());
		newManga.setReleaseStatus(manga.getReleaseStatus());
		

		entityManager.persist(newManga);

		entityManager.getTransaction().commit();
	}
	
	public static List<Manga> findAllManga() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		
		return entityManager.createQuery("from Manga", Manga.class).getResultList();
	}
	
	public static Manga findMangaByMangaID(int mangaSeriesID) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		
		 // il parametro di valueOf è la key del record nel db
		Manga retrievedManga = entityManager.find(Manga.class, mangaSeriesID);
		System.out.println(retrievedManga.getTitle() + " - " + retrievedManga.getAuthor());

		entityManager.getTransaction().commit();
		return retrievedManga;
	}
	
	public static Manga updateMangaByID(Manga manga) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");
		EntityManager entityManager = emf.createEntityManager();

		entityManager.getTransaction().begin();
		
		Manga toUpdateManga = entityManager.find(Manga.class, manga.getMangaSeriesID());
		
		toUpdateManga.setTitle(manga.getTitle());
		toUpdateManga.setAuthor(manga.getAuthor());
		toUpdateManga.setPrice(manga.getPrice());
		toUpdateManga.setVolumes(manga.getVolumes());
		toUpdateManga.setReleaseStatus(manga.getReleaseStatus());
//		toUpdateManga.setPrice(99);
		entityManager.persist(toUpdateManga);

		entityManager.getTransaction().commit();
		return toUpdateManga;
	}

	public static void deleteMangaByID(int mangaSeriesID) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
	
		Manga toDeleteManga = entityManager.find(Manga.class, mangaSeriesID);
		entityManager.remove(toDeleteManga); // cancella dal DB

		entityManager.getTransaction().commit();

	}

}
