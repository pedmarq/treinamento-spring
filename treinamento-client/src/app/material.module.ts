import { NgModule } from '@angular/core';

import {
  MatButtonModule,
  MatMenuModule,
  MatCheckboxModule,
  MatToolbarModule,
  MatIconModule,
  MatCardModule,
  MatListModule,
  MatGridListModule,
  MatSidenavModule
} from '@angular/material';

import { LayoutModule } from '@angular/cdk/layout';

@NgModule({
  imports: [
    MatButtonModule,
    MatMenuModule,
    MatCheckboxModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    MatListModule,
    MatGridListModule,
    MatSidenavModule,
    LayoutModule
  ],
  exports: [
    MatButtonModule,
    MatMenuModule,
    MatCheckboxModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    MatListModule,
    MatGridListModule,
    MatSidenavModule,
    LayoutModule
  ]
})
export class MaterialModule {}
