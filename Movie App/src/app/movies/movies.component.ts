import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-movies',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent {
  movies = [
    // Movies
    
    
    // Korean Dramas
    { 
      title: 'Crash Landing on You', 
      genre: 'Romance', 
      year: 2019, 
      image: 'crash.png' 
    },
    { 
      title: 'Goblin', 
      genre: 'Fantasy', 
      year: 2016, 
      image: 'image copy.png' 
    },
    { 
      title: 'Itaewon Class', 
      genre: 'Drama', 
      year: 2020, 
      image: 'class.png' 
    },
    { 
      title: 'Vincenzo', 
      genre: 'Crime', 
      year: 2021, 
      image: 'vin.png' 
    },
    { 
      title: 'Start-Up', 
      genre: 'Romance/Drama', 
      year: 2020, 
      image: 'image.png' 
    }
  ];
}
