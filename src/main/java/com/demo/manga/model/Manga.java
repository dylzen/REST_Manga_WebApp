package com.demo.manga.model;


// aggiungere persistence al pom -> https://mvnrepository.com/artifact/javax.persistence/javax.persistence-api/2.2
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name = "series")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="manga_series")
@XmlRootElement
public class Manga {

	@Id
	@Column(name="manga_series_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int mangaSeriesID;
	
	@Column(name = "title")
    private String title;

    
    @Column(name = "price")
    private double price;

    @Column(name = "author")
    private String author;
    
    @Column(name = "volumes")
    private int volumes;
    
    @Column(name = "release_status")
    private String releaseStatus;

	public Manga(int mangaSeriesID, String title, double price, String auhor, int volumes, String releaseStatus) {
		super();
		this.mangaSeriesID = mangaSeriesID;
		this.title = title;
		this.price = price;
		this.author = auhor;
		this.volumes = volumes;
		this.releaseStatus = releaseStatus;
	}
	
	public Manga() {
		// TODO Auto-generated constructor stub
	}

	public int getMangaSeriesID() {
		return mangaSeriesID;
	}

	public void setMangaSeriesID(int mangaSeriesID) {
		this.mangaSeriesID = mangaSeriesID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getVolumes() {
		return volumes;
	}

	public void setVolumes(int volumes) {
		this.volumes = volumes;
	}

	public String getReleaseStatus() {
		return releaseStatus;
	}

	public void setReleaseStatus(String releaseStatus) {
		this.releaseStatus = releaseStatus;
	}
	
	
}

