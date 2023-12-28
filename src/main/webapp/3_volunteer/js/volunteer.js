function deleteMovie(n){
	let ok = confirm ('Are you sure you want to delete?');
	if(ok){
		location.href='VolunteerDelC?no=' + n;
	}
}