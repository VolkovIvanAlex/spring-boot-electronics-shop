$(document).ready(function () {
    $("addProductButton").click(function (event) {
        alert("Start");
        var productCode = $("productCode").val();
        var quantity = $("quantity").val();
        var pageName = $("pageName").val();
        $.ajax({
            type: "POST",
            url: "/products/addToCart",
            data: {productCode, quantity , pageName}
        })
    })
})
