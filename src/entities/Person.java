package entities;

abstract class Person {
    private final int id;
    private final String name;
    private static int idCounter = 1;

    public Person(String Name) {
        this.id = idCounter++;
        this.name = Name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
}
