package web.model;

import java.util.List;

public interface CarService {
    void saveCar(Car car);
    List<Car> getCarList(int count);
}
