function setIdOrder(arg) {
	let p = document.getElementById('printBoard');
	p.innerHTML = arg.id;
	idDoc = arg.id;

	let descriptionRows = document.querySelectorAll('#description-table-1 .descr-visible');
	console.log(descriptionRows.length);
	if (descriptionRows != null) {
		for (let i = 0; i < descriptionRows.length; i++) {
			descriptionRows[i].classList.remove('descr-visible');
			descriptionRows[i].classList.add('descr-hidden')
		}
	}
	let newDescription = document.getElementsByClassName(idDoc);
	console.log(newDescription.length);
	if (newDescription != null) {
		for (let i = 0; i < newDescription.length; i++) {
			newDescription[i].classList.remove('descr-hidden');
			newDescription[i].classList.add('descr-visible')
		}
	}
}
let idDoc ='';