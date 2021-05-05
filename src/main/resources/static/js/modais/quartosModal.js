var modal = document.getElementById('quartosModal')
modal.addEventListener('show.bs.modal', function (event) {

  	var button = event.relatedTarget

 	var idQuarto = button.getAttribute('data-id')
	var nQuartos = button.getAttribute('data-n')

	var modal = $(this)
	var form = modal.find('form')
	var action = form.data('url-base')
	
	if(!action.endsWith('/')) {
		action += '/'
	}
	
	form.attr('action', action + idQuarto)
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o quarto <strong> #' + idQuarto + ' - ' + nQuartos + '</strong>?')
	
})