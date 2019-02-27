import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {MovieListComponent} from './component/movie-list/movie-list.component';
import {HttpClientModule} from '@angular/common/http';
import {NewMovieComponent} from './component/new-movie/new-movie.component';

const appRoutes: Routes = [
  { path: 'movies', component: MovieListComponent },
  { path: 'new-movie', component: NewMovieComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes, { useHash: true }
    ),
    HttpClientModule
  ],
  exports: [
    RouterModule
  ],
  providers: [

  ]
})
export class AppRoutingModule {}
