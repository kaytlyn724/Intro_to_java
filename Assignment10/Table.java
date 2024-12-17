// Assignment: 10
// Name: Kaytlyn Daffern
// StudentID: 1221263225
// Lecture: Tu-Th 1:30-2:45
// Time took to complete: 2 hours
// Description: This fine instantiates a new table for the Assignment 10 file.

public class Table {
    String name;
    int guests;
    Table next;

    public Table(int n, String name){
        this.name = name;
        guests = n;
        next = null;
    }

    public String toString(){
        return "\nReservation for " + name + ": party of "
                + guests + ".\n";
    }


    public static class EmptyTable extends Table{

        public EmptyTable() {
            super(-1, "");
        }
    }
}
