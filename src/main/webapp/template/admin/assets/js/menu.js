$(document).ready(function () {
    $('.addMenu').on('click', function (e) {
        $('#exampleModal').modal('toggle').find('.modal-body').load($(this).attr('href'));
    });
});