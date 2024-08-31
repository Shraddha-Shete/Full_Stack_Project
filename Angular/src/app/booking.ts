import { PaymentDetails } from "./payment-details";

export class Booking {
    checkInDate!:any;
    checkOutDate!:any;
    roomType!:string;
    numRooms!:number;
    guestName!:string;
    guestEmail!:string;
    guestPhone!:string;
    specialRequests!:string;
    cardNumber!: string;
    cardExpiry!: string;
    cardCVV!: string;
    cardName!: string;
   
    hotelId!:number;
}
