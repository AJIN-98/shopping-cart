import {Pipe, PipeTransform} from '@angular/core'
import {Item} from '../model/item'

@Pipe({
  name: 'search'
})
export class SearchPipe implements PipeTransform {

  transform(items: Item[], searchText: string): any[] {
    if (!items) {
      return []
    }
    if (!searchText) {
      return items
    }
    searchText = searchText.toLowerCase()
    return items.filter(it => {
      return it.name.toLowerCase().includes(searchText);
    });
  }

}
