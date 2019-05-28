package tests;

import exceptions.AllergyException;
import exceptions.NotHungry;
import model.Animal;
import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertTrue;

public class AnimalTests {

    @Test
    public void eatIsHungryNotAllergic() {
        //expecting eatenTimes to be 1 and no exceptions thrown.
        Animal animal = new Animal(true, false);
        int eatenTimes = 0;

        try {
            eatenTimes = animal.eat();
        } catch (AllergyException e) {
            fail("Got allergic when shouldn't have");
        } catch (NotHungry e) {
            fail("Got hungry when we shouldn't have");
        }

        assertTrue(eatenTimes == 1);
    }

    @Test
    public void eatNotHungryNotAllergic() {
        //expecting a NotHungry exception to be thrown
        //and for eatenTimes to remain 0
        Animal animal = new Animal(false, false);
        int eatenTimes = 0;

        try {
            eatenTimes = animal.eat();
        } catch (AllergyException e) {
            fail("Got allergy exception");
        } catch (NotHungry e) {
            //don't have to do anything here
        }
        assertTrue(eatenTimes == 0);
    }

    @Test
    public void eatIsHungryIsAllergic() {
        //expecting an IsAllergic exception to be thrown
        //and for eatenTimes to remain 0
        Animal animal = new Animal(true, true);
        int eatenTimes = 0;

        try {
            eatenTimes = animal.eat();
        } catch (AllergyException e) {
            //don't have to do anything here
        } catch (NotHungry e) {
            fail("Got isHungry exception");
        }
        assertTrue(eatenTimes == 0);
    }

    @Test
    public void eatNotHungryIsAllergic() {
        //expecting a notHungry exception to be thrown
        //and for eatenTimes to remain 0
        Animal animal = new Animal(false, true);
        int eatenTimes = 0;

        try {
            eatenTimes = animal.eat();
        } catch (AllergyException e) {
            fail("Got allergy exception");
        } catch (NotHungry e) {
            //don't have to do anything here
        }
        assertTrue(eatenTimes == 0);
    }
}
