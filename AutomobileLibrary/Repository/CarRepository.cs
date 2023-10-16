using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AutomobileLibrary.BussinessObject;
using AutomobileLibrary.DataAccess;

namespace AutomobileLibrary.Repository
{
    public class CarRepository : ICarRepository
    {
        public void DeleteCar(int carID) => CarDBContext.Instance.Remove(carID);



        public Car GetCarbyID(int carID) => CarDBContext.Instance.GetCarByID(carID);


        public IEnumerable<Car> GetCarts() => CarDBContext.Instance.GetCarList();


        public void InsertCar(Car car) => CarDBContext.Instance.AddNew(car);


        public void UpdateCar(Car car) => CarDBContext.Instance.Update(car);
    }

}
