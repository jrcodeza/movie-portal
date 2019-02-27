import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-movie-list-item',
  templateUrl: './movie-list-item.component.html',
  styleUrls: ['./movie-list-item.component.css']
})
export class MovieListItemComponent implements OnInit {

  @Input()
  name: string;

  @Input()
  description: string;

  @Input()
  year: string;

  @Input()
  imageUrl: string;

  @Input()
  id: string;

  constructor() { }

  ngOnInit() {
  }

  getImageUrl(): string {
    return this.imageUrl === null ? 'https://thenypost.files.wordpress.com/2014/11/movietheater131050-525x350.jpg?quality=90&strip=all&w=618&h=300&crop=1'
      : this.imageUrl;
  }

}
