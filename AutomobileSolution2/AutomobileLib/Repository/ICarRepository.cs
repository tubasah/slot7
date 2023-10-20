using AutomobileLib.BussinessObject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AutomobileLib.Repository
{
    public interface ICarRepository
    {
        IEnumerable<Car> GetCars();
        Car GetCarById(int carId);
        void UpdateCar(Car car);
        void DeleteCar(int carId);
        void InsertCar(Car car);
    }
}
