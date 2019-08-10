import { Component, OnInit } from '@angular/core';

import { Conta } from 'src/model/conta';
import { ApiService } from 'src/service/api.service';

@Component({
  selector: 'app-conta-list',
  templateUrl: './conta-list.component.html',
  styleUrls: ['./conta-list.component.css']
})
export class ContaListComponent implements OnInit {

  dataSource: Conta[];
  isLoadingResults = true;

  constructor(private _api: ApiService) { }

  ngOnInit() {
    this._api.getContas()
      .subscribe(res => {
        this.dataSource = res;
        console.log(this.dataSource);
        this.isLoadingResults = false;
      }, err => {
        console.log(err);
        this.isLoadingResults = false;
      });
  }

}
