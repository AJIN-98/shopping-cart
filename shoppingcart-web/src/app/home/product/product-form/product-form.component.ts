import {Component, OnInit} from '@angular/core'
import {Item} from 'src/app/model/item'
import {ItemService} from 'src/app/services/item.service'
import {ToastrService} from 'src/app/services/toastr.service'
import {ActivatedRoute, Router} from '@angular/router'
import {FormBuilder, FormGroup, Validators} from '@angular/forms'

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.scss']
})
export class ProductFormComponent implements OnInit {

  productForm: FormGroup
  submitted = false

  constructor(private service: ItemService,
              private tostr: ToastrService,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private router: Router) {
  }

  ngOnInit() {
    this.productForm = this.formBuilder.group({
      id: [''],
      name: ['', [Validators.required]],
      value: ['0.00', [Validators.required, Validators.min(0.01)]]
    })

    this.route.params.subscribe(params => {
      if (params['id']) {
        this.service.getProduct(params['id']).subscribe((item) => {
          this.productForm.patchValue(item)
        })
      }
    })
  }

  save() {
    this.submitted = true
    if (this.productForm.invalid) {
      return
    }
    this.service.saveProduct(new Item(this.productForm.value)).subscribe((product) => {
      this.tostr.info(`Product ${product.name} saved!`)
      this.router.navigate(['/app/products/list'])
    })
  }

  get controls() {
    return this.productForm.controls
  }

}
