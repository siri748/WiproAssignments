import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

export interface Song {
  id: number;
  title: string;
  artist: string;
  url: string;
}

@Injectable({
  providedIn: 'root'
})
export class MusicService {
  private songsList: Song[] = [
    { id: 1, title: 'Andhaga Andhagada', artist: 'Shreya Ghoshal', url: 'inkem.mp3' },
    { id: 2, title: 'Vennelave', artist: 'Shreya Ghoshal', url: 'venna.mp3' },
    { id: 3, title: 'Parichayam Ila', artist: 'Shreya Ghoshal', url: 'pari.mp3' }
  ];
  private songsSubject = new BehaviorSubject<Song[]>(this.songsList);
  songs$ = this.songsSubject.asObservable();

  constructor() {}

  getSongs(): Song[] {
    return this.songsSubject.value;
  }

  addSong(song: Song) {
    const updated = [...this.songsSubject.value, song];
    this.songsSubject.next(updated);
  }

  removeSong(id: number) {
    const updated = this.songsSubject.value.filter(song => song.id !== id);
    this.songsSubject.next(updated);
  }
}
