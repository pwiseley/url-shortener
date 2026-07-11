import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UrlResponse } from '../models/url-response';
import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class UrlService {
  private http = inject(HttpClient);
  private readonly endpoint = `${environment.apiBase}/api/urls`;

  shorten(originalUrl: string): Observable<UrlResponse> {
    return this.http.post<UrlResponse>(this.endpoint, { originalUrl });
  }
}
