$(document).ready(function () {
    $("form").submit(function (event) {
        event.preventDefault();
        var form = $(this);
        $.ajax({
            url: form.attr('action'),
            type: 'Post',
            data: form.serialize()
        }).done(function () {
            console.log('success');
        }).fail(function () {
            console.log('fail');
        });
    })
})