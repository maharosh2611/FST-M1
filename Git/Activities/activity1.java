package Activities;

public class activity1 {
	
	public static class Car {
	    //Class Member Variables
	    String color;
	    int make;
	    String transmission;
	    int tyres;
	    int doors;
	    String name;
		
	    //Constructor
	    Car() {
		tyres = 4;
		doors = 4;
	    }

	    //Class Methods
	    public void displayCharacterstics(){
	    	System.out.println("car company name: " + name);
		System.out.println("Color of the Car: " + color);
		System.out.println("Make of the Car: " + make);
		System.out.println("Transmission of the Car: " + transmission);
		System.out.println("Number of doors on the car: " + doors);
	    	System.out.println("Number of tyres on the car: " + tyres);
	    }

	    public void accelerate() {
		System.out.println("Car is moving forward.");
	    }
		
	    public void brake() {
		System.out.println("Car has stopped.");
	    }

	
	 public static void main(String[] args) {
	        Car toyota = new Car();
	        toyota.name = "Toyota";
	        toyota.make = 2014;
	        toyota.color = "Black";
	        toyota.transmission = "Manual";
	    
	        //Using Car class method
	        toyota.displayCharacterstics();
	        toyota.accelerate();
	        toyota.brake();
	    }
	}
}