var modal = document.getElementById('categoriasModal')
modal.addEventListener('show.bs.modal', function (event) {

  	var button = event.relatedTarget

 	var idCategoria = button.getAttribute('data-id')
	var nomeCategoria = button.getAttribute('data-nome')

	var modal = $(this)
	var form = modal.find('form')
	var action = form.data('url-base')
	
	if(!action.endsWith('/')) {
		action += '/'
	}
	
	form.attr('action', action + idCategoria)
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir a categoria <strong>' + idCategoria + ' - ' + nomeCategoria + '</strong>?')
	
})