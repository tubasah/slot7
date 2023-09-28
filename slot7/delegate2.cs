using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace slot7
{
    public delegate void MyDelegate1(string msg);
    class MyClass
    {
        public static void print(String msg) => Console.WriteLine($"{msg.ToUpper()}");
        public static void show(String msg) => Console.WriteLine($"{msg.ToLower()}");


    }
    class Program1
    {
        static void InvokeDelegate(MyDelegate1 dele, string msg) => dele(msg);
        static void Main(string[] args)
        {
            string msg = "Passing Delegate As a Parameter";
            InvokeDelegate(MyClass.print, msg);

            InvokeDelegate(MyClass.show, msg);
        }
    }

}
