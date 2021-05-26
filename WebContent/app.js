function initVars(scope) {
	scope.user = new Object();
	scope.logData = new Object();
	scope.loggedUser = new Object();
	scope.moneyDonation = new Object();
	scope.oneFriend = "";
	scope.oneMessage = "";
	scope.oneUser = "";
	scope.message = "";
	scope.frequenceDonation = "";
	scope.isDonating = false;
}
function initView(scope) {
	scope.showRegister = false;
	scope.showSignIn = false;
	scope.showMonMur = false;
	scope.showMesCreations = false;
	scope.showMessage = false;
	scope.showMenuArtiste = false;
	scope.showMenuMuse = false;
	scope.showMenuUser = false;
	scope.showContacts = false;
	scope.showParlerAmi = false;
	scope.showChat = false;
	scope.showProfile = false;
}
function click(button, scope, http) {
	initView(scope);
	initVars(scope);
	switch (button) {
		case "register" :
			scope.showRegister = true;
			break;
		case "signIn" :
			scope.showSignIn = true;
			break;
	}
}
function OK(action, scope, http) {
	switch (action) {
	case "register" :
		initView(scope);
		http.post("ajout" + scope.user.profil,scope.user).then(function(response) {
			if (response.status == 204) scope.message = "account created successfully";
			else scope.message = "registration failed";
			scope.showMessage = true;
		});
		break;
	case "signIn" :
		initView(scope);
		http.get("signin",scope.logData).then(function(response) {
			if (response.status == 200) {
				scope.message = "user connected successfully";
				scope.showMessage = true;
				scope.loggedUser = response.data;
				//alert(JSON.stringify(scope.loggedUser));
				if (scope.loggedUser instanceof Artist) {
					scope.showMenuArtiste = true;
				} else if (scope.loggedUser instanceof Muse) {
					scope.showMenuMuse = true;
				} else {
					scope.showMenuUser = true;
				}
			} else {
				scope.message = "connection failed";
				scope.showMessage = true;
			}
		});
		break;
	case "monMur" :
		break;
	case "mesCreations" :
		break;
	case "mesPartenariats" :
		break;
	case "mesIdees" :
		break;
	case "contacts" :
		initView(scope);
		scope.listDemandesAmi = scope.loggedUser.getDemandesAmiRecues();
		scope.listAmis = scope.loggedUser.getFriends();
		scope.listPropositionsAmi = scope.loggedUser.getPropositionsAmi();
		scope.showContacts = true;
		break;
	}
	case "confirmerAmi" :		
		http.post("accepterami",scope.loggedUser,scope.oneFriend).then(function(response) {
			if (response.status == 204) scope.message = "friend added successfully";
			else scope.message = "could not add friend";
			scope.showMessage = true;			
		});
		break;
	case "parlerAmi" :
		initView(scope);
		http.get("getmessages").then(function(response) {
			if (response.status == 200) {
				scope.listMessages = response.data;
				scope.showChat = true;
				//alert(JSON.stringify(scope.listMessages));
			} else {
				scope.message = "could not download the discussion";
				scope.showMessage = true;
			}
		});
		break;
	case "demanderAmi" :
		http.post("demanderami",scope.loggedUser,scope.oneFriend).then(function(response) {
			if (response.status == 204) scope.message = "request successfully sent";
			else scope.message = "could not send request";
			scope.showMessage = true;			
		});
		break;
	case "envoyerMessage":
		http.post("sendmessage",scope.loggedUser,scope.oneFriend,scope.oneMessage).then(function(response) {
			if (response.status == 204) scope.message = "message successfully sent";
			else scope.message = "could not send the message";
			scope.showMessage = true;			
		});
		break;
	case "showListUsers":
		initView(scope);
		http.get("listusers").then(function(response) {
			if (response.status == 200) {
				scope.listUsers = response.data;
				scope.showListUsers = true;
				//alert(JSON.stringify(scope.listUsers));
			} else {
				scope.message = "could not display Crealink's users";
				scope.showMessage = true;
			}
		});
		break;
	case "showProfile":
		initView(scope);
		http.get("isdonating").then(function(response) {
			if (response.status == 200) {
				scope.isDonating = response.data;
				scope.showProfile = true;
				//alert(JSON.stringify(scope.isDonating));
			} else {
				scope.message = "could not download profile";
				scope.showMessage = true;
			}
		});
		break;
	case "donate":
		initView(scope);
		http.post("fairedonation",scope.loggedUser,scope.user,scope.moneyDonation,scope.frequenceDonation).then(function(response) {
			if (response.status == 204) scope.message = "payment successfully opered";
			else scope.message = "could not process to donation payment";
			scope.showMessage = true;			
		});
		break;
	case "stopDonation":
		initView(scope);
		http.post("arreterdonation",scope.loggedUser,scope.user).then(function(response) {
			if (response.status == 204) scope.message = "donations successfully stopped";
			else scope.message = "could not stop donations to this user";
			scope.showMessage = true;			
		});
		break;		
}

var app = angular.module('Crealink', []);
app.controller('myCtrl', function($scope,$http) {
	initVars($scope);
 	initView($scope);
    $scope.doClick=function(button) {click(button,$scope,$http);}
    $scope.doOK=function(action) {OK(action,$scope,$http);}
});
