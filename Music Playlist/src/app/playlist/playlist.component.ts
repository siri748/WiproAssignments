import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SongComponent } from '../song/song.component';

import { FormsModule } from '@angular/forms';
import { MusicService, Song } from '../services/music.service';

@Component({
  selector: 'app-playlist',
  standalone: true,
  imports: [CommonModule, SongComponent, FormsModule],
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.css']
})
export class PlaylistComponent implements OnInit {
  songs: Song[] = [];
  newSongTitle = '';
  newSongArtist = '';
  newSongUrl = '';

  constructor(private musicService: MusicService) {}
  ngOnInit() {
    this.musicService.songs$.subscribe(data => this.songs = data);
  }
  removeSong(id: number) {
    this.musicService.removeSong(id);
  }
  addSong() {
    if (this.newSongTitle && this.newSongArtist && this.newSongUrl) {
      const id = this.songs.length > 0 ? Math.max(...this.songs.map(s => s.id)) + 1 : 1;
      this.musicService.addSong({
        id,
        title: this.newSongTitle,
        artist: this.newSongArtist,
        url: this.newSongUrl
      });
      this.newSongTitle = '';
      this.newSongArtist = '';
      this.newSongUrl = '';
    }
  }
}
