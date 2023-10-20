using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AutomobileLib.DataAccess
{
    public class StockDataProvider
    {
        public StockDataProvider() { }

        private String ConnectionString { get; set; }
        public StockDataProvider(String connectionString) => ConnectionString = connectionString;

        public void CloseConnection(SqlConnection connection) => connection.Close();

        public SqlParameter createParameter(String name, int size, object value, DbType dbType, ParameterDirection direction = ParameterDirection.Input)
        {
            return new SqlParameter { DbType = dbType, ParameterName = name, Size = size, Value = value, Direction = direction };
        }

        public IDataReader GetDataReader(String commandText, CommandType commandType, out SqlConnection connection, params SqlParameter[] parameters)
        {
            IDataReader reader = null;
            try
            {
                connection = new SqlConnection(ConnectionString);
                connection.Open();
                var command = new SqlCommand(commandText, connection);
                command.CommandType = commandType;
                if (parameters != null)
                {
                    foreach (var param in parameters)
                    {
                        command.Parameters.Add(param);
                    }
                }
                reader = command.ExecuteReader();
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            return reader;
        }



        public void Delete(string commandText, CommandType commandType, params SqlParameter[] parameters)
        {
            try
            {
                using var connection = new SqlConnection(ConnectionString); connection.Open();
                using var command = new SqlCommand(commandText, connection); command.CommandType = commandType;
                if (parameters != null)
                {
                    foreach (var parameter in parameters)
                    {
                        command.Parameters.Add(parameter);
                    }
                    //-
                }
                command.ExecuteNonQuery();
            }

            catch (Exception ex)
            {
                throw new Exception("Data Provider: Delete Method", ex.InnerException);
            }
        }

        public void Insert(string commandText, CommandType commandType, params SqlParameter[] parameters)
        {
            try
            {
                using var connection = new SqlConnection(ConnectionString); connection.Open();
                using var command = new SqlCommand(commandText, connection); command.CommandType = commandType;
                if (parameters != null)
                {
                    foreach (var parameter in parameters)
                    {
                        command.Parameters.Add(parameter);
                    }
                    command.ExecuteNonQuery();

                }
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
        }



        public void Update(string commandText, CommandType commandType, params SqlParameter[] parameters)
        {
            try
            {
                using var connection = new SqlConnection(ConnectionString); connection.Open();
                using var command = new SqlCommand(commandText, connection); command.CommandType = commandType;
                if (parameters != null)
                {
                    foreach (var parameter in parameters)
                    {
                        command.Parameters.Add(parameter);
                    }
                    command.ExecuteNonQuery();
                }
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
        }

    }//end class
}//end namespace
