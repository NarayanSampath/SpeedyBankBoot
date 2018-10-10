export class Imenu {
  menuName: String;
  menuUrl: String;
  constructor(resp: any) {
    this.menuName = resp.menuName;
    this.menuUrl = resp.menuUrl;
  }
}
