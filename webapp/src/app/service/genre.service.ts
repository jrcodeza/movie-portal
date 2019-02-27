import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Genre} from '../model/genre';

@Injectable({
  providedIn: 'root'
})
export class GenreService {

  constructor(private http: HttpClient) { }

  public getGenres(): Observable<Genre[]> {
    return this.http.get(`/api/genres`) as Observable<Genre[]>;
  }

}
