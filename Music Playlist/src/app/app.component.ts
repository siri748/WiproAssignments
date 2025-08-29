import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PlaylistComponent } from './playlist/playlist.component';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, PlaylistComponent],
  template: `<div class="app-container">
               <app-playlist></app-playlist>
             </div>`,
  styles: [`
    .app-container {
      width: 60%;
      margin: auto;
      font-family: Arial, sans-serif;
    }
  `]
})
export class AppComponent {}
