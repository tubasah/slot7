using AutomobileLib.BussinessObject;
using AutomobileLib.Repository;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace AutomobileWinApp
{
    public partial class frmCarManagement : Form
    {
        ICarRepository repository = new CarRepository();
        BindingSource source;
        public frmCarManagement()
        {
            InitializeComponent();
        }

        private void btnLoad_Click(object sender, EventArgs e)
        {
            loadCarList();
        }

        private void btnNew_Click(object sender, EventArgs e)
        {
            frmCarDetails frmCarDetails = new frmCarDetails
            {
                Text = "Add a car",
                insertOrUpdate= false,
                carRepository= repository
            };

            if(frmCarDetails.ShowDialog() == DialogResult.OK )
            {
                loadCarList();
                source.Position= source.Count-1;
            }
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            try
            {
                var car = getCarObject();
                repository.DeleteCar(car.carID);
                loadCarList();

            }catch(Exception ex)
            {
                MessageBox.Show(ex.Message,"Delete a car!");
            }
        }

        private void btnClose_Click(object sender, EventArgs e) => Close();

        private void frmCarManagement_Load(object sender, EventArgs e)
        {
            btnDelete.Enabled = false;
            //dgvCarList.CellDoubleClick+= dgvCarList_CellDoubleClick;
        }

        private void dgvCarList_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            frmCarDetails frmCarDetails = new frmCarDetails
            {
                Text = "Update Car",
                insertOrUpdate = true,
                carInfo = getCarObject(),
                carRepository = repository
            };

            if(frmCarDetails.ShowDialog() == DialogResult.OK)
            {
                loadCarList();
                source.Position = source.Count - 1;
            }
        }

        private Car getCarObject()
        {
            Car car = null;
            try
            {
                car = new Car
                {
                    carID = int.Parse(txtCarId.Text),
                    carName= txtCarName.Text,
                    manufacturer = txtManufacturer.Text,
                    price = decimal.Parse(txtPrice.Text),
                    releaseYear = int.Parse(txtReleaseYear.Text)
                };
            }catch(Exception ex)
            {
                MessageBox.Show(ex.Message,"Get Car");
            }
            return car;
        }

        private void loadCarList()
        {
            var cars = repository.GetCars();
            try
            {
                source = new BindingSource();
                source.DataSource = cars;

                txtCarId.DataBindings.Clear();
                txtCarName.DataBindings.Clear();
                txtManufacturer.DataBindings.Clear();
                txtPrice.DataBindings.Clear();
                txtReleaseYear.DataBindings.Clear();

                txtCarId.DataBindings.Add("Text", source, "CarId");
                txtCarName.DataBindings.Add("Text",source, "CarName");
                txtManufacturer.DataBindings.Add("Text",source, "Manufacturer");
                txtPrice.DataBindings.Add("Text",source, "Price");
                txtReleaseYear.DataBindings.Add("Text",source, "ReleaseYear");

                dgvCarList.DataSource = null;
                dgvCarList.DataSource = cars;
                
                if(cars.Count() == 0)
                {
                    clearText();
                    btnDelete.Enabled = false;
                }
                else
                {
                    btnDelete.Enabled = true;
                }
            }catch(Exception ex)
            {
                MessageBox.Show(ex.Message,"Load car list!");
            }
        }

        private void clearText()
        {
            txtCarId.Text = string.Empty;
            txtManufacturer.Text = string.Empty;
            txtPrice.Text = string.Empty;
            txtReleaseYear.Text = string.Empty;
            txtCarName.Text = string.Empty;
        }
    }
}
