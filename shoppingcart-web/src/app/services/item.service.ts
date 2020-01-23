import { Injectable } from '@angular/core'
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs'
import { Item } from '../model/item'
import { environment } from 'src/environments/environment'

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient
  ) { }

  API_URL = environment.apiUrl.concat('products')

  getProduct(id: string): Observable<Item> {
    return this.http.get<Item>(this.API_URL.concat(`/${id}`))
  }

  listProducts(): Observable<Item[]> {
    return this.http.get<Item[]>(this.API_URL)
  }

  saveProduct(item: Item): Observable<Item> {
    return this.http.put<Item>(this.API_URL, item, this.httpOptions)
  }

  deleteProduct(item: Item): Observable<any> {
    return this.http.delete<any>(this.API_URL.concat(`/${item.id}`))
  }

}
