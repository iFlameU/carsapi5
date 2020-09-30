package cars.services;

import cars.dao.CarsDao;
import cars.models.Car;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class CarsService {

    @Inject
    private CarsDao carsDao;

    public List<Car> getCars() {
        return carsDao.getCars();
    }

    public void addCar(Car car) {
        car.setId(carsDao.getNextId());
        carsDao.getCars().add(car);
    }

    public void modifyCar(Car car) {
        carsDao.getCars().forEach(c -> {
            if(c.getId() == car.getId()) {
                c.setType(car.getType());
                c.setBrand(car.getBrand());
            }
        });
    }

    public void deleteCar(int id) {
        for (Car car: carsDao.getCars()) {
            if (car.getId() == id) {
                carsDao.getCars().remove(car);
                break;
            }
        }

    }
}
