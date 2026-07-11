import { Component, inject, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UrlService } from './services/url.service';
import { UrlResponse } from './models/url-response';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  private urlService = inject(UrlService);

  longUrl = signal('');
  result = signal<UrlResponse | null>(null);

  get longUrlValue(): string {
    return this.longUrl();
  }
  set longUrlValue(value: string) {
    this.longUrl.set(value);
  }
  loading = signal(false);
  error = signal<string | null>(null);
  copied = signal(false);

  readonly githubUrl = 'https://github.com/pwiseley/url-shortener';
  readonly docsUrl = '/swagger-ui.html';

  shorten(): void {
    const url = this.longUrl().trim();
    if (!url) {
      this.error.set('Please enter a URL.');
      return;
    }

    this.loading.set(true);
    this.error.set(null);
    this.result.set(null);
    this.copied.set(false);

    this.urlService.shorten(url).subscribe({
      next: (res) => {
        this.result.set(res);
        this.loading.set(false);
      },
      error: (err) => {
        this.error.set(
          err?.error?.message ?? 'Could not shorten the URL. Check the link and try again.'
        );
        this.loading.set(false);
      },
    });
  }

  copyToClipboard(): void {
    const res = this.result();
    if (!res) return;
    navigator.clipboard.writeText(res.shortUrl).then(() => {
      this.copied.set(true);
      setTimeout(() => this.copied.set(false), 2000);
    });
  }
}
