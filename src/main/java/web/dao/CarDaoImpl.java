package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
@Component
public class CarDaoImpl implements CarDao {
    private final List<Car> cars = new ArrayList<Car>();

    @Override
    public void saveCar(Car car) {
        this.cars.add(car);
    }

    @Override
    public List<Car> getCarsList() {
        return this.cars;
    }
}
