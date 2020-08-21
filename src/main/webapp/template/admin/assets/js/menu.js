$(document).ready(function () {
    
	$('#dataTable').DataTable();
	
    $('.addMenu').on('click', function (e) {
        $('#exampleModal').modal('toggle').find('.modal-body').load($(this).attr('href'));
    });
});