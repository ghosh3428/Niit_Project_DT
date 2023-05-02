$(function() 
{

	var $table = $('#productTable');
	
	if ($table.length) {
		var jsonUrl = '';
		
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/active/product';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/product';
		}
		

		$table
				.DataTable({
					lengthMenu : [ [ 3, 5, 10, -1 ], [ '3', '5', '10', 'ALL' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code',
								mRender : function(data, type, row) {

									return '<img src="' + window.contextRoot + '/rs/images/' + data + '.jpg" class="dataTableImg"/>';

								}
								
							},	
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}
							},
							{
								data : 'quantity'
								
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/product/show/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open">View</span></a> &#160;';

									

									return str;

								}
							}	

					]
				});
	}
	
});