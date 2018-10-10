import {Component} from '@angular/core';
import {ToastaConfig, ToastaService, ToastData, ToastOptions} from 'ngx-toasta';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private toastaService: ToastaService, private toastaConfig: ToastaConfig) {
    this.toastaConfig.theme = 'default';
  }
  addToast() {
    const toastOptions: ToastOptions = {
      title: 'My title',
      msg: 'The message',
      showClose: true,
      timeout: 2000,
      theme: 'default',
      onAdd: (toast: ToastData) => {
        console.log('Toast ' + toast.id + ' has been added!');
      },
      onRemove: function(toast: ToastData) {
        console.log('Toast ' + toast.id + ' has been removed!');
      }
    };




    this.toastaService.error(toastOptions);
    // this.toastaService.warning(toastOptions);
  }
}
