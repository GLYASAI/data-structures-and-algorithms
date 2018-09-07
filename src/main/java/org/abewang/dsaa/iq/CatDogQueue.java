package org.abewang.dsaa.iq;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗队列问题
 *
 * @Author Abe
 * @Date 2018/5/2.
 */
public class CatDogQueue {
    private Queue<PetQueue> dogQ = new LinkedList<>();
    private Queue<PetQueue> catQ = new LinkedList<>();
    private static int count = 0;

    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    public static class PetQueue {
        private Pet pet;
        private int count;

        public PetQueue(Pet pet, int count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }
        public int getCount() {
            return count;
        }
    }

    public void add(Pet pet) {
        if (pet.getPetType().equals("dog")) {
            dogQ.add(new PetQueue(new Dog(), count++));
        } else if (pet.getPetType().equals("cat")) {
            catQ.add(new PetQueue(new Cat(), count++));
        } else {
            throw new RuntimeException("err, not dog or cat");
        }
    }

    public Pet pollAll() {
        if (!dogQ.isEmpty() && !catQ.isEmpty()) {
            if (dogQ.peek().getCount() < catQ.peek().getCount()) {
                return dogQ.poll().getPet();
            } else {
                return catQ.poll().getPet();
            }
        } else if (!dogQ.isEmpty()) {
            return dogQ.poll().getPet();
        } else if (!catQ.isEmpty()) {
            return catQ.poll().getPet();
        } else {
            throw new RuntimeException("the queue is empty");
        }
    }

    public Pet pollDog() {
        if (dogQ.isEmpty()) {
            throw new RuntimeException("the dogQ is empty");
        }

        return dogQ.poll().getPet();
    }

    public Pet pollCat() {
        if (catQ.isEmpty()) {
            throw new RuntimeException("the catQ is empty");
        }

        return catQ.poll().getPet();
    }

    public Boolean isEmpty() {
        return isDogQEmpty() && isCatQEmpty();
    }

    public Boolean isDogQEmpty() {
        return dogQ.isEmpty();
    }

    public Boolean isCatQEmpty() {
        return catQ.isEmpty();
    }

    public static void main(String[] args) {
        CatDogQueue test = new CatDogQueue();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
        while (!test.isDogQEmpty()) {
            System.out.println(test.pollDog().getPetType());
        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getPetType());
        }
    }
}
