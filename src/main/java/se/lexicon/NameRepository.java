package se.lexicon;

import java.util.Arrays;

/**
 * The NameRepository class provides methods to manage a list of names.
 * It offers functionalities such as adding, removing, finding, and updating names.
 */
public class NameRepository {

    private static String[] names = new String[0];


    /**
     * Retrieves the current size of the names array.
     *
     * @return The number of elements in the names array.
     */
    public static int getSize() {
        //todo: PART 1: implement getSize method
        int length = names.length;
        return length;
    }


    /**
     * Sets the names array to the provided array of names & it should replace all existing names.
     *
     * @param newNames The array of names to set.
     */
    public static void setNames(String[] newNames) {
        //todo: PART 1: implement setNames method
        if ((newNames != null) || (newNames.length != 0)) {
            names = newNames;
        }
    }


    /**
     * Clears the names array by creating a new empty array.
     */
    public static void clear() {
        //todo: PART 1: implement clear method
        names = new String[0];
    }


    /**
     * Returns all names in a new array (Retrieves a copy of the names array).
     *
     * @return A new array containing all elements from the names array.
     */
    public static String[] findAll() {
        //todo: PART 1: implement findAll method
        String[] foundNamesArray = new String[0];
        //foundNamesArray = names.clone();
        foundNamesArray =  Arrays.copyOf(names, names.length);
        return foundNamesArray;
    }


    /**
     * Finds a name that matches the given fullName case-insensitively.
     *
     * @param fullName The full name to search for.
     * @return The matching name if found; otherwise, null.
     */
    public static String find(String fullName) {
        //todo: PART 2: implement find method
        for (String name : names) {
            if (name.equals(fullName)) {
                return name;
            }
        }
        return null;
    }


    /**
     * Adds a new fullName to the names array if it doesn't already exist.
     *
     * @param fullName The full name to add.
     * @return True if the fullName is added successfully; false if it already exists.
     */
    public static boolean add(String fullName) {
        //todo: PART 2: implement add method
        if (find(fullName) == null) {
            String[] newNames = Arrays.copyOf(names, names.length + 1);
            newNames[newNames.length - 1] = fullName;
            names = newNames;
            return true; // Name already exists
        }
        return false;// Name already exist
    }


    /**
     * Find all names that match the given firstName.
     *
     * @param firstName The first name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByFirstName(String firstName) {
        //todo: PART 3: findByFirstName method
        // First, count the number of matches
        int count = 0;
        for (String name : names) {
            if (name.startsWith(firstName + " ")) {
                count++;
            }
        }

        // Create an array to hold the matching names
        String[] matchingFristNames = new String[count];
        int index = 0;
        for (String name : names) {
            if (name.startsWith(firstName + " ")) {
                matchingFristNames[index++] = name;
            }
        }

        return matchingFristNames;
    }


    /**
     * Find all names that match the given lastName.
     *
     * @param lastName The last name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByLastName(String lastName) {
        //todo: PART 3: implement findByLastName method
        int count = 0;
        for (String name : names) {
            // Split the name into parts to find the last name
            String[] parts = name.split(" ");
            if (parts.length > 1 && parts[1].equals(lastName)) {
                count++;
            }
        }

        // Create an array to hold the matching names
        String[] lastMatchingNames = new String[count];
        int index = 0;
        for (String name : names) {
            // Split the name into parts to find the last name
            String[] parts = name.split(" ");
            if (parts.length > 1 && parts[1].equals(lastName)) {
                lastMatchingNames[index++] = name;
            }
        }

        return lastMatchingNames;
    }


    /**
     * Updates a name in the names array from the original name to the updated name.
     *
     * @param original    The original name to update.
     * @param updatedName The updated name to set.
     * @return True if the name is updated successfully; false if the updated name already exists or the original name is not found.
     */
    public static boolean update(String original, String updatedName) {
        //todo: PART 3: implement update method
        // Find the index of the original name in the names array
        int index = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(original)) {
                index = i;
                break;
            }
        }

        // If original name not found, return false
        if (index == -1) {
            return false;
        }

        // Check if updatedName already exists in the array (excluding the original itself)
        for (int i = 0; i < names.length; i++) {
            if (i != index && names[i].equals(updatedName)) {
                return false; // Updated name already exists
            }
        }

        // Perform the update
        names[index] = updatedName;
        return true;
    }


    /**
     * Removes a name from the names array, case-insensitively.
     *
     * @param fullName The full name to remove.
     * @return True if the name is removed successfully; false if the name is not found in the array.
     */
    public static boolean remove(String fullName) {
        //todo: PART 4: implement remove method
        int index = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(fullName)) {
                index = i;
                break;
            }
        }
        // If fullName not found, return false
        if (index == -1) {
            return false;
        }
        // Create a new array with one less slot
        String[] newNames = new String[names.length - 1];
        // Copy the names before the removed index
        System.arraycopy(names, 0, newNames, 0, index);
        // Copy the names after the removed index
        System.arraycopy(names, index + 1, newNames, index, names.length - index - 1);
        // Update the names array
        names = newNames;
        return true;
    }
}