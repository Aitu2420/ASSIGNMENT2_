/*
continue working with your subject area;
- follow data abstraction principle; (done)
- organizing a data pool, applying filtering, searching and sorting; (done)
- implement encapsulation, inheritance and polymorphism; (done)
- override toString , equals , hashCode methods. (done)
*/
import java.lang.String;
import java.util.ArrayList; //Is necessary for abstraction, because we are constructing new animals indirectly, only by abstraction of Animal class
import java.util.Scanner;
public class Assignment2 {
    public abstract static class Animal { //Making  the abstraction as basis for our next Animal classes that will be in our list of Animals
        private String diet; //principles of encapsulation
        private int age; //principles of encapsulation
        private String kind; //principles of encapsulation
        private String name; //principles of encapsulation
        public Animal(String diet, int age, String kind, String name) {
            this.diet = diet;
            this.age = age;
            this.kind = kind;
            this.name = name;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setKind(String kind) {
            this.kind = kind;
        }
        public void setDiet(String diet) {
            this.diet = diet;
        }
        public String toString() { //Replacement of getInfo() method
            return "This Animal's name is " + name + " and that is a " + kind + ". It is " + age + " years old and loves " + diet + "\n";
        }
        public int hashCode(Animal animal) { //Implementation of hashCode() method
            return animal.hashCode();
        }
        public static String equals(Animal animal1, Animal animal2) { //Implementation of equals() method
            if (animal1.equals(animal2)) {
                return "These animals are the same!:D";
            }
            return "Nope, they are completely different;(";
        }
    }
    public static class Cat extends Animal { //implementation of Inheritance and Polymorphism
        public Cat(String diet, int age, String kind, String name) {
            super(diet, age, kind, name); //We have full-filled the class in terms of abstraction class, which we used as constructor of that class
        }
    }
    public static class Bird extends Animal { //implementation of Inheritance and Polymorphism since one class is used for creation of new classes
        public Bird(String diet, int age, String kind, String name) {
            super(diet, age, kind, name); //We have full-filled the class in terms of abstraction class, which we used as constructor of that class
        }
    }
    public static class Fish extends Animal { //implementation of Inheritance and Polymorphism
        public Fish(String diet, int age, String kind, String name) {
            super(diet, age, kind, name); //We have full-filled the class in terms of abstraction class, which we used as constructor of that class
        }
    }
    public static class Zookeeper { //Still the same
        private int age; //principles of encapsulation
        private String gender; //principles of encapsulation
        private String name; //principles of encapsulation
        private int work_years; //principles of encapsulation
        public Zookeeper(int age, String gender, String name, int work_years) {
            this.age = age;
            this.gender = gender;
            this.name = name;
            this.work_years = work_years;
        }
        public void getInfo() {
            System.out.print("Zookeeper's name is " + name);
            if(gender == "female") {
                System.out.print(", her ");
            } else {
                System.out.print(", his ");
            }
            System.out.print("gender and age are " + gender + " and " + age + " respectively, and the Zookeeper works here for " + work_years + " years.\n");
        }
        public void setAge(int age) {
            this.age = age;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setWork_years(int work_years) {
            this.work_years = work_years;
        }
        public void setGender(String gender) {
            this.gender = gender;
        }
    }
    public static class Zoo { //Still the same
        private String name; //principles of encapsulation
        public Zoo(String name) {
            this.name = name;
        }
        public void getInfo() {
            System.out.print("This Zoo's name is " + name + ".\n");
        }
        public void setName(String name) {
            this.name = name;
        }
    }
    public static void main(String argc[]) {
        Scanner s = new Scanner(System.in);
        Cat cat1 = new Cat("fish", 3, "Cat","Barsik-chmarsik");
        Cat cat2 = new Cat("meat", 2, "Cat","Temka");
        Bird bird1 = new Bird("insects", 2, "Bird", "Karlushka");
        Fish fish1 = new Fish("sand and garbage", 1, "Fish", "Yasik");
        ArrayList<Animal> animals = new ArrayList<>(); //Datapool
        ArrayList<Animal> favorites = new ArrayList<>();//Datapool
        animals.add(cat1);
        animals.add(cat2);
        animals.add(bird1);
        animals.add(fish1);
        System.out.println("What animal do you want to see and add to your favorites?");
        int c = 0;
        System.out.println("1. A Cat");
        System.out.println("2. A Bird");
        System.out.println("3. A Fish");
        String choice = s.next();
        for(Animal animal : animals) { //Filter and searcing operations by kind
            if(animal.kind.equals(choice)) {
                System.out.println(animal.toString() + "Is it what you want?");
                String choice2 = s.next();
                if(choice2.equals("yes")) {
                    favorites.add(animal);
                    c++;
                } else {
                    System.out.println("Okay, we are going straight on");
                }
            }
        }
        if(c == 0) {
            System.out.println("Unfortunately, there are not such animals;(");
            System.out.println("Here are all kind of animals you like!");
            int c1 = 1;
            for(Animal animal : animals) { //Sorting operation
                if(animal.kind.equals(choice)) {
                    System.out.print(c1 + ". " + animal.toString());
                    c1++;
                }
            }
        } else {
            System.out.println("Congrats! You have just added your favorite animals to your own list!");
        }
    }
}