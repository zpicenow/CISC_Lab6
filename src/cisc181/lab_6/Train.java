package cisc181.lab_6;

/**
 * a class for train
 */
public class Train {
    private TrainCar head;

    /**
     * a constructor that doesn’t accept any parameters and sets head to null
     */
    public Train() {
        this.head = null;

    }

    /**
     *  a getHeadCargo that returns the cargo of the first TrainCar
     * @return the cargo of the first TrainCar
     */
    public String getHeadCargo() {
        if (head != null) {
            return head.getCargo();
        } else {
            return null;
        }
    }

    /**
     * accepts a String representing the cargo that the  new TrainCar will carry and attaches a new TrainCar to the front of the Train
     * @param cargo  the  new TrainCar will carry
     */
    public void attachAtFront(String cargo) {
        TrainCar p = head;
        head = new TrainCar(cargo,p);
    }

    /**
     *  removes the first TrainCar from the train and returns the cargo that it held
     * @return returns the cargo that it held or null
     */
    public String removeFromFront() {
        if (head == null) {
            return null;
        }

            TrainCar p = head;
            head = head.getNext();
            return p.getCargo();


    }

    /**
     * accepts a String representing the cargo that the new TrainCar will carry and attaches a new TrainCar to the end of the Train
     * @param cargo the new TrainCar will carry
     */
    public void attachAtEnd(String cargo) {
        TrainCar trainCar = new TrainCar(cargo, null);
        TrainCar p = head;
        if (p == null) {
            head = trainCar;
        } else {
            while (p.getNext() != null) {
                p = p.getNext();
            }
            p.setNext(trainCar);
        }

    }

    /**
     * removes the last TrainCar from the train and returns the cargo that it held (return null if there are no TrainCars in the Train
     * @return the cargo that it held (return null if there are no TrainCars in the Train
     */
    public String removeFromEnd() {
        if (head == null) {
            return null;
        }

        TrainCar p = head,temp = null;
        while (p.getNext() != null) {
            if (p.getNext().getNext() == null) {
                temp = p.getNext();
                p.setNext(null);
            }
        }
        if (temp!=null)
            return temp.getCargo();
        else
            return null;
    }

}

