using AutomobileLib.BussinessObject;
using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AutomobileLib.DataAccess
{
    public class CarDBContext : BaseDAL
    {
        private static CarDBContext instance =null;
        private static readonly object instamceLock = new object();
        private CarDBContext() { }
        public static CarDBContext Instance
        {
            get
            {
                lock(instamceLock)
                {
                    if(instance== null)
                    {
                        instance = new CarDBContext();
                    }
                }
                return instance;
            }
        }

        public IEnumerable<Car> getCars() 
        {
            IDataReader dataReader=null;
            string SQLSelect = "Select * from Cars";
            var cars = new List<Car>();
            try
            {
                dataReader = dataProvider.GetDataReader(SQLSelect, CommandType.Text, out connection);
                while(dataReader.Read())
                {
                    cars.Add(new Car
                    {
                        carID = dataReader.GetInt32(0),
                        carName= dataReader.GetString(1),
                        manufacturer = dataReader.GetString(2),
                        price = dataReader.GetDecimal(3),
                        releaseYear = dataReader.GetInt32(4)
                    });
                }
            }catch(Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                dataReader.Close();
                closeConnection();
            }
            return cars;
        }


        public Car getCarByID(int carID)
        {
            Car car=null;
            IDataReader dataReader = null;
            string sqlString = "Select * from Cars where CarId= @CarId";
            try
            {
                var param = dataProvider.createParameter("@CarId",4,carID,DbType.Int32);
                dataReader = dataProvider.GetDataReader(sqlString, CommandType.Text, out connection, param);
                if(dataReader.Read() )
                {
                    car = new Car
                    {
                        carID = dataReader.GetInt32(0),
                        carName = dataReader.GetString(1),
                        manufacturer = dataReader.GetString(2),
                        price = dataReader.GetDecimal(3),
                        releaseYear = dataReader.GetInt32(4)
                    };
                }
            }
            catch(Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                dataReader.Close();
                closeConnection();
            }
            return car;
        }

        public void addNew(Car car)
        {
            try
            {
                Car product = getCarByID(car.carID);
                if(product == null)
                {
                    string sqlString = "Insert Cars values(@CarId,@CarName,@Manufacturer,@Price,@ReleasedYear)";
                    var parameters = new List<SqlParameter>();
                    parameters.Add(dataProvider.createParameter("@CarID",4,car.carID,DbType.Int32));
                    parameters.Add(dataProvider.createParameter("@CarName",50,car.carName,DbType.String));
                    parameters.Add(dataProvider.createParameter("@Manufacturer", 50,car.manufacturer,DbType.String));
                    parameters.Add(dataProvider.createParameter("@Price", 50,car.price,DbType.Decimal));
                    parameters.Add(dataProvider.createParameter("@ReleasedYear", 4, car.releaseYear, DbType.Int32));
                    dataProvider.Insert(sqlString, CommandType.Text, parameters.ToArray());

                }
                else
                {
                    throw new Exception("Car is already exist!");
                }

            }catch(Exception ex) 
            { 
                throw new Exception(ex.Message);
            }
            finally
            {
                closeConnection();
            }
        }


        public void update(Car car)
        {
            try
            {
                Car c  = getCarByID(car.carID);
                if(c!=null)
                {
                    string sqlString = "Update Cars set CarName = @CarName, Manufacturer = @Manufacturer,Price =@Price, ReleasedYear = @ReleasedYear where CarId = @CarId";
                    var parameters = new List<SqlParameter>();
                    parameters.Add(dataProvider.createParameter("@CarId", 4, car.carID, DbType.Int32));
                    parameters.Add(dataProvider.createParameter("@CarName", 50, car.carName, DbType.String));
                    parameters.Add(dataProvider.createParameter("@Manufacturer", 50, car.manufacturer, DbType.String));
                    parameters.Add(dataProvider.createParameter("@Price", 50, car.price, DbType.Decimal));
                    parameters.Add(dataProvider.createParameter("@ReleasedYear", 4, car.releaseYear, DbType.Int32));
                    dataProvider.Update(sqlString, CommandType.Text, parameters.ToArray());
                }
                else
                {
                    throw new Exception("Car does not exist!");
                }
            }
            catch(Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally { closeConnection(); }
        }

        public void remove(int carID)
        {
            try
            {
                Car c = getCarByID(carID);
                if(c!=null)
                {
                    string sqlString = "Delete Cars where CarId=@CarId";
                    var param = dataProvider.createParameter("@CarId",4,carID, DbType.Int32);
                    dataProvider.Delete(sqlString,CommandType.Text, param);
                }
                else
                {
                    throw new Exception("Car does not exist!");
                }

            }
            catch(Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally { closeConnection(); }
        }
    }
}
