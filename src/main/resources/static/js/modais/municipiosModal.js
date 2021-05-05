var modal = document.getElementById('municipiosModal')
modal.addEventListener('show.bs.modal', function (event) {

  	var button = event.relatedTarget

 	var idMunicipio = button.getAttribute('data-id')
	var nomeMunicipio = button.getAttribute('data-nome')

	var modal = $(this)
	var form = modal.find('form')
	var action = form.data('url-base')
	
	if(!action.endsWith('/')) {
		action += '/'
	}
	
	form.attr('action', action + idMunicipio)
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o municipio <strong>' + idMunicipio + ' - ' + nomeMunicipio + '</strong>?')
	
})