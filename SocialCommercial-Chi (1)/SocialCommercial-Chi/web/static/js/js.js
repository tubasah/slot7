

const dropdownButton = document.getElementById('dropdownButton');
const dropdownContent = document.querySelector('.dropdown-content');

// Thêm sự kiện click vào nút
dropdownButton.addEventListener('click', function() {
// Kiểm tra xem dropdown có đang được hiển thị hay không
const isActive = dropdownContent.classList.contains('active');

// Nếu đang hiển thị, thì ẩn đi
if (isActive) {
    dropdownContent.classList.remove('active');
} else {
    // Nếu chưa hiển thị, thì hiển thị dropdown
    dropdownContent.classList.add('active');
}
});

// Đóng dropdown khi bấm bất kỳ đâu ngoài dropdown
document.addEventListener('click', function(event) {
if (!dropdownButton.contains(event.target) && !dropdownContent.contains(event.target)) {
    dropdownContent.classList.remove('active');
}
});

var darkButton = document.querySelector(".darkTheme");

    darkButton.onclick = function(){
        darkButton.classList.toggle("button-Active");
        document.body.classList.toggle("dark-color");
    }

