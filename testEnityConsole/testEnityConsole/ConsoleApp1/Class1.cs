using ConsoleApp1.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    internal class Class1
    {
        static void Main(string[] args)
        {
            MyStoreContext mystore= new MyStoreContext();
            var products=from p in mystore.Products select new {p.ProductName,p.CategoryId};
            foreach (var product in products)
            {
                Console.WriteLine($" ProductName: { product.ProductName} CategoryID: { product.CategoryId} ");
            }
        }
    }
}
