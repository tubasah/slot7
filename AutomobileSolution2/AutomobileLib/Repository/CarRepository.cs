using AutomobileLib.BussinessObject;
using AutomobileLib.DataAccess;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AutomobileLib.Repository
{
    public class CarRepository : ICarRepository
    {
        public void DeleteCar(int carId) => CarDBContext.Instance.remove(carId);

        public Car GetCarById(int carId) => CarDBContext.Instance.getCarByID(carId);

        public IEnumerable<Car> GetCars() => CarDBContext.Instance.getCars();

        public void InsertCar(Car car) => CarDBContext.Instance.addNew(car);

        public void UpdateCar(Car car) => CarDBContext.Instance.update(car);
    }
}
