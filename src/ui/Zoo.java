package ui;

import exceptions.BrokeException;
import exceptions.MessyError;
import model.Animal;
import model.Keeper;
import model.Manager;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            animals.add(new Animal());
        }
        Keeper keeper = new Keeper(animals);
        Manager manager = new Manager(animals, keeper);
        System.out.println("Zoo is open for business.");
        try {
            manager.manage();
        } catch (BrokeException e) {
            System.out.println("Reduce costs!");
        } catch (MessyError e) {
            System.out.println("Keeper, you're fired!");
        }
        finally {
            System.out.println("... profits");
        }
        System.out.println("And everything goes on as normal");
    }


}