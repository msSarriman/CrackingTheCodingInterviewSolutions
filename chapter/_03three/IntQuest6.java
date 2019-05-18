/**
 * Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first
 * out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
 * or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
 * that type). They cannot select which specific animal they would like. Create the data structures to
 * maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
 * and dequeueCat. You may use the built-in Linked List data structure.
 * Hints: #22, #56, #63
 * - We could consider keeping a single linked list for dogs and cats, and then iterating
 * through it to find the first dog (or cat).What is the impact of doing this?
 * - Let's suppose we kept separate lists for dogs and cats. How would we find the oldest
 * animal of any type? Be creative!
 * - Think about how you'd do it in real life.You have a list of dogs in chronological order and
 * a list of cats in chronological order. What data would you need to find the oldest animal?
 * How would you maintain this data?
 */

package chapter._03three;

import java.util.LinkedList;
import java.util.Random;

public class IntQuest6 {
    static class ShelterQueue<T> {
        LinkedList<T> dogs;
        LinkedList<T> cats;


        /**
         * Constructor
         */
        ShelterQueue() {
            this.dogs = new LinkedList<>();
            this.cats = new LinkedList<>();
        }


        /**
         * enqueue()
         * Adds an animal to the corresponding list.
         *
         * @param type   = the type of the animal
         * @param animal = the animal
         */
        protected void enqueue(String type, T animal) {
            if (type.equals("dog")) {
                dogs.add(animal);
            } else if (type.equals("cat")) {
                cats.add(animal);
            } else {
                System.out.println("Must be \"dog\" or \"cat\"");
            }
        }


        /**
         * dequeueAny()
         * Returns randomly the oldest cat or dog.
         *
         * @return = the corresponding animal
         */
        protected T dequeueAny() {
            T animalToReturn = null;
            Random rand = new Random();
            int dogOrCat = rand.nextInt(100) % 2;
            if (dogOrCat == 0 && !dogs.isEmpty()) {
                animalToReturn = dogs.getFirst();
                dogs.remove();
            } else if (!cats.isEmpty()) {
                animalToReturn = cats.getFirst();
                cats.remove();
            }
            return animalToReturn;
        }


        /**
         * Returns the oldest dog, and rearranges the list.
         *
         * @return = the corresponding dog.
         */
        protected T dequeueDog() {
            T dogToReturn = null;
            if (!dogs.isEmpty()) {
                dogToReturn = dogs.getFirst();
                dogs.remove();
            }
            return dogToReturn;
        }


        /**
         * Returns the oldest cat, and rearranges the list.
         *
         * @return = the corresponding cat.
         */
        protected T dequeueCat() {
            T catToReturn = null;
            if (!cats.isEmpty()) {
                catToReturn = cats.getFirst();
                cats.remove();
            }
            return catToReturn;
        }
    }

    public static void main(String[] args) {
        ShelterQueue<String> myQueue = new ShelterQueue<>();

        myQueue.enqueue("dog", "bob");
        myQueue.enqueue("dog", "pepita");
        myQueue.enqueue("dog", "fix");
        myQueue.enqueue("dog", "rico");
        myQueue.enqueue("dog", "deva");

        myQueue.enqueue("cat", "leo");
        myQueue.enqueue("cat", "clair");
        myQueue.enqueue("cat", "psipsinel");
        myQueue.enqueue("cat", "gloomy");
        myQueue.enqueue("cat", "barfoo");

        System.out.println("Dequeue any: " + myQueue.dequeueAny());
        System.out.println("Dequeue any: " + myQueue.dequeueAny());

        System.out.println("Dequeue cat: " + myQueue.dequeueCat());
        System.out.println("Dequeue cat: " + myQueue.dequeueCat());
        System.out.println("Dequeue cat: " + myQueue.dequeueCat());
        System.out.println("Dequeue cat: " + myQueue.dequeueCat());
        System.out.println("Dequeue cat: " + myQueue.dequeueCat());

        System.out.println("Dequeue dog: " + myQueue.dequeueDog());
        System.out.println("Dequeue dog: " + myQueue.dequeueDog());
        System.out.println("Dequeue dog: " + myQueue.dequeueDog());
        System.out.println("Dequeue dog: " + myQueue.dequeueDog());
        System.out.println("Dequeue dog: " + myQueue.dequeueDog());
    }
}

