function setIdOrder(arg) {
	idDoc = arg.id;
	let descriptionRows = document.querySelectorAll('#description-table-1 .descr-visible');
	if (descriptionRows != null) {
		for (let i = 0; i < descriptionRows.length; i++) {
			descriptionRows[i].classList.remove('descr-visible');
			descriptionRows[i].classList.add('descr-hidden')
		}
	}
	let newDescription = document.getElementsByClassName(idDoc);
	if (newDescription != null) {
		for (let i = 0; i < newDescription.length; i++) {
			newDescription[i].classList.remove('descr-hidden');
			newDescription[i].classList.add('descr-visible')
		}
	}
}

function setSelectStyle() {
	let oldRowStyleElement = document.getElementsByClassName('order-select')[0];
	if (oldRowStyleElement != null) {
		oldRowStyleElement.classList.remove('order-select');
	}
	let newRowStyleElement = document.getElementById(idDoc);
	newRowStyleElement.classList.add('order-select');
}

let idDoc ='';
