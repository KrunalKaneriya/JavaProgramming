
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		LinkedList<String>placesToVisit = new LinkedList<String>();
		addInOrder(placesToVisit,"Sydney");
		addInOrder(placesToVisit,"Melbourne");
		addInOrder(placesToVisit,"Brisbane");
		addInOrder(placesToVisit,"Perth");
		addInOrder(placesToVisit,"Canberra");
		addInOrder(placesToVisit,"Adelaide");
		addInOrder(placesToVisit,"Darwin");
		addInOrder(placesToVisit,"Alice Springs");
		addInOrder(placesToVisit,"Darwin");
		printList(placesToVisit);
		visit(placesToVisit);
//		placesToVisit.add("Sydney");
//		placesToVisit.add("Melbourne");
//		placesToVisit.add("Brisbane");
//		placesToVisit.add("Perth");
//		placesToVisit.add("Canberra");
//		placesToVisit.add("Adelaide");
//		placesToVisit.add("Darwin");
//
//		printList(placesToVisit);
//		placesToVisit.add(1,"Alice Springs");
//		printList(placesToVisit);
//		placesToVisit.remove(4);
//		printList(placesToVisit);
	}

	private static void printList(LinkedList<String>linkedList) {

		Iterator<String> i =linkedList.iterator();
		while(i.hasNext()) {
			System.out.println("Visiting: " + i.next());
		}
		System.out.println("========================");
	}

	private static boolean addInOrder(LinkedList<String>linkedList,String newCity) {

		ListIterator<String> stringListIterator = linkedList.listIterator();
		while(stringListIterator.hasNext()) {
			int comparison = stringListIterator.next().compareTo(newCity);
			if(comparison==0) {
				//equal do not add
				System.out.println(newCity + " is already included.");
				return false;
			} else if(comparison>0) {
				//new city should appear before this one
				//brisbane -> adelaide
				//now here there will be problem that if we enter in this method
				//then the list will go to next element so we need to go back to previous
				//element and adding the element at that place.
				stringListIterator.previous();
				stringListIterator.add(newCity);
				return true;
			} else if(comparison<0) {
				//move on next city

			}
		}
		stringListIterator.add(newCity);
		return true;
	}

	private static void visit(LinkedList cities) {
		Scanner scanner = new Scanner(System.in);
		boolean quit = false;
		boolean goingforward = true;
		ListIterator<String> listIterator = cities.listIterator();
		if (cities.isEmpty()) {
			System.out.println("No Cities in the items list.");
		} else {
			System.out.println("Now visiting " + listIterator.next());
			printMenu();
		}
		while (!quit) {
			int action = scanner.nextInt();
			scanner.nextLine();
			switch (action) {
				case 0:
					System.out.println("Vacation Over");
					quit = true;
					break;
				case 1:
					if(!goingforward) {
						if(listIterator.hasNext()) {
							listIterator.next();
						}
						goingforward=true;
					}
					if(listIterator.hasNext()) {
						System.out.println("Now Visiting " + listIterator.next());
						goingforward = true;
					} else {
						System.out.println("Reached the end..");
						goingforward = false;
					}
					break;
				case 2:
					if(goingforward) {
						if(listIterator.hasPrevious()) {
							listIterator.previous();
						}
						goingforward = false;
					}
					if(listIterator.hasPrevious()) {
						System.out.println("Now Visiting "+ listIterator.previous());
					} else {
						System.out.println("We are at Start of the list");
					}
					break;
				case 3:
					printMenu();
			}


		}

	}
	private static void printMenu() {
		System.out.println("Available Action \n Press ");
		System.out.println("0 = to quit\n"  +
				"1 = go to next city\n" +
				"2= go to previous city\n"+
				"3 = print menu");
	}
}

