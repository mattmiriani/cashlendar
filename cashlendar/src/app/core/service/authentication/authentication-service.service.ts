import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationServiceService {

  private _http= inject(HttpClient);

  login(body: any): Observable<any> {
    return this._http.post(
      `http://localhost:8080/security/login`,
      body
    );
  }
}
