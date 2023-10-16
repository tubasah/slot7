namespace WinFormsApp1
{
    partial class frmCarManagement
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
            lbManufacturer = new Label();
            lbPrice = new Label();
            lbReleasedYear = new Label();
            txtCarID = new TextBox();
            txtCarName = new TextBox();
            txtmanufacturer = new TextBox();
            txtPrice = new TextBox();
            txtReleasedYear = new TextBox();
            btnLoad = new Button();
            btnNew = new Button();
            btnDel = new Button();
            btnClose = new Button();
            dgvCarList = new DataGridView();
            ((System.ComponentModel.ISupportInitialize)dgvCarList).BeginInit();
            SuspendLayout();
            // 
            // lbCarID
            // 
            lbCarID.AutoSize = true;
            lbCarID.Location = new Point(69, 72);
            lbCarID.Margin = new Padding(5, 0, 5, 0);
            lbCarID.Name = "lbCarID";
            lbCarID.Size = new Size(59, 25);
            lbCarID.TabIndex = 0;
            lbCarID.Text = "CarID";
            // 
            // lbCarName
            // 
            lbCarName.AutoSize = true;
            lbCarName.Location = new Point(69, 120);
            lbCarName.Margin = new Padding(5, 0, 5, 0);
            lbCarName.Name = "lbCarName";
            lbCarName.Size = new Size(96, 25);
            lbCarName.TabIndex = 0;
            lbCarName.Text = "Car Name";
            // 
            // lbManufacturer
            // 
            lbManufacturer.AutoSize = true;
            lbManufacturer.Location = new Point(69, 168);
            lbManufacturer.Margin = new Padding(5, 0, 5, 0);
            lbManufacturer.Name = "lbManufacturer";
            lbManufacturer.Size = new Size(127, 25);
            lbManufacturer.TabIndex = 0;
            lbManufacturer.Text = "Manufacturer";
            // 
            // lbPrice
            // 
            lbPrice.AutoSize = true;
            lbPrice.Location = new Point(518, 68);
            lbPrice.Margin = new Padding(5, 0, 5, 0);
            lbPrice.Name = "lbPrice";
            lbPrice.Size = new Size(54, 25);
            lbPrice.TabIndex = 0;
            lbPrice.Text = "Price";
            // 
            // lbReleasedYear
            // 
            lbReleasedYear.AutoSize = true;
            lbReleasedYear.Location = new Point(518, 120);
            lbReleasedYear.Margin = new Padding(5, 0, 5, 0);
            lbReleasedYear.Name = "lbReleasedYear";
            lbReleasedYear.Size = new Size(127, 25);
            lbReleasedYear.TabIndex = 0;
            lbReleasedYear.Text = "Released Year";
            // 
            // txtCarID
            // 
            txtCarID.Location = new Point(200, 65);
            txtCarID.Margin = new Padding(5);
            txtCarID.Name = "txtCarID";
            txtCarID.Size = new Size(251, 32);
            txtCarID.TabIndex = 1;
            // 
            // txtCarName
            // 
            txtCarName.Location = new Point(200, 113);
            txtCarName.Margin = new Padding(5);
            txtCarName.Name = "txtCarName";
            txtCarName.Size = new Size(251, 32);
            txtCarName.TabIndex = 1;
            // 
            // txtmanufacturer
            // 
            txtmanufacturer.Location = new Point(200, 161);
            txtmanufacturer.Margin = new Padding(5);
            txtmanufacturer.Name = "txtmanufacturer";
            txtmanufacturer.Size = new Size(251, 32);
            txtmanufacturer.TabIndex = 1;
            // 
            // txtPrice
            // 
            txtPrice.Location = new Point(644, 61);
            txtPrice.Margin = new Padding(5);
            txtPrice.Name = "txtPrice";
            txtPrice.Size = new Size(251, 32);
            txtPrice.TabIndex = 1;
            // 
            // txtReleasedYear
            // 
            txtReleasedYear.Location = new Point(644, 120);
            txtReleasedYear.Margin = new Padding(5);
            txtReleasedYear.Name = "txtReleasedYear";
            txtReleasedYear.Size = new Size(251, 32);
            txtReleasedYear.TabIndex = 1;
            // 
            // btnLoad
            // 
            btnLoad.BackColor = SystemColors.AppWorkspace;
            btnLoad.Location = new Point(200, 223);
            btnLoad.Margin = new Padding(5);
            btnLoad.Name = "btnLoad";
            btnLoad.Size = new Size(118, 38);
            btnLoad.TabIndex = 2;
            btnLoad.Text = "Load";
            btnLoad.UseVisualStyleBackColor = false;
            btnLoad.Click += btnLoad_Click;
            // 
            // btnNew
            // 
            btnNew.BackColor = SystemColors.AppWorkspace;
            btnNew.Location = new Point(456, 223);
            btnNew.Margin = new Padding(5);
            btnNew.Name = "btnNew";
            btnNew.Size = new Size(118, 38);
            btnNew.TabIndex = 2;
            btnNew.Text = "New";
            btnNew.UseVisualStyleBackColor = false;
            btnNew.Click += btnNew_Click;
            // 
            // btnDel
            // 
            btnDel.BackColor = SystemColors.AppWorkspace;
            btnDel.Location = new Point(712, 223);
            btnDel.Margin = new Padding(5);
            btnDel.Name = "btnDel";
            btnDel.Size = new Size(118, 38);
            btnDel.TabIndex = 2;
            btnDel.Text = "Delete";
            btnDel.UseVisualStyleBackColor = false;
            btnDel.Click += btnDel_Click;
            // 
            // btnClose
            // 
            btnClose.BackColor = SystemColors.AppWorkspace;
            btnClose.Location = new Point(488, 628);
            btnClose.Margin = new Padding(5);
            btnClose.Name = "btnClose";
            btnClose.Size = new Size(118, 38);
            btnClose.TabIndex = 2;
            btnClose.Text = "Close";
            btnClose.UseVisualStyleBackColor = false;
            btnClose.Click += btnClose_Click;
            // 
            // dgvCarList
            // 
            dgvCarList.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dgvCarList.Location = new Point(200, 300);
            dgvCarList.Margin = new Padding(5);
            dgvCarList.Name = "dgvCarList";
            dgvCarList.ReadOnly = true;
            dgvCarList.RowTemplate.Height = 25;
            dgvCarList.Size = new Size(695, 305);
            dgvCarList.TabIndex = 3;
            dgvCarList.CellDoubleClick += DgvCarList_CellDoubleClick;
            // 
            // frmCarManagement
            // 
            AutoScaleDimensions = new SizeF(11F, 25F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(960, 701);
            Controls.Add(dgvCarList);
            Controls.Add(btnClose);
            Controls.Add(btnDel);
            Controls.Add(btnNew);
            Controls.Add(btnLoad);
            Controls.Add(txtReleasedYear);
            Controls.Add(txtPrice);
            Controls.Add(txtmanufacturer);
            Controls.Add(txtCarName);
            Controls.Add(txtCarID);
            Controls.Add(lbReleasedYear);
            Controls.Add(lbPrice);
            Controls.Add(lbManufacturer);
            Controls.Add(lbCarName);
            Controls.Add(lbCarID);
            Font = new Font("Segoe UI", 14F, FontStyle.Regular, GraphicsUnit.Point);
            Margin = new Padding(5);
            Name = "frmCarManagement";
            Text = "frmCarManagement";
            Load += frmCarManagement_Load;
            ((System.ComponentModel.ISupportInitialize)dgvCarList).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label lbCarID;
        private Label lbCarName;
        private Label lbManufacturer;
        private Label lbPrice;
        private Label lbReleasedYear;
        private TextBox txtCarID;
        private TextBox txtCarName;
        private TextBox txtmanufacturer;
        private TextBox txtPrice;
        private TextBox txtReleasedYear;
        private Button btnLoad;
        private Button btnNew;
        private Button btnDel;
        private Button btnClose;
        private DataGridView dgvCarList;
    }
}