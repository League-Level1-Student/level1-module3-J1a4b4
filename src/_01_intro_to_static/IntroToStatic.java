package _01_intro_to_static;

public class IntroToStatic {

	
     static int nextBibNumber;
     static String raceLocation = "New York";
     static String raceStartTime = "9.00am";

     String name;
     int speed;
     int bibNumber;
     
IntroToStatic (String name, int speed){
     this.name = name;
     this.speed = speed;
     nextBibNumber ++;
     bibNumber = nextBibNumber;
}

public static void main(String[] args) {
     //create two athletes      //print their names, bibNumbers, and the location of their race.
	IntroToStatic john = new IntroToStatic("John", 20);
	IntroToStatic jane = new IntroToStatic("Jane", 21);
	System.out.println(john.name);
	System.out.println(jane.name);
	System.out.println(john.bibNumber);
	System.out.println(jane.bibNumber);
	System.out.println(raceLocation);
}
}
