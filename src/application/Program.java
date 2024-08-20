package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		// OBS: as datas foram trocadas para mais recentes por conta da logica proposta, por isso estou usando datas desse ano e comparando 
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf  =new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("Room Number:");
		int number = sc.nextInt();
		
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		// se a data de checkOut NÃO(!) for posterior a data de checkIn....condição
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Reservation dates for update must be future dates");
			
		} 
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			
			// Atualizando a reserva 
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			 checkIn = sdf.parse(sc.next());
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			 checkOut = sdf.parse(sc.next());
			 
			
			 Date now = new Date();
			 
			 if(checkIn.before(now) || checkOut.before(now)) {
				 System.out.println("Error in reservation: Reservation dates for update must be future dates");
			 }
			 
			// se a data de checkOut NÃO(!) for posterior a data de checkIn....condição
			 else if (!checkOut.after(checkIn)) {
					System.out.println("Error in reservation: Reservation dates for update must be future dates"); 
				 }
			 
			 else {
				 reservation.updateDates(checkIn, checkOut);
				 System.out.println("Reservation: " + reservation);
				 }
			 
			 }
		
		sc.close();

	}

}
