import {Genre} from './genre';

export interface Movie {

  id: number;
  title:  string;
  description?: string;
  genre: Genre;
  year: number;
  duration: number;
  coverUrl: string;

}
