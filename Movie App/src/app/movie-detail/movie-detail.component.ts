import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-movie-detail',
  standalone: true,
  imports: [CommonModule, MatCardModule],
  templateUrl: './movie-detail.component.html',
  styleUrls: ['./movie-detail.component.css']
})
export class MovieDetailComponent {
  movieId: number;

  constructor(private route: ActivatedRoute) {
    this.movieId = Number(this.route.snapshot.paramMap.get('id'));
  }
}
