document.addEventListener("DOMContentLoaded", function () {
                // Lấy phần tử dropdown và nút arrow_carrot-down
                var dropdown = document.querySelector(".dropdown-content");
                var arrow = document.querySelector(".arrow_carrot-down");

                // Bắt sự kiện click vào nút arrow_carrot-down
                arrow.addEventListener("click", function () {
                    // Kiểm tra trạng thái hiện tại của dropdown và thay đổi nó
                    if (dropdown.style.display === "block") {
                        dropdown.style.display = "none";
                    } else {
                        dropdown.style.display = "block";
                    }
                });
            });