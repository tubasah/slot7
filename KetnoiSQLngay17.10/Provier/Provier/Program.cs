using Microsoft.Data.SqlClient;
using Microsoft.Extensions.Configuration;
using System;
using System.Data.Common;
using System.IO;

class Program
{
    // Get connection string from appsettings.json
    static string GetConnectionString()
    {
        IConfiguration config = new ConfigurationBuilder()
            .SetBasePath(Directory.GetCurrentDirectory())
            .AddJsonFile("appsettings.json", true, true)
            .Build();
        var strConnection = config["ConnectionStrings:MyStoreDB"];
        return strConnection;
    }

    static void ViewProducts()
    {
        DbProviderFactory factory = SqlClientFactory.Instance;

        // Get the connection object.
        using DbConnection connection = factory.CreateConnection();
        if (connection == null)
        {
            Console.WriteLine("Unable to create the connection object.");
            return;
        }
        connection.ConnectionString = GetConnectionString();
        connection.Open();

        // Make command object.
        using DbCommand command = factory.CreateCommand();
        if (command == null)
        {
            Console.WriteLine("Unable to create the command object.");
            return;
        }
        command.Connection = connection;
        command.CommandText = "SELECT ProductID, ProductName FROM Products"; // Remove the space

        // Print out data with data reader.
        using DbDataReader dataReader = command.ExecuteReader();
        Console.WriteLine("***** Product List ******* ");
        while (dataReader.Read())
        {
            Console.WriteLine($"Product ID: {dataReader["ProductID"]}, Product Name: {dataReader["ProductName"]}.");
        }
    }

    static void Main(string[] args)
    {
        ViewProducts();
        Console.ReadLine();
    }
}
