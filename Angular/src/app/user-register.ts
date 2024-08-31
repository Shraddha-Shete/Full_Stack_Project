export class UserRegister {
    id!:number;
    firstName!:String;
    lastName!:String;
    email!:String;
    mobNo!:String;
    password!:String;
    confirmPassword!:String;
    role!: string; 
    passwordMatch(): boolean {
        // console.log('Checking password match:', this.password === this.confirmPassword);
        return this.password === this.confirmPassword;
      }
}
