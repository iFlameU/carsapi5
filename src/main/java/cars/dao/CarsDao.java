package cars.dao;

import cars.models.Car;

import javax.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class CarsDao {
    private final ArrayList<Car> cars;
    private int id;

    public CarsDao() {
        cars = new ArrayList<>();
        id = 0;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public int getNextId() {
        return id++;
    }
}
