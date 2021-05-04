var modal = document.getElementById('negociosModal')
modal.addEventListener('show.bs.modal', function (event) {

  	var button = event.relatedTarget

 	var idNegocio = button.getAttribute('data-id')
	var nomeNegocio = button.getAttribute('data-nome')

	var modal = $(this)
	var form = modal.find('form')
	var action = form.data('url-base')
	
	if(!action.endsWith('/')) {
		action += '/'
	}
	
	form.attr('action', action + idNegocio)
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o negócio <strong>' + idNegocio + ' - ' + nomeNegocio + '</strong>?')
	
})