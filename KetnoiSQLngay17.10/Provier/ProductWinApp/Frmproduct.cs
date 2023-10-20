using Microsoft.Data.SqlClient;
using Microsoft.Extensions.Configuration;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.Common;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ProductWinApp
{
    public partial class Frmproduct : Form
    {
        public Frmproduct()
        {
            InitializeComponent();
        }
        private string GetConnectionString()
        {
            IConfiguration config = new ConfigurationBuilder()
                .SetBasePath(Directory.GetCurrentDirectory())
                .AddJsonFile("appsettings.json", true, true)
                .Build();
            var strConnection = config["ConnectionStrings:MyStoreDB"];
            return strConnection;
        }
        DataSet dataSet = new DataSet();
        private void Frmproduct_Load(object sender, EventArgs e)
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
            String sql = "Select * From Products;Select * From Category";
            try
            {
                SqlDataAdapter sqlDataAdapter = new SqlDataAdapter(sql, GetConnectionString());
                sqlDataAdapter.Fill(dataSet);
            }
            catch (Exception ex) { }
        }

        private void btnViewProduct_Click(object sender, EventArgs e)
        {
            dgvData.DataSource = dataSet.Tables[0];
        }

        private void btnCategory_Click(object sender, EventArgs e)
        {
            dgvData.DataSource = dataSet.Tables[1];
        }

        
    }
}
