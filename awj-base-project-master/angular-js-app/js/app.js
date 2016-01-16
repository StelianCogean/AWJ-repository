
var app = angular.module('blog', []);

+app.controller('HomeController', ['$scope', '$http', function($scope, $http) {
    $scope.helloWorld = 'Aplicatii Web cu suport Java!';
  $scope.Profesor={};
  var url = "http://localhost:8080/persoana";
   $scope.persoane = [];
   $scope.keysPersoane = [];
   $scope.keysPersoaneVar=[];
	$scope.obj={};
   $scope.person = {};
   $scope.editPerson = {};
 
   var url = "http://localhost:8080/Evidenta";
   $scope.grupa = [];
   $scope.keys = [];
	$scope.obj={};
   $scope.group = {};
   $scope.editGroup = {};
 $scope.newKeys=[];
 
    var url = "http://localhost:8080/Profesor";
   $scope.Profesori= [];
   $scope.keysProfesori = [];
    $scope.obj={};
   $scope.profi = [];
   $scope.editGroup = {};
 $scope.newKeys=[];
 
   $http.get('http://localhost:8080/persoana').then(
     function successCallback(response) {
		$scope.obj=response;
     $scope.persoane = $scope.obj.data;
     $scope.keysPersoaneVar = Object.keys(response.data[0]);
     $scope.keysPersoane= $scope.keysPersoaneVar.reverse();
     console.log($scope.keysPersoane);
   });
 
	 $http.get('http://localhost:8080/Evidenta').then(
     function successCallback(response) {
		$scope.obj=response;
        console.log(response.data);
     $scope.persoane = $scope.obj.data;
     $scope.keys = Object.keys(response.data[0]);
     $scope.newKeys.push($scope.keys[4]);
     $scope.newKeys.push($scope.keys[0]);
     $scope.newKeys.push($scope.keys[1]);
     $scope.newKeys.push($scope.keys[3]);
     $scope.newKeys.push($scope.keys[2]);
   });
 
 
   $scope.addPersoana = function(persoana) {
        persoana.id = parseInt(persoana.id);
        console.log(persoana.id);
        $http({
            method: 'POST',
            url: url,
            data: persoana
        }).then(function successCallback(response) {
            console.log(response);
            $scope.persoane.push(persoana);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };

	
	 $scope.addEvidenta = function(Evidenta) {
        Evidenta.id = parseInt(Evidenta.id);
        console.log(Evidenta.id);
        $http({
            method: 'POST',
            url: url,
            data: Evidenta
        }).then(function successCallback(Evidenta) {
            console.log(response);
            $scope.grupa.push(Evidenta);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deletePersoana = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.persoane = $scope.persoane.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };

	 $scope.deleteEvidenta = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.grupa = $scope.grupa.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdatePerson = function(person) {
        $scope.editPerson = person;
    };
	
	 $scope.setUpdateGroup = function(group) {
        $scope.editGroup = group;
    };


    $scope.updatePerson = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editPerson
        }).then(function successCallback(response) {
            $scope.editPerson = {};
            console.log(response);
            // $scope.persoane.push($scope.editPerson);
            // done.
        }, function errorCallback(response) {
            $scope.editPerson = {};
            console.log(response);
        });
    };
	

    $scope.updateGroup = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editGroup
        }).then(function successCallback(response) {
            $scope.editGroup = {};
            console.log(response);
            // $scope.persoane.push($scope.editPerson);
            // done.
        }, function errorCallback(response) {
            $scope.editGroup = {};
            console.log(response);
        });
    };
    //logica pt profesori
    var urlProf='http://localhost:8080/Profesor';

    $http.get('http://localhost:8080/Profesor').then(
     function successCallback(response) {
      $scope.obj=response;
        $scope.profi=$scope.obj.data;
        console.log(response.data);
    // $scope.profi = $scope.obj.data;
     $scope.keysProfesori = Object.keys(response.data[0]);
  
   });
    $scope.profesor={};
           $scope.addProfesor = function(profesor) {
            $scope.profi.data.push(profesor);
            console.log("proful de adaugat:",profesor);
        profesor.id = parseInt(profesor.id);
        console.log(profesor.id);
        $http({
            method: 'POST',
            url: urlProf,
            data: profesor
        }).then(function successCallback(response) {
            console.log(response);
            $scope.profi.push(profesor);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };
      $scope.editProfesor = {};
     $scope.setUpdateProfesor = function(profesor) {
        $scope.editProfesor = profesor;
    };

    $scope.updateProfesor = function() {
        $http({
            method: 'PUT',
            url: urlProf,
            data: $scope.editProfesor
        }).then(function successCallback(response) {
            $scope.editProfesor = {};
            console.log(response);
            // $scope.persoane.push($scope.editPerson);
            // done.
        }, function errorCallback(response) {
            $scope.editProfesor = {};
            console.log(response);
        });
    };
    
   
    $scope.addEvidenta = function(Evidenta) {
        Evidenta.id = parseInt(Evidenta.id);
        console.log(Evidenta.id);
        $http({
            method: 'POST',
            url: url,
            data: Evidenta
        }).then(function successCallback(Evidenta) {
            console.log(response);
            $scope.grupa.push(Evidenta);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };

     $scope.deleteProfesor = function(id) {
        $http({
            method: 'DELETE',
            url: urlProf+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.profi = $scope.profi.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };
/*
       $http.post("http://localhost:8080/Profesor", profesor).success(function(profesor, status) {
         //   $scope.hello = data;
            $scope.profi.push(profesor);

        })
       .error(profesor){
         $scope.profi.push(profesor);

       }*/
       //logica pentru laborant
       var urlLab = "http://localhost:8080/Laborant";
   $scope.laboranti = {};
   $scope.keysLaborant = [];
    $scope.obj={};
   $scope.laborant = {};
   $scope.editLaborant = {};
 $scope.newKeys=[];

 $http.get('http://localhost:8080/laborant').then(
     function successCallback(response) {
        $scope.obj=response;
     $scope.laboranti = $scope.obj.data;
     $scope.keysLaborant = Object.keys(response.data[0]);
     //$scope.keysPersoane= $scope.keysPersoaneVar.reverse();
     console.log($scope.keysLaborant);
   });
 $scope.addLaborant = function(laborant) {
        laborant.id = parseInt(laborant.id);
        console.log(laborant.id);
        $http({
            method: 'POST',
            url: urlLab,
            data: laborant
        }).then(function successCallback(response) {
            console.log(response);
            $scope.laboranti.push(laborant);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };

$scope.editLaborant={};
    $scope.setUpdateLaborant = function(laborant) {
        $scope.editLaborant = laborant;
    };
        $scope.updateLaborant = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editLaborant
        }).then(function successCallback(response) {
            $scope.editLaborant = {};
            console.log(response);
             $scope.laboranti.push($scope.editLaborant);
            // done.
        }, function errorCallback(response) {
            $scope.editLaborant = {};
            console.log(response);
        });
    };
        $scope.deleteLaborant = function(id) {
        $http({
            method: 'DELETE',
            url: urlLab+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.laboranti = $scope.laboranti.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };

	
  }]);