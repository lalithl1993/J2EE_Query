var letters = /[A-Za-z -']$/;

function vname( fname, nameid, flg )
{
	if( (isNaN(fname)) && (letters.test(fname)) )
	{
		document.getElementById(nameid).innerHTML="Correct";
		document.getElementById(nameid).style.color="green";
		
			flag[flg]=true;
	}
	else
	{
			document.getElementById(nameid).innerHTML="Must be alphabets";
			document.getElementById(nameid).style.color="red";
			flag[flg]=false;
	}
}