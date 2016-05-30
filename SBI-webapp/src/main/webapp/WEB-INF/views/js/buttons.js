function odb(){
	var wynik = document.getElementById("rozsz");
	console.log(wynik.childNodes.length);
	if(document.getElementById("rozsz").childNodes.length==1){
		
		var lista = document.createElement('ul');
		wynik.appendChild(lista);
		
		var add = document.createElement("li"),
		check = document.createElement("li"),
		a1 = document.createElement("a"),
		a2 = document.createElement("a");
		
		a1.innerHTML="Dodaj odbiorcę";
		a2.innerHTML="Lista odbiorców";
		
		add.appendChild(a1);
		check.appendChild(a2);
		lista.appendChild(add);
		lista.appendChild(check);
	} else {
		while (wynik.childNodes.length > 1) {
			wynik.removeChild(wynik.lastChild);
		}
		strona();
	}
}

function wiad(){
	var wynik = document.getElementById("rozsz");

	if(document.getElementById("rozsz").childNodes.length==1){
		
		var lista = document.createElement('ul');
		wynik.appendChild(lista);
		
		var add = document.createElement("li"),
		check = document.createElement("li"),
		a1 = document.createElement("a"),
		a2 = document.createElement("a");
		
		a1.innerHTML="Napisz wiadomość";
		a2.innerHTML="Sprawdz skrzynkę";
		
		add.appendChild(a1);
		check.appendChild(a2);
		lista.appendChild(add);
		lista.appendChild(check);
	} else {
		while (wynik.childNodes.length > 1) {
			wynik.removeChild(wynik.lastChild);
		}	
		strona();
	}
}




function strona(){
	odbiorcy = document.getElementById("odbiorcy"),
	wiadomosci = document.getElementById("wiad"),
	zlecenia = document.getElementById("zlecenia"),
	oferty = document.getElementById("oferty"),
	profil = document.getElementById("prof");
	
	odbiorcy.innerHTML = "Odbiorcy";
	wiadomosci.innerHTML = "Wiadomości";
	zlecenia.innerHTML = "Zlecenia Stałe";
	oferty.innerHTML = "Oferty";
	profil.innerHTML = "Profil";
	
}


function wykonaj(){
	blok = document.getElementById("content");
	lewy = document.getElementById("leftCont");
	p1 = document.createElement("p");
	p2 = document.createElement("p");
	p3 = document.createElement("p");
	p4 = document.createElement("p");
	p5 = document.createElement("p");
	p6 = document.createElement("p");
	console.log(p1);
	if(blok.childNodes.length==1 && lewy.childNodes.length==1){
		
		formleft = document.createElement("form");
		formleft.setAttribute('method',"post");
		formleft.setAttribute('action',"submit.php");
		
		formularz = document.createElement("form");
		formularz.setAttribute('method',"post");
		formularz.setAttribute('action',"submit.php");
		
		p1.innerHTML = "Nazwa odbiorcy :";
		p2.innerHTML = "Numer rachunku :";
		p3.innerHTML = "Adres odbiorcy :";
		p4.innerHTML = "Tytuł przelewu :"
		p5.innerHTML = "Kwota :";
		p6.innerHTML = "Data przelewu :";
		
		l1 = document.createElement("input");
		l1.setAttribute('type',"number");
		l1.setAttribute('name',"kwota");
		l2 = document.createElement("input");
		l2.setAttribute('type',"date");
		l2.setAttribute('name',"data");
		
		
		in1 = document.createElement("input");
		in1.setAttribute('type',"text");
		in1.setAttribute('name',"username");
		in2 = document.createElement("input");
		in2.setAttribute('type',"text");
		in2.setAttribute('name',"username");
		in3 = document.createElement("input");
		in3.setAttribute('type',"text");
		in3.setAttribute('name',"username");
		in4 = document.createElement("TEXTAREA");
		
		
		formleft.appendChild(p5);
		formleft.appendChild(l1);
		formleft.appendChild(p6);
		formleft.appendChild(l2);
		formularz.appendChild(p1);
		formularz.appendChild(in1);
		formularz.appendChild(p2);
		formularz.appendChild(in2);
		formularz.appendChild(p3);
		formularz.appendChild(in3);
		formularz.appendChild(p4);
		formularz.appendChild(in4);
		
		
		lewy.appendChild(formleft);
		blok.appendChild(formularz);
	}
}
