import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Song } from '../services/music.service';

@Component({
  selector: 'app-song',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './song.component.html',
  styleUrls: ['./song.component.css']
})
export class SongComponent {
  @Input() song!: Song;
}
