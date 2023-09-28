using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace slot7
{
    public delegate void MyDeletgate3(string msg);
    class Myclass
    {
        public static void print(String msg) => Console.WriteLine($"{msg.ToUpper()}");
        public static void show(String msg) => Console.WriteLine($"{msg.ToLower()}");
        public static void display(String msg) => Console.WriteLine($"{msg}");
    }
    class Program3
    {
        static void Main(string[] args)
        {
            string msg = "Multicast Delegate";
            MyDeletgate3 Mydele01 = Myclass.print;
            MyDeletgate3 Mydele02 = Myclass.show;
            MyDeletgate3 Mydele03 = Myclass.display;

            Console.WriteLine("combine 1+2");
            MyDeletgate3 Mydel = Mydele01 + Mydele02;
            Mydel(msg);
            Mydel += Mydele03;
            Console.WriteLine("combine 1+2+3");
            Mydel(msg);

            Console.WriteLine("remove 2");
            Mydel -= Mydele02;
            Mydel("Hello World");


        }
    }
}
