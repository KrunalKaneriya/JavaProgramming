public class Main {

    public static void main(String[] args) {
	Dimensions dimensions = new Dimensions(20,20,5);
	Case theCase = new Case("220B","dell","240",dimensions);

	Monitor theMonitor = new Monitor("27 INch Beast","Acer",27,new Resolution(2540,1440));

	Motherboard themotherboard = new Motherboard("BJ-200","Asus",4,6,"2.44");

	PC thePC = new PC(theCase,theMonitor,themotherboard);

	thePC.getTheCase().pressPowerButton();
	thePC.powerUp();

	//theMonitor.drawPixelAt(21,45,"Red");
    }
}
