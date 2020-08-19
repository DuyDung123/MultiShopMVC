// Call the dataTables jQuery plugin
$(document).ready(function() {
  // $('#dataTable').DataTable();
  $('.addMenu').on('click', function (e) {
    $('#exampleModal').modal('toggle').find('.modal-body').load($(this).attr('href'));
  });

  $("#btnDelete").click(function () {
    var data = {};
    var ids = $('tbody input[type=checkbox]:checked').map(function () {
      return $(this).val();
    }).get();
    data['ids'] = ids;
    deleteNew(data);
  });

  function deleteNew(data) {
    $.ajax({
      url: '${APIurl}',
      type: 'DELETE',
      contentType: 'application/json',
      data: JSON.stringify(data),
      success: function (result) {
        window.location.href = "/MultiShop/admin/N/menu/edit?message=delete_success";
      },
      error: function (error) {
        window.location.href = "${NewURL}?message=error_system";
      }
    });
  }
});
