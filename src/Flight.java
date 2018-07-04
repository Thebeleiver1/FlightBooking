
public class Flight 
{
	private String flightNumber;
	private String departurePoint;
	private String destination;
	private String departureTime;
	private String arrivalTime;
	private int capacity;
	private int checkedInPassengers;
	private int currentDelay;
	private char status;
	
	// constructor	
	public Flight (String flightNumber, String departurePoint,
			 String destination, String departureTime,
			 String arrivalTime, int capacity)
	{
		
		this.flightNumber = flightNumber;
		this.departurePoint = departurePoint;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime =  arrivalTime;
		this.capacity = capacity;
		this.status = 'S';
		
	}
	
	// accessor for private variable
	
	public char getStatus()
	{
		return status;
	}
	
	
	 
	public String getdeparturePoint()
	{
		 return departurePoint;
	 }
	
	public String getflightNumber()
	{
		return flightNumber;
	}
	
	public String getdestination()
	{
		return destination;
	}
	
	public int getCapacity()
	{
		return capacity;
	}
	
	public String getdepartureTime()
	{
		return departureTime;
	}
	
	public String getArrival()
	{
		return arrivalTime;
	}
	
	// mutator to change some variable value;
	
	public void setgetStatus()
	{
		this.status = 'S';
	}
	
	public void setcheckin()
	{
		this.status = 'D';
	}
	
	public void setCancel()
	{
		this.status = 'C';
	}
	
	// checking status to checkIn.
	public boolean checkIn()
	{
		if(this.status == 'B')
		{
			return true;
		}
		else
			return false;
	}
	//checking flight status.
	public boolean open(){
		if(status == 'S')
		{
			this.status = 'B';
			
			return true;
		}
		
		return false;
	}
	
	// method to close the flight .
	public boolean close()
	{
		if(status == 'B')
		{
			this.status = 'D';
			return true;
		}
		return false;
	}
	
	
	// checking no of passenger  capacity.
	public boolean checkIn(int passengers)
	{
		if(status == 'B' && passengers <= capacity)
		{
			this.checkedInPassengers = passengers;
			return true;
		}
		return false;
	}
	
	// check cancelled if not hour of delay
	public boolean delay(int hours)
	{
		if(status != 'S')
		{
			return false;
		}
		else
		{
			if(hours <= 4)
			{
				// function to add hours.
				addDelayTime(hours);
			
				this.status = 'S';
				
				return true;
			}
			else
			{
				this.status = 'C';
				return false;
			}
		}
	}
	
	// adding delay time to departure and arrival time 
	public void addDelayTime(int add)
	{
		String[] parts = departureTime.split(":");
		String[] parts1 = arrivalTime.split(":");
		String departureHour = parts[0];
		String departureMin = parts[1];
		String arrivalHour = parts1[0];
		String arrivalMin = parts1[1];
		// converting string to integer
		int departureHour1 = Integer.parseInt(departureHour);
		int arrivalHour1 = Integer.parseInt(arrivalHour);
		// adding delay time and start form 0 if it is 24
		int departHour = (departureHour1 + add)%24;
		int arriveHour = (arrivalHour1+add)%24;
		String dHour = String.format("%02d",departHour);
		String aHour = String.format("%02d",arriveHour);
		// combining hour and minute.
		this.departureTime = dHour + ":" + departureMin;
		this.arrivalTime = aHour + ":" + arrivalMin;
		
	}
	
	// printing all the required details
	public void printDetails()
	{
		System.out.println(flightNumber);
		System.out.println(departurePoint);
		System.out.println(destination);
		System.out.println(departureTime);
		System.out.println(arrivalTime);
		System.out.println(checkedInPassengers);
		if(status == 'S')
			System.out.println("Scheduled");
			
		if(status == 'B')
			System.out.println("Boarding");
		if(status == 'D')
			System.out.println("Departed");
		if(status == 'C')
			System.out.println("Canceled");
		
				
	}
	
	public void printFlightDetails()
	{
		
		String flightNumber = getflightNumber();
		String departurePoint = getdeparturePoint();
		String destination = getdestination();
		String departureTime = getdepartureTime();
		char status = getStatus();
		String arrivalTime = getArrival();
		int capacity = getCapacity();
		String stat ="Scheduled";
		if(status == 'S')
			stat = "Scheduled";
			
		if(status == 'B')
			stat = "Boarding";
		if(status == 'D')
			stat = "Departed";
		if(status == 'C')
			stat = "cancelled";
		
		
		
		System.out.printf("%-7s %-18s %-18s %-7s %-8s %-13s %-7s",flightNumber,departurePoint
								,destination,departureTime,arrivalTime,stat,capacity);
		System.out.println();
	}
	

}



