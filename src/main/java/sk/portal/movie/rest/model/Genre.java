package sk.portal.movie.rest.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Genre {

	private Long id;

	@NotNull
	@Size(min = 1, max = 100)
	private String name;

	@Size(min = 1, max = 255)
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
