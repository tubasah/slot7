using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace slot7
{
    class Program4
    {
        static int Sum(int x, int y) => x + y;
        static void Print(String msg)=> Console.WriteLine(msg.ToUpper());
        static void Main(string[] args)
        {
            int a = 15, b = 25, s;
            string strResult;
            Func<int, int, int> sumFunc = Sum;
            s=sumFunc(a, b);
            strResult=$"{a} + {b} = {s} ";
            Console.WriteLine("invoke print method by action delegate");
            Action<string> action = Print;
            action(strResult);

        }
    }
}
