function eliminar(id){
	swal({
  title: "¿Estás seguro de eliminar?",
  text: "¡Una vez eliminado, no será posible recuperar la información!",
  icon: "warning",
  buttons: true,
	  dangerMode: true,
	})
	.then((OK) => {
	  if (OK) {
		$.ajax({
			url:"/eliminarUser/"+id,
			success: function(res){
				console.log(res);
				
			}
		});
			swal("El usuario ha sido eliminado!", {
				icon: "success",
			}).then((ok) => {
				if (ok) {
					location.href="/listarUser";
				}
			})
		} else {
			swal("El usuario está a salvo :)!");
		}
	});

}

function eliminarCliente(id){
	swal({
  title: "¿Estás seguro de eliminar?",
  text: "¡Una vez eliminado, no será posible recuperar la información!",
  icon: "warning",
  buttons: true,
	  dangerMode: true,
	})
	.then((OK) => {
	  if (OK) {
		$.ajax({
			url:"/eliminarCliente/"+id,
			success: function(res){
				console.log(res);
				
			}
		});
			swal("El cliente ha sido eliminado!", {
				icon: "success",
			}).then((ok) => {
				if (ok) {
					location.href="/listarCliente";
				}
			})
		} else {
			swal("El cliente está a salvo :)!");
		}
	});
	}
	
	function eliminarProveedor(id){
	swal({
  title: "¿Estás seguro de eliminar?",
  text: "¡Una vez eliminado, no será posible recuperar la información!",
  icon: "warning",
  buttons: true,
	  dangerMode: true,
	})
	.then((OK) => {
	  if (OK) {
		$.ajax({
			url:"/eliminarProveedor/"+id,
			success: function(res){
				console.log(res);
				
			}
		});
			swal("El proveedor ha sido eliminado!", {
				icon: "success",
			}).then((ok) => {
				if (ok) {
					location.href="/listarProveedor";
				}
			})
		} else {
			swal("El proveedor está a salvo :)!");
		}
	});

}
