import {Component, ViewChild} from '@angular/core';
import {FooterComponent} from "./footer/footer.component";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Togetair';

  @ViewChild('footerComponent')
  footerComponent: FooterComponent;

  changeLastAccessed() {
    console.log('The previous lastAccessed was ' + this.footerComponent.lastAccessed);
    this.footerComponent.lastAccessed = new Date().toString();
  }
}
