package cisc181.lab_6;

/**
 * a class for TrainCar
 */
public class TrainCar {
    private String cargo;
    private TrainCar next;

    /**
     *  a constructor that accepts and sets both properties
     * @param cargo what the train load
     * @param next next train
     */
    public TrainCar(String cargo, TrainCar next) {
        this.cargo = cargo;
        this.next = next;
    }

    /**
     * a getCargo method
     * @return a getCargo method
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * a getNext method that returns the next TrainCar
     * @return the next TrainCar
     */
    public TrainCar getNext() {
        return next;
    }

    /**
     * a setCargo method
     * @param cargo a setCargo method
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * a setNext method which will set the next property to the TrainCar passed to this method
     * @param next the next property to the TrainCar
     */
    public void setNext(TrainCar next) {
        this.next = next;
    }

    /**
     * Override the toString method to return the cargo
     * @return return the cargo
     */
    @Override
    public String toString() {
        return cargo;
    }
}
