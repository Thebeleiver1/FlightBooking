//--------------------------------------------------------------------------------
import java.util.Scanner;
public class CountryAirStage2
{
	public static void main(String[] args)
	{
		String selection;
		Scanner input = new Scanner(System.in);
		//creating array with flight details
		Flight countryAir[] = new Flight[8];
		countryAir[0] = new Flight("CA101","Melbourne","Warrnambool","06:00","06:40",30);
		countryAir[1] = new Flight("CA201","Melbourne","King Island","07:00","07:45",20);
		countryAir[2] = new Flight("CA102","Warrnambool","Melbourne","08:00","09:00",30);
		countryAir[3] = new Flight("CA301","Melbourne","Portland","10:00","11:15",30);
		countryAir[4] = new Flight("CA202","King Island","Melbourne","10:00","10:45",20);
		countryAir[5] = new Flight("CA401","Melbourne","Flinders Island","11:00","12:05",20);
		countryAir[6] = new Flight("CA302","Portland","Melbourne","13:00","14:15",30);
		countryAir[7] = new Flight("CA402","Flinders Island","Melbourne","14:00","15:05",20);
		// Printing out the required data from array
		System.out.printf("%s%11s%20s%19s","Flight No.","Departure","Destination","Depart Time");
		System.out.println();
		System.out.println();
     // looping through all the array and getting details using accessor
		for(int i = 0; i < countryAir.length;i++ )
		{
			String flightNumber = countryAir[i].getflightNumber();
			String departurePoint = countryAir[i].getdeparturePoint();
			String destination = countryAir[i].getdestination();
			String departureTime = countryAir[i].getdepartureTime();
			
			System.out.printf("%-11s %-17s %-18s %s",flightNumber,departurePoint,
									destination,departureTime);
			System.out.println();
			

		}
		System.out.println();
		System.out.println("Enter the departure point ");
		// take a user input as departure point
		String departure = input.nextLine();
		int counter = 0;
		System.out.println();
		for(int i = 0; i < countryAir.length;i++ )
		{
			// if user input matches will display related data.
			if(countryAir[i].getdeparturePoint().equalsIgnoreCase(departure) )
			{
			String flightNumber = countryAir[i].getflightNumber();
			String departurePoint = countryAir[i].getdeparturePoint();
			String destination = countryAir[i].getdestination();
			String departureTime = countryAir[i].getdepartureTime();
			counter = 1;
			
			System.out.printf("%-11s %-17s %-18s %s",flightNumber,departurePoint,destination,departureTime);
			System.out.println();
			}
		}
		System.out.println();
		// checking did user input match or not
		if(counter ==0)
		{
			System.out.println(" There is no flight departing from your selected location");
		}
		String flightNumber;
		
		// printing the menu at least once	
		do
		{
			System.out.println();
			System.out.println("  CountryAir Terminal Menu");
			System.out.println("   -----------------------");
			System.out.println("  A - Open Flight");
			System.out.println("  B - Check In Passengers");
			System.out.println("  C - Close Flight");
			System.out.println("  D - Delay Flight");
			System.out.println("  E - Dispaly All Flight");
			System.out.println("  X - Exit Menu");
			System.out.println();
			System.out.println("Enter your selection: ");
			selection = input.nextLine();
			// checking user input match or not 
			// force user to choose right option asking till the proper menu selection
			while(!(selection.equalsIgnoreCase("A")||selection.equalsIgnoreCase("B")
					||selection.equalsIgnoreCase("C")||selection.equalsIgnoreCase("D")
					||selection.equalsIgnoreCase("E")||selection.equalsIgnoreCase("X")))
			{
					System.out.printf("Please choose proper value from list: ");
					selection = input.nextLine();
			}
			// displaying instruction as user selection.
			switch(selection){
				case "A":
				case "a":
					System.out.printf("Pls Enter the Flight Number:");
					flightNumber = input.nextLine();
					for(int i = 0; i < countryAir.length;i++ )
					{
						// checking user input match or not
						if(countryAir[i].getflightNumber().equalsIgnoreCase(flightNumber) )
						{
							flightNumber = countryAir[i].getflightNumber();
							String departurePoint = countryAir[i].getdeparturePoint();
							String destination = countryAir[i].getdestination();
							String departureTime = countryAir[i].getdepartureTime();
							counter = 1;
							System.out.println();
							System.out.printf("%s%11s%20s%19s\n","Flight No.","Departure",
													"Destination","Depart Time");
							System.out.printf("%-11s %-17s %-18s %s\n",flightNumber,departurePoint,	
													destination,departureTime);
							System.out.println();
							boolean result;
							//checking flighy status calling method
							result = countryAir[i].open();
							countryAir[i].open();
							//display the instruction according to flight status							
							if(result == true)
							{
								System.out.println("Flight "+ countryAir[i].getflightNumber() 
													 	  +" has beeen opened for boarding." );
							}
							else
							{
								System.out.println("Flight "+ countryAir[i].getflightNumber() 
													 	+" could not be opened");
							}
							
							
						}
							
					}
					if(counter == 0)
					{
						System.out.println(" Flight " + flightNumber+ " not found" );
						
					}
					counter = 0;
					System.out.println();
					break;
					
				case "B":
				case "b":
					System.out.printf("Pls Enter the Flight Number:");
					flightNumber = input.nextLine();
					for(int i = 0; i < countryAir.length;i++ )
					{
						if(countryAir[i].getflightNumber().equalsIgnoreCase(flightNumber) )
						{
							flightNumber = countryAir[i].getflightNumber();
							String departurePoint = countryAir[i].getdeparturePoint();
							String destination = countryAir[i].getdestination();
							String departureTime = countryAir[i].getdepartureTime();
							counter = 1;
							System.out.println();
							System.out.printf("%s%11s%20s%19s\n","Flight No.","Departure",
													"Destination","Depart Time");
							System.out.printf("%-11s %-17s %-18s %s\n",flightNumber,departurePoint,
													destination,departureTime);
							System.out.println();
							
							boolean result;
							result = countryAir[i].open();
							// Checking the flight status and open for checkin.												
							if(result == true)
							{
								System.out.println("Flight "+ countryAir[i].getflightNumber() 
													 	+ " not openend for boarding." );
								countryAir[i].setgetStatus();
							}
							else
							{
								System.out.printf("Enter no of Passenger");
								int checkIn = input.nextInt();
								countryAir[i].checkIn(checkIn);
								boolean checkResult;
								// check no of passenger to its capacity .
								checkResult = countryAir[i].checkIn(checkIn);
								if(checkResult == true)
								{
									System.out.println(checkIn + " Passengers checked in for flight " + 
															 countryAir[i].getflightNumber());
									countryAir[i].checkIn();
								}
								else
								{
									System.out.println("Error capacity exceed for flight " + 
															 countryAir[i].getflightNumber());
								}
							}
							
							System.out.println();
						}
					}
					if(counter ==0)
					{
						System.out.println(" Flight " + flightNumber+ " not found" );
						
					}
					break;
				
				case "c":
				case "C":
					System.out.printf("Pls Enter the Flight Number:");
					flightNumber = input.nextLine();
					for(int i = 0; i < countryAir.length;i++ )
					{
						if(countryAir[i].getflightNumber().equalsIgnoreCase(flightNumber) )
						{
							flightNumber = countryAir[i].getflightNumber();
							String departurePoint = countryAir[i].getdeparturePoint();
							String destination = countryAir[i].getdestination();
							String departureTime = countryAir[i].getdepartureTime();
							counter = 1;
							System.out.println();
							System.out.printf("%s%11s%20s%19s\n","Flight No.","Departure",
													"Destination","Depart Time");
							System.out.printf("%-11s %-17s %-18s %s\n",flightNumber,departurePoint,
													destination,departureTime);
							System.out.println();
							
							boolean result;
							result = countryAir[i].checkIn();
							
							// Check if check in is done and ready to close							
							if(result == true)
							{
								System.out.println("Flight "+ countryAir[i].getflightNumber() 
													 	+ " has been closed for departure." );
								countryAir[i].setcheckin();
								
							}
							else
							{
								System.out.println("Flight "+ countryAir[i].getflightNumber() + " could not be closed." );
							}
							System.out.println();
						}
					}
					if(counter ==0)
					{
						System.out.println(" Flight " + flightNumber+ " not found" );
						
					}
					break;
					
				case "D":
				case "d":

					System.out.printf("Pls Enter the Flight Number:");
					flightNumber = input.nextLine();
					for(int i = 0; i < countryAir.length;i++ )
					{
						if(countryAir[i].getflightNumber().equalsIgnoreCase(flightNumber) )
						{
							flightNumber = countryAir[i].getflightNumber();
							String departurePoint = countryAir[i].getdeparturePoint();
							String destination = countryAir[i].getdestination();
							String departureTime = countryAir[i].getdepartureTime();
							counter = 1;
							System.out.println();
							System.out.printf("%s%11s%20s%19s\n","Flight No.","Departure",
													"Destination","Depart Time");
							System.out.printf("%-11s %-17s %-18s %s\n",flightNumber,departurePoint,
													destination,departureTime);
							System.out.println();
							int delay = 0;
							boolean result = countryAir[i].delay(delay);
							// if flight is already opened cannot be delayed
							if(result != true)
							{
								System.out.println("Flight "+ countryAir[i].getflightNumber() + " cannot be delayed." );
							}
							else
							{
								System.out.printf("Enter the delay time: ");
								delay = input.nextInt();
								// delay time exceed 4 hour flight is cancelled
								if(delay > 4)
								{
									countryAir[i].addDelayTime(delay);;
									System.out.println("Departure time for flight "+ countryAir[i].getflightNumber()
											+ " is now "+ countryAir[i].getdepartureTime()+" !Flight Canceled");
									countryAir[i].setCancel();
								}
								else
				
									{
										//add the delay time to normal scheduled
										countryAir[i].delay(delay);
										System.out.println("Departure time for flight "+ countryAir[i].getflightNumber()
																+ " is now "+ countryAir[i].getdepartureTime());
										
									}
									
							}
							
							
							
							System.out.println();
						}
					}
					if(counter ==0)
					{
						System.out.println(" Flight " + flightNumber+ " not found" );
						
					}
					break;
					
				case "E":
				case "e":
					System.out.printf("%s%11s%21s%14s%9s%8s%14s\n","Flight","Departure","Destination",
											"Depart","Arrival","Status","Capacity");
					System.out.printf("%s%47s%8s\n","no.","Time","Time");
					System.out.println();
					//Print all the flight detail with new status
					for(int i = 0; i < countryAir.length;i++ )
						{
							countryAir[i].printFlightDetails();
				
						}
					break;
					
				
				// display when user choose x ..	
				default:
					System.out.println();
					System.out.println("Thank you Have a good Day");
			}
			
			// loop till the user choose proper value from menu
		}while(selection.equalsIgnoreCase("A")||selection.equalsIgnoreCase("B")
				||selection.equalsIgnoreCase("C")||selection.equalsIgnoreCase("D")
				|| selection.equalsIgnoreCase("E"));
		
		
		
	}
	
	
	
}
