using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace slot7
{
    public delegate void PrintDetails(string msg);
    class Program5
    {
        event PrintDetails Print;
        void Show(string msg) => Console.WriteLine(msg.ToUpper());
        static void Main(string[] args)
        {
            Program5 p=new Program5();
            p.Print += new PrintDetails(p.Show);
            p.Print("Hello World");

        }


    }
}
