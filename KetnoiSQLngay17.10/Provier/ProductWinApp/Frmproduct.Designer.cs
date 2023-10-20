namespace ProductWinApp
{
    partial class Frmproduct
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
            btnViewProduct = new Button();
            btnCategory = new Button();
            dgvData = new DataGridView();
            ((System.ComponentModel.ISupportInitialize)dgvData).BeginInit();
            SuspendLayout();
            // 
            // btnViewProduct
            // 
            btnViewProduct.Location = new Point(197, 38);
            btnViewProduct.Name = "btnViewProduct";
            btnViewProduct.Size = new Size(136, 29);
            btnViewProduct.TabIndex = 0;
            btnViewProduct.Text = "View Product";
            btnViewProduct.UseVisualStyleBackColor = true;
            btnViewProduct.Click += btnViewProduct_Click;
            // 
            // btnCategory
            // 
            btnCategory.Location = new Point(439, 38);
            btnCategory.Name = "btnCategory";
            btnCategory.Size = new Size(126, 29);
            btnCategory.TabIndex = 1;
            btnCategory.Text = "View Category";
            btnCategory.UseVisualStyleBackColor = true;
            btnCategory.Click += btnCategory_Click;
            // 
            // dgvData
            // 
            dgvData.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dgvData.Location = new Point(23, 84);
            dgvData.Name = "dgvData";
            dgvData.RowHeadersWidth = 51;
            dgvData.RowTemplate.Height = 29;
            dgvData.Size = new Size(765, 354);
            dgvData.TabIndex = 3;
            // 
            // Frmproduct
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(dgvData);
            Controls.Add(btnCategory);
            Controls.Add(btnViewProduct);
            Name = "Frmproduct";
            Text = "Frmproduct";
            Load += Frmproduct_Load;
            ((System.ComponentModel.ISupportInitialize)dgvData).EndInit();
            ResumeLayout(false);
        }

        #endregion

        private Button btnViewProduct;
        private Button btnCategory;
        private DataGridView dgvData;
    }
}