var id;
function salvar() {
	var pessoas = $("#activities").val();
	var data = $("#date").val();
	var horario = $("#time").val();
	

	//atualizando
	var urlPreparada = '/reservas/atualizar/';
	var typePreparado = 'PUT';
	
	if(isNaN(id)){
		//criando
		urlPreparada = '/reservas/criar/';
		typePreparado = 'POST';
	}

	$.ajax({
		url: urlPreparada,
		type: typePreparado,
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		data: JSON.stringify({
		    "id": id ,
		    "pessoas": pessoas ,
		    "horario":  horario ,
		    "data": data 
		   
		}),
		complete: function (response) {
			console.log(response.responseJSON.mensagem);
			location.reload();
		},
		error: function () {
			alert('Não foi possivel criar/atualizar o post!!');
		},
	 
	});
}