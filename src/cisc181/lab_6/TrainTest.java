package cisc181.lab_6;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrainTest {

    @Test
    public void test_Train() {

        System.out.println("Testing Train");

        Train cargoTrain = new Train();

        cargoTrain.attachAtFront("coal");
        assertEquals(cargoTrain.getHeadCargo().equals("coal"),true);

        cargoTrain.attachAtFront("bananas");
        assertEquals(cargoTrain.getHeadCargo().equals("bananas"),true);

        cargoTrain.attachAtEnd("lumber");
        cargoTrain.attachAtEnd("apples");


        assertEquals(cargoTrain.removeFromFront().equals("bananas"),true);
        assertEquals(cargoTrain.removeFromFront().equals("coal"),true);

        // add more TrainCars to your Train and  add Test cases to remove them

        cargoTrain.attachAtFront("pears");
        cargoTrain.attachAtFront("papers");

        assertEquals(cargoTrain.removeFromFront().equals("papers"),true);
        assertEquals(cargoTrain.removeFromFront().equals("pears"), true);
        assertEquals(cargoTrain.getHeadCargo().equals("lumber"), true);
        assertEquals(cargoTrain.removeFromEnd().equals("apples"), true);
        assertEquals(cargoTrain.removeFromFront().equals("lumber"), true);
        assertEquals(cargoTrain.removeFromFront(), null);
        assertEquals(cargoTrain.removeFromEnd() == null, true);

    }

}