import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, of, throwError } from 'rxjs';
import { catchError, tap, map } from 'rxjs/operators';
import { Conta } from 'src/model/conta';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json;charset=UTF-8'})
};
const apiUrl = '/api';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }

  getContas(): Observable<Conta[]> {
    const url = `${apiUrl}/contas`;
    return this.http.get<Conta[]>(url)
      .pipe(
        tap(contas => console.log('li as contas')),
        catchError(this.handleErrors('getContas', []))
      );
  }

  getConta(id: number): Observable<Conta> {
    const url = `${apiUrl}/contas/${id}`;
    return this.http.get<Conta>(url)
      .pipe(
        tap(_ => console.log(`li a conta de id = ${id}`)),
        catchError(this.handleErrors<Conta>(`getConta id=${id}`))
      );
  }

  private handleErrors<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}
