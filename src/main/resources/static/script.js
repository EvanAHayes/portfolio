var keylist = "abcdefghijklmnopqrstuvwxyz1234567890!?@#$%&";
var temp = "";

function generatepass(pLength){
    temp ="";
    //loop through the keylist one value at a time run to plength

    for(i = 0; i < pLength; i++){
        temp+=keylist.charAt(Math.floor(Math.random()*keylist.length))
    }
    return temp;

}


function populateForm(enterlength){
    document.passGen.output.value = generatepass(enterlength);
}