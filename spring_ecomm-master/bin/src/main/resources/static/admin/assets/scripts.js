$(function() {
    // Side Bar Toggle
    $('.hide-sidebar').click(function() {
	  $('#sidebar').hide('fast', function() {
	  	$('#content').removeClass('span9');
	  	$('#content').addClass('span12');
	  	$('.hide-sidebar').hide();
	  	$('.show-sidebar').show();
	  });
	});

	$('.show-sidebar').click(function() {
		$('#content').removeClass('span12');
	   	$('#content').addClass('span9');
	   	$('.show-sidebar').hide();
	   	$('.hide-sidebar').show();
	  	$('#sidebar').show('fast');
	});
});

$(document).ready(function () {
	try {
		initEvents();
	} catch (e) {
		alert('ready: ' + e.message);
	}
});

function initEvents(){

    var timer = setTimeout(function() {
	        try {
        	var data = {};
        	$("#order-list").empty();
            $.ajax({
                type:'GET',
                url : 'http://localhost:8008/master/api/v1/getOrders',
                success: function(res){
                	console.log(res);
                	for(var i=0;i<res.length;i++){
                		$("#order-list").append(`               		
	                		<tr class="gradeA odd">
								<td class="  sorting_1">${res[i].name}</td>
								<td class=" ">${res[i].phone}</td>
								<td class=" ">${res[i].address}</td>
								<td class="center ">${res[i].email}</td>
								<td class="center ">${res[i].quantity}</td>
								<td class="center ">${res[i].total}</td>
								<td class="center ">
									<input type="hidden" name="custId" value="${res[i].id}">
									<button class="btn btn-success btn-mini">Edit</button>
									<span class="btn btn-danger btn-mini delete-order" data-id="${res[i].id}">Delete</span>
								</td>
							</tr>
                		`);
                	}
                	$(".delete-order").on('click',function(){
						var idOrder = this.dataset.id;
						deleteOrder(idOrder);
					})
                }
            })
         	/*$("#order-list").empty();*/
        } catch (e) {
            alert('' + e.message);
        }
	}, 500);
	var deleteOrder = function(idOrder){
		alert("Delete order !");
		var data ={};
		data.id = idOrder;
		
		fetch('http://localhost:8008/master/api/v1/deleteOrder', {
		  method: 'POST', // or 'PUT'
		  headers: {
		    'Content-Type': 'application/json',
		  },
		  body: JSON.stringify(data),
		})
		.then(function(response){ console.log(response) })
		.then(data => {
			setTimeout(function() {
				console.log('Success:', data);
				window.location.reload();
				//window.location='http://localhost:9091/admin/orders'
			},2000)
			
		})
		.catch((error) => {
		  console.error('Error:', error);
		});
	}
	
    
    var getAll = function getListContent() {
        try {
            var data = {};
            $.ajax({
                type: 'POST',
                url: '/master/z003/getAll',
                dataType: 'html',
                loading: true,
                data: data,
                success: function (res) {
                    $("#orders").empty();
                    $("#orders").append(res);
                },
                // Ajax error
                error: function (res) {
                }
            });
        } catch (e) {
            alert('' + e.message);
        }
    }    
    
    $('#get-all-order').on('click', function(){
        try {
        	var data = {};
        	$("#order-list").empty();
            $.ajax({
                type:'GET',
                url : 'http://localhost:8008/master/api/v1/getOrders',
                success: function(res){
                	console.log(res);
                	for(var i=0;i<res.length;i++){
                		$("#order-list").append(`               		
	                		<tr class="gradeA odd">
								<td class="  sorting_1">${res[i].name}</td>
								<td class=" ">${res[i].phone}</td>
								<td class=" ">${res[i].address}</td>
								<td class="center ">${res[i].email}</td>
								<td class="center ">${res[i].quantity}</td>
								<td class="center ">${res[i].total}</td>
								<td class="center ">
									<button class="btn btn-success btn-mini">Edit</button>
									<a href="/remove-order/${res[i].id}" class="btn btn-danger btn-mini" onclick="return confirm('Are you sure ?')">Delete</a>
								</td>
							</tr>
                		`);
                	}
					                   
                }
            })
         	/*$("#order-list").empty();*/
        } catch (e) {
            alert('' + e.message);
        }
                        
    })
     
}