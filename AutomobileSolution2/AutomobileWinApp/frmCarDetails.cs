using AutomobileLib.BussinessObject;
using AutomobileLib.Repository;

namespace AutomobileWinApp
{
    public partial class frmCarDetails : Form
    {
        public frmCarDetails()
        {
            InitializeComponent();
        }

        public ICarRepository carRepository { get; set; }
        public bool insertOrUpdate { get; set; }
        public Car carInfo { get; set; }

        private void frmCarDetails_Load(object sender, EventArgs e)
        {
            cboManufacturer.BindingContext= this.BindingContext;
            txtCarId.Enabled = !insertOrUpdate;
            if(insertOrUpdate)
            {
                txtCarId.Text = carInfo.carID.ToString();
                txtCarName.Text = carInfo.carName.ToString();
                txtPrice.Text = carInfo.price.ToString();
                txtReleaseYear.Text = carInfo.releaseYear.ToString();
                cboManufacturer.Text = carInfo.manufacturer.Trim();
            }

        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            try
            {
                var car = new Car
                {
                    carID = int.Parse(txtCarId.Text),
                    carName = txtCarName.Text,
                    price = decimal.Parse(txtPrice.Text),
                    releaseYear = int.Parse(txtReleaseYear.Text),
                    manufacturer = cboManufacturer.Text
                };
                if(insertOrUpdate)
                {
                    carRepository.UpdateCar(car);
                }
                else
                {
                    carRepository.InsertCar(car);
                }
            }
            catch(Exception ex)
            {
               MessageBox.Show(ex.Message,insertOrUpdate == false ?"Add a new car":"Update a car");
            }
        }

        private void btnCancel_Click(object sender, EventArgs e) => this.Close();
    }
}