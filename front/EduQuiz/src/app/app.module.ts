import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { ApiRestService } from './apirest.service';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    HttpClientModule, // Añade RouterModule a la lista de imports
  ],
  providers: [ApiRestService],
  bootstrap: [AppComponent],
})
export class AppModule {}
