import { Component, OnInit } from '@angular/core';
import { Item } from 'src/app/model/item';
import { ItemService } from 'src/app/services/item.service';
import { ToastrService } from 'src/app/services/toastr.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.scss']
})
export class ProductFormComponent implements OnInit {

  product: Item

  constructor(private service: ItemService,
    private tostr: ToastrService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.product = new Item()
    this.route.params.subscribe(params => {
      if (params['id']) {
        this.service.getProduct(params['id']).subscribe((item) => {
          this.product = item
        })
      }
    })
  }

  save() {
    this.service.saveProduct(this.product).subscribe((product) => {
      this.tostr.info(`Product ${this.product.name} saved!`)
      this.router.navigate(['/app/products/list'])

    })
  }

}
