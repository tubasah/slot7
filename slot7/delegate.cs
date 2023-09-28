using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace slot7
{
    public delegate int MyDelegate(int num1, int num2);
    class Program
    {
        static int add(int num1, int num2) => num1+ num2;
        static int sub(int num1, int num2) => num1 - num2;
        static void Main(string[] args)
        {
            int n1 = 25;
            int n2 = 15;
            int res;
            MyDelegate obj1 = new MyDelegate(add);
            res = obj1(n1, n2);
            Console.WriteLine($"{n1} + {n2} = {res}");
            MyDelegate obj2 = sub;
            res=obj2.Invoke(n1 , n2);
            Console.WriteLine($"{n1} - {n2} = {res}");
        }
    }
}
