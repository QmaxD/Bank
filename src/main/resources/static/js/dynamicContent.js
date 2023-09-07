
$(document).ready(function() {
    $('a[name=dynamic]').on('click', function(event) {
        event.preventDefault(); // предотвращаем действие по умолчанию при клике на ссылке
        var url = $(this).attr('href'); // получаем URL ссылки

        if (url === '/readme' || url === '/aboutme') {
            if (window.location.pathname === "/calculate") {
                alert('calculate');
                console.log('calculate');
                window.location.href = "/";
            }
            $.ajax({
                url: url,
                type: 'GET',
                success: function(response) {
                    $('#dynamic-content').html(response); // вставляем ответ в div с id dynamic-content
                }
            });
        }
    });
});
