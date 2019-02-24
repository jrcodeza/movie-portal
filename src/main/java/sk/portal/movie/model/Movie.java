package sk.portal.movie.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Movie {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Size(min = 1, max = 100)
	private String title;

	@Size(min = 1, max = 255)
	private String description;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "genre_id")
	@JsonManagedReference
	private Genre genre;

	@NotNull
	@DecimalMin("1900")
	private Integer year;

	@DecimalMin("0")
	private Integer duration;

	private String coverUrl;

	@OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<MovieComment> comments;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getCoverUrl() {
		return coverUrl;
	}

	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<MovieComment> getComments() {
		return comments;
	}

	public void setComments(List<MovieComment> movieComments) {
		this.comments = movieComments;
	}
}
