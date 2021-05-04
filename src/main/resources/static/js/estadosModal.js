var modal = document.getElementById('estadosModal')
modal.addEventListener('show.bs.modal', function (event) {

  	var button = event.relatedTarget

 	var idEstado = button.getAttribute('data-id')
	var nomeEstado = button.getAttribute('data-nome')

	var modal = $(this)
	var form = modal.find('form')
	var action = form.data('url-base')
	
	if(!action.endsWith('/')) {
		action += '/'
	}
	
	form.attr('action', action + idEstado)
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o negócio <strong>' + idEstado + ' - ' + nomeEstado + '</strong>?')
	
})