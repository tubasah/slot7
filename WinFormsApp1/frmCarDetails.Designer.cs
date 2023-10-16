namespace WinFormsApp1
{
    partial class frmCarDetails
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            lbCarID = new Label();
            lbCarName = new Label();
            lbMaufacturer = new Label();
            lbPrice = new Label();
            lbReleasedYear = new Label();
            txtCarID = new TextBox();
            txtCarName = new TextBox();
            txtPrice = new TextBox();
            txtReleasedYear = new TextBox();
            cboManufacturer = new ComboBox();
            btnSave = new Button();
            btnCancel = new Button();
            SuspendLayout();
            // 
            // lbCarID
            // 
            lbCarID.AutoSize = true;
            lbCarID.Location = new Point(109, 59);
            lbCarID.Margin = new Padding(5, 0, 5, 0);
            lbCarID.Name = "lbCarID";
            lbCarID.Size = new Size(73, 30);
            lbCarID.TabIndex = 0;
            lbCarID.Text = "Car ID";
            // 
            // lbCarName
            // 
            lbCarName.AutoSize = true;
            lbCarName.Location = new Point(109, 117);
            lbCarName.Margin = new Padding(5, 0, 5, 0);
            lbCarName.Name = "lbCarName";
            lbCarName.Size = new Size(110, 30);
            lbCarName.TabIndex = 1;
            lbCarName.Text = "Car Name";
            // 
            // lbMaufacturer
            // 
            lbMaufacturer.AutoSize = true;
            lbMaufacturer.Location = new Point(109, 175);
            lbMaufacturer.Margin = new Padding(5, 0, 5, 0);
            lbMaufacturer.Name = "lbMaufacturer";
            lbMaufacturer.Size = new Size(131, 30);
            lbMaufacturer.TabIndex = 1;
            lbMaufacturer.Text = "Maufacturer";
        
            // 
            // lbPrice
            // 
            lbPrice.AutoSize = true;
            lbPrice.Location = new Point(109, 233);
            lbPrice.Margin = new Padding(5, 0, 5, 0);
            lbPrice.Name = "lbPrice";
            lbPrice.Size = new Size(60, 30);
            lbPrice.TabIndex = 1;
            lbPrice.Text = "Price";
       
            // 
            // lbReleasedYear
            // 
            lbReleasedYear.AutoSize = true;
            lbReleasedYear.Location = new Point(109, 291);
            lbReleasedYear.Margin = new Padding(5, 0, 5, 0);
            lbReleasedYear.Name = "lbReleasedYear";
            lbReleasedYear.Size = new Size(146, 30);
            lbReleasedYear.TabIndex = 1;
            lbReleasedYear.Text = "Released Year";
  
            // 
            // txtCarID
            // 
            txtCarID.Location = new Point(291, 59);
            txtCarID.Margin = new Padding(5, 6, 5, 6);
            txtCarID.Name = "txtCarID";
            txtCarID.Size = new Size(293, 36);
            txtCarID.TabIndex = 2;
            // 
            // txtCarName
            // 
            txtCarName.Location = new Point(291, 118);
            txtCarName.Margin = new Padding(5, 6, 5, 6);
            txtCarName.Name = "txtCarName";
            txtCarName.Size = new Size(293, 36);
            txtCarName.TabIndex = 2;
            // 
            // txtPrice
            // 
            txtPrice.Location = new Point(291, 233);
            txtPrice.Margin = new Padding(5, 6, 5, 6);
            txtPrice.Name = "txtPrice";
            txtPrice.Size = new Size(293, 36);
            txtPrice.TabIndex = 2;
            txtPrice.Text = "0";
            // 
            // txtReleasedYear
            // 
            txtReleasedYear.Location = new Point(291, 291);
            txtReleasedYear.Margin = new Padding(5, 6, 5, 6);
            txtReleasedYear.Name = "txtReleasedYear";
            txtReleasedYear.Size = new Size(293, 36);
            txtReleasedYear.TabIndex = 2;
            txtReleasedYear.Text = "0";
            // 
            // cboManufacturer
            // 
            cboManufacturer.BackColor = SystemColors.ButtonShadow;
            cboManufacturer.FormattingEnabled = true;
            cboManufacturer.Items.AddRange(new object[] { "Audi", "BMW", "Ford", "Honda", "Hyundai", "Kia", "Suzuki ", "Toyota" });
            cboManufacturer.Location = new Point(291, 175);
            cboManufacturer.Margin = new Padding(5, 6, 5, 6);
            cboManufacturer.Name = "cboManufacturer";
            cboManufacturer.Size = new Size(293, 38);
            cboManufacturer.TabIndex = 3;
            // 
            // btnSave
            // 
            btnSave.BackColor = SystemColors.AppWorkspace;
            btnSave.Location = new Point(291, 359);
            btnSave.Margin = new Padding(5, 6, 5, 6);
            btnSave.Name = "btnSave";
            btnSave.Size = new Size(129, 46);
            btnSave.TabIndex = 4;
            btnSave.Text = "Save";
            btnSave.UseVisualStyleBackColor = false;
            btnSave.Click += btnSave_Click;
            // 
            // btnCancel
            // 
            btnCancel.BackColor = SystemColors.AppWorkspace;
            btnCancel.Location = new Point(455, 359);
            btnCancel.Margin = new Padding(5, 6, 5, 6);
            btnCancel.Name = "btnCancel";
            btnCancel.Size = new Size(129, 46);
            btnCancel.TabIndex = 4;
            btnCancel.Text = "Cancel";
            btnCancel.UseVisualStyleBackColor = false;
            btnCancel.Click += btnCancel_Click;
            // 
            // frmCarDetails
            // 
            AutoScaleDimensions = new SizeF(12F, 30F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(705, 565);
            Controls.Add(btnCancel);
            Controls.Add(btnSave);
            Controls.Add(cboManufacturer);
            Controls.Add(txtReleasedYear);
            Controls.Add(txtPrice);
            Controls.Add(txtCarName);
            Controls.Add(txtCarID);
            Controls.Add(lbReleasedYear);
            Controls.Add(lbPrice);
            Controls.Add(lbMaufacturer);
            Controls.Add(lbCarName);
            Controls.Add(lbCarID);
            Font = new Font("Segoe UI", 16F, FontStyle.Regular, GraphicsUnit.Point);
            Margin = new Padding(5, 6, 5, 6);
            Name = "frmCarDetails";
            Text = "frmCarDetails";
            Load += frmCarDetails_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label lbCarID;
        private Label lbCarName;
        private Label lbMaufacturer;
        private Label lbPrice;
        private Label lbReleasedYear;
        private TextBox txtCarID;
        private TextBox txtCarName;
        private TextBox txtPrice;
        private TextBox txtReleasedYear;
        private ComboBox cboManufacturer;
        private Button btnSave;
        private Button btnCancel;
    }
}