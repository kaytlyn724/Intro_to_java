// Assignment: 10
// Name: Kaytlyn Daffern
// StudentID: 1221263225
// Lecture: Tu-Th 1:30-2:45
// Time took to complete: 2 hours
// Description: This LinkedList java class offers options for the Assignment 10 file where users can remove their reservation
// at any position in the list as well as check position in the queue, see how many reservations have this many guests,
// and list all current reservations

public class LinkedList {
    Table first;
    int size;
    
    public LinkedList(){
        first = null;
        size = 0;
    }

    public void add(int numberOfGuests, String name){
        Table newGuest = new Table(numberOfGuests, name);
        if(first == null){
            first = newGuest;
        }
        else{
            Table pointer = first;
            while(pointer.next != null)
                pointer = pointer.next;

            pointer.next = newGuest;
        }
        size++;
    }
    
    public Table removeFirst() {
    	
    	if (first == null) {
    		first = new Table.EmptyTable();
    		size++;
    		return first;
    	}
    	
    	else {
    		Table temp = first;
    		first = first.next;
    		size--;
    		return temp;
    	}
    }
    
    public Table removeLast() {
    	Table temp = null;
    	Table pointer = first;
    	
    	while (pointer.next.next != null) {
    		pointer = pointer.next;
    	}
    	temp = pointer.next;
    	pointer.next = null;
    	
    	size--;
    	return temp;
    }
    
    public Table removeMiddle(String name) {
    	
    	Table temp = null;
    	Table mid = first;
    	
    	if (first.name.equals(name)) {
    		return removeFirst();
    	}
    	while(mid != null) {
			temp = mid;
			mid = mid.next;
			if((mid != null) && (mid.name.equals(name))) {
				temp.next = mid.next;
				
				size--;
				return mid;
			}
		}
    	return new Table.EmptyTable();
    }
    
    public Table removeGuest(String name) {
    	
    	int pos = getPosition(name);
		
		if(pos < 0) {
			return new Table.EmptyTable();
		}
		
		else if(pos == 0) {
			return removeFirst();
		}
		else if(pos == size - 1) {
			return removeLast();
		}
		else {
			return removeMiddle(name);
		}
    }
    
    public int getPosition(String name) {
    	int pos = 0;
    	Table pointer = first;
    	if(first == null) {
    		return -1;
    	}
    	while(pointer != null) {
        	if(pointer.name.equals(name)) {
        		return pos;
        	}
        	else {
        		pointer = pointer.next;
            	pos++;
        	}
        }
    	
        return -1;
    }
    
    public int getNumberOfParties(int numGuests) {
		Table pointer = first;
		int num = 0;
    	
    	if(pointer == null) {
    		return -1;
    	}
    	
    	while (pointer != null) {
			if (pointer.guests == numGuests) {
				pointer = pointer.next;
				num++;
			}
			else {
				pointer = pointer.next;
			}
    	}
    	return num;
    }
    
    public String listReservations() {
    	Table pointer = first;
		int num = 0;
		String statement = "";
		
		while (pointer != null) {
			if (pointer.guests < 0) {
				pointer = pointer.next;
			}
			else {
				num++;
				statement += pointer.toString();
				pointer = pointer.next;
			}
    	}
		if(num == 0) {
			return "No reservations in queue at this time.\n";
		}
		return (statement + "\nTotal reservations: " + num + ".\n");
    }
    
    

}
