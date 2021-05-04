var modal = document.getElementById('bairrosModal')
modal.addEventListener('show.bs.modal', function (event) {

  	var button = event.relatedTarget

 	var idBairro = button.getAttribute('data-id')
	var nomeBairro = button.getAttribute('data-nome')

	var modal = $(this)
	var form = modal.find('form')
	var action = form.data('url-base')
	
	if(!action.endsWith('/')) {
		action += '/'
	}
	
	form.attr('action', action + idBairro)
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o bairro <strong>' + idBairro + ' - ' + nomeBairro + '</strong>?')
	
})