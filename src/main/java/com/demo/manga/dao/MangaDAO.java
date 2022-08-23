package com.demo.manga.dao;

import java.util.List;

import javax.persistence.*;

import com.demo.manga.model.Manga;

public class MangaDAO {

//	@SuppressWarnings("deprecation")
//	public void addManga(Manga manga) {
//
//		SessionFactory sessionFactory = MangaUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();
//		session.saveOrUpdate(manga);
//		transaction.commit();
//		session.close();
//
//	}
	
	public void createMangaRecord(Manga manga) {
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

//	public List<Manga> findAllManga() {
//		SessionFactory sessionFactory = MangaUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		return session.createQuery("from Manga", Manga.class).getResultList();
//	}
	
	public static List<Manga> findAllManga() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		
		return entityManager.createQuery("from Manga", Manga.class).getResultList();
	}
//
//	public Manga findMangaByMangaID(int mangaSeriesID) {
//		SessionFactory sessionFactory = MangaUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		return session.find(Manga.class, mangaSeriesID);
//
//	}
	
	public Manga findMangaByMangaID(int mangaSeriesID) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		
		 // il parametro di valueOf è la key del record nel db
		Manga retrievedManga = entityManager.find(Manga.class, mangaSeriesID);
		System.out.println(retrievedManga.getTitle() + " - " + retrievedManga.getAuthor());

		entityManager.getTransaction().commit();
		return retrievedManga;
	}
//
//	public void deleteMAngaById(int mangaSeriesID) {
//		Manga manga = findMangaByMangaID(mangaSeriesID);
//		SessionFactory sessionFactory = MangaUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();
//		session.delete(manga);
//		transaction.commit();
//		session.close();
//
//	}
	public void deleteMangaByID(int mangaSeriesID) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
	
		Manga toBeDeletedManga = entityManager.find(Manga.class, mangaSeriesID);
		entityManager.remove(toBeDeletedManga); // cancella dal DB

		entityManager.getTransaction().commit();

	}

}
