$(function() {
	switch (menu) {
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;

	case 'Demo page':
		$('#demo').addClass('active');
		break;
	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}
	/*
	 * var products = [ [ '1', 'ABC' ], [ '2', 'CDE' ], [ '3', 'FGH' ], [ '4',
	 * 'HIJ' ], [ '5', 'KLM' ], [ '6', 'NOP' ], ];
	 */
	// code for jquery dataTable
	var $table = $('#productListTable');

	// execute the below code only where we have this table
	if ($table.length) {
		// console.log('Inside the table!');
		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}

		$table.DataTable({
			lengthMenu : [ [ 3, 5, 10, -1 ],
					[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
			pageLength : 5,
			ajax : {
				url : jsonUrl,
				dataSrc : ''
			},
			columns : [ {
				data : 'name'
			}, {
				data : 'brand'
			}, {
				data : 'unitPrice',
					mRender : function(data, type, row) {
						return '&#8377; ' + data
					}
			}, {
				data : 'quantity',
				mRender : function(data, type, row) {

					if (data < 1) {
						return '<span style="color:red">Out of Stock!</span>';
					}

					return data;

				}
			}

			]
		});
	}
});
