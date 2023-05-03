package web.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dao.CarDao;

import java.util.List;
@Component
public class CarServiceImpl implements CarService {
    private CarDao dao;
    @Autowired
    public CarServiceImpl(CarDao dao) {
        this.dao = dao;
    }

    @Override
    public void saveCar(Car car) {
        this.dao.saveCar(car);
    }

    @Override
    public List<Car> getCarList(int count) {
        List<Car> cars = this.dao.getCarsList();
        int checkCount = count < 0 ? cars.size() : Math.min(count, cars.size());
        return cars.subList(0, checkCount);
    }
}
