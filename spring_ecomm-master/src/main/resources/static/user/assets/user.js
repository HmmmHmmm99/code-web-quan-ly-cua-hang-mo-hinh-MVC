$(document).ready(function () {
	try {
		initEvents();
	} catch (e) {
		alert('ready: ' + e.message);
	}
});

function initEvents(){
	/*$('#').on('click', function(){
        $('#form-order').submit(function(ev){
            ev.preventDefault();
            try {
                $.ajax({
                    type:'post',
                    url : '/master/z003/create',
                    dataType: 'json',
                    loading: true,
                    data: $('#form-order').serialize(),
                    success: function(res){
                        console.log(res)
                        console.log(res.status=="200");
                        if(res.status=="200"){
                            window.location.reload();
                        }               
                    }
                })
            } catch (e) {
                alert('' + e.message);
            }
        })
                        
    })*/
    var getAll = function getListContent() {
        try {
            var data = {};
            $.ajax({
                type: 'POST',
                url: '',
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
   	
    var createOrder = function(){
		try {
            $.ajax({
                type:'post',
                url : '',
                dataType: 'json',
                loading: true,
                data: $('#form-order').serialize(),
                success: function(res){
                    console.log(res)
                    console.log(res.status=="200");
                    if(res.status=="200"){
                        window.location.reload();
                    }               
                }
            })
        } catch (e) {
            alert('' + e.message);
        }
	}
	
	var timer1 = setTimeout(function() {
	        try {
        	var data = {};
        	$("#order-history").empty();
            $.ajax({
                type:'GET',
                url : 'http://localhost:8008/master/api/v1/getOrders',
                success: function(res){
                	console.log(res);
                	for(var i=0;i<res.length;i++){
                		$("#order-history").append(`               		
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
	}, 00);
	
	
	
	$("#testform").on('click',function(){
		var data ={};
		data.name = $('#name-order').val();
		data.phone = $('#phone-order').val();
		data.address = $('#address-order').val();
		data.email = $('#email-order').val();
		data.date = $('#date-order').val();
		data.quantity = parseInt($('#quantity-order').val());
		data.total = $('#total-order').val()+"";
		if($('#paypal').val()=="1"){
			data.note = "Paypal "+$('#note-order').val();
		}
		else{
			data.note = "COD "+$('#note-order').val();
		}
		
		fetch('http://localhost:8008/master/api/v1/createOrder', {
		  method: 'POST', // or 'PUT'
		  headers: {
		    'Content-Type': 'application/json',
		  },
		  body: JSON.stringify(data),
		})
		.then(function(response){ console.log(response) })
		.then(data => {
			var timer = setTimeout(function() {
	            window.location='http://localhost:9091//order-success';
	         }, 2000);
		  console.log('Success:', data);
		})
		.catch((error) => {
		  console.error('Error:', error);
		});
	});
}