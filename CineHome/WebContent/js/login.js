
$(document).ready(function () {
    $('.table').on('click', '.mostrar', function () {
        const button = $(this);
        const row = button.closest('tr');
        const passwordSpan = row.find('.password');
        const actualPasswordSpan = row.find('.actual-password');

        if (passwordSpan.is(':hidden')) {
            passwordSpan.show();
            actualPasswordSpan.hide();
            button.text('Mostrar');
        } else {
            passwordSpan.hide();
            actualPasswordSpan.show();
            button.text('Ocultar');
        }
    });
});


