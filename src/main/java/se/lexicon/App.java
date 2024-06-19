package se.lexicon;


public class App {
    public static void main(String[] args) {

        int size = NameRepository.getSize();
        System.out.println(size);
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        System.out.println(NameRepository.getSize());
        // call more methods as needed
        //call the clear
        NameRepository.clear();
        System.out.println(NameRepository.getSize());

        //find the names in the array
        NameRepository.setNames(new String[]{"Amira Leo", "Ananya Leo", "Andrew Joseph"});
        String[] currentNames = NameRepository.findAll();
        System.out.println("The current names array is: ");
        for (String name : currentNames) {
            System.out.println(name);
        }

        //To find a name exist
        String findName = "Ananya Leo";
        String foundName = NameRepository.find(findName);
        System.out.println("Found name: " + (foundName != null ? foundName : (findName +" Not found")));

        //To find a name not exist
        findName = "Amira";
        foundName = NameRepository.find(findName);
        System.out.println("Found name: " + (foundName != null ? foundName : (findName +" Not found")));

        //To add a new name
        boolean added = NameRepository.add("Rahul");
        System.out.println("Added Rahul: " + added);

        //To add a name that exist
        added = NameRepository.add("Andrew Joseph");
        System.out.println("Added Andrew Joseph again: " + added);

        //To find the name with the first name
        String[] foundFristNames = NameRepository.findByFirstName("Andrew");
        System.out.println("Names found with first name Andrew: ");
        for (String name : foundFristNames) {
            System.out.println(name);
        }

        //To find the name with the last name
        String[] foundLAstNames = NameRepository.findByLastName("Leo");
        System.out.println("Names found with Last name Leo: ");
        for (String name : foundLAstNames) {
            System.out.println(name);
        }

        //to update the array
        boolean updated = NameRepository.update("Amira Leo", "Amira Christopher");
        System.out.println("Updated Amira Leo to Amira Christopher: " + updated);

        updated = NameRepository.update("Ananya Leo", "Ananya Christopher");
        System.out.println("Updated Ananya Leo to Ananya Christopher: " + updated);

        updated = NameRepository.update("Charlie Brown", "Bob Smith");
        System.out.println("Updated Charlie Brown to Bob Smith: " + updated);

        //to remave a name
        boolean removed = NameRepository.remove("Andrew Joseph");
        System.out.println("Removed Andrew Joseph: " + removed);

        removed = NameRepository.remove("David Miller");
        System.out.println("Removed David Miller: " + removed);

        System.out.println("The current names array is: ");
        for (String name : currentNames) {
            System.out.println(name);
        }
    }
}
