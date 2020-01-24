import {Injectable} from '@angular/core'
import {HttpClient} from '@angular/common/http'
import {environment} from 'src/environments/environment'
import {Observable} from 'rxjs'
import {User} from '../model/user'

@Injectable({
  providedIn: 'root'
})
export class UserService {

  API_URL = environment.apiUrl.concat('users')

  constructor(private http: HttpClient) { }

  saveUser(user: User): Observable<User> {
    return this.http.put<User>(this.API_URL, user)
  }

  getUser(id: string): Observable<User> {
    return this.http.get<User>(this.API_URL.concat(`/${id}`))
  }

}
