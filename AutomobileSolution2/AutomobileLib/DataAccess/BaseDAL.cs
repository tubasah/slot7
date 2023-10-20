using Microsoft.Data.SqlClient;
using Microsoft.Extensions.Configuration;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AutomobileLib.DataAccess
{
    public class BaseDAL
    {
        public StockDataProvider dataProvider { get; set; } = null;
        public SqlConnection connection = null;

        public BaseDAL()
        {
            var connectionString = getConnectionString();
            dataProvider = new StockDataProvider(connectionString);
        }

        public string getConnectionString()
        {
            string connectionString;
            IConfiguration config = new ConfigurationBuilder()
                .SetBasePath(Directory.GetCurrentDirectory())
                .AddJsonFile("appsettings.json", true, true)
                .Build();
            connectionString = config["ConnectionStrings:MyStoreDB"];
            return connectionString;
        }

        public void closeConnection() => dataProvider.CloseConnection(connection);
    }
}
