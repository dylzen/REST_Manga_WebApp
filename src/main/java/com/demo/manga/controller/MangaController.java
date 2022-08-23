package com.demo.manga.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.manga.dao.MangaDAO;
import com.demo.manga.model.Manga;

import org.apache.log4j.Logger;


/**
 * Servlet implementation class mangaController
 */
@WebServlet(urlPatterns = "/MangaController") // l'URL della servlet
public class MangaController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(MangaController.class);

	public MangaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag = request.getParameter("flag");

		handleRequestUsingFlag(request, response, flag);
	}

	private void handleRequestUsingFlag(HttpServletRequest request, HttpServletResponse response, String flag)
			throws ServletException, IOException {

		MangaDAO mangaDAO = new MangaDAO();

//		if ("modificaManga".equalsIgnoreCase(flag)) {
//			int mangaSeriesID = Integer.valueOf(request.getParameter("mangaSeriesID"));
//			Manga manga = mangaDAO.findMangaByMangaID(mangaSeriesID);
//			request.setAttribute("manga", manga);
//			request.getRequestDispatcher("aggiungi_manga.jsp").forward(request, response);
//		} 
		if ("eliminaManga".equalsIgnoreCase(flag)) {
			String mangaSeriesID = request.getParameter("mangaSeriesID");
			if (mangaSeriesID != "") {
				mangaDAO.deleteMangaByID(Integer.valueOf(mangaSeriesID));
			}
			List<Manga> mangas = MangaDAO.findAllManga();
			request.setAttribute("mangas", mangas);
			request.getRequestDispatcher("mostra_manga.jsp").forward(request, response);
		} 
		else {
			List<Manga> mangas = MangaDAO.findAllManga();
			request.setAttribute("mangas", mangas);
			request.getRequestDispatcher("mostra_manga.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MangaDAO mangaDAO = new MangaDAO();

		double price = Double.parseDouble(request.getParameter("price"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String mangaSeriesID = request.getParameter("mangaSeriesID");
		int volumes = Integer.parseInt(request.getParameter("volumes"));
		String releaseStatus = request.getParameter("releaseStatus");
		

		Manga manga = new Manga();
		manga.setAuthor(author);
		manga.setPrice(price);
		manga.setTitle(title);
		manga.setVolumes(volumes);
		manga.setReleaseStatus(releaseStatus);
		if (mangaSeriesID != "" && Integer.valueOf(mangaSeriesID) > 0) {
			manga.setMangaSeriesID(Integer.valueOf(mangaSeriesID));
		}

		mangaDAO.createMangaRecord(manga);

		handleRequestUsingFlag(request, response, "mostraManga");

	}

}
