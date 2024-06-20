$(document).ready(function () {
    $(".add-product-form").submit(function (event) {
        event.preventDefault();
        var form = $(this);
        $.ajax({
            url: form.attr('action'),
            type: 'Post',
            data: form.serialize()
        }).done(function (data) {
            alert(data["quantity"] + " products with code " + data["productCode"] + ' added to cart');
        }).fail(function () {
            alert('please enter a positive quantity');
        });
    })
})