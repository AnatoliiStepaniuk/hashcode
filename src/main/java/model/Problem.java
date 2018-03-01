package model;

/**
 * Created by Denys on 2018-03-01.
 */
public class Problem {

    int rows;
    int columns;
    int vehicles;
    int rides;
    int bonus;
    int steps;

    public int getRows() {
        return rows;
    }

    public Problem setRows(int rows) {
        this.rows = rows;
        return this;
    }

    public int getColumns() {
        return columns;
    }

    public Problem setColumns(int columns) {
        this.columns = columns;
        return this;
    }

    public int getVehicles() {
        return vehicles;
    }

    public Problem setVehicles(int vehicles) {
        this.vehicles = vehicles;
        return this;
    }

    public int getRides() {
        return rides;
    }

    public Problem setRides(int rides) {
        this.rides = rides;
        return this;
    }

    public int getBonus() {
        return bonus;
    }

    public Problem setBonus(int bonus) {
        this.bonus = bonus;
        return this;
    }

    public int getSteps() {
        return steps;
    }

    public Problem setSteps(int steps) {
        this.steps = steps;
        return this;
    }
}
