function print(element, index) {
	let elements = document.getElementsByClassName('kiyv-type');
	for (let i = 0; i < elements.length; i++) {
		if (i==index) {
			elements[i].innerHTML = element.value;
		} else {
			elements[i].innerHTML = '-';
		}
	}
}

function setIdOrder(idDoc) {
	let p = document.getElementById('printBoard');
	p.innerHTML = idDoc.id;
}

function addDescrSecond(idDoc, descrSecond) {

}

// let indexes = [];
// let descriptionSeconds = [];
