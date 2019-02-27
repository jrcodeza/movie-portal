import {Component, OnInit} from '@angular/core';
import {Movie} from '../../model/movie';
import {MovieService} from '../../service/movie.service';
import {GenreService} from '../../service/genre.service';
import {Genre} from '../../model/genre';

@Component({
  selector: 'app-new-movie',
  templateUrl: './new-movie.component.html',
  styleUrls: ['./new-movie.component.css']
})
export class NewMovieComponent implements OnInit {

  movieToBeCreated: Movie = this.createEmptyMovie();

  allMovies: Movie[];

  availableGenres: Genre[];

  constructor(private movieService: MovieService,
              private genreService: GenreService) { }

  ngOnInit() {
    this.movieService.getMovies().subscribe(response => this.allMovies = response);
    this.genreService.getGenres().subscribe(response => this.availableGenres = response);
  }

  saveMovie(): void {
    this.movieService.createMovie(this.movieToBeCreated).subscribe(response => {
      this.movieToBeCreated = this.createEmptyMovie();
      this.movieService.getMovies().subscribe(response => this.allMovies = response);
      alert('Movie was successfully created');
    });
  }

  private createEmptyMovie(): Movie {
    return {
      title: '',
      genreId: null,
      year: 0,
      id: 1
    };
  }
}
